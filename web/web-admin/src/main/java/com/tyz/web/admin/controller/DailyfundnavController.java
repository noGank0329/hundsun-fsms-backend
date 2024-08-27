package com.tyz.web.admin.controller;

import com.tyz.common.result.Result;
import com.tyz.model.entity.Dailyfundnav;
import com.tyz.web.admin.service.DailyfundnavService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/dailyfundnav")
public class DailyfundnavController {
    @Autowired
    private DailyfundnavService dailyfundnavService;

    @GetMapping("/get_dailynav")
    public Result<Dailyfundnav> getDailynav(@RequestBody Dailyfundnav dailyfundnav){
        Dailyfundnav dailyfundnav1 =  dailyfundnavService.getDailynav(dailyfundnav);
        return Result.ok(dailyfundnav1);
    }

    @GetMapping("/queryPreviousDayNav")
    public Result<List<Dailyfundnav>> queryPreviousDayNav(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        Date previousDay = cal.getTime();
        List<Dailyfundnav> list = dailyfundnavService.listByDate(previousDay);
        return Result.ok(list);
    }

    @GetMapping("/queryToday")
    public Result<List<Dailyfundnav>> queryToday(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        System.out.println(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 0);
        Date today = cal.getTime();
        List<Dailyfundnav> list = dailyfundnavService.listByDate(today);
        return Result.ok(list);
    }


    @PostMapping("/updateFundNav")
    public Result updateFundNav(@RequestBody List<Dailyfundnav> dailyfundnavs){
        for(Dailyfundnav dailyfundnav:dailyfundnavs){
            dailyfundnavService.saveOrUpdate(dailyfundnav);
        }
        return Result.ok();
    }
}
