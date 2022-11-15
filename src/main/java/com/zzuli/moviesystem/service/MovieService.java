package com.zzuli.moviesystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.Movie;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
public interface MovieService extends IService<Movie> {

    public Page pageMovie(int page, int pageSize, String name);

}
