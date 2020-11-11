package com.yuan.farmerwork.ynblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.farmerwork.ynblog.domain.Tag;
import com.yuan.farmerwork.ynblog.mapper.TagMapper;
import com.yuan.farmerwork.ynblog.service.TagService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签列表 服务实现类
 * </p>
 *
 * @author yjs
 * @since 2020-10-29
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
