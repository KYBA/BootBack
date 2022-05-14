package com.example.demo.service;

import java.util.List;

import com.example.demo.common.CommonPage;
import com.example.demo.entity.req.Question;
import com.example.demo.entity.resp.ScoreAndCount;

public interface SearchService {

    CommonPage searchEvent(String category, String location, String time, Integer pageNum, Integer pageSize);

    CommonPage searchCharity(String yearLevel, String state, String size, String keyword, Integer pageNum,
            Integer pageSize);

    ScoreAndCount scoreAndCount(List<Question> answers);

}
