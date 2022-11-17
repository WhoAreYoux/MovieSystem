package com.zzuli.moviesystem.entity;

import java.time.LocalDateTime;

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
@ApiModel("新闻")
public class News {


    /**
     * id编号
     */
    @ApiModelProperty("自增id")
    private Long id;
    /**
     * 新闻标题
     */
    @ApiModelProperty("标题")
    private String title;

    /**
     * 作者
     */
    @ApiModelProperty("作者")
    private String author;

    /**
     * 发表日期
     */
    @ApiModelProperty("发表日期")
    private LocalDateTime date;

    /**
     * 内容
     */
    @ApiModelProperty("新闻内容")
    private String description;


}
