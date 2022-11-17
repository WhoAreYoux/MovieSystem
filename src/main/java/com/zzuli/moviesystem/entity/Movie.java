package com.zzuli.moviesystem.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("电影")
public class Movie {


    /**
     * id编号
     */
    @ApiModelProperty("自增id")
    private Long id;
    /**
     * 电影名称
     */
    @ApiModelProperty("电影名称")
    private String name;

    /**
     * 导演名称
     */
    @ApiModelProperty("导演名称")
    private String director;

    /**
     * 演员名称
     */
    @ApiModelProperty("演员名称")
    private String actor;

    /**
     * 电影类型
     */
    @ApiModelProperty("电影类型")
    private String type;

    /**
     * 出品国家
     */
    @ApiModelProperty("出品国家")
    private String country;

    /**
     * 出品年份
     */
    @ApiModelProperty("出品年份")
    private LocalDate time;

    /**
     * 评分
     */
    @ApiModelProperty("电影评分")
    private Double score;

    /**
     * 图片
     */
    @ApiModelProperty("图片")
    private String photo;

    /**
     * 片源
     */
    @ApiModelProperty("视频片源")
    private String href;

    /**
     * 描述
     */
    @ApiModelProperty("影片介绍")
    private String description;


}
