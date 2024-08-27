package com.tyz.web.admin.vo;

import lombok.Data;



import lombok.Data;

@Data
public class AccountRequest {
    private Long accountId; // 账户id
    private Long customerId; // 用户id
    private Long customerIdCard; // 客户认证号码

    // Lombok注解@Data已自动生成getter和setter方法
}