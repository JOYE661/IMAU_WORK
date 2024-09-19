<template>
  <div class="login_container">
    <div class="login_box">
      <h1>用户登录</h1>
      <!-- 表单 -->
      <el-form :model="form" label-width="60px">
        <!-- 表单项 -->
        <el-form-item label="账号" prop="username">
          <el-input
            v-model="form.username"
            prefix-icon="el-icon-user"
          ></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input
            type="password"
            v-model="form.password"
            prefix-icon="el-icon-lock"
          ></el-input>
        </el-form-item>
        <!-- 按钮 -->
        <el-form-item class="btns">
          <el-button type="primary" @click="login">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        username: "aaa",
        password: "111",
      },
    };
  },
  methods: {
    login() {
      let url = "/login";
      this.axios.post(url, this.form).then((res) => {
        this.$processResult(this, res, (data) => {
          // 将登录成功之后的 token，保存到客户端的 sessionStorage 中
          window.sessionStorage.setItem("token", data.token);
          this.$router.push("/home");
        });
      });
    },
  },
};
</script>

<style lang="less" scoped>
.login_container {
  background-color: #2b5b6b;
  height: 100%;
  .login_box {
    width: 450px;
    height: 300px;
    background: #fff;
    border-radius: 3px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    h1 {
      text-align: center;
    }
    .el-form {
      padding: 0 20px;
    }
    .btns {
      text-align: right;
    }
  }
}
</style>
