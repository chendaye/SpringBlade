package org.springblade.lengo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.lengo.entity.Blog;
import org.springblade.lengo.mapper.BlogMapper;
import org.springblade.lengo.service.BlogService;
import org.springframework.stereotype.Service;

/**
 * BlogServiceImpl增加mybatis-plus的配置
 */
@Service
public class BlogServerImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
}
