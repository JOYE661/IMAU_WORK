package com.demo.crm.biz.service.impl;

import com.demo.crm.biz.mapper.CompanyMapper;
import com.demo.crm.biz.mapper.UserMapper;
import com.demo.crm.biz.pojo.Company;
import com.demo.crm.biz.pojo.User;
import com.demo.crm.biz.service.CompanyService;
import com.demo.crm.biz.service.UserService;
import com.demo.crm.vo.PageCondition;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private CompanyMapper companyMapper;

    @Override
    public Company login(String name) {
        return companyMapper.findByname(name);
    }

    @Override
    public void save(Company company) {
        companyMapper.insert(company);
    }

    @Override
    public int count() {
        return companyMapper.selectCount(null);
    }

    @Override
    public List<Company> findPage(PageCondition pageCondition) {
        return companyMapper.findPage(pageCondition);
    }

    @Override
    public void updateCompany(Company company) {
        companyMapper.updateCompany(company);
    }
}
