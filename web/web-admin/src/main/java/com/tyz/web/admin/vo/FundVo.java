package com.tyz.web.admin.vo;

import lombok.Data;

@Data
public class FundVo {
    private Long FundId;

    private String FundName;

    private String FundType;

    private Long FundRiskLevel;

    private Long FundState;
}
