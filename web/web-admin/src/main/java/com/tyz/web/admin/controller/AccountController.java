package com.tyz.web.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tyz.common.result.Result;
import com.tyz.model.entity.Account;
import com.tyz.model.entity.Creditcard;
import com.tyz.web.admin.service.AccountService;
import com.tyz.web.admin.service.CreditcardService;
import com.tyz.web.admin.vo.CreateAccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private CreditcardService creditcardService;



    @GetMapping("/query")
    public Result queryAccount(@RequestParam Long accountId){
        accountService.getById(accountId);
        return Result.ok();
    }

    @DeleteMapping("/delete")
    public Result deleteAccount(@RequestParam Long id){

        //删除creditcard
        LambdaQueryWrapper<Creditcard> creditcardLambdaQueryWrapper = new LambdaQueryWrapper<>();
        creditcardLambdaQueryWrapper.eq(Creditcard::getAccountId,id);
        creditcardService.remove(creditcardLambdaQueryWrapper);
        accountService.removeById(id);
        return Result.ok();
    }
}
