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
public class YnMian implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 主页介绍
     */
    private String mainTitle;


}
