package com.tyz.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName sharerecord
 */
@TableName(value ="sharerecord")
@Data
public class Sharerecord implements Serializable {
    /**
     * 份额记录id
     */
    @TableId(type = IdType.AUTO)
    private Integer recordId;

    /**
     * 账户id
     */
    private Integer accountId;

    /**
     * 份额记录日期
     */
    private Date shareRecordDate;

    /**
     * 份额记录类型
     */
    private Integer shareRecordType;

    /**
     * 份额记录金额
     */
    private Integer shareRecordAmount;

    /**
     * 之前份额
     */
    private Integer shareBefore;

    /**
     * 之后份额
     */
    private Integer shareAfter;

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
        Sharerecord other = (Sharerecord) that;
        return (this.getRecordId() == null ? other.getRecordId() == null : this.getRecordId().equals(other.getRecordId()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getShareRecordDate() == null ? other.getShareRecordDate() == null : this.getShareRecordDate().equals(other.getShareRecordDate()))
            && (this.getShareRecordType() == null ? other.getShareRecordType() == null : this.getShareRecordType().equals(other.getShareRecordType()))
            && (this.getShareRecordAmount() == null ? other.getShareRecordAmount() == null : this.getShareRecordAmount().equals(other.getShareRecordAmount()))
            && (this.getShareBefore() == null ? other.getShareBefore() == null : this.getShareBefore().equals(other.getShareBefore()))
            && (this.getShareAfter() == null ? other.getShareAfter() == null : this.getShareAfter().equals(other.getShareAfter()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecordId() == null) ? 0 : getRecordId().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getShareRecordDate() == null) ? 0 : getShareRecordDate().hashCode());
        result = prime * result + ((getShareRecordType() == null) ? 0 : getShareRecordType().hashCode());
        result = prime * result + ((getShareRecordAmount() == null) ? 0 : getShareRecordAmount().hashCode());
        result = prime * result + ((getShareBefore() == null) ? 0 : getShareBefore().hashCode());
        result = prime * result + ((getShareAfter() == null) ? 0 : getShareAfter().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recordId=").append(recordId);
        sb.append(", accountId=").append(accountId);
        sb.append(", shareRecordDate=").append(shareRecordDate);
        sb.append(", shareRecordType=").append(shareRecordType);
        sb.append(", shareRecordAmount=").append(shareRecordAmount);
        sb.append(", shareBefore=").append(shareBefore);
        sb.append(", shareAfter=").append(shareAfter);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}