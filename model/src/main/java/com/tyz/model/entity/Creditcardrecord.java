package com.tyz.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName creditcardrecord
 */
@TableName(value ="creditcardrecord")
@Data
public class Creditcardrecord implements Serializable {
    /**
     * 银行卡记录id
     */
    @TableId(type = IdType.AUTO)
    private Integer recordId;

    /**
     * 银行卡id
     */
    private String creditcardId;

    /**
     * 银行卡记录日期
     */
    private Date creditcardRecordDate;

    /**
     * 银行卡记录类型
     */
    private Integer creditcardRecordType;

    /**
     * 银行卡记录金额
     */
    private BigDecimal creditcardRecordAmount;

    /**
     * 之前余额
     */
    private BigDecimal balanceBefore;

    /**
     * 之后余额
     */
    private BigDecimal balanceAfter;

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
        Creditcardrecord other = (Creditcardrecord) that;
        return (this.getRecordId() == null ? other.getRecordId() == null : this.getRecordId().equals(other.getRecordId()))
            && (this.getCreditcardId() == null ? other.getCreditcardId() == null : this.getCreditcardId().equals(other.getCreditcardId()))
            && (this.getCreditcardRecordDate() == null ? other.getCreditcardRecordDate() == null : this.getCreditcardRecordDate().equals(other.getCreditcardRecordDate()))
            && (this.getCreditcardRecordType() == null ? other.getCreditcardRecordType() == null : this.getCreditcardRecordType().equals(other.getCreditcardRecordType()))
            && (this.getCreditcardRecordAmount() == null ? other.getCreditcardRecordAmount() == null : this.getCreditcardRecordAmount().equals(other.getCreditcardRecordAmount()))
            && (this.getBalanceBefore() == null ? other.getBalanceBefore() == null : this.getBalanceBefore().equals(other.getBalanceBefore()))
            && (this.getBalanceAfter() == null ? other.getBalanceAfter() == null : this.getBalanceAfter().equals(other.getBalanceAfter()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecordId() == null) ? 0 : getRecordId().hashCode());
        result = prime * result + ((getCreditcardId() == null) ? 0 : getCreditcardId().hashCode());
        result = prime * result + ((getCreditcardRecordDate() == null) ? 0 : getCreditcardRecordDate().hashCode());
        result = prime * result + ((getCreditcardRecordType() == null) ? 0 : getCreditcardRecordType().hashCode());
        result = prime * result + ((getCreditcardRecordAmount() == null) ? 0 : getCreditcardRecordAmount().hashCode());
        result = prime * result + ((getBalanceBefore() == null) ? 0 : getBalanceBefore().hashCode());
        result = prime * result + ((getBalanceAfter() == null) ? 0 : getBalanceAfter().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recordId=").append(recordId);
        sb.append(", creditcardId=").append(creditcardId);
        sb.append(", creditcardRecordDate=").append(creditcardRecordDate);
        sb.append(", creditcardRecordType=").append(creditcardRecordType);
        sb.append(", creditcardRecordAmount=").append(creditcardRecordAmount);
        sb.append(", balanceBefore=").append(balanceBefore);
        sb.append(", balanceAfter=").append(balanceAfter);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}