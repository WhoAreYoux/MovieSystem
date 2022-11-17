package com.zzuli.moviesystem.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
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
@ApiModel("用户")
@Data
public class User {

    /**
     *
     */
    @ApiModelProperty("自增id")
    private Long id;
    /**
     * 手机号 非空
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String name;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String icon;

    /**
     * 角色类型 1为用户2为管理员
     */
    @ApiModelProperty("角色类型")
    private Integer type;

    /**
     * 逻辑删除字段 默认为0  为1时代表删除
     */
    @ApiModelProperty("逻辑删除字段")
    @TableLogic
    private Integer isdeleted;


}
