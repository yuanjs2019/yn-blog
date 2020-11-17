package com.yuan.farmerwork.ynblog.rest.admin;

import com.yuan.farmerwork.ynblog.domain.YnDocumentDetails;
import com.yuan.farmerwork.ynblog.domain.pojo.QueryDocId;
import com.yuan.farmerwork.ynblog.mapper.YnDocumentDetailsMapper;
import com.yuan.farmerwork.ynblog.service.YnDocumentDetailsService;
import com.yuan.farmerwork.ynblog.utils.Result;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * .
 *
 * @author : YJS
 * @date: 2020-11-17 16:37
 */
@RestController
@RequestMapping("query")
public class QueryController {

    @Autowired
    YnDocumentDetailsMapper documentDetailsMapper;
    //根据
    /*
     * 文章保存，修改请求
     */
    @RequestMapping("/queryByDocId")
    public Result queryByDocId(@RequestBody QueryDocId docId) {
        List<YnDocumentDetails> docCatalogs = documentDetailsMapper.findDocCatalogById(docId.getId());
        if(!docCatalogs.isEmpty())
        docCatalogs = docCatalogs.stream().filter(x->x.getLevel()==1).collect(Collectors.toList());
        return Result.ok(docCatalogs);
    }
}
