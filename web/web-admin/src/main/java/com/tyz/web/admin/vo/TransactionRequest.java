package com.tyz.web.admin.vo;

import lombok.Data;

import java.util.List;

@Data
public class TransactionRequest {
    private List<Long> ids;

    // getters and setters
    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
