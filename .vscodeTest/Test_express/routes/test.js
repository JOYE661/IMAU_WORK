const express = require('express')
// 使用express路由模块
const router = express.Router()

// 编写具体请求处理方法
router.get('/',  (req, res)=> {
    res.send('test模块默认请求处理')
})

router.get('/test1',(req,res)=>{
    res.send('test1')
})

router.get('/test2',(req,res)=>{
    res.send('test2');
});

router.post('/test3',(req,res)=>{
    res.send('test3');
});

router.get('/testReqParmas/:id/:sId',(req,res)=>{
    console.log(req.params)
    res.send('testReqParmas');
});

router.get('/testReqQuery',(req,res)=>{
    console.log(req.query);
    res.send(req.query);
})

router.post('/testReqBody',(req,res)=>{
    console.log(req.body);
    res.send(req.body);
})
router.get('/testReqHeader',(req,res)=>{
    console.log(req.header('token'));
    res.send(req.headers);
})

router.get('/testResStatus',(req,res)=>{
    res.status(500);
    res.send('testResStatus');
})

router.get('/testRedirect',(req,res)=>{
    res.redirect('https://www.baidu.com');
})

router.get('/testResHeaderSet',(req,res)=>{
    res.set('token','123456789798')
    res.send('testResHeaderSet')
})
// 导出路由，非常关键的步骤！！！
module.exports = router