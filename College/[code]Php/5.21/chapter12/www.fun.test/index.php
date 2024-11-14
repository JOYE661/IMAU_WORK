<?php
require './common/init.php';
$cid = input('get', 'cid', 'd');
$page = max(input('get', 'page', 'd'), 1);
$type = input('get', 'type', 's');
$author = input('get', 'author', 'd');
if (!array_key_exists($type, config('APP_NAV'))) {
    $type = 'hot';
}
$where = 'WHERE 1=1 ';
$where .= $author ? "AND `uid`=$author" : ($cid ? "AND `cid`=$cid" : '');
$where .= in_array($type, ['pic', 'text', 'video']) ? "AND `type`='$type'" : '';
$limit = 'LIMIT ' . page_sql($page, config('APP_PAGESIZE'));
$sort = ['hot' => 'ORDER BY p.`reply` DESC,p.`id` DESC', 'new' => 'ORDER BY p.`id` DESC'];
$order = isset($sort[$type]) ? $sort[$type] : $sort['hot'];
// 获取总记录数
$db = Db::getInstance();
$total = $db->fetchRow("SELECT COUNT(*) `total` FROM __POST__ $where")['total'];
// 查询列表
$sql = 'SELECT p.`id`,p.`uid`,p.`type`,p.`content`,p.`time`,p.`hits`,p.`reply`,'
    . ' u.`name`,u.`avatar`,c.`name` cname FROM __POST__ p'
    . ' LEFT JOIN __USER__ u ON p.`uid`=u.`id`'
    . ' LEFT JOIN __CATEGORY__ c ON p.`cid`=c.`id`'
    . " $where $order $limit";
$list = $db->fetchAll($sql);
// 查询结果为空时，自动返回第1页
if (empty($list) && $page > 1) {
    redirect("index.php?type=$type&cid=$cid&page=1");
}
// 查询预览图或预览视频
foreach ($list as $k => $v) {
    if ($v['type'] == 'pic' || $v['type'] == 'video') {
        $list[$k]['preview'] = $db->value('__ATTACHMENT__', 'content', 'i', ['pid' => $v['id']]);
    }
}
$category = category_list();
require './view/index.html';
