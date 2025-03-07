<template>
  <el-button type="primary" @click="visible = true">添加出版社</el-button>
  <el-card shadow="never" style="margin-top: 10px;">

    <!-- 查询区域 -->
    <el-card shadow="never" style="margin: 10px 0;">
      <el-form :model="search">
        <el-row :gutter="30">
          <el-col :xs="24" :sm="12" :md="8" :lg="6">
            <el-form-item label="出版社名:">
              <el-input v-model="search.name" placeholder="请输入出版社名:" />
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div style="text-align: right;">
        <el-button type="primary" @click="getList()">查询</el-button>
        <el-button @click="resetSearch()">重置</el-button>
      </div>
    </el-card>

    <!-- 表格区域 -->
    <el-table :data="tableData" stripe>
      <el-table-column prop="id" label="ID" width="70" />
      <el-table-column prop="name" label="姓名" />
      <el-table-column prop="email" label="邮箱" />
      <!-- <el-table-column prop="createdAt" label="创建时间" width="180" />
      <el-table-column prop="updatedAt" label="更新时间" width="180" /> -->

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
    <!-- 分页 -->
    <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange"
      layout="sizes, total, prev, pager, next" :total="totalNum" :currentPage="search.pageNum"
      :pageSize="search.pageSize">
    </el-pagination>
  </el-card>
  <!-- 新增或编辑的抽屉 -->
  <sDrawer v-model="visible" :title="form.id ? '编辑出版社' : '添加出版社'" size="35%" :close-on-click-modal="false">

    <el-form :model="form" label-width="100px" ref="ruleFormRef">
      <el-form-item label="出版社名称:">
        <el-input v-model="form.name" />
      </el-form-item>
    </el-form>
    <el-form :model="form" label-width="100px" ref="ruleFormRef">
      <el-form-item label="出版社邮箱:">
        <el-input v-model="form.email" />
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="saveData()">确定</el-button>
    </template>
  </sDrawer>
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
      form: {
      },
      visible: false,
      tableData: [],
      totalNum: 100,
      search: {
        pageNum: 1,
        pageSize: 10,
        // token: "",
      },
    };
  },
  created() {
    // this.search.token = localStorage.getItem("token");
    this.getList();
  },
  methods: {
    async getList() {
      const res = await this.$request.get(
        "/django_vue_tushu/cbs/",
        { params: this.search }
      );
      
      if (res.data.code === 200) {
        // this.tableData = res.data.data.sort((a, b)      
        console.log(res.data)
        this.tableData = res.data.data;
        this.totalNum = res.data.zs
      }
    },
    // 每页条数改变时触发 选择一页显示多少行
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.search.pageSize = val;
      this.getList();
    },
    // 当前页改变时触发 跳转其他页
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.search.pageNum = val;
      this.getList();
    },
    resetSearch() {
      let search = {
        pageNum: this.search.pageNum,
        pageSize: this.search.pageSize,
      };
      this.search = search;
      this.getList();
    },
    editItem(row) {
      this.form = this.$deepClone(row)
      this.visible = true
    },
    async saveData() {
      if (this.form.id) {
        const res = await this.$request.put('/django_vue_tushu/cbs/' + this.form.id + '/', this.form)
        if (res.data.code === 200) {
        this.$message.success(res.data.message)
        this.getList()
        this.visible = false
      }
      } else {
        const res = await this.$request.post('/django_vue_tushu/cbs/', this.form)
        if (res.data.code === 200) {
        this.$message.success(res.data.message)
        this.getList()
        this.visible = false
      }
      }
      // const res = await this.$request.post(this.form.id ? '/django_vue_tushu/guanli/' : '/django_vue_tushu/guanli/', this.form)
      // if (res.data.code === 200) {
      //   this.$message.success(res.data.message)
      //   this.getList()
      //   this.visible = false
      // }
    },
    async deleteItem(id) {
      const res = await this.$request.delete("/django_vue_tushu/cbs/" + id + '/')
      if (res.data.code === 200) {
        this.$message.success(res.data.message)
        this.getList()
      }
    },



    // 照片文件超出个数限制时的钩子
    handleExceed(files, fileList) {
      this.$notify.warning({
      title: '警告',
      message: `只能选择 ${this.limitNum} 个文件，当前共选择了 ${files.length + fileList.length} 个`
      })
    },
    // 上传照片文件之前的钩子
    handleBeforeUpload(file) {
      const size = file.size / 1024 / 1024
          if (size > 1) {
            this.$notify.warning({
            title: '警告',
            message: '图片大小必须小于1M'
          })
      }
    },
    handleSuccess1(res) {
        console.log(res.data,'777777777777777777777777777777777777777')
        this.form.img_url = res.data.file
        this.dialogImageUrl = ''
        this.$notify({
            title: '通知',
            message: '上传照片成功~',
            type: 'success',
            duration: 5000
      })
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