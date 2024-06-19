package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.pojo.TComment;
import org.example.service.TCommentService;
import org.example.mapper.TCommentMapper;
import org.springframework.stereotype.Service;

/**
* @author xiaoMa
* @description 针对表【t_comment】的数据库操作Service实现
* @createDate 2024-04-03 09:40:46
*/
@Service
public class TCommentServiceImpl extends ServiceImpl<TCommentMapper, TComment>
    implements TCommentService{

}




