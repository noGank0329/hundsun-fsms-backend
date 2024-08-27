package com.tyz.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tyz.model.entity.Fund;

import java.util.List;

public interface FundMapper extends BaseMapper<Fund> {
    List<Fund> listFundInfo();

    IPage<Fund> pageFundByQuery(IPage<Fund> page, Fund fund);
}
