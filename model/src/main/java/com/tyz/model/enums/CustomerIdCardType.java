package com.tyz.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CustomerIdCardType implements BaseEnum{
    IDENTITY_CARD(0,"身份证"),
    PASSPORT(1,"护照"),
    HONGKONG_MACAO_RESIDENTS(3,"港澳台居民居住证/通行证")
    ;
    @EnumValue
    @JsonValue
    private Integer code;

    private String name;

    CustomerIdCardType(Integer code, String name) {
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
