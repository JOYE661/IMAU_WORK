<?php
require './generate.php';
//保存表单元素，多维数组
$elements = [
    [
        'attr' => ['type' => 'text', 'name' => 'user', 'size' => '25'],
        'tag' => 'input',
        'text' => '姓　　名：',
        
    ], [
        'tag' => 'input',
        'text' => '邮　　箱：',
        'attr' => ['type' => 'text', 'name' => 'email', 'size' => '25']
    ], [
        'text' => '手机号码：',
        'tag' => 'input',
        
        'attr' => ['type' => 'text', 'name' => 'tel', 'size' => '25']
    ], [
        'tag' => 'input',
        'text' => '性　　别：',
        'attr' => ['type' => 'radio', 'name' => 'gender'],
        'option' => ['m' => '男', 'w' => '女'],
        'default' => 'm'
    ], [
        'tag' => 'input',
        'text' => '爱　　好：',
        'attr' => ['type' => 'checkbox', 'name' => 'hobby[]'],
        'option' => ['swimming' => '游泳', 'reading' => '读书', 'running' => '跑步',],
        'default' => ''
    ], [
        'tag' => 'select',
        'text' => '住　　址：',
        'attr' => ['name' => 'area'],
        'option' => ['' => '--请选择--', 'BJ' => '北京', 'SH' => '上海', 'SZ' => '深圳',]
    ], [
        'tag' => 'textarea',
        'text' => '自我介绍：',
        'attr' => ['name' => 'declare', 'cols' => '50', 'rows' => '5']
    ], [
        'tag' => 'input',
        'attr' => ['type' => 'submit', 'value' => '提交']
    ]
];
// var_dump($_POST);
?>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Web表单生成器</title>
    <style>
      body{margin-top:20px;}
      .box{font-family:Tahoma,simsun;font-size:12px;border:1px solid #1678BE;display:table;margin:0 auto;}
      .box-head{padding:5px 20px;background-color:#2487C9;color:#fff;font-size:14px;}
      .box-body{padding:10px 20px;}
      .box-body th{font-weight:normal;vertical-align:top;padding-top:5px;}
      .box-body td{padding-top:2px;padding-bottom:8px;}
      .box-body select{font-family:Tahoma,simsun;font-size:12px;padding:2px 5px;cursor:pointer;}
      .box-body label{margin-right:5px;cursor:pointer;}
      .box-body label input{cursor:pointer;}
      .box-body input{vertical-align:middle;font-family:Tahoma,simsun;font-size:12px;}
      .box-body input[type=text]{padding:2px;}
      .box-body input[type=radio]{margin-top:-1px;}
      .box-body input[type=submit]{padding:4px 15px;cursor:pointer;}
    </style>
  </head>
  <body>
    <!-- 输出定制表单 -->
    <div class="box">
      <div class="box-head">个人信息</div>
      <div class="box-body">
        <form action="form.php" method="post" enctype="multipart/form-data">
          <?=generate($elements)?>
        </form>
      </div>
    </div>
  </body>
</html>