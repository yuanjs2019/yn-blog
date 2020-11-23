package com.yuan.farmerwork.ynblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuan.farmerwork.ynblog.domain.YnItemsDetails;
import com.yuan.farmerwork.ynblog.domain.pojo.ItemsTitles;

import java.util.List;

/**
 * <p>
 * 项目文档表 服务类
 * </p>
 *
 * @author yjs
 * @since 2020-11-23
 */
public interface YnItemsDetailsService extends IService<YnItemsDetails> {

    List<ItemsTitles> findItemsTitlesByItmsId(Long itemsId);
}
