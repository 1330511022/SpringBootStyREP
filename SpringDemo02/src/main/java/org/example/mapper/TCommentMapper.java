package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.TComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 22222222222222222222
* @description 针对表【t_comment】的数据库操作Mapper
* @createDate 2024-04-03 09:40:46
* @Entity org.example.pojo.TComment
*/
@Mapper
public interface TCommentMapper extends BaseMapper<TComment> {

}




