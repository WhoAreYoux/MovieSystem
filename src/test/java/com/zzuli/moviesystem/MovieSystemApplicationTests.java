package com.zzuli.moviesystem;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.entity.User;
import com.zzuli.moviesystem.service.MovieService;
import com.zzuli.moviesystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MovieSystemApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private MovieService movieService;

    @Test
    void contextLoads() {
    }

    @Test
    void testUser() {
        Result result = userService.pageUser(1, 5, null);
        System.out.println(result);
    }


    @Test
    void testUser2() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone,"19544530802").eq(User::getPassword,"123456");
        User user = userService.getOne(queryWrapper);
        System.out.println(user);
    }
    @Test
    void testUser1() {
        User user=new User();
        List<User> list = userService.list();
        System.out.println(list);
    }


    @Test
    void testSelectUserPage() {
        movieService.pageMovie(1,10,null);
    }

}
