package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.resp.CharityVO;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CharityMapper {

    int getTotal(String yearLevel, String state, String size, String keyword);

    List<CharityVO> getList(String yearLevel, String state, String size, String keyword, int start, Integer pageSize);

    List<String> getStateByCharity(Long charityId);

}
