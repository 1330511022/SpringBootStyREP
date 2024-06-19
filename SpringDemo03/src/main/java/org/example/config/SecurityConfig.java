package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.sql.DataSource;

/**
 * @Project: HelloController.java
 * @Package: org.example.config
 * @Description: 安全配置类
 * @author: xiaoMa
 * @Email:17320080198@163.com
 * @date: 2024年06月19日 16:01
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        auth.inMemoryAuthentication().passwordEncoder(encoder)
//                .withUser("Tom").password(encoder.encode("123456")).roles("common")
//                .and()
//                .withUser("Alice").password(encoder.encode("123456")).roles("vip");
//    }
// 2、使用JDBC进行身份认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //根据用户名查询用户信息：用户密码
        String userSQL = "select username,passwd,valid from t_customer " + "where username = ?";
        //根据用户名联合三个表查询了用户的权限
        String authoritySQL = "select c.username,a.authority from t_customer c, " + "t_authority   a,t_customer_authority ca where " + "ca.customer_id=c.id and ca.authority_id=a.id and    c.username =?";
        auth.jdbcAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .dataSource(dataSource)
                .usersByUsernameQuery(userSQL)
                .authoritiesByUsernameQuery(authoritySQL);

    }

    //    //3.访问控制实现
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/detail/common/**").hasRole("common")
//                .antMatchers("/detail/vip/**").hasRole("vip")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();
//    }
    //4.登录配置实现
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/detail/common/**").hasRole("common")
                .antMatchers("/detail/vip/**").hasRole("vip")
                .anyRequest().authenticated();
        http.formLogin()
                .loginPage("/userLogin").permitAll()
                .usernameParameter("name").passwordParameter("pwd")
                .defaultSuccessUrl("/")
                .failureUrl("/userLogin?error");
        //退出功能
        http.logout()
                .logoutUrl("/mylogout")
                .logoutSuccessUrl("/");
        //记住我功能
        http.rememberMe()
                .rememberMeParameter("rememberme")
                .tokenValiditySeconds(200)
                .tokenRepository(tokenRepository());
    }

    @Bean
    public JdbcTokenRepositoryImpl tokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }
}