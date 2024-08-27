package com.tyz.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AccountRiskLevel implements BaseEnum{
    CAUTION(0, "谨慎型"),
    ROBUST(1, "稳健型"),
    BALANCED(2,"平衡型"),
    AGGRESSIVE(3,"进取型"),
    HIGH_AGGRESSIVE(4,"激进型")
    ;

    @EnumValue
    @JsonValue
    private Integer code;

    private String name;

    AccountRiskLevel(Integer code, String name) {
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
