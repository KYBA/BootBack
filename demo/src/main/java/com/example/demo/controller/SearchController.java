package com.example.demo.controller;

import java.util.List;

import com.example.demo.common.CommonPage;
import com.example.demo.common.CommonResult;
import com.example.demo.entity.req.Question;
import com.example.demo.entity.resp.ScoreAndCount;
import com.example.demo.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class SearchController {
    @Autowired(required = true)
    private SearchService searchService;

    @GetMapping("search")
    public CommonResult<CommonPage> searchActivity(String category, String location, String time,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {
        CommonPage result = searchService.searchEvent(category, location, time, pageNum, pageSize);
        return CommonResult.success(result);
    }

    @PostMapping("score")
    public CommonResult<ScoreAndCount> scoreAndCount(@RequestBody List<Question> answers) {
        ScoreAndCount result = searchService.scoreAndCount(answers);
        return CommonResult.success(result);
    }

}
