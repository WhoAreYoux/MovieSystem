package com.zzuli.moviesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzuli.moviesystem.entity.Movie;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.entity.Type;
import com.zzuli.moviesystem.mapper.MovieMapper;
import com.zzuli.moviesystem.service.MovieService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzuli.moviesystem.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
@Service
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements MovieService {

    @Autowired
    private TypeService typeService;

    @Override
    public Result<Page> pageMovie(int page, int pageSize, String name) {
        Page<Movie> pageInfo=new Page<>(page,pageSize);
        LambdaQueryWrapper<Movie> queryWrapper=new LambdaQueryWrapper<>();
        //添加查询条件，根据name进行like模糊查询
        queryWrapper.like(name!=null,Movie::getName,name);
        page(pageInfo, queryWrapper);
        return Result.success(pageInfo);
    }

    @Override
    public Result<String> saveWithType(Movie movie) {
        boolean save = save(movie);
        if(!save){
            return Result.error("保存失败");
        }
        String typeName = movie.getType();
        LambdaQueryWrapper<Type> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(typeName!=null,Type::getName,typeName);
        Type one = typeService.getOne(queryWrapper);
        if(one==null){
            one=new Type();
            one.setName(typeName);
            typeService.save(one);
        }
        return Result.success("保存成功");
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        LambdaQueryWrapper<Movie> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.in(ids!=null,Movie::getId,ids);
        List<Movie> list = list(queryWrapper);
        for (Movie movie : list){
            Long id = movie.getId();
            removeById(id);
        }
    }
}
