package com.zzuli.moviesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.Movie;
import com.zzuli.moviesystem.entity.News;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.mapper.NewsMapper;
import com.zzuli.moviesystem.service.NewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzuli.moviesystem.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Result<Page> pageNews(int page, int pageSize, String title) {
        Page<News> pageInfo=new Page<>(page,pageSize);
        LambdaQueryWrapper<News> queryWrapper=new LambdaQueryWrapper<>();
        //添加查询条件，根据name进行like模糊查询
        queryWrapper.like(title!=null,News::getTitle,title);
        page(pageInfo, queryWrapper);
        return Result.success(pageInfo);
    }


    @Override
    public void deleteByIds(List<Long> ids) {
        LambdaQueryWrapper<News> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.in(ids!=null,News::getId,ids);
        List<News> list = list(queryWrapper);
        for (News news : list){
            Long id = news.getId();
            removeById(id);
        }
    }
}
