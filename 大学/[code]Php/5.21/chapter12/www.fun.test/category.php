<?php
require './common/init.php';
require './common/library/Upload.php';
// 权限验证
if (!IS_ADMIN) {
    exit('您无权访问。<a href="./">返回首页</a>');
}
// 处理表单
if (IS_POST) {
    category_add($error);
    $error && display("栏目添加失败，$error");
    category_save($error);
    $error && display("栏目修改失败，$error");
    category_delete();
}
// 显示页面
display();

// 栏目添加
function category_add(&$error = '')
{
    $cover = category_cover_upload(input('file', 'add_cover', 'a'), $error);
    $result = [];
    foreach (input('post', 'add', 'a') as $k => $v) {
        $result[] = [
            'name' => mb_strimwidth(input($v, 'name', 's'), 0, 12),
            'cover' => input($cover, $k, 's'),
            'sort' => input($v, 'sort', 'd'),
        ];
    }
    $result && Db::getInstance()->insert('__CATEGORY__', 'ssi', $result);
}

// 栏目修改
function category_save(&$error = '')
{
    $result = [];
    foreach (input('post', 'save', 'a') as $k => $v) {
        $result[] = [
            'name' => mb_strimwidth(input($v, 'name', 's'), 0, 12),
            'sort' => input($v, 'sort', 'd'),
            'id' => abs($k),
        ];
    }
    // 保存记录
    $db = Db::getInstance();
    $result && $db->update('__CATEGORY__', 'sii', $result, 'id');
    $cover = [];
    // 获取待删除图片
    $cover_del = input('post', 'del_cover', 'a');
    foreach ($cover_del as $v) {
        $cover[$v] = ['cover' => '', 'id' => abs($v)];
    }
    // 获取新上传的图片
    $cover_save = category_cover_upload(input('file', 'save_cover', 'a'), $error);
    foreach ($cover_save as $k => $v) {
        $cover[$k] = ['cover' => $v, 'id' => abs($k)];
    }
    if ($cover) {
        category_cover_delete(array_keys($cover));          // 删除原图文件
        $db->update('__CATEGORY__', 'si', $cover, 'id');    // 更新图片字段
    }
}

// 栏目删除
function category_delete()
{
    $del = array_map('abs', input('post', 'del', 'a'));
    if ($del) {
        // 删除原图文件
        category_cover_delete($del);
        // 删除数据记录
        $db = Db::getInstance();
        $sql_del = implode(',', $del);
        $db->execute("DELETE FROM __CATEGORY__ WHERE `id` IN ($sql_del)");
        // 将栏目中的内容设置为空栏目
        $db->execute("UPDATE __POST__ SET `cid`=0 WHERE `cid` IN ($sql_del)");
    }
}

// 栏目图片上传
function category_cover_upload($file, &$error = '')
{
    $up = new Upload($file, './uploads/category', date('Y-m/d') , config('PICTURE_EXT'));
    $result = $up->upload();
    $error = $up->getError();
    return $result;
}

// 栏目图片删除
function category_cover_delete($cover)
{
    $data = Db::getInstance()->fetchAll('SELECT `cover` FROM __CATEGORY__ WHERE `id` IN (' . implode(',', $cover) . ')');
    foreach ($data as $v) {
        $path = './uploads/category/' . $v['cover'];
        is_file($path) && unlink($path);
    }
}

// 显示页面并退出
function display($tips = null, $type = '')
{
    $category = category_list();
    require './view/category.html';
    exit;
}
