package com.tyz.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyz.model.entity.Creditcard;

public interface CreditcardMapper extends BaseMapper<Creditcard> {
    Creditcard getOneByCardNumberAndAccountId(Creditcard creditcard);
}
