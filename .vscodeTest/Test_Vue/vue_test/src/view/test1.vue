<template>
    <!-- <div id="test">
        {{ msg  }}
    </div> -->
		<form action="https://www.imau.edu.cn" method="post">
			用户名:<input type="test" name="user" placeholder="手机号" maxlength="8"><br>
			密码：<input type="password" name="pwd" maxlength="8"><br>
			上传头像:<input type="file"><br>
			性别：<input type="radio" name="gender" value="man" checked>男
			<input type="radio" name="gender" value="women">女<br>
			爱好:<br>
				<input type="checkbox" name="game1" value="game1">唱<br>
				<input type="checkbox" name="game2" value="game2">跳<br>
				<input type="checkbox" name="game3" value="game3">rap<br>
				<input type="checkbox" name="game4" value="game4">篮球<br>
				学历:<br>
					<select name="std" size="3">
						<option value="std1">高中</option>
						<option value="std2">初中</option>
						<option value="std3" selected>本科</option>
						<option value="std2">硕士</option>
						<option value="std2">博士</option>
					</select><br>
			备注：<br>
			<textarea rows="8" cols="50">个人简介</textarea>
			<br>
			<input type="submit" value="登录">
			<input type="reset" value="重置">
			<input type="button" value="test" onclick="alert('Hello World')">
		</form>

</template>

<script>

export default({
    name: 'test1',
    props:{
        msg: {
            type: String,
            default: 'aaa'
        }  
    },  
    date(){
        return {
            value1: ''
        }
    }    
})
</script>
<style scoped>
</style>
