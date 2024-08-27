package com.tyz.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CustomerType implements BaseEnum{

    Personal(0, "个人"),
    INSTITUTION(1, "机构");

    @EnumValue
    @JsonValue
    private Integer code;

    private String name;


    CustomerType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return null;
    }
}
