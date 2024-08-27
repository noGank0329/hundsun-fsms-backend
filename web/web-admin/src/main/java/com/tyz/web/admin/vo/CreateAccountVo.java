package com.tyz.web.admin.vo;

import lombok.Data;

@Data
public class CreateAccountVo {
    private String customerName;

    private Long customerType;

    private Long customerIdCardType;

    private Long customerIdCard;

    private Long customerPhone;

    private Long RiskId;

}
