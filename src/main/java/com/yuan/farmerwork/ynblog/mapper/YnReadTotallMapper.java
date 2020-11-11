package com.yuan.farmerwork.ynblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuan.farmerwork.ynblog.domain.YnReadTotall;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yjs
 * @since 2020-11-06
 */
@Mapper
public interface YnReadTotallMapper extends BaseMapper<YnReadTotall> {

    Integer readTotoallAddCount(Long blogId);
}
