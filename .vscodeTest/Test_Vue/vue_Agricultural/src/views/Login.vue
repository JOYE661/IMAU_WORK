<template>
    <div id="login">
        <div class="header">
            <span>农产品销售</span>
        </div>
        <!-- v-model 双向绑定 输入框输入的值就和loginObj对象的uesername属性相同 -->
        <!-- @是v-on指令的缩写，监听叉叉事件，click-》点击
        当点击这个动作发生的事件，会触发一个事件，会触发一个（方法，函数） -->
        <div class="content">
            <div class="bg"></div>
            <div class="login-form">
                <div class="title">User&nbsp;&nbsp;Login</div>
                <el-form :model="formObj">
                    <el-form-item prop="username">
                        <div style="display: flex;">
                            <div class="suffix">
                                <i class="el-icon-user-solid"></i>
                            </div>
                            <el-input v-model="formObj.username" placeholder="会员名/手机号/邮箱"></el-input>
                        </div>
                    </el-form-item>
                    <el-form-item prop="password">
                        <div style="display: flex;">
                            <div class="suffix">
                                <i class="el-icon-lock"></i>
                            </div>
                            <el-input v-model="formObj.password" type="password" placeholder="密码"></el-input>
                        </div>
                        
                    </el-form-item>
                </el-form>
                <div class="login-bt" @click="handleClick">登录</div>
              
                   
            </div>
        </div>
        <div class="footer">
           

        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name:"Login",
   data(){
    return{
        formObj:{
            username:'',
            password:''
        }
    }
   },
   methods:{
    handleClick(){
        //点击触发了这个方法
        // this.$router.push('/home')//相当于点击路由链接（可以返回当前路由界面）
        axios.post('http://localhost:3000/user/login',{username:this.formObj.username,
        password:this.formObj.password
        }).then(res=>{
            //请求完成之后 res后端给到的数据（响应）
            // console.log(res.date);
            if(res.data.code==-1){
                this.$message.error(res.data.msg)
            }else{
                this.$message.success(res.data.msg)
                this.$router.push('/home')
            }
        })
    },
    // 同步处理方法
    async handleClickAsync(){
        let res = await axios.post('http://localhost:3000/user/login',{username:this.formObj.username, password:this.formObj.password})
        if(res.data.code == 0){
            this.$message.success(res.data.msg)
            this.$router.push('/admin/product')
        }else{
            this.$message.error(res.data.msg)
        }
    }
}
}

</script>

<style scoped>
.header{
    background: #ffffff;
    height: 100px;
    color: #18b958;
    font-size: 40px;
}
span{
    position: absolute;
    height: 50px;
    left: 110px;
    top: 25px;
}
.content{
    background: #f1dca5;
    height: 600px;
}
.bg{
    background: url('~@/assets/login.png');
    height: 100%;
    width: 100%;
/*   
   margin-left: 100px;
   margin-right: 100px; */
}
.login-form{
    width: 350px;
    background: #eef1e3;
    position: absolute;
    right: 150px;
    top: 250px;
    padding: 40px;
    box-sizing: border-box;
    
    border-radius: 20px ;
}
.login-form .title{
    font-weight: bold;
    margin-bottom: 20px;
}
.login-bt{
    background: #18b958;
    color: #ffffff;
    height: 40px;
    text-align: center;
    line-height: 40px;
    cursor: pointer;
}
.suffix{
    width: 40px;
    height: 40px;
    background: #68b958;
    text-align: center;
}
span{
    position: absolute;
    height: 50px;
    left: 110px;
    top: 40px;
}
.reg{
    display: inline;
}
.reg1{
    margin-top: 12px;
   float: left;
    cursor: pointer;

}
.reg2{
     margin-top: 12px;
    float: right;
}
.reg:hover{
    text-decoration: underline;
}
.title{
    color: #68b958;
    font-size: 20px;
    padding-left: 60px;
}
</style>