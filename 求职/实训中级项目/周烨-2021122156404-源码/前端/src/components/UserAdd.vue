<template>
  <div>
    <el-form :model="form" label-width="60px">
      <!-- 表单项 -->
      <el-form-item label="账号" prop="username">
        <el-input v-model="form.username" prefix-icon="el-icon-user"></el-input>
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
        <el-button type="primary" @click="save">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    save() {
      let url = "/user/save";
      this.axios.post(url, this.form).then((res) => {
        this.$processResult(this, res, (data) => {
          this.$alert("成功");
        });
      });
    },
  },
};
</script>

<style lang="less">
</style>