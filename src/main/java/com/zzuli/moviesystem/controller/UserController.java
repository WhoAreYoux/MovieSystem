package com.zzuli.moviesystem.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.entity.User;
import com.zzuli.moviesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 分页查询
     * @param page 起始页
     * @param pageSize 页的大小
     * @param phone 手机号
     * @return 返回Result封装的page对象
     */
    @GetMapping("/page")
    public Result<Page> page(int page, int pageSize, String phone){
        return userService.pageUser(page, pageSize, phone);
    }

    /**
     * 登录
     * @param user 用户信息
     * @param request request请求对象
     * @return 返回Result封装的提示信息
     */
    @PostMapping("/login")
    public Result<String> login(@RequestBody User user,HttpServletRequest request){
        return userService.login(user,request);
    }


    /**
     * 退出登录
     * @param request request请求对象
     * @return 返回Result封装的提示信息
     */
    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request){
        //清除session中的id
        request.getSession().removeAttribute("phone");
        return Result.success("退出成功");
    }
}

