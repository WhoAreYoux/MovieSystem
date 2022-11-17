package com.zzuli.moviesystem.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.Movie;
import com.zzuli.moviesystem.entity.News;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.service.MovieService;
import com.zzuli.moviesystem.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    /**
     * 分页查询
     * @param page 页数
     * @param pageSize 信息条数
     * @param title 标题
     * @return Result类封装page结果
     */
    @GetMapping("/page")
    public Result<Page> page(int page, int pageSize, String title){
        return newsService.pageNews(page, pageSize, title);
    }


    /**
     * 新增新闻
     * @param news 实体类news
     * @return Result封装提示信息
     */
    @PostMapping
    public Result<String> save(@RequestBody News news){
        boolean save = newsService.save(news);
        if(!save){
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
    }

    /**
     * 更新新闻
     * @param news 实体类news
     * @return Result封装提示信息
     */
    @PutMapping
    public Result<String> update(@RequestBody News news){
        boolean flag = newsService.updateById(news);
        if(!flag){
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }

    /**
     * 删除新闻
     * @param ids id列表
     * @return Result封装提示信息
     */
    @DeleteMapping
    public Result<String> delete(@RequestParam List<Long> ids){
        System.out.println(ids);
        newsService.deleteByIds(ids);
        return Result.success("删除成功");
    }


}

