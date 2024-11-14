<?php
require './common/init.php';
require './common/library/Upload.php';
// 检查登录
if (!IS_LOGIN) {
    redirect('login.php');
}
// 处理表单
if (IS_POST) {
    // 上传头像
    if (!$avatar = user_avatar_upload(input('file', 'avatar', 'a'), $error)) {
        display("头像上传失败，$error");
    }
    // 删除原来的头像
    $db = Db::getInstance();
    $avatar_old = './uploads/avatar/' . $db->value('__USER__', 'avatar', 'i', ['id' => user('id')]);
    is_file($avatar_old) && unlink($avatar_old);
    // 更新头像记录
    $db->update('__USER__', 'si', ['avatar' => $avatar, 'id' => user('id')], 'id');
}
// 显示页面
display();

// 上传头像
function user_avatar_upload($file, &$error = '')
{
    $upload_dir = './uploads/temp';
    $up = new Upload($file, $upload_dir, '', ['jpg', 'jpeg', 'png']);
    if(!$result = $up->uploadOne()) {
        $error = $up->getError() ?: '没有上传文件。';
        return false;
    }
    $new_dir = date('Y-m/d');
    $avatar_dir = "./uploads/avatar/$new_dir";
    // 创建保存目录
    if (!is_dir($avatar_dir) && !mkdir($avatar_dir, 0777, true)) {
        $error = '无法创建头像保存目录！';
        return false;
    }
    $upload_file = "$upload_dir/$result";
    thumb($upload_file, "$avatar_dir/$result", 120);
    is_file($upload_file) && unlink($upload_file);
    return "$new_dir/$result";
}

// 显示页面并退出
function display($tips = null)
{
    $avatar = Db::getInstance()->value('__USER__', 'avatar', 'i', ['id' => user('id')]);
    require './view/user.html';
    exit;
}
