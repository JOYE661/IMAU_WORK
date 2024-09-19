<template>
  <div>
    <el-form :model="form" label-width="80px">
      <el-form-item label="公司名称">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="公司地址">
        <el-input v-model="form.address"></el-input>
      </el-form-item>
      <el-form-item label="联系人">
        <el-input v-model="form.linkman"></el-input>
      </el-form-item>
      <el-form-item label="联系电话">
        <el-input v-model="form.phone"></el-input>
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
        name: "",
        address: "",
        linkman: "",
        phone: "",
      },
    };
  },
  methods: {
    save() {
      let url = "/company/save";
      this.axios.post(url, this.form).then((res) => {
        this.$processResult(this, res, (data) => {
          this.$alert("成功");
        });
      });
    },
  },
};
</script>

<style lang="less" scoped>
</style>
