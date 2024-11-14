<template>
  <div>
    <el-table v-bind:data="tableData" style="width: 100%">
      <el-table-column prop="id" label="ID" width="180"> </el-table-column>
      <el-table-column prop="username" label="username" width="180">
      </el-table-column>
      <el-table-column prop="password" label="password"> </el-table-column>
      <el-table-column label="操作" width="150px">
        <template slot-scope="scope">
          <el-tooltip effect="dark" content="编辑" placement="top">
            <el-button
              type="primary"
              icon="el-icon-edit"
              size="mini"
              @click="editUser(scope.row)"
            ></el-button>
          </el-tooltip>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      layout="total, prev, pager, next"
      @current-change="handleCurrentChange"
      :current-page.sync="page.pageNum"
      :page-size="page.pageSize"
      :total="total"
    >
    </el-pagination>
    <!-- 编辑对话框 -->
    <el-dialog
      title="编辑用户"
      :visible.sync="editDialogVisible"
      width="40%"
      @close="editDialogClosed"
    >
      <el-form :model="editForm" label-width="70px">
        <el-input type="hidden" v-model="editForm.id"></el-input>
        <el-form-item label="用户名" prop="username">
          <el-input v-model="editForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="editForm.password"></el-input>
        </el-form-item>
      </el-form>
      <!-- 底部区域 -->
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="updateUser">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [],
      page: {
        pageNum: 1,
        pageSize: 3,
      },
      total: 0,
      editDialogVisible: false,
      editForm: {
        id: "",
        username: "",
        password: "",
      },
    };
  },
  methods: {
    findPage() {
      let url = "/user/page";
      this.axios.post(url, this.page).then((res) => {
        this.$processResult(this, res, (data) => {
          this.total = data.total;
          this.tableData = data.list;
        });
      });
    },

    handleCurrentChange(val) {
      this.page.pageNum = val;
      this.findPage();
    },

    editDialogClosed() {
      this.editDialogVisible = false;
    },

    editUser(row) {
      this.editForm = row;
      this.editDialogVisible = true;
    },

    updateUser() {
      let url = "/user/update";
      this.axios.post(url, this.editForm).then((res) => {
        this.$processResult(this, res, (data) => {
          this.editDialogVisible = false;
          this.$alert("成功");
        });
      });
    },
  },
  created() {
    this.findPage();
  },
};
</script>

<style lang="less">
</style>