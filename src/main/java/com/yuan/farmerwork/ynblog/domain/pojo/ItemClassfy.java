package com.yuan.farmerwork.ynblog.domain.pojo;

import com.yuan.farmerwork.ynblog.domain.YnItems;
import lombok.Data;

import java.util.List;

/**
 * 分类项目.
 *
 * @author : YJS
 * @date: 2020-11-09 17:05
 */
@Data
public class ItemClassfy {
    /**
     * 项目分类名称
     */
    private String itemClassfyName;

    private List<YnItems> ynItems;
}
