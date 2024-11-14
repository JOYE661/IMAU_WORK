<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Document</title>
</head>
<body>
  <form action="form.php" method="post" enctype="multipart/form-data">
    
    <!-- 各种表单控件 -->
    <input type="text" name="user" value="test">	<!-- 文本框 -->
    <input type="password" name="pwd" value="">	    <!-- 密码框 -->
    <input type="file" name="upload">         		<!-- 文件上传域 -->
    <input type="hidden" name="id" value="2"> 		<!-- 隐藏域 -->
    <input type="reset"  value="重置">         		<!-- 重置按钮 -->
    <input type="submit" value="提交">        		<!-- 提交按钮 -->
    
    <!-- 单选框 -->
    <input type="radio" name="gender" value="m" checked> 男
    <input type="radio" name="gender" value="w"> 女
    
    <!-- 复选框 -->
    <input type="checkbox" name="hobby[]" value="swimming"> 游泳
    <input type="checkbox" name="hobby[]" value="reading"> 读书
    <input type="checkbox" name="hobby[]" value="running"> 跑步

    <textarea name="introduce" cols="5" rows="10">
        <!-- 文本内容 --> 
    </textarea>

    <select name="area">
        <option selected>--请选择--</option>
        <option value="Beijing">北京</option>
        <option value="Shenzhen">深圳</option>
        <option value="Shanghai">上海</option>
    </select>

    <label><input type="radio" name="gender" value="m">男</label>
    <label><input type="radio" name="gender" value="w">女</label>
  </form>
</body>
</html>