package com.example.demo.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.resp.Event;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EventMapper extends BaseMapper<EventMapper> {

    int getTotal(String category, String location, String time);

    List<Event> getList(String category, String location, String time, int start, Integer pageSize);

}
