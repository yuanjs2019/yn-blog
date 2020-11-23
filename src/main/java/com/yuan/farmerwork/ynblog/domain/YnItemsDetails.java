package com.yuan.farmerwork.ynblog.domain;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 项目文档表
 * </p>
 *
 * @author yjs
 * @since 2020-11-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class YnItemsDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 项目id
     */
    private Long itemsId;

    /**
     * 项目标签主题
     */
    private String itemsTitle;

    /**
     * 内容
     */
    private String content;

    /**
     * 内容
     */
    private String txtContent;

    /**
     * 同级排序
     */
    private Integer orderNum;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除：0-不删除，1-删除
     */
    private Integer isDelete;


}
