package com.yuan.farmerwork.ynblog.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author yjs
 * @since 2020-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class YnBlogTag implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 标签主键id
     */
    private Long tagId;

    /**
     * 博客文章id
     */
    private Long blogId;


}
