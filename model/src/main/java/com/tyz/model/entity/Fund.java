package com.tyz.model.entity;

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
 * @TableName fund
 */
@TableName(value ="fund")
@Data
public class Fund implements Serializable {
    /**
     * 
基金id，主键
     */
    @TableId
    private Integer fundId;

    /**
     * 基金名称
     */
    private String fundName;

    /**
     * 基金类型
     */
    private String fundType;

    /**
     * 基金净值
     */
    private BigDecimal fundNav;

    /**
     * 基金成立时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fundEstDate;

    /**
     * 
基金代码（基于类型）
     */
    private String fundCode;

    /**
     * 
基金风险等级
     */
    private Integer fundRiskLevel;

    /**
     * 基金产品经理名称
     */
    private String fundManagerName;

    /**
     * 基金状态
     */
    private Integer fundState;

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
        Fund other = (Fund) that;
        return (this.getFundId() == null ? other.getFundId() == null : this.getFundId().equals(other.getFundId()))
            && (this.getFundName() == null ? other.getFundName() == null : this.getFundName().equals(other.getFundName()))
            && (this.getFundType() == null ? other.getFundType() == null : this.getFundType().equals(other.getFundType()))
            && (this.getFundNav() == null ? other.getFundNav() == null : this.getFundNav().equals(other.getFundNav()))
            && (this.getFundEstDate() == null ? other.getFundEstDate() == null : this.getFundEstDate().equals(other.getFundEstDate()))
            && (this.getFundCode() == null ? other.getFundCode() == null : this.getFundCode().equals(other.getFundCode()))
            && (this.getFundRiskLevel() == null ? other.getFundRiskLevel() == null : this.getFundRiskLevel().equals(other.getFundRiskLevel()))
            && (this.getFundManagerName() == null ? other.getFundManagerName() == null : this.getFundManagerName().equals(other.getFundManagerName()))
            && (this.getFundState() == null ? other.getFundState() == null : this.getFundState().equals(other.getFundState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFundId() == null) ? 0 : getFundId().hashCode());
        result = prime * result + ((getFundName() == null) ? 0 : getFundName().hashCode());
        result = prime * result + ((getFundType() == null) ? 0 : getFundType().hashCode());
        result = prime * result + ((getFundNav() == null) ? 0 : getFundNav().hashCode());
        result = prime * result + ((getFundEstDate() == null) ? 0 : getFundEstDate().hashCode());
        result = prime * result + ((getFundCode() == null) ? 0 : getFundCode().hashCode());
        result = prime * result + ((getFundRiskLevel() == null) ? 0 : getFundRiskLevel().hashCode());
        result = prime * result + ((getFundManagerName() == null) ? 0 : getFundManagerName().hashCode());
        result = prime * result + ((getFundState() == null) ? 0 : getFundState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fundId=").append(fundId);
        sb.append(", fundName=").append(fundName);
        sb.append(", fundType=").append(fundType);
        sb.append(", fundNav=").append(fundNav);
        sb.append(", fundEstDate=").append(fundEstDate);
        sb.append(", fundCode=").append(fundCode);
        sb.append(", fundRiskLevel=").append(fundRiskLevel);
        sb.append(", fundManagerName=").append(fundManagerName);
        sb.append(", fundState=").append(fundState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}