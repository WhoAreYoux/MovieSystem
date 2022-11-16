package com.zzuli.moviesystem.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用result返回结果，服务端响应的数据最终都会封装成此对象
 * @param <T>
 */

@Data
public class Result<T> implements Serializable {

    private Integer code; //状态码：1成功，0和其它数字为失败

    private String msg; //提示信息

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
