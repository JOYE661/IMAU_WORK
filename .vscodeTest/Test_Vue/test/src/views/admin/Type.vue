<template>
  <div id="type">
    <el-button type="primary" @click="clkAdd">新增分类</el-button>
    <el-table
        :data="tableData"
        border
        stripe
        style="width: 100%"  @select="selectHandle">
        <!-- select 当用户手动勾选数据行的Checkbox时触发的事件 两个参数 selection,row -->
        <el-table-column
          prop="id"
          label="ID">
        </el-table-column>
        <el-table-column
          prop="type_label"
          label="分类名">
        </el-table-column>
        <el-table-column
          label="操作">
          <template slot-scope="scope">
            <el-button type="primary" @click="detailHandle(scope.row)">详情</el-button>
            <el-button type="warning" @click="updateHandle(scope.row)">修改</el-button>
            <el-button type="danger" @click="deleteHandle(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-dialog
        title="新增类型"
        :visible.sync="showAddForm"
        width="30%">
        <el-form :model="formData">
          <el-form-item label="类型名称" prop="type_label">
            <el-input v-model="formData.type_label" placeholder="请输入类型名称"></el-input>
          </el-form-item>
        </el-form>
        <el-button type="primary" @click="submit">保存/提交</el-button>
    </el-dialog>
    <el-dialog title="分类详情" :visible.sync="showDetailForm" width="30%">
        <el-descriptions>
            <el-descriptions-item label="id">{{ currentDetail.id }}</el-descriptions-item>
            <el-descriptions-item label="分类名称">{{ currentDetail.type_label }}</el-descriptions-item>
        </el-descriptions>
    </el-dialog>
    <el-dialog title="修改类型" :visible.sync="showUpdateForm" width="30%">
        <el-form :model="formData">
            <el-form-item label="类型名称" prop="type_label">
              <el-input v-model="formData.type_label" placeholder="请输入类型名称"></el-input>
            </el-form-item>
          </el-form>
          <el-button type="primary" @click="update">保存/提交</el-button>
    </el-dialog>
    
    <el-dialog
        title="删除提示"
        :visible.sync="showDeleteForm"
        width="30%">
        <el-form :model="formData">
          <el-form-item label="确定删除该条分类信息？">
          </el-form-item>
        </el-form>
        <el-button type="info" @click="submitcancel">取消</el-button>
        <el-button type="danger" @click="submitdelete">删除</el-button>
    </el-dialog>


  </div>
</template>

<script>
// 引入axios
import axios from 'axios';
export default {
    name:'Type',
    data(){
        return{
            tableData:[],
            showAddForm:false,
            showDeleteForm:false,
            showDetailForm:false,
            showUpdateForm:false,
            formData:{},
            // 当前详情对象
            currentDetail:{}
        }
    },
    methods:{
      //点击勾选选择框
      selectHandle(selection){
        console.log('selection---',selection);
      },
        async getTypeList(){
            let result = await axios.get('http://localhost:3000/type/findTypeList');
            console.log(result);
            this.tableData = result.data.data;
        },
        clkAdd(){
            this.showAddForm = true;
        },
        async submit(){
            let result = await axios.post('http://localhost:3000/type/addType',this.formData);
            this.$message.success(result.data.msg)
            this.showAddForm = false;
            this.getTypeList();
        },
        
        detailHandle(row){
            // console.log(row);
            this.showDetailForm = true;
            // 对象拷贝
            // this.currentDetail = row;
            this.currentDetail = Object.assign({},row);
        },
        
        async deleteHandle(row){
            this.showDeleteForm=true;
            let result = await axios.get('http://localhost:3000/type/deleteType?id='+row.id);
            this.$message.warning(result.data.msg)
            this.getTypeList();
        },
        updateHandle(row){
            this.showUpdateForm = true;
            // this.formData = row;
            this.formData = Object.assign({},row);
        },
        
        async update(){
            let result = await axios.post('http://localhost:3000/type/updateType',this.formData);
            this.$message.success("修改成功")
            this.showUpdateForm = false;
            this.getTypeList();
        }
    },
    mounted(){
        this.getTypeList();
    }
}
</script>

<style>

</style>