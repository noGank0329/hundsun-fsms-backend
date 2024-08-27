package com.tyz.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyz.model.entity.Creditcardrecord;
import com.tyz.web.admin.mapper.CreditcardrecordMapper;
import com.tyz.web.admin.service.CreditcardrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditcardrecordServiceImpl extends ServiceImpl<CreditcardrecordMapper, Creditcardrecord>
    implements CreditcardrecordService {
    @Autowired
    private CreditcardrecordMapper creditcardrecordMapper;

}
