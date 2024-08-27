package com.tyz.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyz.model.entity.Hold;
import com.tyz.web.admin.mapper.HoldMapper;
import com.tyz.web.admin.service.HoldService;
import com.tyz.web.admin.vo.HoldVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author tangyizuo
* @description 针对表【hold】的数据库操作Service实现
* @createDate 2024-08-19 17:41:55
*/
@Service
public class HoldServiceImpl extends ServiceImpl<HoldMapper, Hold>
    implements HoldService{
    @Autowired
    private HoldMapper holdMapper;

    @Override
    public Hold selectFundShareByAccountAndFundId(HoldVo holdVo) {
        return holdMapper.selectFundShareByAccountAndFundId(holdVo);
    }
}




