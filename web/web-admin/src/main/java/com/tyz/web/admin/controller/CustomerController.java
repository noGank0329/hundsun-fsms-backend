package com.tyz.web.admin.controller;

import com.tyz.common.result.Result;
import com.tyz.model.entity.Customer;
import com.tyz.web.admin.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customerinfo")
    public Result<List<Customer>> customerInfo(){
        List<Customer> list = customerService.list();
        return Result.ok(list);
    }

    @GetMapping("/customerfullinfo")
    public Result<Customer> customerFullInfo(@RequestParam Long id){
        Customer customer = customerService.getById(id);
        return Result.ok(customer);
    }

    @GetMapping("/search_customer")
    public Result<Customer> searchCustomer(@RequestParam Long customerIdCard){
        Customer customer = customerService.getOneByIdCard(customerIdCard);
        return Result.ok(customer);
    }

    @PostMapping("/customer_management")
    public Result customerManagement(@RequestBody Customer customer){
        customerService.selectOneByIdCardAndPhone(customer);
        return Result.ok();
    }

    @PostMapping("/update_customer")
    public Result updateCustomer(@RequestBody Customer Customer){
        customerService.saveOrUpdate(Customer);
        return Result.ok();
    }

    //删除customer信息
    @DeleteMapping("/deleteCustomer")
    public Result deleteCustomer(@RequestParam Long customerId){
        customerService.removeCustomerById(customerId);
        return Result.ok();
    }
}

