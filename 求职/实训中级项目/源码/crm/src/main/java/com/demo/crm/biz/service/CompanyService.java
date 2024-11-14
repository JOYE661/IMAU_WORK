package com.demo.crm.biz.service;

import com.demo.crm.biz.pojo.Company;
import com.demo.crm.biz.pojo.User;
import com.demo.crm.vo.PageCondition;

import java.util.List;

public interface CompanyService {
    Company login(String name);

    void save(Company company);

    int count();

    List<Company> findPage(PageCondition pageCondition);

    void updateCompany(Company company);
}
