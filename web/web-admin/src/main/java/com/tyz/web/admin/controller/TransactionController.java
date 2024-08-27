package com.tyz.web.admin.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tyz.common.result.Result;
import com.tyz.model.entity.Transaction;
import com.tyz.model.enums.TransactionState;
import com.tyz.web.admin.service.TransactionService;
import com.tyz.web.admin.vo.TransactionVo;
import com.tyz.web.admin.vo.WithdrawOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

//    @PostMapping("/delete_purchase")
//    public Result deletePurchase(@RequestParam Long id){
//        transactionService.removeById(id);
//        return Result.ok();
//    }

    @GetMapping("/query")
    public Result<IPage<TransactionVo>> queryTransaction(@RequestParam long current, @RequestParam long size, TransactionVo transactionVo){
        IPage<TransactionVo> page = new Page<>(current,size);
        IPage<TransactionVo> result = transactionService.pageTransactionByQuery(page,transactionVo);
        return Result.ok(result);
    }

    @PostMapping("/delete_purchase")
    public Result deletePurchase(@RequestBody WithdrawOrderVo withdrawOrderVo){
        TransactionState transactionState = TransactionState.WITHDRAW_TRANSACTING;//改成撤单
        LambdaUpdateWrapper<Transaction> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Transaction::getTransactionId,withdrawOrderVo.getTransactionId()).eq(Transaction::getFundId,withdrawOrderVo.getFundId());
        updateWrapper.set(Transaction::getTransactionState,transactionState);
        transactionService.update(updateWrapper);
        return Result.ok();
    }

    @GetMapping("/getTransactionInformation")
    public Result<List<Transaction>> getTransactionInformation(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        List<Transaction> list = transactionService.listTransactionByDate(date);
        return Result.ok(list);
    }
}
