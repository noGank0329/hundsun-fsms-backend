package com.tyz.web.admin.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyz.common.exception.LeaseException;
import com.tyz.common.result.ResultCodeEnum;
import com.tyz.model.entity.Customer;
import com.tyz.model.entity.Account;
import com.tyz.model.entity.Creditcard;
import com.tyz.web.admin.mapper.CustomerMapper;
import com.tyz.web.admin.service.AccountService;
import com.tyz.web.admin.service.CreditcardService;
import com.tyz.web.admin.service.CustomerService;
import com.tyz.web.admin.vo.CustomerInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.List;
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private AccountService accountService;

    @Autowired
    private CreditcardService creditcardService;
    @Override
    public Customer getOneByIdCard(Long customerIdCard) {
        return customerMapper.getOneByIdCard(customerIdCard);
    }

    @Override
    public void selectOneByIdCardAndPhone(Customer customer) {
        Customer customer1 = customerMapper.getOneByIdCard(Long.valueOf(customer.getCustomerIdcard()));
        if(customer1 == null){
            throw new LeaseException(ResultCodeEnum.ADMIN_CUSTOMER_NOT_EXIST_ERROR);
        }
        if(!customer1.getCustomerPhone().equals(customer.getCustomerPhone())){
            throw new LeaseException(ResultCodeEnum.ADMIN_IDENTITY_ERROR);
        }
    }

    @Override
    public IPage<Customer> pageCustomerByQuery(IPage<Customer> page, Customer findCustomer) {
        return customerMapper.pageCustomerByQuery(page,findCustomer);
    }

    @Override
    public void removeCustomerById(Long customerId) {
        List<Account> accounts = accountService.list(new LambdaQueryWrapper<Account>().eq(Account::getCustomerId, customerId));
        List<Integer> accountIds = accounts.stream()
                .map(Account::getAccountId)
                .collect(Collectors.toList());
        //删除account
        LambdaQueryWrapper<Account> accountLambdaQueryWrapper = new LambdaQueryWrapper<>();
        accountLambdaQueryWrapper.eq(Account::getCustomerId, customerId);
        accountService.remove(accountLambdaQueryWrapper);

        //删除creditcard
        LambdaQueryWrapper<Creditcard> creditcardLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //creditcardLambdaQueryWrapper.eq(Creditcard::getAccountId,accountIds);
        creditcardLambdaQueryWrapper.in(Creditcard::getAccountId, accountIds);
        creditcardService.remove(creditcardLambdaQueryWrapper);
    }
    public CustomerInfoVo findCustomerByAccountId(Integer accountId) {
        return customerMapper.findCustomerByAccountId(accountId);
    }
}
