package com.zzuli.moviesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzuli.moviesystem.entity.Movie;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.mapper.MovieMapper;
import com.zzuli.moviesystem.service.MovieService;
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
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements MovieService {

    @Override
    public Page pageMovie(int page, int pageSize, String name) {
        Page<Movie> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Movie> queryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据name进行like模糊查询
        queryWrapper.like(name != null, Movie::getName, name);
        page(pageInfo, queryWrapper);
        return pageInfo;
    }

    @Override
    public Result<String> saveMovie(Movie movie) {
        boolean flag = save(movie);
        if (!flag) {
            return Result.error("添加失败");
        } else {
            return Result.success("添加成功");
        }
    }

    @Override
    public Result<String> updateMovieById(Movie movie) {
        boolean flag = updateById(movie);
        if (!flag) {
            return Result.error("更新失败");
        } else {
            return Result.success("更新成功");
        }
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        LambdaQueryWrapper<Movie> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(ids != null, Movie::getId, ids);
        List<Movie> list = list(queryWrapper);
        for (Movie movie : list) {
            Long id = movie.getId();
            removeById(id);
        }
    }
}
