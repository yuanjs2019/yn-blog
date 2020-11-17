package com.yuan.farmerwork.ynblog.domain.pojo;

import lombok.Data;

import java.util.List;

/**
 * .
 *
 * @author : YJS
 * @date: 2020-11-17 11:03
 */
@Data
public class DocCatalogs {

    private String title;
    private Long id;
    private Long docId;

    private List<DocCatalogs> docCatalogs;
}
