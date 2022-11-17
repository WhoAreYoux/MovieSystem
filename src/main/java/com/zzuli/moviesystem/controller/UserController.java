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


    @GetMapping("/page")
    public Result<Page> page(int page, int pageSize, String phone){
        return userService.pageUser(page, pageSize, phone);
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody User user,HttpServletRequest request){
        return userService.login(user,request);
    }


    /**
     * 退出登录
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request){
        //清除session中的id
        request.getSession().removeAttribute("phone");
        return Result.success("退出成功");
    }
}

