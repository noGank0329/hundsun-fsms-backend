package com.tyz.web.admin.vo;

import lombok.Data;



@Data
public class AccountRequest {
    private Long id;

    // getters and setters
    public Long getIds() {
        return id;
    }

    public void setIds(Long id) {
        this.id = id;
    }
}
