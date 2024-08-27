package com.tyz.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tyz.model.entity.Customer;
import com.tyz.web.admin.vo.CustomerInfoVo;

/**
* @author tangyizuo
* @description 针对表【customer】的数据库操作Mapper
* @createDate 2024-08-19 17:41:55
* @Entity com.demo.pc.entity.Customer
*/
public interface CustomerMapper extends BaseMapper<Customer> {

    Customer getOneByIdCard(Long customerIdCard);

    IPage<Customer> pageCustomerByQuery(IPage<Customer> page, Customer findCustomer);

    CustomerInfoVo findCustomerByAccountId(Integer accountId);
}




