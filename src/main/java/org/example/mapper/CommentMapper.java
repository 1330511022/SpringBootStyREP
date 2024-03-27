package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.prjo.Comment;

/**
 * @Project: SpringDemo
 * @Package: org.example.mysqltest
 * @author: maZhuo
 * @Email:17320080198@163.com
 * @date: 2024年03月20日 11:33
 */
@Mapper
public interface CommentMapper {
    @Select("select * from t_comment where id=#{id}")
    Comment findById(Integer id);

    @Select("select * from t_comment")
    Comment findAll();

    @Insert("INSERT INTO t_comment(CONTENT, AUTHOR, A_ID)" + "values(#{content},#{author},#{aId})")
    int instComment(Comment comment);

    @Update("update t_comment set content=#{content} where id=#{id}")
    int updateComment(Comment comment);

    @Delete("delete from t_comment where id=#{id}")
    int deleteComment(Integer id);
}
