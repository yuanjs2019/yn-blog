package com.yuan.farmerwork.ynblog.domain;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实体对象BLOG.
 * @author yjs
 * @since 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章描述
     */
    private String description;

    /**
     * 内容md格式
     */
    private String textContent;

    /**
     * 内容(带有样式）
     */
    private String content;

    /**
     * 文章头图片
     */
    private String mainPicture;

    /**
     * 作者
     */
    private String author;

    /**
     * 系列code
     */
    private String seriesCode;

    /**
     * 文章类型：1-转载，2-原创
     */
    private String type;

    /**
     * 年份
     */
    private Integer year;

    /**
     * 月份
     */
    private Integer month;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
