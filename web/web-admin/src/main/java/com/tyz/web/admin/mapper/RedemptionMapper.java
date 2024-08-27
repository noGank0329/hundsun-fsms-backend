package com.tyz.web.admin.mapper;

import com.tyz.common.result.Result;
import com.tyz.model.entity.Transaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RedemptionMapper {
    /**
     * 插入交易记录
     * @param redemption 交易对象
     * @return 影响的行数
     */
    int insertRedemption(Transaction redemption);
}
