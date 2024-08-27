package com.tyz.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName transaction
 */
@TableName(value ="transaction")
@Data
public class Transaction implements Serializable {
    /**
     * 交易id，主键
     */
    @TableId(type = IdType.AUTO)
    private Integer transactionId;

    /**
     * 账户id，外键，引用account
     */
    private Integer accountId;

    /**
     * 基金id，外键，引用fund
     */
    private Integer fundId;

    /**
     * 交易类型（申购或者赎回）
     */
    private Integer transactionType;

    /**
     * 交易金额
     */
    private BigDecimal transactionAmount;

    /**
     * 交易份额
     */
    private BigDecimal transactionShare;

    /**
     * 交易时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date transactionDate;

    /**
     * 交易状态
     */
    private Integer transactionState;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Transaction other = (Transaction) that;
        return (this.getTransactionId() == null ? other.getTransactionId() == null : this.getTransactionId().equals(other.getTransactionId()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getFundId() == null ? other.getFundId() == null : this.getFundId().equals(other.getFundId()))
            && (this.getTransactionType() == null ? other.getTransactionType() == null : this.getTransactionType().equals(other.getTransactionType()))
            && (this.getTransactionAmount() == null ? other.getTransactionAmount() == null : this.getTransactionAmount().equals(other.getTransactionAmount()))
            && (this.getTransactionShare() == null ? other.getTransactionShare() == null : this.getTransactionShare().equals(other.getTransactionShare()))
            && (this.getTransactionDate() == null ? other.getTransactionDate() == null : this.getTransactionDate().equals(other.getTransactionDate()))
            && (this.getTransactionState() == null ? other.getTransactionState() == null : this.getTransactionState().equals(other.getTransactionState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTransactionId() == null) ? 0 : getTransactionId().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getFundId() == null) ? 0 : getFundId().hashCode());
        result = prime * result + ((getTransactionType() == null) ? 0 : getTransactionType().hashCode());
        result = prime * result + ((getTransactionAmount() == null) ? 0 : getTransactionAmount().hashCode());
        result = prime * result + ((getTransactionShare() == null) ? 0 : getTransactionShare().hashCode());
        result = prime * result + ((getTransactionDate() == null) ? 0 : getTransactionDate().hashCode());
        result = prime * result + ((getTransactionState() == null) ? 0 : getTransactionState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", transactionId=").append(transactionId);
        sb.append(", accountId=").append(accountId);
        sb.append(", fundId=").append(fundId);
        sb.append(", transactionType=").append(transactionType);
        sb.append(", transactionAmount=").append(transactionAmount);
        sb.append(", transactionShare=").append(transactionShare);
        sb.append(", transactionDate=").append(transactionDate);
        sb.append(", transactionState=").append(transactionState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}