<template>
  <div class="login-container" >
      <el-card class="box-card">
          <div class="login-body">
              <div class="login-title" @click="toIndex" >django vue图书管理系统</div>
              <el-form ref="form" :model="userForm">
                  <el-input placeholder="请输入账号..." v-model="userForm.accountNumber" class="login-input">

                  </el-input>
                  <el-input placeholder="请输入密码..." v-model="userForm.userPassword" class="login-input"
                            @keyup.enter.native="login"  show-password>

                  </el-input>

                  <el-select v-model="userForm.value" clearable placeholder="请选择">
                      <el-option
                      v-for="item in options"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                      </el-option>
                  </el-select>

                  <div class="login-submit" >
                      <el-button type="primary" @click="login">登录</el-button>
                      <el-button type="warning" autocomplete="off" @click="$router.push('/sign-in')" style="margin-left: 20px">注册</el-button>
                  </div>
                  <!-- <div class="other-submit">
                      <router-link to="/login-admin" class="sign-in-text">管理员登录</router-link>
                  </div> -->
              </el-form>
          </div>
      </el-card>
  </div>
</template>

<script>
  export default {
      name: "login",
      data() {
          return {
              userForm: {
                  accountNumber: 'admin',
                  userPassword: 'admin',

              },
              options: [
              {
                  value: '1',
                  label: '管理员'
                  },  ],
          };
      },

      methods: {
          login() {
            this.$request.post("/django_vue_tushu/logintest/",{
                  username: this.userForm.accountNumber,
                  password: this.userForm.userPassword,
                  value: this.userForm.value
              }).then(res => {
                  console.log(res);
                  if (res.data.meta.status===200) {
                      localStorage.setItem("userInfo", res.data.data.username);
                      localStorage.setItem("userInfoid", res.data.data.user_id);
                      localStorage.setItem("img_url_touxiang", res.data.data.img_url);
                      localStorage.setItem("isAdmin", res.data.data.isAdmin);
                      localStorage.setItem("token", res.data.data.token);
                      this.$message.success("登陆成功")
                      if (res.data.data.isAdmin == 1) 
                      { this.$router.replace({path: '/media/list'}); }
                      else { this.$router.push('/media/list') }
                  } else {
                      this.$message.error(res.meta.message);
                  }
              });
          },
          toIndex() {
              this.$router.replace({path: '/index'});
          }
      }
  }
</script>

<style scoped>
  .login-container {
    background-image: url('C:\Users\97687\Desktop\【带小白做前后端分离】从0带你做基于django+vue图书管理系统，前后端分离，适合小白\django_vue_tushu_front\src\assets\bj.jpg');
    background-size: cover; /* 背景图片覆盖整个元素 */
    background-position: center; /* 背景图片居中 */
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      width: 100%;

  }

  .login-body {
      padding: 30px;
      width: 300px;
      height: 100%;
  }

  .login-title {
      padding-bottom: 30px;
      text-align: center;
      font-weight: 600;
      font-size: 20px;
      color: #409EFF;
      cursor: pointer;
  }

  .login-input {
      margin-bottom: 20px;
  }

  .login-submit {
      margin-top: 20px;
      display: flex;
      justify-content: center;
  }

  .sign-in-container {
      padding: 0 10px;
  }

  .sign-in-text {
      color: #409EFF;
      font-size: 16px;
      text-decoration: none;
      line-height:28px;
  }
  .other-submit{
      display:flex;
      justify-content: space-between;
      margin-top: 30px;
      margin-left: 200px;
  }
</style>