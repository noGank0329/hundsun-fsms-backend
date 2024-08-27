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
 * @TableName dailyfundnav
 */
@TableName(value ="dailyfundnav")
@Data
public class Dailyfundnav implements Serializable {
    /**
     * 净值记录id
     */
    @TableId(type = IdType.AUTO)
    private Integer navId;

    /**
     * 产品id
     */
    private Integer fundId;

    /**
     * 净值日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date navDate;

    /**
     * 产品净值
     */
    private BigDecimal fundNav;

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
        Dailyfundnav other = (Dailyfundnav) that;
        return (this.getNavId() == null ? other.getNavId() == null : this.getNavId().equals(other.getNavId()))
            && (this.getFundId() == null ? other.getFundId() == null : this.getFundId().equals(other.getFundId()))
            && (this.getNavDate() == null ? other.getNavDate() == null : this.getNavDate().equals(other.getNavDate()))
            && (this.getFundNav() == null ? other.getFundNav() == null : this.getFundNav().equals(other.getFundNav()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNavId() == null) ? 0 : getNavId().hashCode());
        result = prime * result + ((getFundId() == null) ? 0 : getFundId().hashCode());
        result = prime * result + ((getNavDate() == null) ? 0 : getNavDate().hashCode());
        result = prime * result + ((getFundNav() == null) ? 0 : getFundNav().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", navId=").append(navId);
        sb.append(", fundId=").append(fundId);
        sb.append(", navDate=").append(navDate);
        sb.append(", fundNav=").append(fundNav);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}