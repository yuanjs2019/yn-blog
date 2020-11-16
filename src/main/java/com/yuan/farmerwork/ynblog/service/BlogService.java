package com.yuan.farmerwork.ynblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yuan.farmerwork.ynblog.domain.Blog;
import com.yuan.farmerwork.ynblog.domain.pojo.Blogs;
import com.yuan.farmerwork.ynblog.domain.pojo.PigeonholeData;
import com.yuan.farmerwork.ynblog.domain.pojo.SearchBlog;
import com.yuan.farmerwork.ynblog.domain.pojo.TagsName;

import java.util.List;

/**
 *  服务类
 *
 * @author yjs
 * @since 2020-10-26
 */
public interface BlogService extends IService<Blog> {
    /**
     * 查询文章列表数据
     * @return
     */
    PageInfo<Blogs> findBlogList(Integer page);

    /**
     * 根据id查询文章列表数据
     * @return
     */
    Blogs findBlogsById(Long id);

    /**
     * 查询最新10列表数据
     * @return
     */
    List<Blogs> findBlogLaterList();

    /**
     * 查询阅读最多的10列表数据
     * @return
     */
    List<Blogs> findReadMoreList();

    /**
     * 查询阅读最多的8列表数据(数据内容不一样)
     * @return
     */
    List<Blogs> findReadmList();

    /**
     * 标签code查询文章列表数据
     * @return
     */
    PageInfo<Blogs> findBlogBytagCode(String tagCode,Integer page);

    /**
     * 分类code查询文章列表数据
     * @return
     */
    PageInfo<Blogs> findBlogByclassfCode(String classifyCode,Integer page);

    /**
     * 系列code查询文章列表数据
     * @return
     */
    PageInfo<Blogs> findBlogByseriesCode(String seriesCode,Integer page);

    List<TagsName> findTagsByBlogId(Long blogId);

    /**
     * 根据博客id查询对应的分类code
     * @return
     */
    List<String> findClssfyByBlogId(Long blogId);

    /**
     * 根据关键词搜索博客文章
     * @return
     */
     PageInfo<SearchBlog> searchBlogs(String keywords,Integer page);

    /**
     * 归档数据
     * @return
     */
    List<PigeonholeData> guiDangSum();
}
