package com.zzuli.moviesystem.service.impl;

import com.zzuli.moviesystem.entity.News;
import com.zzuli.moviesystem.mapper.NewsMapper;
import com.zzuli.moviesystem.service.NewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

}
