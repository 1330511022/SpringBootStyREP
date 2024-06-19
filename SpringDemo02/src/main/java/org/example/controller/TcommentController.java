package org.example.controller;

import org.example.mapper.TCommentMapper;
import org.example.pojo.TComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: SpringDemo
 * @Package: org.example.controller
 * @Description: 关于表Comment的控制类
 * @author: xiaoMa
 * @Email:17320080198@163.com
 * @date: 2024年04月11日 19:22
 */
@RestController
public class TcommentController {
    @Autowired
    private TCommentMapper tCommentMapper;


    @GetMapping("selectable")
    public TComment selectable(int id) {
        return tCommentMapper.selectById(id);
    }


}
