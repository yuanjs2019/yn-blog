package com.yuan.farmerwork.ynblog.rest;

import com.yuan.farmerwork.ynblog.domain.Classify;
import com.yuan.farmerwork.ynblog.domain.Series;
import com.yuan.farmerwork.ynblog.domain.Tag;
import com.yuan.farmerwork.ynblog.domain.pojo.Blogs;
import com.yuan.farmerwork.ynblog.domain.pojo.TagsName;
import com.yuan.farmerwork.ynblog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 文章详细查询.
 *
 * @author : YJS
 * @date: 2020-11-06 14:44
 */
@Controller
@RequestMapping("dtails/")
public class QueryDtailsController {

    @Autowired
    BlogService blogService;
    @Autowired
    YnReadTotallService ynReadTotallService;
    @Autowired
    TagService tagService;
    @Autowired
    SeriesService seriesService;
    @Autowired
    ClassifyService classifyService;

    @GetMapping("id/{id}")
    public ModelAndView queryArtcleById(@PathVariable Long id, Map map) {

        //根据id查询文章内容
        Blogs blog = blogService.findBlogsById(id);
        blog.setWords(blog.getTextContent().length());
        blog.setNeedRead(blog.getTextContent().length()/600+1);
        //目录数据获取
        String[] split = blog.getTextContent().split("\n");
        List<String> titleData = Arrays.stream(split).filter(x -> x.startsWith("##")).collect(Collectors.toList());
        List<String> collect = titleData.stream().map(x -> x.replaceAll("#","").trim()).collect(Collectors.toList());
        map.put("titleData",collect);


        blog.setTextContent(null);
        if ("1".equals(blog.getTypeStr())) {
            blog.setTypeStr("转载");
        } else {
            blog.setTypeStr("原创");
        }
        blog.setTagsLists(blogService.findTagsByBlogId(id));
        map.put("blog", blog);
         //查询文章总数
        ynReadTotallService.readTotoallAddCount(id);


        //边页数据
        List<Blogs> blogLaterList = blogService.findBlogLaterList();
        map.put("blogLaterList",blogLaterList);
        List<Blogs> readMoreList = blogService.findReadMoreList();
        map.put("readMoreList",readMoreList);
        List<Tag> taglist = tagService.list();
        List<Classify> classifList = classifyService.list();
        List<Series> seriesList = seriesService.list();
        map.put("tagsTotall",taglist);
        map.put("classifTotall",classifList);
        map.put("seriesTotall",seriesList);

        return new ModelAndView("details", map);
    }
}
