<?php
return [
    // 数据库连接配置
    'DB_CONNECT' => [
        'host' => 'localhost',
        'user' => 'root',
        'pass' => '123456',
        'dbname' => 'php_fun',
        'port' => '3306'
    ],
    // 数据库字符集
    'DB_CHARSET' => 'utf8',
    // 项目的数据库表前缀
    'DB_PREFIX' => 'fun_',
    // 自动登录 加密Cookie的密钥
    'AUTOLOGIN_SERCET' => 'df9jEn3HdpSoe',
    // 自动登录 默认保存时间（30天）
    'AUTOLOGIN_EXPIRES' => 3600 * 24 * 30,
    // 允许的图片扩展名（小写）
    'PICTURE_EXT' => ['jpg', 'jpeg', 'png', 'gif', 'bmp'],
    // 网页标题
    'APP_TITLE' => '趣PHP - 学习分享网站',
    // 顶部导航
    'APP_NAV' => ['hot' => '热门', 'new' => '新鲜', 'pic' => '趣图', 'text' => '趣文', 'video' => '视频'],
    // 每页显示内容数
    'APP_PAGESIZE' => 5,
    // 每页显示评论数
    'APP_REPLY_PAGESIZE' => 5,
    // 每个内容允许的附件最大数量
    'APP_ATTACHMENT_MAX' => 10,
    // 视频域名白名单
    'APP_VIDEO_ALLOW' => [
        'player.youku.com',         // 优酷
        'v.qq.com',                 // 腾讯
        'open.iqiyi.com',           // 爱奇艺
        'tv.sohu.com',              // 搜狐
        'www.acfun.cn',             // AcFun
        'player.bilibili.com',      // bilibili
    ]
];