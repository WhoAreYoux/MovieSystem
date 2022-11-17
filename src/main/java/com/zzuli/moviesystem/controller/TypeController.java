package com.zzuli.moviesystem.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.entity.Type;
import com.zzuli.moviesystem.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/page")
    public Result<Page> page(int page, int pageSize) {
        Page pageType = typeService.pageType(page, pageSize);
        return Result.success(pageType);
    }

    @GetMapping("/list")
    public Result<List<Type>> list() {
        List<Type> list = typeService.list();
        return Result.success(list);
    }

    @PostMapping
    public Result<String> save(@RequestBody Type type) {
        return typeService.saveType(type);
    }

    @PutMapping
    public Result<String> update(@RequestBody Type type) {
        return typeService.updateTypeById(type);
    }

    @DeleteMapping
    public Result<String> delete(@RequestParam List<Long> ids) {
        System.out.println(ids);
        typeService.deleteTypeById(ids);
        return Result.success("删除成功");
    }
}

