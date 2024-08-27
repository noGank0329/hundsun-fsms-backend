package com.tyz.web.admin.controller;

import com.tyz.common.result.Result;
import com.tyz.model.entity.Hold;
import com.tyz.web.admin.service.HoldService;
import com.tyz.web.admin.vo.HoldVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/hold")
public class HoldController {

    @Autowired
    private HoldService holdService;

    @GetMapping("/query")
    public Result<Hold> queryFundShare(@RequestParam HoldVo holdVo){
        Hold hold = holdService.selectFundShareByAccountAndFundId(holdVo);
        return Result.ok(hold);
    }

    @PostMapping("/update")
    public Result updateInformation(@RequestBody Hold hold){
        holdService.saveOrUpdate(hold);
        return Result.ok();
    }

}
