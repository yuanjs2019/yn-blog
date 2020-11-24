package com.yuan.farmerwork.ynblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuan.farmerwork.ynblog.domain.Blog;
import com.yuan.farmerwork.ynblog.domain.pojo.Blogs;
import com.yuan.farmerwork.ynblog.domain.pojo.PigeonholeData;
import com.yuan.farmerwork.ynblog.domain.pojo.SearchBlog;
import com.yuan.farmerwork.ynblog.domain.pojo.TagsName;
import com.yuan.farmerwork.ynblog.mapper.BlogMapper;
import com.yuan.farmerwork.ynblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *  服务实现类
 *
 * @author yjs
 * @since 2020-10-26
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public PageInfo<Blogs> findBlogList(Integer page) {
         PageHelper.startPage(page, 10);
         List<Blogs> blogList = blogMapper.findBlogList();
         return new PageInfo<>(blogList);
    }

    @Override
    public Blogs findBlogsById(Long id) {
        return blogMapper.findBlogsById(id);
    }

    @Override
    public List<Blogs> findBlogLaterList() {
        return blogMapper.findBlogLaterList();
    }

    @Override
    public List<Blogs> findReadMoreList() {
        return blogMapper.findReadMoreList();
    }

    @Override
    public List<Blogs> findReadmList() {
        return blogMapper.findReadmList();
    }

    @Override
    public PageInfo<Blogs> findBlogBytagCode(String tagCode,Integer page) {
        PageHelper.startPage(page, 10);
        List<Blogs> blogList = blogMapper.findBlogBytagCode(tagCode);
        return new PageInfo<>(blogList);
    }

    @Override
    public PageInfo<Blogs> findBlogByclassfCode(String classifyCode,Integer page) {
        PageHelper.startPage(page, 10);
        List<Blogs> blogList = blogMapper.findBlogByclassfCode(classifyCode);
        return new PageInfo<>(blogList);
    }

    @Override
    public PageInfo<Blogs> findBlogByseriesCode(String seriesCode,Integer page) {
        PageHelper.startPage(page, 10);
        List<Blogs> blogList = blogMapper.findBlogByseriesCode(seriesCode);
        return new PageInfo<>(blogList);
    }

    @Override
    public List<Blogs> findBlogTitlesByseriesCode(String seriesCode) {
        return blogMapper.findBlogTitlesByseriesCode(seriesCode);
    }

    @Override
    public List<TagsName> findTagsByBlogId(Long blogId) {
        return blogMapper.findTagsByBlogId(blogId);
    }

    @Override
    public List<String> findClssfyByBlogId(Long blogId) {
        return blogMapper.findClssfyByBlogId(blogId);
    }

    @Override
    public PageInfo<SearchBlog> searchBlogs(String keywords,Integer page) {
        PageHelper.startPage(page, 5);
        return new PageInfo<>(blogMapper.searchBlogs(keywords));
    }

    @Override
    public List<PigeonholeData> guiDangSum() {
        return blogMapper.guiDangSum();
    }
}
