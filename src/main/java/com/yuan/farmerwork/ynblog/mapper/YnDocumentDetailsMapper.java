package com.yuan.farmerwork.ynblog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuan.farmerwork.ynblog.domain.YnDocumentDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yjs
 * @since 2020-11-17
 */
@Mapper
public interface YnDocumentDetailsMapper extends BaseMapper<YnDocumentDetails> {


    List<YnDocumentDetails> findDocCatalogById(Long docId);

    int findMaxOrder(@Param("docId") Long docId, @Param("parentId") Long parentId);

}
