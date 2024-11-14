<?php

/**
 * 读取配置
 * @param string $name 配置项
 * @return mixed 配置值
 */
function config($name)
{
    static $config = null;
    if (!$config) {
        $config = require './common/config.php';
    }
    return isset($config[$name]) ? $config[$name] : '';
}

/**
 * 接收输入的函数
 * @param array $method 输入的数组（可用字符串get、post来表示）
 * @param string $name 从数组中取出的变量名
 * @param string $type 表示类型的字符串
 * @param mixed $default 变量不存在时使用的默认值
 * @return mixed 返回的结果
 */
function input($method, $name, $type = 's', $default = '')
{
    switch ($method) {
        case 'get': $method = $_GET; break;
        case 'post': $method = $_POST; break;
        case 'cookie': $method = $_COOKIE; break;
        case 'file': $method = $_FILES; break;
    }
    $data = isset($method[$name]) ? $method[$name] : $default;
    switch ($type) {
        case 's': return is_string($data) ? $data : $default;
        case 'd': return (int) $data;
        case 'b': return (bool) $data;
        case 'a': return is_array($data) ? $data : [];
        case 'f': return (float) $data;
        default: trigger_error('不存在的过滤类型“' . $type . '”');
    }
}

/**
 * 重定向并停止脚本
 * @param string $url 目标URL
 */
function redirect($url)
{
    header("Location: $url");
    exit;
}

/**
 * 生成分页导航HTML
 * @param string $url 链接地址
 * @param int $total 总记录数
 * @param init $page 当前页码值
 * @param int $size 每页显示的条数
 * @param string $anchor 锚点
 * @return string 生成的HTML结果
 */
function page_html($url, $total, $page, $size, $anchor = '')
{
    // 计算总页数
    $maxpage = max(ceil($total / $size), 1);
    // 如果不足2页，则不显示分页导航
    if ($maxpage <= 1) {
        return '';
    }
    if ($page == 1) {
        $first = '<span>首页</span>';
        $prev = '<span>上一页</span>';
    } else {
        $first = "<a href=\"{$url}1$anchor\">首页</a>";
        $prev = '<a href="' . $url . ($page - 1) . $anchor.  '">上一页</a>';
    }
    if ($page == $maxpage) {
        $next = '<span>下一页</span>';
        $last = '<span>尾页</span>';
    } else {
        $next = '<a href="' . $url . ($page + 1) . $anchor . '">下一页</a>';
        $last = "<a href=\"{$url}{$maxpage}{$anchor}\">尾页</a>";
    }
    // 组合最终样式
    return "$first $prev $next $last";
}
/**
 * 获取SQL中的分页部分
 * @param int $page 当前页码值
 * @param int $size 每页显示的条数
 * @return string 拼接后的结果
 */
function page_sql($page, $size)
{
    return ($page - 1) * $size . ',' . $size;
}

/**
 * 生成缩略图（最大裁剪）
 * @param string $file 原图的路径
 * @param string $save 缩略图的保存路径
 * @param int $limit 缩略图的边长（像素）
 * @return bool 成功返回true，失败返回false
 */
function thumb($file, $save, $limit)
{
    $func = [
        'image/png' => function ($file, $img = null) {
            return $img ? imagepng($img, $file) : imagecreatefrompng($file);
        },
        'image/jpeg' => function ($file, $img = null) {
            return $img ? imagejpeg($img, $file, 100) : imagecreatefromjpeg($file);
        }
    ];
    $info = getimagesize($file);
    list($width, $height) = $info;
    $mime = $info['mime'];
    if (!in_array($mime, ['image/png', 'image/jpeg'])) {
        trigger_error('创建缩略图失败，不支持的图片类型。', E_USER_WARNING);
        return false;
    }
    $img = $func[$mime]($file);
    if ($width > $height) {
        $size = $height;
        $x = (int) (($width - $height) / 2);
        $y = 0;
    } else {
        $size = $width;
        $x = 0;
        $y = (int) (($height - $width) / 2);
    }
    $thumb = imagecreatetruecolor($limit, $limit);
    imagecopyresampled($thumb, $img, 0, 0, $x, $y, $limit, $limit, $size, $size);
    return $func[$mime]($save, $thumb);
}

/**
 * 密码加密
 * @param string $password 密码原文
 * @param string $salt 密钥
 * @return string 加密后的MD5值
 */
function password($password, $salt)
{
    return md5(md5($password) . $salt);
}

/**
 * 生成令牌
 * @return string 生成结果
 */
function token_get(){
	if(isset($_SESSION['fun']['token'])){
		$token = $_SESSION['fun']['token'];
	}else{
		$token = md5(microtime(true));
		$_SESSION['fun']['token'] = $token;
	}
	return $token;
}

/**
 * 验证令牌
 * @params string $token 待验证的令牌
 * @return bool 验证结果
 */
function token_check($token){
	return token_get() === $token;
}

/**
 * 将验证码保存到Session
 * @param string $code 待保存验证码
 */
function captcha_save($code)
{
    $_SESSION['fun']['captcha'] = $code;
}

/**
 * 对验证码进行验证
 * @param string $code 输入验证码
 * @return bool 验证结果
 */
function captcha_check($code)
{
    $captcha = isset($_SESSION['fun']['captcha']) ? $_SESSION['fun']['captcha'] : '';
    if (!empty($captcha)) {
        unset($_SESSION['fun']['captcha']);               // 清除验证码，防止重复验证
        return strtoupper($captcha) == strtoupper($code); // 不区分大小写
    }
    return false;
}

function input_check($field, $data, &$msg = '')
{
    switch ($field) {
        case 'user_name':
            $msg = '2~10位中文、字母、数字、下划线。';
            return (bool)preg_match('/^[\w\x{4E00}-\x{9FA5}]{2,10}$/u', $data);
        case 'user_password':
            $msg = '6~12位字母、数字、下划线。';
            return (bool)preg_match('/^\w{6,12}$/', $data);
        case 'user_email':
            return (bool)preg_match('/^(\w+(\_|\-|\.)*)+@(\w+(\-)?)+(\.\w{2,})+$/', $data);
        case 'post_video':
            $domain = parse_url($data);
            return isset($domain['host']) && in_array(strtolower($domain['host']), config('APP_VIDEO_ALLOW'));
    }
}

function user($name, $user = null)
{
    static $data = null;
    return $user ? ($data = $user) : $data[$name];
}

function autologin_cookie($data)
{
    $time = time();
    return $time . '|' . password($data, $time . config('AUTOLOGIN_SERCET'));
}

function autologin_check($cookie, $data)
{
    $arr = explode('|', $cookie, 2);
    return isset($arr[1]) && (time() - config('AUTOLOGIN_EXPIRES') < (int)$arr[0]) && (password($data, $arr[0] . config('AUTOLOGIN_SERCET')) == $arr[1]);
}

function category_list()
{
    static $data = [];
    return $data ?: ($data = Db::getInstance()->fetchAll('SELECT `id`,`name`,`cover`,`sort` FROM __CATEGORY__ ORDER BY `sort` ASC'));
}

function parse_video_url($url)
{
    preg_match('/ src=[\'"](.*?)[\'"]/', $url, $match);
    return isset($match[1]) ? $match[1] : $url;
}
