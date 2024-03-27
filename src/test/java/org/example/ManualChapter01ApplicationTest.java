package org.example;

import junit.framework.TestCase;
import org.example.mapper.CommentMapper;
import org.example.pojo.Comment;
import org.example.pojo.MyProperties;
import org.example.pojo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


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
    @Test
    public void func4() {
        List<Comment> all = commentMapper.findAll();
        System.out.println(all.toString());
    }
    @Test
    public void func5() {
        Comment comment = new Comment();
        comment.setContent("test");
        comment.setAuthor("test");
        comment.setaId(1);
        int i = commentMapper.instComment(comment);
        System.out.println(i);
    }
    @Test
    public void func6() {
        Comment comment = new Comment();
        comment.setContent("test");
        comment.setAuthor("test");
        comment.setaId(1);
        int i = commentMapper.updateComment(comment);
        System.out.println(i);
    }
    @Test
    public void func7() {
        int i = commentMapper.deleteComment(1);
        System.out.println(i);
    }


}