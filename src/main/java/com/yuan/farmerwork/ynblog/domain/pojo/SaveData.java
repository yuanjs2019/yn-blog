package com.yuan.farmerwork.ynblog.domain.pojo;

import lombok.Data;

/**
 * 保存数据.
 *
 * @author : YJS
 * @date: 2020-11-05 18:01
 */
@Data
public class SaveData {

    private Long id;

    private String content;

    private String textContent;

    private String artcleTitle;

    private String artclePicture;

    private String author;

    private String artcleIntro;

    private String tagsStr;

    private String classifStr;

    private String seriesxStr;

    private String type;
}
