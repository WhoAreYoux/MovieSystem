package com.zzuli.moviesystem.entity;

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
@ApiModel("电影类型")
@Data
public class Type {

    /**
     *
     */
    @ApiModelProperty("自增id")
    private Long id;
    /**
     * 电影类型
     */
    @ApiModelProperty("电影类型名称")
    private String name;


}
