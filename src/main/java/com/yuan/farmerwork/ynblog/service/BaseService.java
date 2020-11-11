package com.yuan.farmerwork.ynblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuan.farmerwork.ynblog.domain.PageParam;

import java.util.List;

/**
 * 基础服务.
 *
 * @author : YJS
 * @date: 2020-10-27 14:55
 */
public interface BaseService<T,R> {
    /**
     * 分页查询
     *
     * @param param 请求参数DTO
     * @return 分页集合
     */
    default PageInfo<R> page(PageParam<T> param) {
        return PageHelper.startPage(param).doSelectPageInfo(() -> list(param.getParam()));
    }

    /**
     * 集合查询
     *
     * @param param 查询参数
     * @return 查询响应
     */
    List<R> list(T param);
}
