const express = require('express')
// 使用express路由模块
const router = express.Router()

// mysql数据库工具
const MysqlUtil = require('../utils/MysqlUtil')

// 获取商品列表数据
router.get('/findGoodsList', async (req, res) => {
    let result = await MysqlUtil.query('select * from tm_goods');
    res.send({
        code: 0,
        msg: '成功',
        data: result
    });
});

// 根据id获取商品详情
router.get('/getGoodsDetail', async (req, res) => {
    let sql = 'select * from tm_goods where id = ? '
    // 1.利用联表查询
    // let sql = 'select goods.*,cate.type_label as goods_type_name from tm_goods goods left join tm_category cate on goods.goods_type = cate.id where goods.id = ? '
    let result = await MysqlUtil.query(sql, [req.query.id]);
    // 2.多查一次
    let result1 = await MysqlUtil.query('select type_label from tm_category where id = ?',[result[0].goods_type]);
    // 灵活
    result[0].goods_type_name = result1[0].type_label
    if (result.length == 0) {
        res.send({
            code: 1,
            msg: '数据不存在',
        })
    } else {
        res.send({
            code: 0,
            msg: '成功',
            data: result[0]
        })
    }
})

// 新增商品
router.post('/addGoods', async (req, res) => {
    // req.body;
    let sql = 'insert into tm_goods(goods_name,goods_price,goods_origin_price,sale_num,evaluation_num,unit_name,stock_num,goods_type) values(?,?,?,?,?,?,?,?)';
    await MysqlUtil.execute(sql, [
        req.body.goods_name,
        req.body.goods_price,
        req.body.goods_origin_price,
        req.body.sale_num,
        req.body.evaluation_num,
        req.body.unit_name,
        req.body.stock_num,
        req.body.goods_type
    ]);
    res.send({
        code: 0,
        msg: '新增成功',
    })
})

// 修改类型数据
router.post('/updateGoods', async (req, res) => {
    // req.body;
    let sql = 'update tm_goods set goods_name = ?,goods_price = ?,goods_origin_price = ?,sale_num = ?,evaluation_num=?,unit_name=?,stock_num=?,goods_type=? where id = ?';
    await MysqlUtil.execute(sql, [
        req.body.goods_name,
        req.body.goods_price,
        req.body.goods_origin_price,
        req.body.sale_num,
        req.body.evaluation_num,
        req.body.unit_name,
        req.body.stock_num,
        req.body.goods_type,
        req.body.id
    ]);
    res.send({
        code: 0,
        msg: '新增成功',
    })
})

// 根据id删除商品
router.get('/deleteGoods', async (req, res) => {
    await MysqlUtil.execute('delete from tm_goods where id = ?', [req.query.id])
    res.send({
        code: 0,
        msg: '删除成功',
    })
})
//批量删除（ids：字符串）
router.post('/batchDelete', async (req, res) => {
    console.log(req.body)
    await MysqlUtil.execute(`delete from tm_goods where id in (${req.body.ids.join(',')})`)
    join
    res.send({
        code: 0,
        msg: '删除成功',
    })
})
// 如果后端给你的是数组，你要变成字符串才能使用的话
// 可以使用.join()函数
// arry.join(’,’)表示用 ，来链接数组中的各项

//管理员查询接口search
router.get('/search',async (req,res)=>{
    let sql = 'select * from tm_goods where goods_name is ?'
    let result = await MysqlUtil.query(sql,[req.query.search]);
    if(result.length == 0){
        res.send({
            code:1,
            msg:'数据不存在',
        })
    }else{
        res.send({
            code:0,
            msg:'成功',
            data:result
        })
    }
})



// 导出路由，非常关键的步骤！！！
module.exports = router