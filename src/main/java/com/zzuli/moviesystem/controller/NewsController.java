package com.zzuli.moviesystem.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.News;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
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

    @GetMapping("/page")
    public Result<Page> page(int page, int pageSize, String title) {
        Page pageNews = newsService.pageNews(page, pageSize, title);
        return Result.success(pageNews);
    }

    @PostMapping
    public Result<String> save(@RequestBody News news) {
        return newsService.saveNews(news);
    }

    @PutMapping
    public Result<String> update(@RequestBody News news) {
        return newsService.updateNewsById(news);
    }

    @DeleteMapping
    public Result<String> delete(@RequestParam List<Long> ids) {
        System.out.println(ids);
        newsService.deleteNewsById(ids);
        return Result.success("删除成功");
    }
}

