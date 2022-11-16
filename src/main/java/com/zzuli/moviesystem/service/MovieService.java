package com.zzuli.moviesystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.Movie;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
public interface MovieService extends IService<Movie> {

    Page pageMovie(int page, int pageSize, String name);

    void deleteByIds(List<Long> ids);
}
