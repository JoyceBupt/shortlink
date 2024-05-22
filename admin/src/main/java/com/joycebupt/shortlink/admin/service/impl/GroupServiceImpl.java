package com.joycebupt.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joycebupt.shortlink.admin.dao.entity.GroupDO;
import com.joycebupt.shortlink.admin.dao.mapper.GroupMapper;
import com.joycebupt.shortlink.admin.service.GroupService;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 短链接分组接口实现层
 */
@Slf4j
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {
}
