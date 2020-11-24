package com.yuan.farmerwork.ynblog.rest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.yuan.farmerwork.ynblog.domain.Blog;
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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author : YJS
 * @date: 2020-11-06 15:30
 */
@Controller
public class QueryListSimpleController {

    @Autowired
    BlogService blogService;
    @Autowired
    TagService tagService;
    @Autowired
    SeriesService seriesService;
    @Autowired
    ClassifyService classifyService;
    @Autowired
    YnBlogTagService ynBlogTagService;


    @GetMapping("/blog")
    public ModelAndView blogIndex(Map map) {
        return queryBlogsList(1, map);
    }

    @GetMapping("/blog/page/{page}")
    public ModelAndView blog(@PathVariable Integer page, Map map) {
        return queryBlogsList(page, map);
    }

    @GetMapping("/tag/{tag}")
    public ModelAndView tagBlogs(@PathVariable String tag, Map map) {
        return queryTagList(tag, 1, map);
    }

    @GetMapping("/tag/{page}/{tag}")
    public ModelAndView tagBlogs(@PathVariable String tag, @PathVariable Integer page, Map map) {
        return queryTagList(tag, page, map);
    }

    @GetMapping("/classfy/{classfy}")
    public ModelAndView classfyBlogs(@PathVariable String classfy, Map map) {
        return queryClassfyList(classfy, 1, map);
    }

    @GetMapping("/classfy/{page}/{classfy}")
    public ModelAndView classfyBlogs(@PathVariable String classfy, @PathVariable Integer page, Map map) {
        return queryClassfyList(classfy, page, map);
    }
    @GetMapping("/series/{series}")
    public ModelAndView seriesBlogs(@PathVariable String series, Map map) {
        return querySeriesList(series, 1, map);
    }

    @GetMapping("/series/{page}/{series}")
    public ModelAndView seriesBlogs(@PathVariable String series, @PathVariable Integer page,Map map) {
        return querySeriesList(series, page, map);
    }
/*    @GetMapping("/series/{series}")
    public ModelAndView seriesBlogs(@PathVariable String series, Map map) {
        return querySeriesList(series, null, map);
    }

    @GetMapping("/series/{series}/{id}")
    public ModelAndView seriesBlogs(@PathVariable String series, @PathVariable Long id, Map map) {
        return querySeriesList(series, id, map);
    }*/

    private ModelAndView queryBlogsList(Integer page, Map map) {
        PageInfo<Blogs> blogList = blogService.findBlogList(page);
        List<Blogs> blogsList = blogList.getList().stream().map(x -> {
            if ("1".equals(x.getTypeStr())) {
                x.setTypeStr("转载");
            } else {
                x.setTypeStr("原创");
            }
            x.setTagsLists(blogService.findTagsByBlogId(x.getId()));
            return x;
        }).collect(Collectors.toList());
        blogList.setList(blogsList);
        map.put("blogsList", blogList);
        List<Blogs> blogLaterList = blogService.findBlogLaterList();
        map.put("blogLaterList", blogLaterList);
        List<Blogs> readMoreList = blogService.findReadMoreList();
        map.put("readMoreList", readMoreList);
        List<Tag> taglist = tagService.list();
        List<Classify> classifList = classifyService.list();
        List<Series> seriesList = seriesService.list();
        map.put("tagsTotall", taglist);
        map.put("classifTotall", classifList);
        map.put("seriesTotall", seriesList);
        return new ModelAndView("blog", map);
    }

    private ModelAndView queryTagList(String tag, Integer page, Map map) {
        PageInfo<Blogs> blogBytagCode = blogService.findBlogBytagCode(tag, page);
        List<Blogs> blogsList = blogBytagCode.getList().stream().map(x -> {
            if ("1".equals(x.getTypeStr())) {
                x.setTypeStr("转载");
            } else {
                x.setTypeStr("原创");
            }
            x.setTagsLists(blogService.findTagsByBlogId(x.getId()));
            return x;
        }).collect(Collectors.toList());
        blogBytagCode.setList(blogsList);
        map.put("blogsList", blogBytagCode);
        map.put("tagTitleCode", tag);
        if (blogBytagCode.getList().isEmpty()) {
            map.put("tagTitleName", tag);
        } else {
            List<TagsName> tagsLists = blogBytagCode.getList().get(0).getTagsLists();
            tagsLists.stream().map(y -> {
                if (tag.equals(y.getTagsCode())) {
                    map.put("tagTitleName", y.getTagsName());
                }
                return y;
            }).collect(Collectors.toList());
        }
        return new ModelAndView("blog-tag", map);
    }

    private ModelAndView queryClassfyList(String classfy, Integer page, Map map) {
        PageInfo<Blogs> blogByClassfyCode = blogService.findBlogByclassfCode(classfy, page);
        List<Blogs> blogsList = blogByClassfyCode.getList().stream().map(x -> {
            if ("1".equals(x.getTypeStr())) {
                x.setTypeStr("转载");
            } else {
                x.setTypeStr("原创");
            }
            x.setTagsLists(blogService.findTagsByBlogId(x.getId()));
            return x;
        }).collect(Collectors.toList());
        blogByClassfyCode.setList(blogsList);
        map.put("blogsList", blogByClassfyCode);
        map.put("classfyTitleCode", classfy);
        Classify classify = classifyService.getOne(new QueryWrapper<Classify>().eq("classify_code", classfy));
        if (classify == null) {
            map.put("classfyTitleName", classfy);
        } else {
            map.put("classfyTitleName", classify.getClassifyName());
        }
        return new ModelAndView("blog-classfy", map);
    }

    private ModelAndView querySeriesList(String series,  Integer page, Map map) {
        if (series != null && !"".equals(series)) {
            PageInfo<Blogs> blogByseriesCode = blogService.findBlogByseriesCode(series,page);
            List<Blogs> blogsList = blogByseriesCode.getList().stream().map(x -> {
                if ("1".equals(x.getTypeStr())) {
                    x.setTypeStr("转载");
                } else {
                    x.setTypeStr("原创");
                }
                x.setTagsLists(blogService.findTagsByBlogId(x.getId()));
                return x;
            }).collect(Collectors.toList());
            blogByseriesCode.setList(blogsList);
            map.put("blogsList", blogByseriesCode);
        } else {
            map.put("blogsList", new PageInfo());
        }
        map.put("seriesTitleCode", series);
        Series isSerics = seriesService.getOne(new QueryWrapper<Series>().eq("serics_code", series));
        if (isSerics == null) {
            map.put("seriesTitleName", series);
        } else {
            map.put("seriesTitleName", isSerics.getSericsName());
        }
        return new ModelAndView("blog-series", map);
    }
   /* private ModelAndView querySeriesList(String series, Long id, Map map) {
        map.put("series", series);
        if (series != null && !"".equals(series)) {
            //查询
            List<Blogs> blogTitles = blogService.findBlogTitlesByseriesCode(series);
            if (!blogTitles.isEmpty()) {
                if (id == null) {
                    id = blogTitles.get(0).getId();
                }
                Long currentId = id;
                blogTitles = blogTitles.stream().map(x -> {
                    if (x.getId() == currentId) {
                        x.setTypeStr(" -current");
                    } else {
                        x.setTypeStr("");
                    }
                    return x;
                }).collect(Collectors.toList());
                map.put("blogTitles", blogTitles);
                Blog blogDtails = blogService.getById(id);
                map.put("blogDtails", blogDtails);
            }
            Series isSerics = seriesService.getOne(new QueryWrapper<Series>().eq("serics_code", series));
            if (isSerics == null) {
                map.put("seriesTitleName", series);
            } else {
                map.put("seriesTitleName", isSerics.getSericsName());
            }
        }
        return new ModelAndView("seriesdetails", map);
    }*/
}
