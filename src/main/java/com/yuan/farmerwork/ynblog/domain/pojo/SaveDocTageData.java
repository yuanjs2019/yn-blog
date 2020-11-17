package com.yuan.farmerwork.ynblog.domain.pojo;

import lombok.Data;

/**
 * 请求保存文档章节内容.
 *
 * @author : YJS
 * @date: 2020-11-17 17:26
 */
@Data
public class SaveDocTageData {
    /**
     * 文章id
     */
    private String id;

    /**
     * 文章一级标签di
     */
    private String fristTag;
    /**
     * 小节等级：1-一级，2-二级
     */
    private String tageLevel;
    /**
     * 文章小节标题
     */
    private String docTitle;
    /**
     * 内容
     */
    private String content;
    private String textContent;
}
