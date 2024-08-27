package com.tyz.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName settlement
 */
@TableName(value ="settlement")
@Data
public class Settlement implements Serializable {
    /**
     * 清算id，主键
     */
    @TableId
    private Integer settlementId;

    /**
     * 清算日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date settlementDate;

    /**
     * 清算结果
     */
    private String settlementResult;

    /**
     * 清算状态
     */
    private Integer settlementState;

    /**
     * 银行柜员id
     */
    private Integer userId;

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
        Settlement other = (Settlement) that;
        return (this.getSettlementId() == null ? other.getSettlementId() == null : this.getSettlementId().equals(other.getSettlementId()))
            && (this.getSettlementDate() == null ? other.getSettlementDate() == null : this.getSettlementDate().equals(other.getSettlementDate()))
            && (this.getSettlementResult() == null ? other.getSettlementResult() == null : this.getSettlementResult().equals(other.getSettlementResult()))
            && (this.getSettlementState() == null ? other.getSettlementState() == null : this.getSettlementState().equals(other.getSettlementState()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSettlementId() == null) ? 0 : getSettlementId().hashCode());
        result = prime * result + ((getSettlementDate() == null) ? 0 : getSettlementDate().hashCode());
        result = prime * result + ((getSettlementResult() == null) ? 0 : getSettlementResult().hashCode());
        result = prime * result + ((getSettlementState() == null) ? 0 : getSettlementState().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", settlementId=").append(settlementId);
        sb.append(", settlementDate=").append(settlementDate);
        sb.append(", settlementResult=").append(settlementResult);
        sb.append(", settlementState=").append(settlementState);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}