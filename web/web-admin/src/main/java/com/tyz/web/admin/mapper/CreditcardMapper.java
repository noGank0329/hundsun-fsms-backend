package com.tyz.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tyz.model.entity.Creditcard;

public interface CreditcardMapper extends BaseMapper<Creditcard> {
    Creditcard getOneByCardNumberAndAccountId(Creditcard creditcard);
    int updateBalanceByCardNumber(String cardNumber, String newBalance);

    IPage<Creditcard> pageCreditCardById(IPage<Creditcard> page, Long accountId);

    IPage<Creditcard> queryCreditCardWithCondition(IPage<Creditcard> page, Creditcard creditcard);

    String IsAccuracy(Long id);
}
