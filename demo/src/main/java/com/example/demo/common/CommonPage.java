package com.example.demo.common;

import java.util.List;

import com.example.demo.entity.resp.CharityVO;
import com.example.demo.entity.resp.Event;

import lombok.Data;

@Data
public class CommonPage {
    /**
     * 当前页码
     */
    private Long pageNum;
    /**
     * 每页数量
     */
    private Long pageSize;
    /**
     * 总页数
     */
    private Long totalPage;
    /**
     * 总条数
     */
    private Long total;
    /**
     * 分页数据
     */
    private List<CharityVO> list;

    public Long getPageNum() {
        return pageNum;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<CharityVO> getList() {
        return list;
    }

    public void setList(List<CharityVO> list) {
        this.list = list;
    }

}