package org.example;

import junit.framework.TestCase;
import org.example.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)//加载测试运行器
@SpringBootTest//加载上下文
public class HelloControllerTest extends TestCase {
    @Test
    public void testHello() {
        HelloController helloController = new HelloController();
        String hello = helloController.hello();
        System.out.println(hello);
    }

}