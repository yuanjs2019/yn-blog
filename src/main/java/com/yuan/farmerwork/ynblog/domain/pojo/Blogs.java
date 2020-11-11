package com.yuan.farmerwork.ynblog.domain.pojo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 文章数据列表.
 *
 * @author : YJS
 * @date: 2020-11-06 11:18
 */
@Data
public class Blogs {

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
     * 文章头图片
     */
    private String mainPicture;

    /**
     * 作者
     */
    private String author;


    /**
     * 文章类型：1-转载，2-原创
     */
    private String typeStr;


    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 内容
     */
    private String content;

    /**
     * md内容
     */
    private String textContent;

    /**
     * 标签集合
     */
    private List<TagsName> tagsLists;


    private Integer words;

    private Integer needRead;

    /**
     * 阅读次数
     */
    private Long readNums;

}
