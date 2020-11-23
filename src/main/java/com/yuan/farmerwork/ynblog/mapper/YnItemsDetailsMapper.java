package com.yuan.farmerwork.ynblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuan.farmerwork.ynblog.domain.YnItemsDetails;
import com.yuan.farmerwork.ynblog.domain.pojo.ItemsTitles;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 项目文档表 Mapper 接口
 * </p>
 *
 * @author yjs
 * @since 2020-11-23
 */
@Mapper
public interface YnItemsDetailsMapper extends BaseMapper<YnItemsDetails> {


    List<ItemsTitles> findItemsTitlesByItmsId(Long itemsId);
}
