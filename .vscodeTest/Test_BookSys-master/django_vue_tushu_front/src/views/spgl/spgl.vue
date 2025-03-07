<template>
  <div v-if="isAdmin != 3">
  <el-button type="primary" @click="visible = true">添加图书</el-button>
</div>
  <el-card shadow="never" style="margin-top: 10px;">

    <!-- 查询区域 -->
    <el-card shadow="never" style="margin: 10px 0;">
      <el-form :model="search">
        <el-row :gutter="30">
          <el-col :xs="24" :sm="12" :md="8" :lg="6">
            <el-form-item label="图书名:">
              <el-input v-model="search.title" placeholder="请输入图书名" />
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
      <el-table-column prop="title" label="书籍名称" />
      <el-table-column label="图书图片">
        <template #default="scope">
        <img :src="'http://127.0.0.1:8000/upimg/' + scope.row.img_url" width="100" height="100">
        <!-- <img :src="scope.row.img_url" width="50" height="50"> -->
        </template>
      </el-table-column>
      <el-table-column prop="price" label="价格" />
      <el-table-column prop="bread" label="阅读量" />
      <el-table-column prop="bcomment" label="评论量" />
      <el-table-column prop="publish.name" label="出版社" />
      <el-table-column prop="authors.0.name" label="作者" />
      <el-table-column label="操作" width="120" fixed="right">
        <template #default="scope">
          <div v-if="isAdmin == 1">
          <el-button link type="primary" size="small" @click="editItem(scope.row)">编辑</el-button>
          <el-popconfirm title="确定要删除吗?" @confirm="deleteItem(scope.row.id)">
            <template #reference>
              <el-button link type="primary" size="small">删除</el-button>
            </template>
          </el-popconfirm>
        </div>
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
  <sDrawer v-model="visible" :title="form.id ? '编辑学院' : '添加学院'" size="35%" :close-on-click-modal="false">
    <el-form :model="form" label-width="80px" ref="ruleFormRef">
      <el-form-item label="图书标题:">
        <el-input v-model="form.title" />
      </el-form-item>
    </el-form>
    <!-- <el-form :model="form" label-width="80px" ref="ruleFormRef">
      <el-form-item label="图书图片:">
        <el-input v-model="form.img_url" />
      </el-form-item>
    </el-form> -->

    <el-form :model="form" label-width="80px" ref="ruleFormRef">
    <el-form-item label="图书图片:">
        <div v-if="form.id">
          <el-upload
            class="upload-demo"
            action="http://127.0.0.1:8000/img_upload/"
            :data={data:form.id}
            :on-preview="handlePreview"
            :on-remove="handleRemove"
            :before-remove="beforeRemove"
            :on-success="handleSuccess1"
            multiple
            :limit="1"
            :on-exceed="handleExceed"> 
            <el-button type="primary" size="mini" icon="el-icon-upload">
                修改图片
            </el-button>
          </el-upload>
    </div>

    <div v-else>
            <el-upload
            class="upload-demo"
            action="http://127.0.0.1:8000/img_upload/"
            :on-preview="handlePreview"
            :on-remove="handleRemove"
            :before-remove="beforeRemove"
            :on-success="handleSuccess1"
            multiple
            :limit="1"
            :on-exceed="handleExceed"> 
            <el-button type="primary" size="mini" icon="el-icon-upload">
                上传图片
            </el-button>
          </el-upload>
        </div>

    </el-form-item>
  </el-form>

    <el-form :model="form" label-width="80px" ref="ruleFormRef">
      <el-form-item label="图书价格:">
        <el-input v-model="form.price" />
      </el-form-item>
    </el-form>
    <el-form :model="form" label-width="80px" ref="ruleFormRef">
      <el-form-item label="图书阅读:">
        <el-input v-model="form.bread" />
      </el-form-item>
    </el-form>
    <el-form :model="form" label-width="80px" ref="ruleFormRef">
      <el-form-item label="图书评论:">
        <el-input v-model="form.bcomment" />
      </el-form-item>
    </el-form>

    <!-- <el-form :model="form" label-width="80px" ref="ruleFormRef">
      <el-form-item label="上架状态:">
        <el-input v-model="form.zhuangtai" />
      </el-form-item>
    </el-form>

    <el-form :model="form" label-width="80px" ref="ruleFormRef">
      <el-form-item label="开放状态:">
        <el-input v-model="form.is_kaifang" />
      </el-form-item>
    </el-form>

    <el-form :model="form" label-width="80px" ref="ruleFormRef">
      <el-form-item label="审核状态:">
        <el-input v-model="form.is_shenhe" />
      </el-form-item>
    </el-form> -->

    <el-form :model="form" label-width="80px" ref="ruleFormRef">
      <el-form-item label="出版社:">
        <el-select v-model="form.publish_id" clearable placeholder="请选择">
                <el-option
                  v-for="item in cbsdata"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
                </el-option>
    </el-select>
      </el-form-item>
    </el-form>

    <!-- <el-form :model="form" label-width="80px" ref="ruleFormRef">
      <el-form-item label="作者:">
        <el-select v-model="form.authors_id" clearable placeholder="请选择">
                <el-option
                  v-for="item in zzdata"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id">
                </el-option>
    </el-select>
      </el-form-item>
    </el-form> -->

    <el-form :model="form" label-width="80px" ref="ruleFormRef">
      <el-form-item label="作者:">
      <el-select v-model="form.authors_id" multiple placeholder="请选择">
        <el-option
          v-for="item in zzdata"
          :key="item.id"
          :label="item.name"
          :value="item.id">
        </el-option>
  </el-select>
  </el-form-item>
    </el-form>



    <!-- <el-select v-model="form.xy_id" clearable placeholder="请选择">
                <el-option
                  v-for="item in xydata"
                  :key="item.id"
                  :label="item.college_name"
                  :value="item.id">
                </el-option>
    </el-select> -->

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
        // id: '',
      },

      xydata: [],
      value1: [],
        value2: [],

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
    this.getcbs();
    this.getzz();
    this.isAdmin = localStorage.getItem("isAdmin");
    this.mj_id = localStorage.getItem("userInfoid");
    if (this.isAdmin==2){
      this.form.maijia_id = this.mj_id
    }
  },
  methods: {
    async getList() {
      const res = await this.$request.get(
        "/django_vue_tushu/ts/",
        { params: this.search }
      );
      
      if (res.data.code === 200) {
        // this.tableData = res.data.data.sort((a, b)      
        console.log(res.data)
        this.tableData = res.data.data;
        this.totalNum = res.data.zs
      }
    },

    // 老板接口
    async getcbs() {
      const res = await this.$request.get(
        "/django_vue_tushu/cbs/",
        { params: this.search }
      );
      
      if (res.data.code === 200) {
        // this.tableData = res.data.data.sort((a, b)      
        console.log(res.data)
        this.cbsdata = res.data.data;
      }
    },

    // 分类接口
    async getzz() {
      const res = await this.$request.get(
        "/django_vue_tushu/zz/",
        { params: this.search }
      );
      
      if (res.data.code === 200) {
        // this.tableData = res.data.data.sort((a, b)      
        console.log(res.data)
        this.zzdata = res.data.data;
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
        const res = await this.$request.put('/django_vue_tushu/ts/' + this.form.id + '/', this.form)
        if (res.data.code === 200) {
        this.$message.success(res.data.message)
        this.getList()
        this.visible = false
      }
      } else {
        const res = await this.$request.post('/django_vue_tushu/ts/', this.form)
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
      const res = await this.$request.delete("/django_vue_tushu/ts/" + id + '/')
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