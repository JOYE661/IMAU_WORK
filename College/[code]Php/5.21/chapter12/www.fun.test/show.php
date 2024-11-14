<?php
require './common/init.php';
// 接收参数
$id = input('get', 'id', 'd');
$page = max(input('get', 'page', 'd'), 1);
$action = input('get', 'action', 's');
// 处理请求
$db = Db::getInstance();
if (IS_POST && $action == 'reply') {
    if (!IS_LOGIN) {
        redirect('login.php');
    }
    $reply = mb_strimwidth(input('post', 'reply', 's'), 0, 200);
    $result = $db->insert('__REPLY__', 'iisi', ['pid' => $id, 'uid' => user('id'), 'content' => $reply, 'time' => time()]);
    $result && $db->execute("UPDATE __POST__ SET `reply`=`reply`+1 WHERE `id`=$id");
    redirect("show.php?id=$id#reply");
} elseif ($action == 'reply_del') {
    if (!IS_LOGIN) {
        redirect('login.php');
    }
    $del = input('get', 'del', 'd');
    $result = IS_ADMIN ? $db->delete('__REPLY__', 'i', ['id' => $del]) : $db->delete('__REPLY__', 'ii', ['id' => $del, 'uid' => user('id')]);
    $result && $db->execute("UPDATE __POST__ SET `reply`=`reply`-1 WHERE `id`=$id AND `reply` > 0");
    redirect("show.php?id=$id&page=$page");
}
// 增加阅读计数
$db->execute("UPDATE __POST__ SET `hits`=`hits`+1 WHERE `id`=$id");
// 查询记录
$sql = 'SELECT p.`uid`,p.`type`,p.`content`,p.`time`,p.`hits`,p.`reply`,'
    . ' u.`name`,u.`avatar`,c.`name` cname FROM __POST__ p'
    . ' LEFT JOIN __USER__ u ON p.`uid`=u.`id`'
    . ' LEFT JOIN __CATEGORY__ c ON p.`cid`=c.`id`'
    . " WHERE p.`id`=$id LIMIT 1";
if (!$post = $db->fetchRow($sql)) {
    exit('您查看的内容不存在。');
}
$type = $post['type'];
$atch = [];
if ($type == 'pic' || $type == 'video') {
    $atch = $db->select('__ATTACHMENT__', 'content', 'i', ['pid' => $id]);
}
// 查询回复
$total = $db->fetchRow("SELECT COUNT(*) `total` FROM __REPLY__ WHERE `pid`=$id")['total'];
$limit = 'LIMIT ' . page_sql($page, config('APP_REPLY_PAGESIZE'));
$reply = $db->fetchAll('SELECT r.`id`,r.`uid`,r.`content`,r.`time`,'
    . ' u.`name`,u.`avatar` FROM __REPLY__ r'
    . ' LEFT JOIN __USER__ u ON r.`uid`=u.`id`'
    . " WHERE r.`pid`=$id ORDER BY r.`id` DESC $limit");
$category = category_list();
require './view/show.html';