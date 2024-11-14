<?php
require './common/init.php';
require './common/library/Upload.php';
// 检查登录
if (!IS_LOGIN) {
    redirect('login.php');
}
// 接收参数
$id = input('get', 'id', 'd');
$type = input('get', 'type', 's');
if (!in_array($type, ['pic', 'text', 'video'])) {
    $type = 'text';
}
// 删除指定内容
$action = input('get', 'action', 's');
if ($action == 'del') {
    $db = Db::getInstance();
    // 先验证权限
    $result = $db->find('__POST__', 'uid,type', 'i', ['id' => $id]);
    if (!$result || (!IS_ADMIN && $result['uid'] != user('id'))) {
        exit('您无权删除此内容，或内容不存在。');
    }
    // 删除图片
    if ($result['type'] == 'pic') {
        foreach ($db->select('__ATTACHMENT__', 'content', 'i', ['pid' => $id]) as $v) {
            $path = './uploads/picture/' . $v['content'];
            is_file($path) && unlink($path);
        }
    }
    // 删除记录
    $db->delete('__POST__', 'i', ['id' => $id]);
    $db->delete('__ATTACHMENT__', 'i', ['pid' => $id]);
    redirect('./');
}
// 处理表单
if (IS_POST) {
    $data = [
        'cid' => input('post', 'cid', 'd'),
        'content' => mb_strimwidth(input('post', 'content', 's'), 0, 1000),
        'uid' => user('id'),
    ];
    $db = Db::getInstance();
    if ($id) {
        // 更新记录，在更新前先验证权限
        $result = $db->find('__POST__', 'uid,type', 'i', ['id' => $id]);
        if (!$result || (!IS_ADMIN && $result['uid'] != user('id'))) {
            exit('您无权编辑此内容，或内容不存在。');
        }
        $type = $result['type'];
        $data['id'] = $id;
        $db->update('__POST__', 'isii', $data, 'id');
        // 删除原来的图片或视频
        if ($type == 'pic') {
            $del = array_map('abs', input('post', 'del', 'a'));
            $del && post_picture_delete($id, $del);
        } elseif ($type == 'video') {
            $db->delete('__ATTACHMENT__', 'i', ['pid' => $id]);
        }
    } else {
        // 新增记录
        $data['type'] = $type;
        $data['time'] = time();
        $id = $db->insert('__POST__', 'isisi', $data);
    }
    // 上传附件，保存记录
    $atch = post_attachment($id, $type, $error);
    $atch && $db->insert('__ATTACHMENT__', 'si', $atch);
    $error ? display($error, $id, $type) : redirect("show.php?id=$id");
}
// 显示页面
display(null, $id, $type);

// 处理图片和视频
function post_attachment($id, $type, &$error = '')
{
    $atch = [];
    if ($type == 'pic') {
        $pic = post_picture_upload(input('file', 'pic', 'a'), $error);
        $error && $error = "图片上传失败：$error";
        foreach ($pic as $v) {
            $atch[] = ['content' => $v, 'pid' => $id];
        }
    } elseif ($type == 'video') {
        foreach (input('post', 'video', 'a') as $v) {
            $v = is_string($v) ? parse_video_url(trim($v)) : '';
            if (!input_check('post_video', strtolower($v))) {
                $error = '链接视频失败，URL中包含不支持的域名。';
                continue;
            }
            $atch[] = ['content' => substr($v, 0, 255), 'pid' => $id];
        }
    }
    return $atch;
}

// 上传图片
function post_picture_upload($file, &$error = '')
{
    $up = new Upload($file, './uploads/picture/', date('Y-m/d'), config('PICTURE_EXT'), config('APP_ATTACHMENT_MAX'));
    $result = $up->upload();
    $error = $up->getError();
    return $result;
}

// 删除图片
function post_picture_delete($pid, $del)
{
    $db = Db::getInstance();
    $where = "`pid`=$pid AND `id` IN (" . implode(',', $del) . ')';
    $data = $db->fetchAll("SELECT `content` FROM __ATTACHMENT__ WHERE $where");
    foreach ($data as $v) {
        $path = './uploads/picture/' . $v['content'];
        is_file($path) && unlink($path);
    }
    $db->execute("DELETE FROM __ATTACHMENT__ WHERE $where");
}

// 显示页面并退出
function display($tips = null, $id = 0, $type = 'text')
{
    $atch = [];
    $post = ['cid' => 0, 'content' => ''];
    if ($id) {
        $db = Db::getInstance();
        $post = $db->find('__POST__', 'cid,uid,type,content', 'i', ['id' => $id]);
        if (!$post || (!IS_ADMIN && $post['uid'] != user('id'))) {
            exit('您无权编辑此内容，或内容不存在。');
        }
        $type = $post['type'];
        if ($type == 'pic' || $type == 'video') {
            $atch = $db->select('__ATTACHMENT__', 'id,content', 'i', ['pid' => $id]);
        }
    }
    $category = category_list();
    require './view/post.html';
    exit;
}
