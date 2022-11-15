package com.zzuli.moviesystem.entity;

import java.time.LocalDateTime;

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
public class News {


    /**
     *
     */
    private Long id;
    /**
     * 新闻标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 发表日期
     */
    private LocalDateTime date;

    /**
     * 内容
     */
    private String description;


}
