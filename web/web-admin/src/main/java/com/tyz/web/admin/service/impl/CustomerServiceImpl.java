package com.tyz.web.admin.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyz.common.exception.LeaseException;
import com.tyz.common.result.ResultCodeEnum;
import com.tyz.model.entity.Customer;
import com.tyz.web.admin.mapper.CustomerMapper;
import com.tyz.web.admin.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

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
}
