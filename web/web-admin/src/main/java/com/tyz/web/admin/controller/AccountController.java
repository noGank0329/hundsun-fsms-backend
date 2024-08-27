package com.tyz.web.admin.controller;


import com.tyz.common.result.Result;
import com.tyz.model.entity.Account;
import com.tyz.web.admin.service.AccountService;
import com.tyz.web.admin.vo.CreateAccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;



    @GetMapping("/query")
    public Result queryAccount(@RequestParam Long accountId){
        accountService.getById(accountId);
        return Result.ok();
    }
}
