package com.tyz.web.admin.mapper;

import com.tyz.common.result.Result;
import com.tyz.model.entity.Transaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseMapper {
    /**
     * 插入交易记录
     * @param purchase 交易对象
     * @return 影响的行数
     */
    int insertPurchase(Transaction purchase);
}
