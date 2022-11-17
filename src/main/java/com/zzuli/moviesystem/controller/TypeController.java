package com.zzuli.moviesystem.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.entity.Type;
import com.zzuli.moviesystem.service.TypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "电影类型相关接口")
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**
     * 电影类型分页查询
     * @param page 页码
     * @param pageSize 记录数
     * @return result封装page信息
     */
    @ApiOperation(value = "电影类型分页查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "页码",required = true,dataTypeClass = int.class),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true,dataTypeClass = int.class)
    })
    @GetMapping("/page")
    public Result<Page> page(int page, int pageSize) {
        Page pageType = typeService.pageType(page, pageSize);
        return Result.success(pageType);
    }


    /**
     * 查询全部电影类型
     * @return result封装list列表
     */
    @ApiOperation(value = "电影类型查全部接口")
    @GetMapping("/list")
    public Result<List<Type>> list() {
        List<Type> list = typeService.list();
        return Result.success(list);
    }


    /**
     * 新增电影类型
     * @param type type封装信息
     * @return result封装提示信息
     */
    @ApiOperation(value = "保存电影类型接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "电影类型类封装信息",required = true,dataTypeClass = Type.class)
    })
    @PostMapping
    public Result<String> save(@RequestBody Type type) {
        return typeService.saveType(type);
    }


    /**
     * 修改电影类型
     * @param type type封装信息
     * @return  result封装提示信息
     */
    @ApiOperation(value = "修改电影类型接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "电影类型",required = true,dataTypeClass = Type.class)
    })
    @PutMapping
    public Result<String> update(@RequestBody Type type) {
        return typeService.updateTypeById(type);
    }


    /**
     * 删除电影类型
     * @param ids id列表
     * @return result封装提示信息
     */
    @ApiOperation(value = "删除电影类型接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",value = "删除的类型的id列表",required = true,dataTypeClass = List.class)
    })
    @DeleteMapping
    public Result<String> delete(@RequestParam List<Long> ids) {
        System.out.println(ids);
        typeService.deleteTypeById(ids);
        return Result.success("删除成功");
    }
}

