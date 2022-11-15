package com.zzuli.moviesystem;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        Page page = userService.pageUser(1, 5, null);
        System.out.println(page.getRecords());
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
