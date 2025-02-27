const express = require('express')
// 使用express路由模块
const router = express.Router()

// mysql数据库工具
const MysqlUtil = require('../utils/MysqlUtil')

// 登录接口
// async表示同步方法 需要和await配合使用
// req表示前端发送过来的请求
// res表示后端给前端返回的响应
router.post('/admin_login', async (req,res)=>{
    let sql = 'select * from tm_admin where admin_name = ? and admin_password = ?';
    // req.body表示请求体
    // result 是数据库查询结果 => [] 数组
    const result = await MysqlUtil.query(sql,[req.body.admin_name,req.body.admin_password]);
    // 数组的长度是不是大于 大于0=>有查询结果，有这个用户
    // 等于0=>表示没有查到数据 密码错误 或 用户不存在
    if(result.length > 0){
        // send给前端发送响应
        res.send({
          code:0,
          msg:'登录成功',
        })
    }else{
        res.send({
            code:-1,
            msg:'登录失败',
          })
    }
})



// 导出路由，非常关键的步骤！！！
module.exports = router