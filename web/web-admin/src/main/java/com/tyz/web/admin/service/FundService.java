package com.tyz.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tyz.model.entity.Fund;

import java.util.List;

public interface FundService extends IService<Fund> {
    List<Fund> listFundInfo();

    IPage<Fund> pageFundByQuery(IPage<Fund> page, Fund fund);
}
