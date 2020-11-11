package com.yuan.farmerwork.ynblog.rest;

import com.github.pagehelper.PageInfo;
import com.yuan.farmerwork.ynblog.domain.pojo.SearchBlog;
import com.yuan.farmerwork.ynblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import java.util.Map;


@Controller
public class SearchController {

    @Autowired
    BlogService blogService;

    @GetMapping("/search/{page}/{searchwords}")
    public ModelAndView classify(@PathVariable String searchwords, @PathVariable Integer page, Map map) {
        map.put("keywords", searchwords);
        searchwords = "%"+searchwords+"%";
        PageInfo<SearchBlog> pageInfo = blogService.searchBlogs(searchwords, page);
        map.put("pageInfo", pageInfo);
        return new ModelAndView("search", map);
    }

    @GetMapping("/search/{page}")
    public ModelAndView searchnull(Map map,@PathVariable Integer page) {
        map.put("pageInfo", new PageInfo());
        map.put("keywords", "");
        return new ModelAndView("search", map);
    }

    @GetMapping("/search/")
    public ModelAndView searchnull2(Map map) {
        map.put("pageInfo", new PageInfo());
        map.put("keywords", "");
        return new ModelAndView("search", map);
    }
}
