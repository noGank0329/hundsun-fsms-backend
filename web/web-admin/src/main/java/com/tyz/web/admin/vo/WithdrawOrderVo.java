package com.tyz.web.admin.vo;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class WithdrawOrderVo {
    private Long TransactionId;

    private Long FundId;

    private BigDecimal TransactionAmount;
}
