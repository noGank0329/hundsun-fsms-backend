package com.tyz.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName hold
 */
@TableName(value ="hold")
@Data
public class Hold implements Serializable {
    /**
     * 持有信息id
     */
    @TableId(type = IdType.AUTO)
    private Integer holdId;

    /**
     * 账户id
     */
    private Integer accountId;

    /**
     * 基金id
     */
    private Integer fundId;

    /**
     * 
持有份额
     */
    private Integer fundShare;

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
        Hold other = (Hold) that;
        return (this.getHoldId() == null ? other.getHoldId() == null : this.getHoldId().equals(other.getHoldId()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getFundId() == null ? other.getFundId() == null : this.getFundId().equals(other.getFundId()))
            && (this.getFundShare() == null ? other.getFundShare() == null : this.getFundShare().equals(other.getFundShare()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHoldId() == null) ? 0 : getHoldId().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getFundId() == null) ? 0 : getFundId().hashCode());
        result = prime * result + ((getFundShare() == null) ? 0 : getFundShare().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", holdId=").append(holdId);
        sb.append(", accountId=").append(accountId);
        sb.append(", fundId=").append(fundId);
        sb.append(", fundShare=").append(fundShare);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}