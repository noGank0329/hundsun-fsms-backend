package com.tyz.web.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tyz.common.result.Result;
import com.tyz.common.result.ResultCodeEnum;
import com.tyz.model.entity.Account;
import com.tyz.model.entity.Creditcard;
import com.tyz.web.admin.service.AccountService;
import com.tyz.web.admin.service.CreditcardService;
import com.tyz.web.admin.vo.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/creditcard")
public class CreditcardController {
    @Autowired
    private CreditcardService creditcardService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/balance")
    public Result<Creditcard> balance(
            @RequestParam("account_id") String accountId,
            @RequestParam("card_number") String cardNumber) {
        Creditcard creditcard = new Creditcard();
        creditcard.setAccountId(Integer.valueOf(accountId));
        creditcard.setCreditcardId(cardNumber);
        Creditcard creditcard1 = creditcardService.getOneByCardNumberAndAccountId(creditcard);
        if (creditcard1 != null) {
            return Result.ok(creditcard1);
        } else {
            return Result.fail(ResultCodeEnum.DATA_ERROR.getCode(), "找不到银行卡");
        }
    }

    @PostMapping("/update")
    public Result updateCreditcard(@RequestBody Creditcard creditcard){
        creditcardService.saveOrUpdate(creditcard);
        return Result.ok();
    }

    @GetMapping("/queryAccountByID")
    public Result<List<AccountRequest>> queryAccountByID(@RequestParam Long id){
        //List<AccountRequest> list = accountService.queryAccountByID(id);
        LambdaQueryWrapper<AccountRequest> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AccountRequest::getCustomerIdCard, id);
        List<AccountRequest> list = accountService.queryAccountByID(queryWrapper);
        return Result.ok(list);
    }

    //查询银行卡
    @GetMapping("/queryCreditcardById")
    public Result<IPage<Creditcard>> queryCreditCard(@RequestParam long current, @RequestParam long size, @RequestParam Long accountId){
        IPage<Creditcard> page = new Page<>(current,size);
        IPage<Creditcard> result = creditcardService.pageCreditCardById(page,accountId);
        return Result.ok(result);
    }
    //银行卡管理
    @GetMapping("/queryCreditcard")
    public Result<IPage<Creditcard>> queryCreditCardWithCondition(@RequestParam long current, @RequestParam long size, Creditcard creditcard){
        IPage<Creditcard> page = new Page<>(current,size);
        IPage<Creditcard> result = creditcardService.queryCreditCardWithCondition(page,creditcard);
        return Result.ok(result);
    }

}
