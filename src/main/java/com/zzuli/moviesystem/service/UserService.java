package com.zzuli.moviesystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
public interface UserService extends IService<User> {

    public Page pageUser(int page, int pageSize, String name);
}
