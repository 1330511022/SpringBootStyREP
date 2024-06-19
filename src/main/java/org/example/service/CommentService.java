package org.example.service;

import org.example.pojo.Comment;

/**
 * @Project: SpringDemo
 * @Package: org.example.service
 * @Description: Comment表服务层
 * @author: xiaoMa
 * @Email:17320080198@163.com
 * @date: 2024年04月24日 10:25
 */

public interface CommentService {
    Comment findById(int commentId);

    Comment updateComment(Comment comment);

    void deleteComment(int commentId);
}
