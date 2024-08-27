package com.tyz.web.admin.service;

import com.tyz.common.result.Result;
import com.tyz.model.entity.Transaction;

public interface RedemptionService {
    Result<Transaction> createRedemption(Integer accountId, Integer fundId, Integer redemptionAmount);
}
