package com.yuan.farmerwork.ynblog.service.impl;

import com.yuan.farmerwork.ynblog.domain.YnReadTotall;
import com.yuan.farmerwork.ynblog.mapper.YnReadTotallMapper;
import com.yuan.farmerwork.ynblog.service.YnReadTotallService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yjs
 * @since 2020-11-06
 */
@Service
public class YnReadTotallServiceImpl extends ServiceImpl<YnReadTotallMapper, YnReadTotall> implements YnReadTotallService {

    @Autowired
    YnReadTotallMapper ynReadTotallMapper;
    @Override
    public Integer readTotoallAddCount(Long blogId) {
        return ynReadTotallMapper.readTotoallAddCount(blogId);
    }
}
