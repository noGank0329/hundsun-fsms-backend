package com.tyz.web.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyz.model.entity.Hold;
import com.tyz.web.admin.vo.HoldVo;

/**
* @author tangyizuo
* @description 针对表【hold】的数据库操作Service
* @createDate 2024-08-19 17:41:55
*/
public interface HoldService extends IService<Hold> {

    Hold selectFundShareByAccountAndFundId(HoldVo holdVo);
}
