package com.example.demo.service;

import com.example.demo.common.CommonPage;

public interface SearchService {

    CommonPage searchEvent(String category, String location, String time, Integer pageNum, Integer pageSize);

    CommonPage searchCharity(String yearLevel, String state, String size, String keyword, Integer pageNum,
            Integer pageSize);

}
