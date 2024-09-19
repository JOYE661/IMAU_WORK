package com.demo.crm.biz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Company {
    @TableId(type = IdType.AUTO)
    private  Integer id;
    private String name ;
    private String address;
    private String linkman;
    private String phone;

}
