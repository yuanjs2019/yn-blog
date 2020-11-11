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
 * @since 2020-11-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class YnItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 项目分类id
     */
    private Integer itemClassfyId;
    /**
     * 项目分类名称
     */
    private String itemClassfyName;

    /**
     * 项目名称
     */
    private String itemName;

    /**
     * 项目简介
     */
    private String itemExplain;

    /**
     * 项目图标地址
     */
    private String itemPicture;

    /**
     * 项目地址
     */
    private String itemUrl;

    /**
     * 项目文档地址
     */
    private String itemIntroduceUrl;


}
