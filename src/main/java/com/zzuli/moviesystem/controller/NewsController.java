package com.zzuli.moviesystem.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.Movie;
import com.zzuli.moviesystem.entity.News;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "新闻相关接口")
public class NewsController {
    @Autowired
    private NewsService newsService;


    /**
     * 分页查询
     * @param page 页数
     * @param pageSize 信息条数
     * @param title 电影名
     * @return Result类封装page结果
     */
    @ApiOperation(value = "新闻分页查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "页码",required = true,dataTypeClass = int.class),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true,dataTypeClass = int.class),
            @ApiImplicitParam(name = "title",value = "新闻标题名称",required = false,dataTypeClass = String.class)
    })
    @GetMapping("/page")
    public Result<Page> page(int page, int pageSize, String title) {
        Page pageNews = newsService.pageNews(page, pageSize, title);
        return Result.success(pageNews);
    }


    /**
     * 保存新闻
     * @param news news封装信息
     * @return result封装提示信息
     */
    @ApiOperation(value = "保存新闻接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "news",value = "封装新闻实体类",required = true,dataTypeClass = News.class)
    })
    @PostMapping
    public Result<String> save(@RequestBody News news) {
        return newsService.saveNews(news);
    }


    /**
     * 修改新闻
     * @param news news封装信息
     * @return result封装提示信息
     */
    @ApiOperation(value = "修改新闻接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "news",value = "封装新闻实体类",required = true,dataTypeClass = News.class)
    })
    @PutMapping
    public Result<String> update(@RequestBody News news) {
        return newsService.updateNewsById(news);
    }



    /**
     * 删除新闻
     * @param ids id列表
     * @return result封装提示信息
     */
    @ApiOperation(value = "删除新闻接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",value = "删除的新闻id列表",required = true,dataTypeClass = List.class)
    })
    @DeleteMapping
    public Result<String> delete(@RequestParam List<Long> ids) {
        System.out.println(ids);
        newsService.deleteNewsById(ids);
        return Result.success("删除成功");
    }

}

