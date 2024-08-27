package com.tyz.web.admin.service;


import com.tyz.common.result.Result;
import com.tyz.model.entity.Transaction;

public interface PurchaseService {
    Result<Transaction> createPurchase(Integer accountId, String cardNumber, Integer fundId, Double purchaseAmount);
}
