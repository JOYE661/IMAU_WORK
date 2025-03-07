const express = require('express')
// 使用express路由模块
const router = express.Router()

// mysql数据库工具
const MysqlUtil = require('../utils/MysqlUtil')

// 获取分类列表数据
router.get('/findTypeList',async (req,res)=>{
    let result = await MysqlUtil.query('select * from tm_category');//查询出来的是一个数组
    res.send({
        code:0,
        msg:'成功',
        data:result//显示是一个数组
    });
});

// 新增分类
router.post('/addType',async (req,res)=>{
    // req.body;
    let sql = 'insert into tm_category(type_label) values(?)';
    await MysqlUtil.execute(sql,[req.body.type_label]);
    res.send({
        code:0,
        msg:'新增成功',
      })
})

// 根据id获取类型详情
router.get('/getTypeDetail',async (req,res)=>{
    let sql = 'select * from tm_category where id = ? '
    let result = await MysqlUtil.query(sql,[req.query.id]);
    if(result.length == 0){
        res.send({
            code:1,
            msg:'数据不存在',
        })
    }else{
        res.send({
            code:0,
            msg:'成功',
            data:result[0]
        })
    }
})

// 根据id删除类型
router.get('/deleteType',async (req,res)=>{
  await MysqlUtil.execute('delete from tm_category where id = ?',[req.query.id])
  res.send({
    code:0,
    msg:'删除成功',
  })
})

// 修改类型数据
router.post('/updateType',async (req,res)=>{
    // req.body;
    let sql = 'update tm_category set type_label = ? where id = ?';
    await MysqlUtil.execute(sql,[req.body.type_label,req.body.id]);
    res.send({
        code:0,
        msg:'新增成功',
      })
})


// 导出路由，非常关键的步骤！！！
module.exports = router