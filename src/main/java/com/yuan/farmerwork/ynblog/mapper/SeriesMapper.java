package com.yuan.farmerwork.ynblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuan.farmerwork.ynblog.domain.Series;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 标签列表 Mapper 接口
 * </p>
 *
 * @author yjs
 * @since 2020-10-29
 */
@Mapper
public interface SeriesMapper extends BaseMapper<Series> {

}
