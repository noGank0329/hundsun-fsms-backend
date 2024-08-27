package com.tyz.web.admin.controller;

import com.tyz.common.result.Result;
import com.tyz.common.result.ResultCodeEnum;
import com.tyz.model.entity.Transaction;
import com.tyz.web.admin.service.PurchaseService;
import com.tyz.web.admin.service.RedemptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redemption")
public class RedemptionController {
    @Autowired
    private RedemptionService redemptionService;

    @PostMapping("/create")
    public Result<Transaction>createPurchase(
            @RequestParam Integer accountId,
            @RequestParam Integer fundId,
            @RequestParam Integer redemptionAmount) {

        return redemptionService.createRedemption(accountId, fundId, redemptionAmount);
    }
}
