package com.demo.crm.biz.controller;

import com.demo.crm.biz.pojo.Company;
import com.demo.crm.biz.pojo.User;
import com.demo.crm.biz.service.CompanyService;
import com.demo.crm.biz.service.UserService;
import com.demo.crm.jwt.JwtUtils;
import com.demo.crm.vo.PageCondition;
import com.demo.crm.vo.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RestController
public class CompanyController {

    // 注入
    //@Autowired
    @Resource
    private CompanyService companyService;

    // 注册
    // http://localhost:9000/reg?username=aaa&password=111
    @RequestMapping("/company/save")
    public Result reg(@RequestBody Company company) throws IOException {
        companyService.save(company);
        return Result.ok();
    }

    @RequestMapping("/company/page")
    public Result page(@RequestBody PageCondition pageCondition) {
        int total = companyService.count();
        List<Company> list = companyService.findPage(pageCondition);
        return Result.ok().addTotal(total).addList(list);
    }

    @RequestMapping("/company/update")
    public Result updateUser(@RequestBody Company company) {
        companyService.updateCompany(company);
        return Result.ok();
    }
}
