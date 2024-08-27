package com.tyz.web.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tyz.common.result.Result;
import com.tyz.model.entity.Fund;
import com.tyz.web.admin.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/fund")
public class FundController {
    @Autowired
    private FundService fundService;

    @GetMapping("/fundinfo")
    public Result<IPage<Fund>> fundInfo(@RequestParam long current,@RequestParam long size,Fund fund){
        IPage<Fund> page = new Page<>(current,size);
        IPage<Fund> result = fundService.pageFundByQuery(page,fund);
//        List<Fund> list = fundService.listFundInfo();
        return Result.ok(result);
    }

    @GetMapping("/fullinfo")
    public Result<Fund> fullInfo(@RequestParam Long id){
        Fund fund = fundService.getById(id);
        return Result.ok(fund);
    }

    @DeleteMapping("/modify_fund")
    public Result modifyFund(@RequestParam Long id){
        fundService.removeById(id);
        return Result.ok();
    }

    @PostMapping("/update_fund")
    public Result updateFund(@RequestBody Fund fund){
        fundService.saveOrUpdate(fund);
        return Result.ok();
    }

    @GetMapping("/query")
    public Result<Fund> queryFund(@RequestParam Long id){
        Fund fund = fundService.getById(id);
        return Result.ok(fund);
    }

    @PostMapping("/create_dailynav")
    public Result createDailyNav(){
        //暂时搁置
//        fundService.generateDailyNav();
        return Result.ok();
    }

    @PostMapping("/generateNewProduct")
    public Result generateNewProduct(@RequestBody Fund fund){
        fund.setFundCode(fund.getFundType());
        fundService.save(fund);
        return Result.ok();
    }


}
