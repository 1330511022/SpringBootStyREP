package org.example;

import junit.framework.TestCase;
import org.example.mysqltest.Comment;
import org.example.mysqltest.CommentMapper;
import org.example.propertest.MyProperties;
import org.example.propertest.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)//加载测试运行器
@SpringBootTest//加载上下文
public class ManualChapter01ApplicationTest extends TestCase {
    @Autowired //注入实例
    private Person person;
    @Autowired
    private MyProperties myProperties;
    @Autowired
    private CommentMapper commentMapper;

    @Test//单元测试示例
    public void func() {
        System.out.println(person.toString());
    }

    @Test
    public void func2() {
        System.out.println(myProperties.toString());
    }
    @Test
    public void func3() {
        Comment byId = commentMapper.findById(1);
        System.out.println(byId.toString());
    }

}