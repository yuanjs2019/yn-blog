package com.yuan.farmerwork.ynblog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.farmerwork.ynblog.domain.YnDocumentDetails;
import com.yuan.farmerwork.ynblog.domain.pojo.DocCatalogs;
import com.yuan.farmerwork.ynblog.domain.pojo.OutPigeData;
import com.yuan.farmerwork.ynblog.mapper.YnDocumentDetailsMapper;
import com.yuan.farmerwork.ynblog.service.YnDocumentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yjs
 * @since 2020-11-17
 */
@Service
public class YnDocumentDetailsServiceImpl extends ServiceImpl<YnDocumentDetailsMapper, YnDocumentDetails>
        implements YnDocumentDetailsService {

    @Autowired
    YnDocumentDetailsMapper documentDetailsMapper;

    @Override
    public List<DocCatalogs> findDocCatalogById(Long docId) {
        List<DocCatalogs> docCatalogAll = new ArrayList<>();
        List<YnDocumentDetails> docCatalogs = documentDetailsMapper.findDocCatalogById(docId);
        List<YnDocumentDetails> firstLevels = docCatalogs.stream()
                .filter(x -> x.getLevel() == 1)
                .sorted(Comparator.comparing(YnDocumentDetails::getOrderNum)).collect(Collectors.toList());
        firstLevels.stream().map(x -> {
            Long id = x.getId();
            List<YnDocumentDetails> secondLeves = docCatalogs.stream()
                    .filter(y -> y.getParentId() == id)
                    .sorted(Comparator.comparing(YnDocumentDetails::getOrderNum))
                    .collect(Collectors.toList());
            DocCatalogs docCatalogfrist = new DocCatalogs();
            if (!secondLeves.isEmpty()) {
                List<DocCatalogs> docCatalogsList = new ArrayList<>();
                secondLeves.stream().map(z -> {
                    DocCatalogs docCatalog = new DocCatalogs();
                    docCatalog.setId(z.getId());
                    docCatalog.setTitle(z.getSubhead());
                    docCatalog.setDocId(docId);
                    docCatalogsList.add(docCatalog);
                    return z;
                }).collect(Collectors.toList());
                docCatalogfrist.setDocCatalogs(docCatalogsList);
            }
            docCatalogfrist.setId(id);
            docCatalogfrist.setDocId(docId);
            docCatalogfrist.setTitle(x.getSubhead());
            docCatalogAll.add(docCatalogfrist);
            return x;
        }).collect(Collectors.toList());
        //只考慮两层
        return docCatalogAll;
    }
}
