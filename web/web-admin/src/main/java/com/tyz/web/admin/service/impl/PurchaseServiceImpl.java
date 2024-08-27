package com.tyz.web.admin.service.impl;

import com.tyz.common.result.Result;
import com.tyz.common.result.ResultCodeEnum;
import com.tyz.web.admin.mapper.PurchaseMapper;
import com.tyz.web.admin.service.CreditcardService;
import com.tyz.web.admin.service.CustomerService;
import com.tyz.web.admin.service.FundService;
import com.tyz.web.admin.service.PurchaseService;
import com.tyz.model.entity.Creditcard;
import com.tyz.model.entity.Fund;
import com.tyz.model.entity.Transaction;
import com.tyz.web.admin.vo.CustomerInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private CreditcardService creditcardService;

    @Autowired
    private FundService fundService;

    @Autowired
    private CustomerService customerService;

    public Result<Transaction> createPurchase(Integer accountId, String cardNumber, Integer fundId, Double purchaseAmount) {
        Creditcard creditcard = new Creditcard();
        creditcard.setAccountId(accountId);
        creditcard.setCreditcardId(cardNumber);
        Creditcard creditcard1 = creditcardService.getOneByCardNumberAndAccountId(creditcard);
        if (creditcard1 == null) {
            return Result.fail(ResultCodeEnum.DATA_ERROR.getCode(), "银行卡信息不存在");
        }
        CustomerInfoVo customer = customerService.findCustomerByAccountId(accountId);
        Fund fund = fundService.getById(fundId);
        if (fund == null||customer == null) {
            return Result.fail(ResultCodeEnum.DATA_ERROR.getCode(), "客户信息不存在");
        }
        if (purchaseAmount <= 0 || purchaseAmount > Double.parseDouble(creditcard1.getBalance())) {
            return Result.fail(ResultCodeEnum.PARAM_ERROR.getCode(), "申购金额不合法");
        }
        if (fund.getFundState()!=0) {
            return Result.fail(ResultCodeEnum.DATA_ERROR.getCode(), "基金不可用");
        }
        if(customer.riskLevel<fund.getFundRiskLevel()){
            return Result.fail(ResultCodeEnum.PARAM_ERROR.getCode(), "风险等级不符合");
        }
        BigDecimal transactionShare = new BigDecimal(purchaseAmount).divide(fund.getFundNav(), RoundingMode.HALF_UP);

        Transaction purchase = new Transaction();
        purchase.setAccountId(accountId);
        purchase.setFundId(fundId);
        purchase.setTransactionType(0);
        purchase.setTransactionAmount(new BigDecimal(purchaseAmount));
        purchase.setTransactionShare(transactionShare);
        purchase.setTransactionDate(new Date());
        purchase.setTransactionState(0); // 假设 0 表示待处理

        int result = purchaseMapper.insertPurchase(purchase);
        if (result > 0) {
            Double newBalance = Double.parseDouble(creditcard1.getBalance())-purchaseAmount;
            boolean balanceUpdated = creditcardService.updateCardBalance(cardNumber, newBalance);

            if (balanceUpdated) {
                return Result.ok(purchase);
            } else {
                return Result.fail(ResultCodeEnum.SERVICE_ERROR.getCode(), "余额更新失败");
            }
        } else {
            return Result.fail(ResultCodeEnum.SERVICE_ERROR.getCode(), "申购申请失败");
        }
    }
}
