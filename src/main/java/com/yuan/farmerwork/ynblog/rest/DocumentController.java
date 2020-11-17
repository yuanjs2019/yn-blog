package com.yuan.farmerwork.ynblog.rest;


import com.yuan.farmerwork.ynblog.domain.YnDocument;
import com.yuan.farmerwork.ynblog.domain.YnDocumentDetails;
import com.yuan.farmerwork.ynblog.domain.pojo.Blogs;
import com.yuan.farmerwork.ynblog.domain.pojo.DocCatalogs;
import com.yuan.farmerwork.ynblog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@Controller
public class DocumentController {

    @Autowired
    BlogService blogService;

    @Autowired
    YnDocumentService documentService;

    @Autowired
    YnDocumentDetailsService documentDetailsService;


    @GetMapping("/documents")
    public ModelAndView documents(Map map) {

        //文档数据获取
        List<YnDocument> documentList = documentService.list();
        map.put("documentList", documentList);
        //最新文章数据
        List<Blogs> blogLaterList = blogService.findBlogLaterList();
        map.put("blogLaterList", blogLaterList);
        //阅读多文章数据
        List<Blogs> readMoreList = blogService.findReadMoreList();
        map.put("readMoreList", readMoreList);
        return new ModelAndView("documents", map);
    }

    @GetMapping("/doc/{id}")
    public ModelAndView docDtails(@PathVariable Long id, Map map) {
        //获取目录
        List<DocCatalogs> docCatalogs = documentDetailsService.findDocCatalogById(id,0L);
        map.put("docCatalogs", docCatalogs);
        if (!docCatalogs.isEmpty()) {
            //获取内容
            YnDocumentDetails detailsContent = documentDetailsService.getById(docCatalogs.get(0).getId());
            map.put("detailsContent", detailsContent);
        }
        return new ModelAndView("doc", map);
    }

    @GetMapping("/doc/{docId}/{id}")
    public ModelAndView docDtails(@PathVariable Long docId, @PathVariable Long id, Map map) {
            //获取内容
            Long parentId = 0L;
            YnDocumentDetails detailsContent = documentDetailsService.getById(id);
            if (detailsContent != null) {
                map.put("detailsContent", detailsContent);
                parentId = detailsContent.getParentId();
            }

        //获取目录
        List<DocCatalogs> docCatalogs = documentDetailsService.findDocCatalogById(docId,parentId);
        map.put("docCatalogs", docCatalogs);

        return new ModelAndView("doc", map);
    }
}
