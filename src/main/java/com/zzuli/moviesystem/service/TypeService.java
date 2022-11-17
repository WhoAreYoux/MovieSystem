package com.zzuli.moviesystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.entity.Type;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
public interface TypeService extends IService<Type> {

    Page pageType(int page, int pageSize);

    Result<String> saveType(Type type);

    Result<String> updateTypeById(Type type);

    void deleteTypeById(List<Long> ids);
}
