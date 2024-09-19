<?php

class Upload
{

    private $file = [];         // 文件信息数组
    private $allow_ext = [];    // 允许上传和保存文件的扩展名
    private $upload_dir = '';   // 上传文件保存目录
    private $new_dir = '';      // 介于上传目录和文件名之间的子目录
    private $error = '';        // 错误信息
    private $msg = [
        UPLOAD_ERR_INI_SIZE => '文件大小超过了服务器设置的限制！',
        UPLOAD_ERR_FORM_SIZE => '文件大小超过了表单设置的限制！',
        UPLOAD_ERR_PARTIAL => '文件只有部分被上传！',
        UPLOAD_ERR_NO_TMP_DIR => '上传文件临时目录不存在！',
        UPLOAD_ERR_CANT_WRITE => '文件写入失败！'
    ];

    /**
     * 构造方法
     * @param array $file 上传文件 $_FILES['xx'] 数组
     * @param string $upload_dir 上传文件保存目录
     * @param array $new_dir 介于上传目录和文件名之间的子目录
     * @param array $allow_ext 允许上传和保存文件的扩展名
     * @param int $limit 文件数量限制，默认20，至少为1
     */
    public function __construct(array $file, $upload_dir = '.', $new_dir = '', array $allow_ext = [], $limit = 20)
    {
        if (isset($file['error'])) {
            $this->file = $this->parse($file, max((int) $limit, 1));
        }
        $this->upload_dir = trim($upload_dir, '/');
        $this->new_dir = trim($new_dir, '/');
        $this->allow_ext = $allow_ext;
    }

    /**
     * 上传一个文件
     * @return string 成功返回文件名，失败返回false
     */
    public function uploadOne()
    {
        return $this->save(current($this->file));
    }

    /**
     * 上传文件，支持文件数组
     * @return array 返回保存文件名的数组
     */
    public function upload()
    {
        $result = [];
        foreach ($this->file as $k => $v) {
            if (!$save = $this->save($v)) {
                continue;
            }
            $result[$k] = $save;
        }
        return $result;
    }

    /**
     * 获取错误信息
     * @return string 错误信息
     */
    public function getError()
    {
        return $this->error;
    }

    private function parse($file, $limit)
    {
        $result = [];
        if (is_array($file['error'])) {
            foreach ($file['error'] as $k => $v) {
                $v = (int) $v;
                $this->error = isset($this->msg[$v]) ? $this->msg[$v] : '';
                if ($v == UPLOAD_ERR_OK && ( --$limit >= 0)) {
                    $result[$k] = [
                        'name' => $file['name'][$k],
                        'tmp_name' => $file['tmp_name'][$k],
                        'type' => $file['type'][$k],
                        'size' => $file['size'][$k],
                        'error' => $file['error'][$k]
                    ];
                }
            }
        } elseif ($file['error'] == UPLOAD_ERR_OK) {
            $result[] = $file;
        } else {
            $this->error = isset($this->msg[$file['error']]) ? $this->msg[$v] : '';
        }
        return $result;
    }

    private function save($file)
    {
        if ($this->error || $file['error'] == UPLOAD_ERR_NO_FILE) {
            return false;
        }
        $ext = pathinfo($file['name'], PATHINFO_EXTENSION);
        if (!in_array(strtolower($ext), $this->allow_ext)) {
            $this->error = '文件上传失败：只允许扩展名：' . implode(', ', $this->allow_ext);
            return false;
        }
        $upload_dir = $this->upload_dir . '/' . $this->new_dir;
        if (!is_dir($upload_dir) && !mkdir($upload_dir, 0777, true)) {
            $this->error = '文件上传失败：无法创建保存目录！';
            return false;
        }
        $new_name = md5(microtime(true)) . ".$ext";
        if (!move_uploaded_file($file['tmp_name'], "$upload_dir/$new_name")) {
            $this->error = '文件上传失败：无法保存文件！';
            return false;
        }
        return trim($this->new_dir . '/' . $new_name, '/');
    }
}
