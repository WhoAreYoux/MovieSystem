package com.zzuli.moviesystem.mapper;

import com.zzuli.moviesystem.entity.News;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
@Mapper
public interface NewsMapper extends BaseMapper<News> {

    @Select("select * from tb_user")
    void findAll();

}
