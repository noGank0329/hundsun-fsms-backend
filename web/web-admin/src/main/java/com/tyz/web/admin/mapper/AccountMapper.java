package com.tyz.web.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tyz.model.entity.Account;
import com.tyz.web.admin.vo.AccountRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper extends BaseMapper<Account> {
    IPage<Account> pageAccountByCustomerId(IPage<Account> page, Long customerId);
    List<String> findCardNumbersByAccountId(Integer accountId);

    List<AccountRequest> queryAccountByID(@Param("ew") LambdaQueryWrapper<AccountRequest> queryWrapper);
}