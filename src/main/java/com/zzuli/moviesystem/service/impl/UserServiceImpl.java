package com.zzuli.moviesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.Movie;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.entity.User;
import com.zzuli.moviesystem.mapper.UserMapper;
import com.zzuli.moviesystem.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Result<Page> pageUser(int page, int pageSize, String phone) {
        Page<User> pageInfo=new Page<>(page,pageSize);
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        //添加查询条件，根据name进行like模糊查询
        queryWrapper.like(phone!=null,User::getPhone,phone);
        page(pageInfo, queryWrapper);
        return Result.success(pageInfo);
    }

    @Override
    public Result<String> login(@RequestBody User user, HttpServletRequest request) {

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone,user.getPhone()).eq(User::getPassword,user.getPassword());
        User one = getOne(queryWrapper);
        if(one==null){
            return Result.error("账号或密码错误");
        }
        request.getSession().setAttribute("phone",one.getPhone());
        return Result.success(null);
    }
}
