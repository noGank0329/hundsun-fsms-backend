package com.tyz.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyz.model.entity.Sharerecord;
import com.tyz.web.admin.mapper.SharerecordMapper;
import com.tyz.web.admin.service.SharerecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SharerecordServiceImpl extends ServiceImpl<SharerecordMapper, Sharerecord>
    implements SharerecordService {
    @Autowired
    private SharerecordMapper sharerecordMapper;


}
