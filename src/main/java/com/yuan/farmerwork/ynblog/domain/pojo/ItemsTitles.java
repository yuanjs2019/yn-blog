package com.yuan.farmerwork.ynblog.domain.pojo;

import lombok.Data;

/**
 * 项目标签.
 *
 * @author : YJS
 * @date: 2020-11-23 13:48
 */
@Data
public class ItemsTitles {

    /**
     * 项目标签id
     */
    private Long id;
    /**
     * 项目名称
     */
    private String itemsName;

    /**
     * 项目标签名称
     */
    private String itemsTitle;

    /**
     * 类型
     */
    private String type = "";

}
