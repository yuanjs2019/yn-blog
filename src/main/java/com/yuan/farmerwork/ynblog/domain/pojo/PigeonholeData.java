package com.yuan.farmerwork.ynblog.domain.pojo;

import lombok.Data;

/**
 * 归档数据.
 *
 * @author : YJS
 * @date: 2020-11-11 16:55
 */
@Data
public class PigeonholeData {

    private Long id;
    private String yearMonth;
    private String insertTime;
    private String title;
}
