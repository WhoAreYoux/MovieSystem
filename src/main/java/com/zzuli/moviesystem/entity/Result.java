package com.zzuli.moviesystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用result返回结果，服务端响应的数据最终都会封装成此对象
 * @param <T>
 */

@Data
@ApiModel("封装返回结果")
public class Result<T> implements Serializable {

    @ApiModelProperty("状态码")
    private Integer code; //状态码：1成功，0和其它数字为失败

    @ApiModelProperty("失败提示信息")
    private String msg; //提示信息

    @ApiModelProperty("成功返回数据")
    private T data; //数据


    public static <T> Result<T> success(T object) {
        Result<T> r = new Result<>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> Result<T> error(String msg) {
        Result r = new Result();
        r.msg = msg;
        r.code = 0;
        return r;
    }


}
