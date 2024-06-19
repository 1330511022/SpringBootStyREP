package org.example.service.impl;

import org.example.pojo.Comment;
import org.example.service.CommentService;
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
    @Override
    public Comment findById(int commentId) {
        return null;
    }

    @Override
    public Comment updateComment(Comment comment) {
        return null;
    }

    @Override
    public void deleteComment(int commentId) {

    }
}
