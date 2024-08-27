package com.tyz.web.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tyz.common.result.Result;
import com.tyz.model.entity.Account;
import com.tyz.model.entity.Customer;
import com.tyz.model.entity.User;
import com.tyz.web.admin.service.AccountService;
import com.tyz.web.admin.service.CustomerService;
import com.tyz.web.admin.service.UserService;
import com.tyz.web.admin.vo.CreateAccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;


    @PostMapping("/login")
    public Result<String> login(@RequestBody User user){
        String token = userService.userLogin(user);
        return Result.ok(token);
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        userService.userRegister(user);
        return Result.ok();
    }

    @GetMapping("/queryCustomer")
    public Result<IPage<Customer>> query(@RequestParam long current, @RequestParam long size, Customer findCustomer){
        IPage<Customer> page = new Page<>(current,size);
        IPage<Customer> result = customerService.pageCustomerByQuery(page,findCustomer);

        return Result.ok(result);
    }

    @GetMapping("/queryAccountByCustomerId")
    public Result<IPage<Account>> queryAccountByCustomerId(@RequestParam long current, @RequestParam long size,Long customerId){
        IPage<Account> page = new Page<>(current,size);
        IPage<Account> result = accountService.pageAccountByCustomerId(page,customerId);
        return Result.ok(result);
    }

    @PostMapping("/create_account")
    public Result createAccount(@RequestBody CreateAccountVo createAccountVo){
        accountService.addAccount(createAccountVo);
        return Result.ok();
    }

    //银行卡管理
}