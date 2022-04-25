package com.example.demo.controller;

import com.example.demo.common.CommonPage;
import com.example.demo.common.CommonResult;
import com.example.demo.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/charity")
public class CharityController {
    @Autowired(required = true)
    private SearchService searchService;

    @GetMapping("search")
    public CommonResult<CommonPage> searchActivity(String yearLevel, String state, String size, String keyword,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "7") Integer pageSize) {
        CommonPage result = searchService.searchCharity(yearLevel, state, size, keyword, pageNum, pageSize);
        return CommonResult.success(result);
    }
}
