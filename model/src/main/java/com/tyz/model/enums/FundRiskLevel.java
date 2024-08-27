package com.tyz.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FundRiskLevel implements BaseEnum{
    LOW_RISK(0, "低风险"),
    MEDIUM_LOW_RISK(1, "中低风险"),
    MEDIUM_RISK(2,"中风险"),
    MEDIUM_HIGH_RISK(3,"中高风险"),
    HIGH_RISK(4,"高风险")
    ;

    @EnumValue
    @JsonValue
    private Integer code;

    private String name;

    FundRiskLevel(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
