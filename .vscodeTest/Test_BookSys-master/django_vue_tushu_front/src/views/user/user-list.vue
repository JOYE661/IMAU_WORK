<template>
  <div v-if="this.search.isAdmin == 1">
  <el-button type="primary" @click="visible = true">添加用户</el-button>
</div>
  <div v-if="this.search.isAdmin == 1">
  <el-card shadow="never" style="margin-top: 10px;">
    <!-- 表格区域 -->
    <el-table :data="tableData" stripe>
      <el-table-column prop="id" label="ID" width="70" />
      <!-- <el-table-column prop="nickName" label="昵称" /> -->
      <el-table-column prop="username" label="姓名" />
      <!-- <el-table-column prop="email" label="邮箱" /> -->
      <el-table-column label="操作" width="120" fixed="right">
        <template #default="scope">
          <el-button link type="primary" size="small" @click="editItem(scope.row)">编辑</el-button>
          <el-popconfirm title="确定要删除吗?" @confirm="deleteItem(scope.row.id)">
            <template #reference>
              <el-button link type="primary" size="small">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
  </el-card>
</div>

<div v-if="this.search.isAdmin == 2">
  <el-card shadow="never" style="margin-top: 10px;">
    <!-- 表格区域 -->
    <el-table :data="tableData" stripe>
      <el-table-column prop="id" label="ID" width="70" />
      <el-table-column prop="name" label="姓名" />
      <el-table-column prop="password" label="密码" />
      <el-table-column prop="college_cs" label="学院" />
      <!-- <el-table-column prop="position" label="职称" /> -->
      <el-table-column label="操作" width="120" fixed="right">
        <template #default="scope">
          <el-button link type="primary" size="small" @click="editItem(scope.row)">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-card>
</div>

<div v-if="this.search.isAdmin == 3">
  <el-card shadow="never" style="margin-top: 10px;">
    <!-- 表格区域 -->
    <el-table :data="tableData" stripe>
      <el-table-column prop="id" label="ID" width="70" />
      <el-table-column prop="name" label="姓名" />
      <el-table-column prop="password" label="密码" />
      <el-table-column prop="college_gm" label="学院" />
      <!-- <el-table-column prop="college.college_name" label="职称" /> -->
      <el-table-column label="操作" width="120" fixed="right">
        <template #default="scope">
          <el-button link type="primary" size="small" @click="editItem(scope.row)">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-card>
</div>

  <!-- 新增或编辑的抽屉 -->
  <div v-if="this.search.isAdmin == 1">
  <sDrawer v-model="visible" :title="form.id ? '修改信息' : '添加用户'" size="35%" :close-on-click-modal="false">
    <el-form :model="form" label-width="50px" ref="ruleFormRef">
      <el-form-item label="密码:">
        <el-input v-model="form.password" />
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="saveData()">确定</el-button>
    </template>
  </sDrawer>
</div>

<div v-if="this.search.isAdmin == 2">
  <sDrawer v-model="visible" :title="form.id ? '修改信息' : '添加学院'" size="35%" :close-on-click-modal="false">
    <el-form :model="form" label-width="80px" ref="ruleFormRef">
      <el-form-item label="密码:">
        <el-input v-model="form.password" />
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="saveData()">确定</el-button>
    </template>
  </sDrawer>
</div>

<div v-if="this.search.isAdmin == 3">
  <sDrawer v-model="visible" :title="form.id ? '修改信息' : '添加学院'" size="35%" :close-on-click-modal="false">
    <el-form :model="form" label-width="80px" ref="ruleFormRef">
      <el-form-item label="密码:">
        <el-input v-model="form.password" />
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="saveData()">确定</el-button>
    </template>
  </sDrawer>
</div>

</template>

<script>
import sDrawer from "@/components/s-drawer/s-drawer.vue"
export default {
  components: {
    sDrawer,
  },
  watch: {
    visible(value) {
      if (!value) {
        this.form = {}
      }
    }
  },
  data() {
    return {
      form: {},
      visible: false,
      tableData: [],
      search: {
        // pageNum: 1,
        // pageSize: 10,
        isAdmin:0,
        nickName: ""
      },
    };
  },
  created() {
    this.search.isAdmin = localStorage.getItem("isAdmin");
    this.search.nickName = localStorage.getItem("userInfo");
    this.getList();
  },
  methods: {
    async getList() {
      const res = await this.$request.get(
        "/django_vue_tushu/guanli/",
        { params: this.search }
      );
      
      if (res.data.code === 200) {
        this.tableData = res.data.data;
        console.log(res.data.data)
      }
    },
    editItem(row) {
      this.form = this.$deepClone(row)
      this.visible = true
    },
    async saveData() {
      if (this.form.id) {
        const res = await this.$request.put('/django_vue_tushu/guanli/' + this.form.id + '/', this.form)
        if (res.data.code === 200) {
        this.$message.success(res.data.message)
        this.getList()
        this.visible = false
      }
      } else {
        const res = await this.$request.post(this.form.id ? '/django_vue_tushu/guanli/' : '/jc/guanli/', this.form)
        if (res.data.code === 200) {
        this.$message.success(res.data.message)
        this.getList()
        this.visible = false
      }
      }
      // const res = await this.$request.post(this.form.id ? '/jc/guanli/' : '/jc/guanli/', this.form)
      // if (res.data.code === 200) {
      //   this.$message.success(res.data.message)
      //   this.getList()
      //   this.visible = false
      // }
    },
    async deleteItem(id) {
      const res = await this.$request.delete("/django_vue_tushu/guanli/" + id + '/')
      if (res.data.code === 200) {
        this.$message.success(res.data.message)
        this.getList()
      }
    },
  },
};

</script>

<style scoped>
.el-pagination {
  margin-top: 10px;
}

.el-row {
  margin-bottom: 20px;
}

.el-row:last-child {
  margin-bottom: 0px;
}
</style>