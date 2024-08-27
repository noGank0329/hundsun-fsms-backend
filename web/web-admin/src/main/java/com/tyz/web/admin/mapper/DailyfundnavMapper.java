package com.tyz.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyz.model.entity.Dailyfundnav;

import java.util.Date;
import java.util.List;

/**
* @author tangyizuo
* @description 针对表【dailyfundnav】的数据库操作Mapper
* @createDate 2024-08-19 17:41:55
* @Entity com.demo.pc.entity.Dailyfundnav
*/
public interface DailyfundnavMapper extends BaseMapper<Dailyfundnav> {

    Dailyfundnav getDailynav(Dailyfundnav dailyfundnav);

    List<Dailyfundnav> listByDate(Date date);
}




