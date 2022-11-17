package com.zzuli.moviesystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.Movie;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.service.MovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
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
     * @param page 页数
     * @param pageSize 信息条数
     * @param name 电影名
     * @return Result类封装page结果
     */
    @GetMapping("/page")
    public Result<Page> page(int page, int pageSize, String name){
        return movieService.pageMovie(page, pageSize, name);
    }


    /**
     * 新增电影
     * @param movie 实体类movie
     * @return Result封装提示信息
     */
    @PostMapping
    public Result<String> save(@RequestBody Movie movie){
        return movieService.saveWithType(movie);
    }

    /**
     * 更新电影
     * @param movie 实体类movie
     * @return Result封装提示信息
     */
    @PutMapping
    public Result<String> update(@RequestBody Movie movie){
        boolean flag = movieService.updateById(movie);
        if(!flag){
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }

    /**
     * 删除电影
     * @param ids id列表
     * @return Result封装提示信息
     */
    @DeleteMapping
    public Result<String> delete(@RequestParam List<Long> ids){
        System.out.println(ids);
        movieService.deleteByIds(ids);
        return Result.success("删除成功");
    }

}

