<?php
header('Content-type:text/html;charset=utf-8');
//定义用户信息：id和姓名
$info = array('id'=>234,'name'=>'王五');

//判断是否上传头像
if(!empty($_FILES['pic'])){	
	//获取用户上传文件信息
	$pic_info = $_FILES['pic'];

	//判断文件上传到临时文件是否出错
	if($pic_info['error'] >0){
		$error_msg = '上传错误:';
		switch($pic_info['error']){
			case 1: $error_msg .= '文件大小超过了php.ini中upload_max_filesize选项限制的值！'; break;
			case 2: $error_msg .= '文件大小超过了表单中max_file_size选项指定的值！'; break;
			case 3: $error_msg .= '文件只有部分被上传！'; break;
			case 4: $error_msg .= '没有文件被上传！'; break;
			case 6: $error_msg .= '找不到临时文件夹！'; break;
			case 7: $error_msg .= '文件写入失败！'; break;
			default: $error_msg .='未知错误！'; break; 
		}
		echo $error_msg;
		return false;
	}
	
	//获取上传文件的类型
	//$type = substr(strrchr($pic_info['name'],'.'),1);
    $type = substr($pic_info['name'],strrpos($pic_info['name'],".")+1);
	//判断上传文件类型
	if($type !== 'jpg'){
		echo '图像类型不符合要求，允许的类型为:jpg';
		return false;
	}
	
	//为上传文件起名字
	$new_file = $info['id'].'.jpg';
	//上传文件保存路径
	$filename = './pic/'.$new_file;
	//若用户现有头像存在则删除
	/*if(file_exists($filename)){
		unlink($filename);
	}*/
	//头像上传到临时目录成功，将其保存到脚本所在目录中
	if(!move_uploaded_file($pic_info['tmp_name'],$filename)){
		echo '头像上传失败';
		return false;
	}
}
?>
<!doctype html>
<html>
 <head>
  <meta charset="utf-8">
  <title>用户头像上传</title>
  <style>
  	body{ background:#ccc; }
	.box{ width:320px; border: solid #ccc 1px; background:#fff; margin:0 auto; padding:0 0 10px 60px;}
	img{ width:90px; float:left;padding:2px;border:1px solid #999;}
	.exist{ float:left;}
	.upload{ clear:both; padding-top:15px; }
	h2{ padding-left:60px;font-size:20px;}
	.sub{ margin-left:85px; background:#0099FF; border:1px solid #55BBFF; width:85px; height:30px; color:#FFFFFF; font-size:13px; font-weight:bold; cursor:pointer; margin-top:5px;}
  </style>
 </head>
 <body>
 <div class="box">
   <h2>编辑用户头像</h2>
   <p>用户姓名：<?php echo $info['name'];?></p>
   <p class="exist">现有头像：</p>
   <img src="<?php echo './pic/'.$info['id'].'.jpg?rand='.rand(); ?>" onerror="this.src='./default.jpg'" />
   <form method="post" enctype="multipart/form-data">
	 <p class="upload">上传头像：<input name="pic" type="file"/></p>
	 <p><input class="sub" type="submit" value="保存头像"></p>
   </form>
 </div>
 </body>
</html>