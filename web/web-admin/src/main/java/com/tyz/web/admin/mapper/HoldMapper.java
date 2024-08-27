package com.tyz.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyz.model.entity.Hold;
import com.tyz.web.admin.vo.HoldVo;

public interface HoldMapper extends BaseMapper<Hold> {
    Hold selectFundShareByAccountAndFundId(HoldVo holdVo);
}
