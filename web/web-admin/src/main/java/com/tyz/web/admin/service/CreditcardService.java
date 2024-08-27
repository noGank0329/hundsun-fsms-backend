package com.tyz.web.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyz.model.entity.Creditcard;

public interface CreditcardService extends IService<Creditcard> {
    Creditcard getOneByCardNumberAndAccountId(Creditcard creditcard);
}
