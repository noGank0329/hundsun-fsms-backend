package com.tyz.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tyz.model.entity.Creditcard;

public interface CreditcardService extends IService<Creditcard> {
    Creditcard getOneByCardNumberAndAccountId(Creditcard creditcard);
    boolean updateCardBalance(String cardNumber, Double newBalance);

    IPage<Creditcard> pageCreditCardById(IPage<Creditcard> page, Long accountId);

    IPage<Creditcard> queryCreditCardWithCondition(IPage<Creditcard> page, Creditcard creditcard);

    void IsAccuracy(Long id,String password);
}
