package com.zzuli.moviesystem.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.Movie;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
@RestController
@RequestMapping("/movie")
@Api(tags = "套餐相关接口")
public class MovieController {

    @Autowired
    private MovieService movieService;


    /**
     * 分页查询
     * @param page 页数
     * @param pageSize 信息条数
     * @param name 电影名
     * @return Result类封装page结果
     */
    @ApiOperation(value = "电影分页查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "页码",required = true,dataTypeClass = int.class),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true,dataTypeClass = int.class),
            @ApiImplicitParam(name = "name",value = "电影名称",required = false,dataTypeClass = String.class)
    })
    @GetMapping("/page")
    public Result<Page> page(int page, int pageSize, String name){
        return movieService.pageMovie(page, pageSize, name);
    }

    /**
     * 保存电影
     * @param movie movie封装信息
     * @return result封装提示信息
     */
    @ApiOperation(value = "保存电影接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "movie",value = "封装电影实体类",required = true,dataTypeClass = Movie.class)
    })
    @PostMapping
    public Result<String> save(@RequestBody Movie movie){
        boolean save = movieService.save(movie);
        if(!save){
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
    }


    /**
     * 修改电影信息
     * @param movie movie封装信息
     * @return result封装提示信息
     */
    @ApiOperation(value = "修改电影接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "movie",value = "封装电影实体类",required = true,dataTypeClass = Movie.class),
    })
    @PutMapping
    public Result<String> update(@RequestBody Movie movie){
        boolean flag = movieService.updateById(movie);
        if(!flag){
            return Result.error("更新失败");
        }
        return Result.success("更新成功");
    }


    /**
     * 删除电影
     * @param ids id列表
     * @return result封装提示信息
     */
    @ApiOperation(value = "删除电影接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",value = "删除的电影id列表",required = true,dataTypeClass = List.class)
    })
    @DeleteMapping
    public Result<String> delete(@RequestParam List<Long> ids){
        System.out.println(ids);
        movieService.deleteByIds(ids);
        return Result.success("删除成功");
    }

}

