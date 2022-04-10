package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.common.CommonPage;
import com.example.demo.dao.EventMapper;
import com.example.demo.entity.resp.Event;
import com.example.demo.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired(required = false)
    private EventMapper eventMapper;

    @Override
    public CommonPage searchEvent(String category, String location, String time, Integer pageNum, Integer pageSize) {
        CommonPage result = new CommonPage();
        int total = eventMapper.getTotal(category, location, time);
        result.setTotal(Long.valueOf(total));
        if (total % pageSize == 0) {
            result.setTotalPage(Long.valueOf(total % pageSize));
        } else {
            result.setTotalPage(Long.valueOf(total % pageSize + 1));
        }
        List<Event> list = eventMapper.getList(category, location, time, (pageNum - 1) * pageSize, pageSize);
        result.setList(list);
        result.setPageNum(Long.valueOf(pageNum));
        result.setPageSize(Long.valueOf(pageSize));
        return result;
    }

}
