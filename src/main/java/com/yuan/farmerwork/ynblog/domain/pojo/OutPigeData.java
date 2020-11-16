package com.yuan.farmerwork.ynblog.domain.pojo;

import lombok.Data;

import java.util.List;

/**
 * .
 *
 * @author : YJS
 * @date: 2020-11-11 17:53
 */
@Data
public class OutPigeData {

    private Long yearMonth;
    private List<PigeonholeData> pigeonholeData;
}
