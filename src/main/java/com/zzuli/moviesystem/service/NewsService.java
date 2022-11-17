package com.zzuli.moviesystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.News;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzuli.moviesystem.entity.Result;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
public interface NewsService extends IService<News> {

    void deleteByIds(List<Long> ids);

    Result<Page> pageNews(int page, int pageSize, String title);
}
