package com.zzuli.moviesystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzuli.moviesystem.entity.Movie;
import com.zzuli.moviesystem.entity.Result;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
public interface MovieService extends IService<Movie> {

    Page pageMovie(int page, int pageSize, String name);

    Result<String> saveMovie(Movie movie);

    Result<String> updateMovieById(Movie movie);

    void deleteByIds(List<Long> ids);
}
