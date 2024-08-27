package com.tyz.web.admin.vo;

import lombok.Data;

/**
 * 代表客户信息的值对象
 */
@Data
public class CustomerInfoVo {
    private Integer customerId;
    private String customerName;
    private String customerPhone;
    private Integer customerIdcard;
    private Integer customerIdcardType;
    public Integer riskLevel;
}
