package com.zzuli.moviesystem.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzuli
 * @since 2022-11-15
 */
@Data
public class Movie {


    /**
     *
     */
    private Long id;
    /**
     * 电影名称
     */
    private String name;

    /**
     * 导演名称
     */
    private String director;

    /**
     * 演员名称
     */
    private String actor;

    /**
     * 电影类型
     */
    private String type;

    /**
     * 出品国家
     */
    private String country;

    /**
     * 出品年份
     */
    private LocalDate time;

    /**
     * 评分
     */
    private Double score;

    /**
     * 图片
     */
    private String photo;

    /**
     * 片源
     */
    private String href;

    /**
     * 描述
     */
    private String description;


}
