package com.zzuli.moviesystem;

import com.zzuli.moviesystem.controller.TypeController;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.entity.Type;
import com.zzuli.moviesystem.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TypeTest {

    @Autowired
    private TypeService typeService;

    @Test
    void contextLoads() {
        List<Type> list = typeService.list();
        System.out.println(list);
    }

    @Test
    void contextLoads1() {
        Type type = new Type();
        type.setName("只因");
        typeService.saveType(type);
    }

    @Test
    void update(){

    }

    @Test
    void delete(){

    }
}
