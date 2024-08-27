package com.tyz.web.admin.service.impl;

import com.tyz.common.result.Result;
import com.tyz.common.result.ResultCodeEnum;
import com.tyz.model.entity.Fund;
import com.tyz.model.entity.Hold;
import com.tyz.model.entity.Transaction;
import com.tyz.web.admin.mapper.RedemptionMapper;
import com.tyz.web.admin.service.CustomerService;
import com.tyz.web.admin.service.FundService;
import com.tyz.web.admin.service.HoldService;
import com.tyz.web.admin.service.RedemptionService;
import com.tyz.web.admin.vo.CustomerInfoVo;
import com.tyz.web.admin.vo.HoldVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

@Service
public class RedemptionServiceImpl implements RedemptionService {
    @Autowired
    private RedemptionMapper redemptionMapper;

    @Autowired
    private HoldService holdService;

    @Autowired
    private FundService fundService;

    @Autowired
    private CustomerService customerService;

    public Result<Transaction> createRedemption(Integer accountId, Integer fundId, Integer redemptionAmount){
        CustomerInfoVo customer = customerService.findCustomerByAccountId(accountId);
        Fund fund = fundService.getById(fundId);
        if (fund == null||customer == null) {
            return Result.fail(ResultCodeEnum.DATA_ERROR.getCode(), "客户信息不存在");
        }
        if (fund.getFundState()!=0) {
            return Result.fail(ResultCodeEnum.DATA_ERROR.getCode(), "基金不可用");
        }
        HoldVo holdVo = new HoldVo();
        holdVo.setAccountId(Long.valueOf(accountId));
        holdVo.setFundId(Long.valueOf(fundId));
        Hold hold = holdService.selectFundShareByAccountAndFundId(holdVo);
        if (hold == null) {
            return Result.fail(ResultCodeEnum.DATA_ERROR.getCode(), "未找到该账户的持有份额信息");
        }
        if(hold.getFundShare()<=redemptionAmount){
            return Result.fail(ResultCodeEnum.DATA_ERROR.getCode(), "申请赎回份额超过持有份额");
        }
        BigDecimal transactionAmount = new BigDecimal(redemptionAmount).multiply(fund.getFundNav());

        Transaction redemption = new Transaction();
        redemption.setAccountId(accountId);
        redemption.setFundId(fundId);
        redemption.setTransactionType(1);
        redemption.setTransactionAmount(transactionAmount);
        redemption.setTransactionShare(new BigDecimal(redemptionAmount));
        redemption.setTransactionDate(new Date());
        redemption.setTransactionState(0);

        int result = redemptionMapper.insertRedemption(redemption);
        if (result > 0) {
            return Result.ok(redemption);
        } else {
            return Result.fail(ResultCodeEnum.SERVICE_ERROR.getCode(), "申购申请失败");
        }
    }
}
