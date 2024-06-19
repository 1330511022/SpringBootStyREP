package org.example.service.impl;

import org.example.mapper.CommentMapper;
import org.example.pojo.Comment;
import org.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Project: SpringDemo
 * @Package: org.example.service.impl
 * @Description: Comment服务层实现类
 * @author: xiaoMa
 * @Email:17320080198@163.com
 * @date: 2024年04月24日 10:26
 */

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public Comment findById(int commentId) {
        Comment byId = commentMapper.findById(commentId);
        return byId;
    }

    @Override
    public Comment updateComment(Comment comment) {
        return null;
    }

    @Override
    public void deleteComment(int commentId) {

    }
}
