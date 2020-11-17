package com.yuan.farmerwork.ynblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuan.farmerwork.ynblog.domain.YnDocumentDetails;
import com.yuan.farmerwork.ynblog.domain.pojo.DocCatalogs;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yjs
 * @since 2020-11-17
 */
public interface YnDocumentDetailsService extends IService<YnDocumentDetails> {


    List<DocCatalogs> findDocCatalogById(Long docId,Long id);

    int findMaxOrder(Long docId,Long parentId);
}
