package com.zzuli.moviesystem.mapper;

import com.zzuli.moviesystem.entity.Movie;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
@Mapper
public interface MovieMapper extends BaseMapper<Movie> {

}
