package com.tyz.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tyz.model.entity.Settlement;
import com.tyz.model.entity.Transaction;
import com.tyz.web.admin.vo.TransactionVo;

import java.util.Date;
import java.util.List;


/**
* @author tangyizuo
* @description 针对表【transaction】的数据库操作Mapper
* @createDate 2024-08-19 17:41:55
* @Entity com.demo.pc.entity.Transaction
*/
public interface TransactionMapper extends BaseMapper<Transaction> {

    IPage<TransactionVo> pageTransactionByQuery(IPage<TransactionVo> page, TransactionVo transactionVo);

    IPage<Settlement> settlementSubscriptionOrRedemption(IPage<Settlement> page,Long id);

    List<Transaction> listTransactionByDate(Date date);
}




