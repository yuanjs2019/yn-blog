package com.yuan.farmerwork.ynblog.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yjs
 * @since 2020-11-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class YnLinks implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
    /**
     * 链接资源名称
     */
    private String linkName;

    /**
     * 链接资源地址
     */
    private String linkUrl;

    /**
     * 链接资源介绍
     */
    private String linkDescption;

    /**
     * 是否删除：0-不删除，1-删除
     */
    private Integer isDelelte;


}
