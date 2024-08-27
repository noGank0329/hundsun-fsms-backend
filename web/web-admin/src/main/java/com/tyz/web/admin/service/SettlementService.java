package com.tyz.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tyz.model.entity.Settlement;

import java.util.Date;
import java.util.List;

public interface SettlementService extends IService<Settlement> {

    List<Settlement> listSettlementByDate(Date date);
}
