package com.tyz.web.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyz.common.exception.LeaseException;
import com.tyz.common.result.ResultCodeEnum;
import com.tyz.model.entity.Account;
import com.tyz.model.entity.Customer;
import com.tyz.web.admin.mapper.AccountMapper;
import com.tyz.web.admin.mapper.CustomerMapper;
import com.tyz.web.admin.service.AccountService;
import com.tyz.web.admin.vo.AccountRequest;
import com.tyz.web.admin.vo.CreateAccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.checkerframework.checker.units.UnitsTools.min;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>
    implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void addAccount(CreateAccountVo createAccountVo) {
        //先放一下，没捋清楚,数据库有问题，需要更改
        Customer customer = customerMapper.getOneByIdCard(createAccountVo.getCustomerIdCard());
        if(customer != null){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_EXIST_ERROR);
        }
        Customer newCustomer = new Customer();
        newCustomer.setCustomerIdcard(Math.toIntExact(createAccountVo.getCustomerIdCard()));
        newCustomer.setCustomerName(createAccountVo.getCustomerName());
        newCustomer.setCustomerType(Math.toIntExact(createAccountVo.getCustomerType()));
        newCustomer.setCustomerIdcardType(Math.toIntExact(createAccountVo.getCustomerIdCardType()));
        newCustomer.setCustomerPhone(String.valueOf(createAccountVo.getCustomerPhone()));
        customerMapper.insert(newCustomer);

        Customer customer1 = customerMapper.getOneByIdCard(Long.valueOf(newCustomer.getCustomerIdcard()));

        Account newAccount = new Account();
        newAccount.setCustomerId(customer1.getCustomerId());
        newAccount.setAccountRiskLevel(Math.toIntExact(createAccountVo.getRiskId()));
        newAccount.setCreateDate(new Date());
        newAccount.setStatus("正常");
        accountMapper.insert(newAccount);
    }

    @Override
    public IPage<Account> pageAccountByCustomerId(IPage<Account> page, Long customerId) {
        return accountMapper.pageAccountByCustomerId(page,customerId);
    }

    @Override
    public List<String> getCardNumbersByAccountId(Integer accountId) {
        return accountMapper.findCardNumbersByAccountId(accountId);
    }

    @Override
    public List<AccountRequest> queryAccountByID(LambdaQueryWrapper<AccountRequest> queryWrapper) {
        return accountMapper.queryAccountByID(queryWrapper);
    }

}
