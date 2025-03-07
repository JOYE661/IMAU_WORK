<template>
  <div id="home">
      <div class="agri">
        农产品销售平台
        <el-input
          placeholder="请输入要搜索商品名称"
          v-model="input"
          clearable
          class="input"
        ></el-input>
        <el-button class="sousuo">搜索</el-button>
      </div>
      
    
    <div class="content">
      <el-carousel height="500px">
        <el-carousel-item v-for="item in colorList" :key="item">
          <img :src="item.img" class="zhutu">
          <!-- <div class="banner-item" :style="{ background: item }"></div> -->
        </el-carousel-item>
      </el-carousel>
      <!-- <div class="Label">
        <div class="label">水果</div>
      </div> -->

      <div class="goods-box">
        <div class="goods-item" v-for="(item, index) in goodsList" :key="index" @click="toDetail(item.id)">
          <img :src="item.img" class="picture"  />
          <div>{{ item.goods_name }}</div>
          <div>￥{{ item.goods_price }}</div>
        </div>
      </div>
    </div>
    
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: "Home",
  data() {
    return {
      input: "",
      colorList: [
        {
          img:require('@/assets/zhutu1.png')
         
        },
        {
           img:require('@/assets/zhutu2.jpg')
        }
      ],
      goodsList: [
      
      ],
    };
  },
  methods:{
    toDetail(id){
      this.$router.push('/goodsDetail?id='+id)
    },
    async getList(){
      let result = await axios.get('http://localhost:3000/goods/findGoodsList');
      this.goodsList = result.data.data;
    },
    async onSubmit() {
        let result = await axios.get('http://localhost:3000/goods/search?search='+ this.input);
        this.tableData= result.data.data;;//更新
      },
  },
  mounted(){
    this.getList();
  }
};
</script>

<style scoped>
.zhutu{
  width: 100%;
  height: 110%;
}
#top {
  width: 100%;
  height: 30px;
  background: #ffffff;
}
.picture{
  width: 1000px;
}
.content {
  width: 100%;
  height: 2000px;
  background: #efe9e9;
 
}
.Label {
  margin-left: 210px;
  margin-top: 50px;
}
.label {
  border-left: 4px solid #18b958 ;
  padding-left: 10px;
}

.input {
  width: 600px;
  margin-left: 50px;
}
.agri {
  color: #18b958;
  font-size: 40px;
  margin-left: 200px;
 
}
.banner-item {
  width: 100%;
  height: 400px;
}
.goods-box {
  display: flex;
  flex-wrap: wrap;
  margin-top: 100px;
  margin-left: 200px;
}

.picture {
  width: 350px;
  height: 350px;
  margin-top: 10px;
  
}

.goods-item {
  margin: 10px;
  background: #ffffff;
  width: 366px;
  height: 410px;
  text-align: center;
}
.sousuo{
  background-color: #18b958;
  color: #ffffff;
}
.yuan {
  width: 60px;
  height: 60px;
  border: 2px solid #f30b0b;
  border-radius: 50%;
  text-align: center;
  line-height: 60px;
  font-size: 28px;
  color: #f30b0b;
  display: inline-block;
  margin: 150px;
}
</style>
