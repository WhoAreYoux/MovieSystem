package com.zzuli.moviesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzuli.moviesystem.entity.News;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.mapper.NewsMapper;
import com.zzuli.moviesystem.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Override
    public Page pageNews(int page, int pageSize, String title) {
        Page<News> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<News> queryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据title进行like模糊查询
        queryWrapper.like(title != null, News::getTitle, title);
        page(pageInfo, queryWrapper);
        return pageInfo;
    }

    @Override
    public Result<String> saveNews(News news) {
        boolean flag = save(news);
        if (!flag) {
            return Result.error("添加失败");
        } else {
            return Result.success("添加成功");
        }
    }

    @Override
    public Result<String> updateNewsById(News news) {
        boolean flag = updateById(news);
        if (!flag) {
            return Result.error("更新失败");
        } else {
            return Result.success("更新成功");
        }
    }

    @Override
    public void deleteNewsById(List<Long> ids) {
        LambdaQueryWrapper<News> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(ids != null, News::getId, ids);
        List<News> newsList = list(queryWrapper);
        for (News news : newsList) {
            long id = news.getId();
            removeById(id);
        }
    }
}
