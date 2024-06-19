package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.pojo.TArticle;
import org.example.service.TArticleService;
import org.example.mapper.TArticleMapper;
import org.springframework.stereotype.Service;

/**
* @author xiaoMa
* @description 针对表【t_article】的数据库操作Service实现
* @createDate 2024-04-03 09:39:20
*/
@Service
public class TArticleServiceImpl extends ServiceImpl<TArticleMapper, TArticle>
    implements TArticleService{

}




