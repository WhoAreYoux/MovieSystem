package com.zzuli.moviesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzuli.moviesystem.entity.News;
import com.zzuli.moviesystem.entity.Result;
import com.zzuli.moviesystem.entity.Type;
import com.zzuli.moviesystem.mapper.TypeMapper;
import com.zzuli.moviesystem.service.TypeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

    @Override
    public Result<Page> pageType(int page, int pageSize) {
        Page<Type> pageInfo = new Page<>(page, pageSize);
        page(pageInfo, null);
        return Result.success(pageInfo);
    }

    @Override
    public Result<String> saveType(@RequestBody Type type) {
        boolean flag = save(type);
        if (!flag) {
            return Result.error("添加失败");
        } else {
            return Result.success("添加成功");
        }
    }

    @Override
    public Result<String> updateTypeById(@RequestBody Type type) {
        boolean flag = updateById(type);
        if (!flag) {
            return Result.error("更新失败");
        } else {
            return Result.success("更新成功");
        }
    }

    @Override
    public void deleteTypeById(List<Long> ids) {//多项删除
        LambdaQueryWrapper<Type> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(ids != null, Type::getId, ids);
        List<Type> typeList = list(queryWrapper);

        for (Type type : typeList) {
            long id = type.getId();
            removeById(id);
        }
    }
}
