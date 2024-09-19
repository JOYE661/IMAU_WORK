package com.demo.crm.vo;

import lombok.Data;

@Data
public class PageCondition {
    private String year;
    private String provId;
    private String cityId;
    private int pageNum;
    private int pageSize;
    private int first;

    public int getFirst() {
        return (pageNum - 1) * pageSize;
    }
}
