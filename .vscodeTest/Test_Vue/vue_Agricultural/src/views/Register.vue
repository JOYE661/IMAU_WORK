<template>
    <div id="register">
        <div class="header">
            <span>农产品销售</span>
        </div>
        <!-- v-model 双向绑定 输入框输入的值就和loginObj对象的uesername属性相同 -->
        <!-- @是v-on指令的缩写，监听叉叉事件，click-》点击
        当点击这个动作发生的事件，会触发一个事件，会触发一个（方法，函数） -->
        <div class="content">
            <div class="bg"></div>
            <div class="login-form">
                <div class="title">User&nbsp;&nbsp;Registration</div>
                <el-form >
                    <el-form-item prop="username">
                        <div style="display: flex;">
                            <div class="suffix">
                                <i class="el-icon-user-solid"></i>
                            </div>
                            <el-input  v-model="formData.username" placeholder="请设置用户名"></el-input>
                        </div>
                    </el-form-item>
                    <el-form-item prop="password">
                        <div style="display: flex;">
                            <div class="suffix">
                                <i class="el-icon-lock"></i>
                            </div>
                            <el-input  v-model="formData.password" placeholder="请设置登录密码" type="password" ></el-input>
                        </div>
                        
                    </el-form-item>
                      <el-button class="login-bt1" @click="submit">注册</el-button
 >
                 <el-button class="login-bt2" @click="handle">返回登录</el-button
>
                </el-form>
                
              
              
                   
            </div>
        </div>
        <div class="footer">
           

        </div>
    </div>
</template>

<script>
import axios from "axios";
export default {
  name: "Register",
  data() {
    return {
      // tableData:[],
      formData: {},
     
    }
  },
  methods: {
    //  async getRegisterList(){
    //         let result = await axios.get('http://localhost:3000/user/findRegisterList');
    //         console.log(result);
    //         this.tableData = result.data.data;
    //   },
       
    handle() {
      this.$router.push("/login");
    },
    async submit() {
      // console.log(this.formData)
      let result = await axios.post(
        "http://localhost:3000/user/adduser",this.formData
      );
      this.$message.success("注册成功");
      // this.getRegisterList();
    },
   
  },
  // mounted() {
  //   this.getRegisterList();
  // },
}
</script>

<style scoped>
.header {
  background: #ffffff;
  height: 100px;
  color: #18b958;
  font-size: 40px;
}
span {
  position: absolute;
  height: 50px;
  left: 110px;
  top: 40px;
}
.content {
  background: #65bd55;
  height: 600px;
}
.bg {
  background: url("~@/assets/login.png");
  height: 100%;
  width: 100%;
  /*   
   margin-left: 100px;
   margin-right: 100px; */
}
.login-form {
  width: 350px;
  background: #eeefe9;
  position: absolute;
  right: 150px;
  top: 250px;
  padding: 40px;
  box-sizing: border-box;
  border-radius: 20px;
}
.login-form .title {
  font-weight: bold;
  margin-bottom: 20px;
}
.login-bt1 {
  background: #18b958;
  color: #ffffff;
  height: 40px;
  text-align: center;
  line-height: 20px;
  cursor: pointer;
  width: 100px;
}
.login-bt2 {
  background: #18b958;
  color: #ffffff;
  height: 40px;
  text-align: center;
  line-height: 20px;
  cursor: pointer;
  width: 100px;
  float: right;
}
.suffix {
  width: 40px;
  height: 40px;
  background: #68b958;
  text-align: center;
}
.reg {
  display: inline;
}
.reg1 {
  margin-top: 12px;
  float: left;
  cursor: pointer;
}
.reg2 {
  margin-top: 12px;
  float: right;
}
.reg:hover {
  text-decoration: underline;
}
.title {
  color: #68b958;
  font-size: 20px;
  padding-left: 40px;
}
</style>