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
 * @since 2020-11-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class YnDocumentDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 文档id
     */
    private Long docId;

    /**
     * 副标题
     */
    private String subhead;

    /**
     * 内容
     */
    private String content;

    /**
     * 内容
     */
    private String txtContent;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 是否存在数据：0-不存在，1-存在
     */
    private Integer isData;

    /**
     * 同级排序
     */
    private Integer orderNum;

    /**
     * 是否删除：0-不删除，1-删除
     */
    private Integer isDelete;


}
