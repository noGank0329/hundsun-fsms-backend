package com.tyz.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyz.model.entity.Creditcard;
import com.tyz.web.admin.mapper.CreditcardMapper;
import com.tyz.web.admin.service.CreditcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditcardServiceImpl extends ServiceImpl<CreditcardMapper, Creditcard>
        implements CreditcardService {
    @Autowired
    private CreditcardMapper creditcardMapper;

    @Override
    public Creditcard getOneByCardNumberAndAccountId(Creditcard creditcard) {
        return creditcardMapper.getOneByCardNumberAndAccountId(creditcard);
    }
    @Override
    public boolean updateCardBalance(String cardNumber, Double newBalance) {
        int updatedRows = creditcardMapper.updateBalanceByCardNumber(cardNumber, newBalance.toString());
        return updatedRows > 0;
    }
    @Override
    public IPage<Creditcard> pageCreditCardById(IPage<Creditcard> page, Long accountId) {
        return creditcardMapper.pageCreditCardById(page,accountId);
    }

    @Override
    public IPage<Creditcard> queryCreditCardWithCondition(IPage<Creditcard> page, Creditcard creditcard) {
        return creditcardMapper.queryCreditCardWithCondition(page,creditcard);
    }

}
