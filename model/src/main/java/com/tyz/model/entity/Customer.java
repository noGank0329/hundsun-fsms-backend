package com.tyz.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName customer
 */
@TableName(value ="customer")
@Data
public class Customer implements Serializable {
    /**
     * 客户id，主键
     */
    @TableId(type = IdType.AUTO)
    private Integer customerId;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 客户类型
     */
    private Integer customerType;

    /**
     * 客户认证号码
     */
    private Integer customerIdcard;

    /**
     * 客户认证类型
     */
    private Integer customerIdcardType;

    /**
     * 客户联系反射方式
     */
    private String customerPhone;

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
        Customer other = (Customer) that;
        return (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getCustomerName() == null ? other.getCustomerName() == null : this.getCustomerName().equals(other.getCustomerName()))
            && (this.getCustomerIdcard() == null ? other.getCustomerIdcard() == null : this.getCustomerIdcard().equals(other.getCustomerIdcard()))
            && (this.getCustomerIdcardType() == null ? other.getCustomerIdcardType() == null : this.getCustomerIdcardType().equals(other.getCustomerIdcardType()))
            && (this.getCustomerPhone() == null ? other.getCustomerPhone() == null : this.getCustomerPhone().equals(other.getCustomerPhone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getCustomerName() == null) ? 0 : getCustomerName().hashCode());
        result = prime * result + ((getCustomerIdcard() == null) ? 0 : getCustomerIdcard().hashCode());
        result = prime * result + ((getCustomerIdcardType() == null) ? 0 : getCustomerIdcardType().hashCode());
        result = prime * result + ((getCustomerPhone() == null) ? 0 : getCustomerPhone().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", customerId=").append(customerId);
        sb.append(", customerName=").append(customerName);
        sb.append(", customerIdcard=").append(customerIdcard);
        sb.append(", customerIdcardType=").append(customerIdcardType);
        sb.append(", customerPhone=").append(customerPhone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}