package com.tyz.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tyz.model.entity.Account;
import com.tyz.web.admin.vo.AccountRequest;
import com.tyz.web.admin.vo.CreateAccountVo;

import java.util.List;

public interface AccountService extends IService<Account> {

    void addAccount(CreateAccountVo createAccountVo);

    IPage<Account> pageAccountByCustomerId(IPage<Account> page, Long customerId);

    List<String> getCardNumbersByAccountId(Integer accountId);

    List<AccountRequest> queryAccountByID(Long id);
}
