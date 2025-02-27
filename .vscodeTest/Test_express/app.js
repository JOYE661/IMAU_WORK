const express = require('express');
// 引入bodyParser
const bodyParser = require('body-parser');
// 引入json
const json = express.json({type:'*/json'})

const app = express();
// 使用json
app.use(json)
// 使用bodyParser
app.use(bodyParser.urlencoded({extended:false}))

// 解决跨域问题
app.all("*",function(req,res,next){
    // 设置允许跨域的域名,*代表允许任意域名跨域
    res.header('Access-Control-Allow-Origin','*');
    // 允许的header类型
    res.header('Access-Control-Allow-Headers','content-type');
    // 跨域允许的请求方式
    res.header('Access-Control-Allow-Methods','DELETE,PUT,POST,GET,OPTIONS');
    if(req.method.toLowerCase() == 'options')
        res.send(200); // 让options 尝试请求快速结束
    else
        next();
})

const port = 3000;

// 引入test.js文件！！！
const test = require('./routes/test')
const user = require('./routes/user')
const type = require('./routes/type')
const product = require('./routes/product')
const admin_login = require('./routes/admin_login')
app.get('/',(req,res)=>{
    res.send("hello express");
})

// 使用test路由模块！！！
app.use('/test', test);
app.use('/user',user);
app.use('/type',type);
app.use('/goods',product)
app.use('/admin_login',admin_login)
const MysqlUtil = require('./utils/MysqlUtil');
// 查询数据 测试
// MysqlUtil.query('select * from tm_user').then(res=>{
//     console.log(res)
// })
// 新增数据 测试
// MysqlUtil.execute('insert into tm_user(username,password,nickname) values(?,?,?)',['test','123456','测试']).then(res=>{
//     console.log(res);
// })
// 修改数据 测试
// MysqlUtil.execute('update tm_user set username = ?,nickname = ? where id = ?',['test1','测试1',2]).then(res=>{
//     console.log(res);
// })
// 删除数据 测试
// MysqlUtil.execute('delete from tm_user where id in (3,4)').then(res=>{
//     console.log(res);
// })

app.listen(port,()=>{
    console.log(`Example app listening on port ${port}`)
})