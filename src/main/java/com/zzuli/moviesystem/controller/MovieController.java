package com.zzuli.moviesystem.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.Movie;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.service.MovieService;
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
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;


    /**
     * 分页查询
     *
     * @param page     页数
     * @param pageSize 信息条数
     * @param name     电影名
     * @return Result类封装page结果
     */
    @GetMapping("/page")
    public Result<Page> page(int page, int pageSize, String name) {
        Page pageMovie = movieService.pageMovie(page, pageSize, name);
        return Result.success(pageMovie);
    }


    @PostMapping
    public Result<String> save(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }


    @PutMapping
    public Result<String> update(@RequestBody Movie movie) {
        return movieService.updateMovieById(movie);
    }

    @DeleteMapping
    public Result<String> delete(@RequestParam List<Long> ids) {
        System.out.println(ids);
        movieService.deleteByIds(ids);
        return Result.success("删除成功");
    }

}

