package com.yuan.farmerwork.ynblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuan.farmerwork.ynblog.domain.YnReadTotall;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yjs
 * @since 2020-11-06
 */
public interface YnReadTotallService extends IService<YnReadTotall> {

    Integer readTotoallAddCount(Long blogId);
}
