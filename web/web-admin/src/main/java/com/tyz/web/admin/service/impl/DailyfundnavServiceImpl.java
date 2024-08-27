package com.tyz.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyz.model.entity.Dailyfundnav;
import com.tyz.web.admin.mapper.DailyfundnavMapper;
import com.tyz.web.admin.service.DailyfundnavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author tangyizuo
* @description 针对表【dailyfundnav】的数据库操作Service实现
* @createDate 2024-08-19 17:41:55
*/
@Service
public class DailyfundnavServiceImpl extends ServiceImpl<DailyfundnavMapper, Dailyfundnav>
    implements DailyfundnavService{

    @Autowired private DailyfundnavMapper dailyfundnavMapper;

    @Override
    public Dailyfundnav getDailynav(Dailyfundnav dailyfundnav) {
        return dailyfundnavMapper.getDailynav(dailyfundnav);
    }

    @Override
    public List<Dailyfundnav> listByDate(Date date) {
        return dailyfundnavMapper.listByDate(date);
    }
}




