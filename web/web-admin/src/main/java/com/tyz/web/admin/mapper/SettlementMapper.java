package com.tyz.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tyz.model.entity.Settlement;

import java.util.Date;
import java.util.List;

public interface SettlementMapper extends BaseMapper<Settlement> {

    List<Settlement> listSettlementByDate(Date date);
}
