package org.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.example.mapper.TArticleMapper;
import org.example.mapper.TCommentMapper;
import org.example.pojo.TArticle;
import org.example.pojo.TComment;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Project: SpringDemo
 * @Package: PACKAGE_NAME
 * @Description: 关于Mybatis的接口测试
 * @author: xiaoMa
 * @Email:17320080198@163.com
 * @date: 2024年04月03日 11:59
 */
@SpringBootTest
@MapperScan("org.example.mapper")
public class MybatisTest {
    @Autowired
    private TArticleMapper tArticleMapper;
    @Autowired
    private TCommentMapper tCommentMapper;


    //查询
    @Test
    public void testSelect() {
        TArticle tArticle = tArticleMapper.selectById(1);
        System.out.println(tArticle.toString());

    }

    //查询(查询多条数据)
    @Test
    public void testSelect_all() {
        List<TComment> tCommentData = tCommentMapper.selectList(new QueryWrapper<TComment>().eq("a_id", 1));
        for (TComment tCommentDatum : tCommentData) {
            System.out.println(tCommentDatum.toString());
        }
    }
    //删除
    @Test
    public void testDelete() {
        int i = tCommentMapper.deleteById(3);
        if (i == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    //修改(更新)
    @Test
    public void testUpdate() {
        TComment tComment = new TComment();
        tComment.setId(2);
        tComment.setAuthor("xiaoma");
        tComment.setAId(2);
        tComment.setContent("测试更新只更新a_ID为" + tComment.getAId() + "的数据");
        UpdateWrapper<TComment> tCommentUpdateWrapper = new UpdateWrapper<>();
        tCommentUpdateWrapper.eq("a_id", tComment.getAId());
        int update = tCommentMapper.update(tComment, tCommentUpdateWrapper);
        if (update == 1) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
        //updateById(Object)(根据id来修改数据)
        int i = tCommentMapper.updateById(tComment);
    }
    //插入数据
    @Test
    public void testInsert() {
        TComment tComment = new TComment();
        tComment.setId(5);
        tComment.setAId(5);
        tComment.setAuthor("xiaoma");
        tComment.setContent("测试插入");
        int insert = tCommentMapper.insert(tComment);
        if (insert == 1) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }


    }
}

