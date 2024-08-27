package com.tyz.web.admin.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tyz.common.result.Result;
import com.tyz.model.entity.Settlement;
import com.tyz.model.entity.Transaction;
import com.tyz.model.entity.Fund;
import com.tyz.web.admin.service.SettlementService;
import com.tyz.web.admin.service.TransactionService;
import com.tyz.web.admin.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/settlement")
public class SettlementController {
    @Autowired
    private FundService fundService;
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private SettlementService settlementService;


    //申购或赎回订单
    @GetMapping("/order")
    public Result<IPage<Settlement>> settlementSubscriptionOrRedemption(@RequestParam long current, @RequestParam long size,Long id){
        IPage<Settlement> page = new Page<>(current,size);
        IPage<Settlement> result = transactionService.settlementSubscriptionOrRedemption(page,id);
        return Result.ok(result);
    }

    @PostMapping("/updateTransactionStateById")
    public Result updateTransactionStateById(@RequestBody List<Long> ids) {
        for (Long id : ids) {
            // Step 1: 获取交易记录
            Transaction transaction = transactionService.getById(id);
            if (transaction == null) {
                continue;
            }

            // Step 2: 获取对应的 fundId 和 当前的净值 fundNav
            long fundId = transaction.getFundId();
            Fund fund = fundService.getById(fundId);
            if (fund == null) {
                continue;
            }
            BigDecimal fundNav = fund.getFundNav();

            // Step 3: 根据交易类型更新 transactionShare 或 transactionAmount
            if (transaction.getTransactionType() == 1) { // 申购订单
                // 更新 transactionShare = transactionAmount / fundNav

                BigDecimal transactionAmount = transaction.getTransactionAmount();
                BigDecimal newTransactionShare = transactionAmount.divide(fundNav,2);
                transaction.setTransactionShare(newTransactionShare);
            } else if (transaction.getTransactionType() == 0) { // 赎回订单
                // 更新 transactionAmount = transactionShare * fundNav

                BigDecimal transactionShare = transaction.getTransactionShare();
                BigDecimal newTransactionAmount = transactionShare.multiply(fundNav);

                transaction.setTransactionAmount(newTransactionAmount);

            }

            // Step 4: 更新交易状态
            transaction.setTransactionState(1);

            // Step 5: 保存更新后的交易记录
            transactionService.updateById(transaction);
        }
        return Result.ok();
    }


    @GetMapping("/getSettlementInformation")
    public Result<List<Settlement>> getSettlementInformation(Date date){
        List<Settlement> list = settlementService.listSettlementByDate(date);
        return Result.ok(list);
    }
}
