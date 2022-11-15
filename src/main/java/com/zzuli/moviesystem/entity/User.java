package com.zzuli.moviesystem.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
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
public class User {

    /**
     *
     */
    private Long id;
    /**
     * 手机号 非空
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String name;

    /**
     * 头像
     */
    private String icon;

    /**
     * 角色类型 1为用户2为管理员
     */
    private Integer type;

    /**
     * 逻辑删除字段 默认为0  为1时代表删除
     */
    @TableLogic
    private Integer isdeleted;


}
