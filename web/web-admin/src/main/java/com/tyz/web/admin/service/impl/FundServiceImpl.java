package com.tyz.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyz.model.entity.Fund;
import com.tyz.web.admin.mapper.FundMapper;
import com.tyz.web.admin.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundServiceImpl extends ServiceImpl<FundMapper, Fund>
    implements FundService {
    @Autowired
    private FundMapper fundMapper;
    @Override
    public List<Fund> listFundInfo() {
        return fundMapper.listFundInfo();
    }

    @Override
    public IPage<Fund> pageFundByQuery(IPage<Fund> page, Fund fund) {
        return fundMapper.pageFundByQuery(page,fund);
    }
}
