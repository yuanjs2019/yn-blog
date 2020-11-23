package com.yuan.farmerwork.ynblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.farmerwork.ynblog.domain.YnItemsDetails;
import com.yuan.farmerwork.ynblog.domain.pojo.ItemsTitles;
import com.yuan.farmerwork.ynblog.mapper.YnItemsDetailsMapper;
import com.yuan.farmerwork.ynblog.service.YnItemsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 项目文档表 服务实现类
 * </p>
 *
 * @author yjs
 * @since 2020-11-23
 */
@Service
public class YnItemsDetailsServiceImpl extends ServiceImpl<YnItemsDetailsMapper, YnItemsDetails> implements YnItemsDetailsService {

    @Autowired
    YnItemsDetailsMapper ynItemsDetailsMapper;

    @Override
    public List<ItemsTitles> findItemsTitlesByItmsId(Long itemsId) {
        return ynItemsDetailsMapper.findItemsTitlesByItmsId(itemsId);
    }
}
