package org.example.controller;

import org.example.pojo.Comment;
import org.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: SpringDemo
 * @Package: org.example.controller
 * @Description: Comment控制类
 * @author: xiaoMa
 * @Email:17320080198@163.com
 * @date: 2024年04月24日 11:56
 */

@RestController
public class CommentController {


    @Autowired
    private CommentService commentService;
    //查询数据的访问请求
    @GetMapping("/get/{id}")
    public Comment findById(@PathVariable("id") int comment_id){
        Comment comment = commentService.findById(comment_id);
        return comment;
    }
    //修改数据的请求
    @GetMapping("/update/{id}/{author}")
    public Comment updateComment(@PathVariable("id") int comment_id,
                                 @PathVariable("author") String author){
        Comment comment = commentService.findById(comment_id);
        comment.setAuthor(author);
        Comment updateComment = commentService.updateComment(comment);
        return updateComment;
    }
    //删除数据请求
    @GetMapping("/delete/{id}")
    public String  deleteComment(@PathVariable("id") int comment_id){
        commentService.deleteComment(comment_id);
        return "数据删除成功！"+comment_id;
    }


}



