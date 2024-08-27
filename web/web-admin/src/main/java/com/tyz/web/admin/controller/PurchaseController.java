package com.tyz.web.admin.controller;

import com.tyz.common.result.Result;
import com.tyz.common.result.ResultCodeEnum;
import com.tyz.model.entity.Transaction;
import com.tyz.web.admin.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/create")
    public Result<Transaction>createPurchase(
            @RequestParam Integer accountId,
            @RequestParam String cardNumber,
            @RequestParam Integer fundId,
            @RequestParam Double purchaseAmount) {

        return purchaseService.createPurchase(accountId, cardNumber, fundId, purchaseAmount);
    }
}
