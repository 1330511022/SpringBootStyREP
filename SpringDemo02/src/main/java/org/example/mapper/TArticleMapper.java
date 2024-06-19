package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.TArticle;

/**
 * @author xioaMa
 * @description 针对表【t_article】的数据库操作Mapper
 * @createDate 2024-04-03 09:39:20
 * @Entity org.example.pojo.TArticle
 */
@Mapper
public interface TArticleMapper extends BaseMapper<TArticle> {

}




