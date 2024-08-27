package com.tyz.web.admin.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyz.model.entity.Settlement;
import com.tyz.model.entity.Transaction;
import com.tyz.web.admin.mapper.TransactionMapper;
import com.tyz.web.admin.service.TransactionService;
import com.tyz.web.admin.vo.TransactionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author tangyizuo
* @description 针对表【transaction】的数据库操作Service实现
* @createDate 2024-08-19 17:41:55
*/
@Service
public class TransactionServiceImpl extends ServiceImpl<TransactionMapper, Transaction>
    implements TransactionService {
    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public IPage<TransactionVo> pageTransactionByQuery(IPage<TransactionVo> page, TransactionVo transactionVo) {
        return transactionMapper.pageTransactionByQuery(page,transactionVo);
    }

    @Override
    public IPage<Settlement> settlementSubscriptionOrRedemption(IPage<Settlement> page,Long id) {
        return transactionMapper.settlementSubscriptionOrRedemption(page,id);
    }

    @Override
    public List<Transaction> listTransactionByDate(Date date) {
        return transactionMapper.listTransactionByDate(date);
    }
}




