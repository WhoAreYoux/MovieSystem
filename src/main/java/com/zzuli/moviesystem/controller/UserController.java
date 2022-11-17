package com.zzuli.moviesystem.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.entity.Type;
import com.zzuli.moviesystem.entity.User;
import com.zzuli.moviesystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
@Api(tags = "用户相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户分页查询
     * @param page 页码
     * @param pageSize 记录数
     * @param phone 手机号
     * @return
     */
    @ApiOperation(value = "用户分页查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "页码",required = true,dataTypeClass = int.class),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true,dataTypeClass = int.class),
            @ApiImplicitParam(name = "phone",value = "手机号",required = false,dataTypeClass = String.class)
    })
    @GetMapping("/page")
    public Result<Page> page(int page, int pageSize, String phone){
        return userService.pageUser(page, pageSize, phone);
    }


    /**
     * 用户登录
     * @param user 用户信息
     * @param request
     * @return result封装提示信息
     */
    @ApiOperation(value = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user",value = "用户信息",required = true,dataTypeClass = User.class)
    })
    @PostMapping("/login")
    public Result<String> login(@RequestBody User user,HttpServletRequest request){
        return userService.login(user,request);
    }


    /**
     * 退出登录
     * @param request
     * @return
     */
    @ApiOperation(value = "退出登录接口")
    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request){
        //清除session中的id
        request.getSession().removeAttribute("phone");
        return Result.success("退出成功");
    }
}

