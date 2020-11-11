package com.yuan.farmerwork.ynblog.rest.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yuan.farmerwork.ynblog.domain.*;
import com.yuan.farmerwork.ynblog.domain.pojo.EditorProperties;
import com.yuan.farmerwork.ynblog.domain.pojo.SaveData;
import com.yuan.farmerwork.ynblog.domain.pojo.TagsName;
import com.yuan.farmerwork.ynblog.service.*;
import com.yuan.farmerwork.ynblog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 编辑页面.
 *
 * @author : YJS
 * @date: 2020-10-29 16:46
 */
@RestController
@RequestMapping("/admin")
public class EditorController {

    @Autowired
    TagService tagService;
    @Autowired
    SeriesService seriesService;
    @Autowired
    ClassifyService classifyService;
    @Autowired
    BlogService blogService;
    @Autowired
    YnBlogTagService ynBlogTagService;
    @Autowired
    YnBlogClassifyService ynBlogClassifyService;
    @Autowired
    YnReadTotallService ynReadTotallService;
    @Value("${sys.params.default_picture_url}")
    private String defaultPictureUrl;

    /*
     * 标签，分类，系列添加请求
     */
    @RequestMapping("/tags")
    public Result addTags(@RequestBody EditorProperties properties) {
        String type = properties.getType();
        String vaule = properties.getVaule();
        String code = properties.getCode();
        if (Optional.ofNullable(vaule).isPresent()) {
            switch (type) {
                case "tags": {
                    Tag isTag = tagService.getOne(new QueryWrapper<Tag>().eq("tag_code", code).last("limit 1"));
                    if (isTag != null) {
                        return Result.build(402, "已存在码值[" + code + "]");
                    }
                    Tag tag = new Tag();
                    tag.setTagName(vaule);
                    tag.setTagCode(code);
                    tagService.save(tag);
                }
                break;
                case "secrisc": {
                    Series isSerics = seriesService.getOne(new QueryWrapper<Series>().eq("serics_code", code).last("limit 1"));
                    if (isSerics != null) {
                        return Result.build(402, "已存在码值[" + code + "]");
                    }
                    Series series = new Series();
                    series.setSericsName(vaule);
                    series.setSericsCode(code);
                    seriesService.save(series);
                }
                break;
                case "classify": {
                    Classify isClassify = classifyService.getOne(new QueryWrapper<Classify>().eq("classify_code", code).last("limit 1"));
                    if (isClassify != null) {
                        return Result.build(402, "已存在码值[" + code + "]");
                    }
                    Classify classify = new Classify();
                    classify.setClassifyName(vaule);
                    classify.setClassifyCode(code);
                    classifyService.save(classify);
                }
                break;
                default:
                    return Result.build(402, "无此类型");
            }
        }
        return Result.ok();
    }

    /*
     * 文章保存，修改请求
     */
    @RequestMapping("/save")
    public Result save(@RequestBody SaveData saveData) {

        //判断是否存在id来区分更新与保存操作
        if (saveData.getId() == null || saveData.getId() == 0L) {
            Blog orgBlog = blogService.getOne(new QueryWrapper<Blog>().eq("title", saveData.getArtcleTitle()).last("limit 1"));
            if (orgBlog != null) {
                return Result.build(402, "文章[" + saveData.getArtcleTitle() + "]已存在");
            }
        }
        Blog blog = new Blog();
        blog.setAuthor(saveData.getAuthor());
        blog.setContent(saveData.getContent());
        blog.setDescription(saveData.getArtcleIntro());
        if (saveData.getArtclePicture() != null && !"".equals(saveData.getArtclePicture())) {
            blog.setMainPicture(saveData.getArtclePicture());
        } else {
            blog.setMainPicture(defaultPictureUrl);
        }
        blog.setTextContent(saveData.getTextContent());
        blog.setTitle(saveData.getArtcleTitle());
        if (saveData.getType() != null && !saveData.getType().contains(",")) {
            blog.setType(saveData.getType());
        }
        Calendar cal = Calendar.getInstance();
        blog.setYear(cal.get(Calendar.YEAR));
        blog.setMonth(cal.get(Calendar.MONTH) + 1);
        blog.setUpdateTime(LocalDateTime.now());
        if (saveData.getSeriesxStr() != null && !"".equals(saveData.getSeriesxStr())) {
            blog.setSeriesCode(saveData.getSeriesxStr());
        }
        if (saveData.getId() == null || saveData.getId() == 0L) {
            blog.setCreateTime(LocalDateTime.now());
            blogService.save(blog);
        } else {
            blog.setId(saveData.getId());
            blogService.updateById(blog);
        }

        //保存修改标签
        if (saveData.getTagsStr() != null && !"".equals(saveData.getTagsStr())) {
            if (saveData.getId() != null && saveData.getId() != 0L) {
                ynBlogTagService.remove(new QueryWrapper<YnBlogTag>().eq("blog_id", saveData.getId()));
            }
            String[] tags = saveData.getTagsStr().split("\\,");
            Arrays.stream(tags).map(x -> {
                Tag isTag = tagService.getOne(new QueryWrapper<Tag>().eq("tag_code", x).last("limit 1"));
                if (isTag != null) {
                    YnBlogTag ynBlogTag = new YnBlogTag();
                    ynBlogTag.setTagId(isTag.getId());
                    ynBlogTag.setBlogId(blog.getId());
                    ynBlogTagService.save(ynBlogTag);
                }
                return x;
            }).collect(Collectors.toList());
        }
        //保存修改分类
        if (saveData.getClassifStr() != null && !"".equals(saveData.getClassifStr())) {
            if (saveData.getId() != null && saveData.getId() != 0L) {
                ynBlogClassifyService.remove(new QueryWrapper<YnBlogClassify>().eq("blog_id", saveData.getId()));
            }
            String[] classifys = saveData.getClassifStr().split("\\,");
            Arrays.stream(classifys).map(x -> {
                Classify isClassify = classifyService.getOne(new QueryWrapper<Classify>().eq("classify_code", x)
                        .last("limit 1"));
                if (isClassify != null) {
                    YnBlogClassify ynBlogClassify = new YnBlogClassify();
                    ynBlogClassify.setClassifyId(isClassify.getId());
                    ynBlogClassify.setBlogId(blog.getId());
                    ynBlogClassifyService.save(ynBlogClassify);
                }
                return x;
            }).collect(Collectors.toList());
        }
        //保存数据时，要添加浏览数
        if (saveData.getId() == null || saveData.getId() == 0L) {
            YnReadTotall ynReadTotall = new YnReadTotall();
            ynReadTotall.setBlogId(blog.getId());
            ynReadTotallService.save(ynReadTotall);
        }
        return Result.ok();
    }


    /*
     * 文章编辑页面
     */
    @GetMapping("/edit")
    public ModelAndView edit(Map map) {
        List<Tag> taglist = tagService.list();
        List<Classify> classifList = classifyService.list();
        List<Series> seriesList = seriesService.list();
        map.put("tagList", taglist);
        map.put("classifList", classifList);
        map.put("seriesList", seriesList);
        return new ModelAndView("save", map);
    }

    /*
     * 文章编辑页面
     */
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id, Map map) {
        if (id > 0) {
            Blog blog = blogService.getById(id);
            if (blog != null) {
                map.put("orgBlog", blog);
         /*       List<TagsName> tagsNames = blogService.findTagsByBlogId(id);
                List<String> tagsArray = tagsNames.stream().map(x -> x.getTagsCode()).collect(Collectors.toList());
                List<String> classfyArray = blogService.findClssfyByBlogId(id);
                map.put("orgTagsArray", tagsArray);
                map.put("orgClassfyArray", classfyArray);*/
            }
        }
        List<Tag> taglist = tagService.list();
        List<Classify> classifList = classifyService.list();
        List<Series> seriesList = seriesService.list();
        map.put("tagList", taglist);
        map.put("classifList", classifList);
        map.put("seriesList", seriesList);
        return new ModelAndView("save", map);
    }
}
