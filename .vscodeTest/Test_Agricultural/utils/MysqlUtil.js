// 引入mysql2
const mysql = require('mysql2');
// 引入数据库配置
const config = require('../config/dbconfig')

class MysqlUtil{

    // 获取mysql数据库的连接
    static async getConnection(){
        // await等待数据库连接完成
        const connection = await mysql.createConnection(config);
        return connection;
    }

    // 数据库查询
    static async query(sql,params = []){
        const conn = await this.getConnection();
        // 取出结果
        const [rows] = await conn.promise().query(sql,params);
        return rows;
    }

    // 执行数据库 新增、修改、删除
    static async execute(sql,params = []){
        const conn = await this.getConnection();
        const result = await conn.promise().execute(sql,params);
        return result;
    }

}

// 导出工具
module.exports = MysqlUtil;