package com.tyz.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionState implements BaseEnum{
    WITHDRAW_TRANSACTING(2,"已撤单"),
    DONE_TRANSACTING(1, "已完成"),
    NOT_TRANSACTING(0, "未完成");

    @EnumValue
    @JsonValue
    private Integer code;

    private String name;

    TransactionState(Integer code, String name) {
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
