<?php

class Captcha
{

    /**
     * 生成验证码
     * @param int $count 验证码的位数
     * @return string 生成结果
     */
    public static function create($count = 5)
    {
        $charset = 'ABCDEFGHJKLMNPQRSTUVWXYZ23456789';  // 随机因子
        $code = '';                                     // 保存生成的验证码
        // 生成随机码
        $len = strlen($charset) - 1;
        for ($i = 0; $i < $count; ++$i) {
            $code .= $charset[mt_rand(0, $len)];
        }
        return $code;
    }

    /**
     * 输出验证码图像
     * @param string $code 验证码字符串
     */
    public static function show($code, $x = 250, $y = 62)
    {
        // 创建图像资源
        $im = imagecreate($x, $y);
        // 随机生成背景颜色 
        imagecolorallocate($im, mt_rand(50, 200), mt_rand(0, 155), mt_rand(0, 155));
        // 设置验证码文本的颜色和字体
        $fontcolor = imagecolorallocate($im, 255, 255, 255);
        $fontfile = realpath('./common/library/fonts/captcha.ttf');
        // 在图像中绘制验证码
        for ($i = 0, $len = strlen($code); $i < $len; ++$i) {
            imagettftext($im,                       // 图像资源
                30,                                 // 字符尺寸
                mt_rand(0, 20) - mt_rand(0, 25),    // 随机设置字符倾斜角度
                32 + $i * 40, mt_rand(30, 50),      // 随机设置字符坐标
                $fontcolor,                         // 字符颜色
                $fontfile,                          // 字符样式
                $code[$i]                           // 字符内容
            );
        }
        // 添加8个干扰线
        for ($i = 0; $i < 8; ++$i) {
            // 随机生成干扰线颜色
            $linecolor = imagecolorallocate($im, mt_rand(0, 255), mt_rand(0, 255), mt_rand(0, 255));
            // 随机生成干扰线
            imageline($im, mt_rand(0, $x), 0, mt_rand(0, $x), $y, $linecolor);
        }
        // 添加250个噪点
        for ($i = 0; $i < 250; ++$i) {
            // 随机生成噪点位置
            imagesetpixel($im, mt_rand(0, $x), mt_rand(0, $y), $fontcolor);
        }
        // 设置消息头
        header('Content-Type: image/png');
        // 输出图片
        imagepng($im);
        // 释放图像资源
        imagedestroy($im);
    }
}