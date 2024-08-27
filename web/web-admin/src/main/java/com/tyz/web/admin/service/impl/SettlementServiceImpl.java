package com.tyz.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyz.model.entity.Settlement;
import com.tyz.web.admin.mapper.SettlementMapper;
import com.tyz.web.admin.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SettlementServiceImpl extends ServiceImpl<SettlementMapper, Settlement>
    implements SettlementService {

    @Autowired
    private SettlementMapper settlementMapper;

    @Override
    public List<Settlement> listSettlementByDate(Date date) {
        return settlementMapper.listSettlementByDate(date);
    }
}
