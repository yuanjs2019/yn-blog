package com.yuan.farmerwork.ynblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuan.farmerwork.ynblog.domain.Blog;
import com.yuan.farmerwork.ynblog.domain.pojo.Blogs;
import com.yuan.farmerwork.ynblog.domain.pojo.SearchBlog;
import com.yuan.farmerwork.ynblog.domain.pojo.TagsName;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  Mapper 接口.
 *
 * @author yjs
 * @since 2020-10-26
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

    /**
     * 查询文章列表数据
     * @return
     */
   List<Blogs> findBlogList();

    /**
     * 根据id查询文章列表数据
     * @return
     */
   Blogs findBlogsById(Long id);

    /**
     * 标签code查询文章列表数据
     * @return
     */
    List<Blogs> findBlogBytagCode(String tagCode);

    /**
     * 分类code查询文章列表数据
     * @return
     */
    List<Blogs> findBlogByclassfCode(String classifyCode);


    /**
     * 系列code查询文章列表数据
     * @return
     */
    List<Blogs> findBlogByseriesCode(String seriesCode);

    /**
     * 查询最新10列表数据
     * @return
     */
   List<Blogs> findBlogLaterList();

    /**
     * 查询阅读最多的5列表数据
     * @return
     */
   List<Blogs> findReadMoreList();

    /**
     * 查询阅读最多的8列表数据(数据内容不一样)
     * @return
     */
   List<Blogs> findReadmList();

    /**
     * 根据博客id查询对应的标签信息
     * @return
     */
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
   List<SearchBlog> searchBlogs(String keywords);
}
