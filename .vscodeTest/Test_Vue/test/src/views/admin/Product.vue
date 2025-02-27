<template>
  <div id="product">
   
   
<el-form :inline="true" :model="formInline" class="demo-form-inline">
  <el-form-item label="请输入商品名称">
    <el-input v-model="formInline.user" placeholder="关键字"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">查询</el-button>
    <el-button type="primary" @click="handleAddBt">新增商品</el-button>
    <el-button type="danger" @click="deleteAll">批量删除</el-button>
  </el-form-item>
</el-form>

    <el-table
    :data="tableData"
    border
    stripe
    style="width: 100%" @select="selectHandle">\
    <el-table-column type="selection" width="55">
    </el-table-column>
    <el-table-column
      prop="goods_name"
      label="商品名称">
    </el-table-column>
    <el-table-column
      prop="goods_price"
      label="价格">
    </el-table-column>
    <el-table-column
      prop="sale_num"
      label="销量">
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
    title="新增商品"
    :visible.sync="showAddForm"
    width="30%">
    <el-form :model="formData">
      <el-form-item label="商品名称" prop="goods_name">
        <el-input v-model="formData.goods_name" placeholder="请输入商品名称"></el-input>
      </el-form-item>
      <el-form-item label="商品价格" prop="goods_price">
        <el-input-number v-model="formData.goods_price" :precision="2" :step="0.1" :min="0"></el-input-number>
      </el-form-item>
      <el-form-item label="商品原价" prop="goods_origin_price">
        <el-input-number v-model="formData.goods_origin_price" :precision="2" :step="0.1" :min="0"></el-input-number>
      </el-form-item>
      <el-form-item label="商品销量" prop="sale_num">
        <el-input-number v-model="formData.sale_num" :min="0"></el-input-number>
      </el-form-item>
      <el-form-item label="商品评价数量" prop="evaluation_num">
        <el-input-number v-model="formData.evaluation_num" :min="0"></el-input-number>
      </el-form-item>
      <el-form-item label="商品单位" prop="unit_name">
        <el-input v-model="formData.unit_name" placeholder="请输入商品单位"></el-input>
      </el-form-item>
      <el-form-item label="商品库存" prop="stock_num">
        <el-input-number v-model="formData.stock_num" :min="0"></el-input-number>
      </el-form-item>
      <el-form-item label="商品类型" prop="goods_type">
        <el-select v-model="formData.goods_type" placeholder="请选择商品类型">
          <el-option
            v-for="item in typeList"
            :key="item.id"
            :label="item.type_label"
            :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
    </el-form>
    <el-button type="primary" @click="submit">保存/提交</el-button>
  </el-dialog>

  <el-dialog title="分类详情" :visible.sync="showDetailForm" width="30%">
    <el-descriptions>
        <el-descriptions-item label="商品名称">{{ currentDetail.goods_name }}</el-descriptions-item>
        <el-descriptions-item label="商品价格">{{ currentDetail.goods_price }}</el-descriptions-item>
        <el-descriptions-item label="商品原价">{{ currentDetail.goods_origin_price }}</el-descriptions-item>
        <el-descriptions-item label="商品销量">{{ currentDetail.sale_num }}</el-descriptions-item>
        <el-descriptions-item label="商品评价数量">{{ currentDetail.evaluation_num }}</el-descriptions-item>
        <el-descriptions-item label="商品单位">{{ currentDetail.unit_name }}</el-descriptions-item>
        <el-descriptions-item label="商品库存">{{ currentDetail.stock_num }}</el-descriptions-item>
        <el-descriptions-item label="商品类型">{{ currentDetail.goods_type_name }}</el-descriptions-item>
    </el-descriptions>
</el-dialog>

<el-dialog
    title="修改商品"
    :visible.sync="showUpdateForm"
    width="30%">
    <el-form :model="formData">
      <el-form-item label="商品名称" prop="goods_name">
        <el-input v-model="formData.goods_name" placeholder="请输入商品名称"></el-input>
      </el-form-item>
      <el-form-item label="商品价格" prop="goods_price">
        <el-input-number v-model="formData.goods_price" :precision="2" :step="0.1" :min="0"></el-input-number>
      </el-form-item>
      <el-form-item label="商品原价" prop="goods_origin_price">
        <el-input-number v-model="formData.goods_origin_price" :precision="2" :step="0.1" :min="0"></el-input-number>
      </el-form-item>
      <el-form-item label="商品销量" prop="sale_num">
        <el-input-number v-model="formData.sale_num" :min="0"></el-input-number>
      </el-form-item>
      <el-form-item label="商品评价数量" prop="evaluation_num">
        <el-input-number v-model="formData.evaluation_num" :min="0"></el-input-number>
      </el-form-item>
      <el-form-item label="商品单位" prop="unit_name">
        <el-input v-model="formData.unit_name" placeholder="请输入商品单位"></el-input>
      </el-form-item>
      <el-form-item label="商品库存" prop="stock_num">
        <el-input-number v-model="formData.stock_num" :min="0"></el-input-number>
      </el-form-item>
      <el-form-item label="商品类型" prop="goods_type">
        <el-select v-model="formData.goods_type" placeholder="请选择商品类型">
          <el-option
            v-for="item in typeList"
            :key="item.id"
            :label="item.type_label"
            :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
    </el-form>
    <el-button type="primary" @click="submitUpdate">保存/提交</el-button>
  </el-dialog>
  </div>
</template>

<script>
// 引入axios
import axios from 'axios';
export default {
    name:'Product',
    data(){
      return{
        showAddForm:false,
        showDetailForm:false,
        showUpdateForm:false,
        formData:{},
        tableData:[],
        typeList:[],
        currentDetail:{},// 当前展示的详情对象
        formInline: {
          user: ''
        },
        ids:[],//存储选中的id
      }
    },
    methods:{
      //批量删除
      deleteAll(){
        console.log('批量删除---ids---',this.ids);
      //要求传递的id必须是字符串，将数组转化为字符串
      this.$confirm('此操作将永久删除该文件，是否继续？','提示',{
        confirmButtonText:'确定',
        cancelButtonText:'取消',
        type:'warning',
      }).then(async()=>{
         let result = await axios.post('http://localhost:3000/goods/batchDelete',{ids:this.ids});
            console.log(result);
            if(result.data.code==0){
               this.getGoodsList();
            }
      }).catch((e)=>{
        console.log(e)
      });
      
      },
      //点击勾选选择框----选中id----
      selectHandle(selection){
        console.log('selection---',selection);
        let arr=[]
        selection.forEach(ele=>{
          arr.push(ele.id)
        });
        this.ids=arr;
      },

      handleAddBt(){
        this.showAddForm = true;
      },
      async getTypeList(){
            let result = await axios.get('http://localhost:3000/type/findTypeList');
            console.log(result);
            this.typeList = result.data.data;
      },
      async getGoodsList(){
        let result = await axios.get('http://localhost:3000/goods/findGoodsList');
        console.log(result);
        this.tableData = result.data.data;
      },
      async submit(){
        // console.log(this.formData)
        let result = await axios.post('http://localhost:3000/goods/addGoods',this.formData);
        this.$message.success(result.data.msg)
        this.showAddForm = false;
        this.getGoodsList();
      },
      async deleteHandle(row){
          let result = await axios.get('http://localhost:3000/goods/deleteGoods?id='+row.id);
          this.$message.warning(result.data.msg)
          this.getGoodsList();
      },
      async detailHandle(row){
         let result = await axios.get('http://localhost:3000/goods/getGoodsDetail?id='+row.id);
         this.currentDetail = result.data.data;
         this.showDetailForm = true;
      },
      updateHandle(row){
          this.showUpdateForm = true;
          this.formData = Object.assign({},row);
      },
      async submitUpdate(){
        let result = await axios.post('http://localhost:3000/goods/updateGoods',this.formData);
        this.$message.success("修改成功")
        this.showUpdateForm = false;
        this.getGoodsList();
      },
      
      async onSubmit() {
        let result = await axios.get('http://localhost:3000/goods/search?search='+ this.formInline.user);
        this.tableData= result.data.data;;//更新
      },
      

    },
    mounted(){
      this.getTypeList();
      this.getGoodsList();
    }

}
</script>

<style scoped>
#product{
    width: 100%;
}
</style>