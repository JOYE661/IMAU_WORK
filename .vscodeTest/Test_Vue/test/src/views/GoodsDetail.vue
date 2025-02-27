<template >
    <div class="sum">
    <div class="agri">
        农产品销售平台
        <div class="agri1">十全十美呼市总店</div>
        <el-input
          placeholder="请输入内容"
          v-model="input"
          clearable
          class="input"
        ></el-input>
        <el-button type="danger" plain  id="bt">搜索</el-button>
    </div>
    <img src="@/assets/detail.png" id="ima">
    <div class="intro">
    <img :src="currentDetail.img" id="tudou">
    <div class="right-desc">
          <p class="goods-name">{{currentDetail.goods_name}}</p>
          <p class="new-goods">旗舰新品</p>
          <div class="info-card">
            <div class="origin-price-box">
              <span class="label">原价</span>
              <span class="value">￥{{currentDetail.goods_origin_price}}/{{currentDetail.unit_name}}</span>
            </div>
            <div class="price-box">
              <span class="label">现价</span>
              <span class="value">￥{{currentDetail.goods_price}}/{{currentDetail.unit_name}}</span>
            </div>
          </div>
          <div class="sale-count-box">
            <div class="sale-count-item">
              <span class="label">总销量</span>
              <span class="value">{{currentDetail.sale_num}}</span>
            </div>
            <div class="sale-count-item">
              <span class="label">累计评价</span>
              <span class="value">{{currentDetail.evaluation_num}}</span>
            </div>
            <div class="sale-count-item">
              <span class="label">送积分</span>
              <span class="value green">{{currentDetail.score}}</span>
            </div>
          </div>
          <div class="buy-box">
            <div class="buy-num-box">
              <span class="buy-num">数量：</span>
              <el-input-number v-model="buyCount" controls-position="right" :min="0" :max="10"></el-input-number>
              <span class="unit">{{currentDetail.unit_name}}</span>
              <span class="stock-num" style="margin-left: 20px">库存:{{currentDetail.stock}}</span>
            </div>
            <div class="buy-bts">
              <div class="bt">立即购买</div>
              <div class="red">加入购物车</div>
            </div>
          </div>
        </div>
      </div>
      <div class="goods-params">
        <el-tabs type="border-card" class="tabs">
          <el-tab-pane label="商品详情">
            <div class="param-item">
              <span class="label">产品名称：</span>
              <span class="value">{{currentDetail.goods_name}}</span>
            </div>
            <div class="param-item">
              <span class="label">产品规格（单位）：</span>
              <span class="value">{{currentDetail.unit}}</span>
            </div>
            <div class="goods-img">
              <img :src="currentDetail.img" alt="">
            </div>
          </el-tab-pane>
        </el-tabs>
      </div>
    </div>

   
     
   
</template>
<script>
import axios from 'axios';
export default {
  name: "GoodsDetail",
  data(){
    return{
      searchKey:'',
      currentDetail:{
            name:'',
            originPrice:'',
            price:'',
            salesNum:'',
            evaluationNum:'',
            score:'',
            stock:'',
            unit:''
        // img:require('@/assets/tudou.png')
      },// 当前展示的详情对象
      buyCount:0
    }
  },
  methods:{
    async detailHandle(){
         let result = await axios.get('http://localhost:3000/goods/getGoodsDetail?id='+this.$route.query.id);
         this.currentDetail = result.data.data;
         this.showDetailForm = true;
      },
  },
  mounted(){
      // console.log(this.$route.query.id)
      this.detailHandle();
  }
  
}
</script>
<style scoped> 
#yuanjia{
    color: #878484;
    font-size: 40px;
}
#jiage1{
    text-decoration: line-through;
    font-size: 15px;
}
#jiage2{
    color: #bc1c1c;
    font-size: 20px;
}
.agri {
  color: #f30b0b;
  font-size: 40px;
  margin-left: 200px;
   display: flex;
   margin-top: 10px;
}
.input {
  width: 400px;
  margin-left: 50px;
  margin-top: 20px;
}
.agri1{
    color: black;
    font-size: 15px;
    font-weight: normal;
    margin-left: 100px;
    margin-top: 30px;
}
#bt{
    height: 40px;
    margin-top:20px ;
}
#ima{
    width: 1200px;
    margin-top: 200px;
    margin-left: 10px;
    margin-top: 40px;
    margin-left: 140px;
}
#tudou{
    width: 500px;
    margin-left: 140px;
    margin-top: 40px;
    border: 1px solid rgb(223, 204, 204);
}
.intro{
    display: flex;
}
.td{
    color: black;
    font-size: 20px;
    font-weight: bold;
    margin-top: 50px;
    margin-left: 40px;
}
.qjd{
    color: rgb(255, 0, 0);
    font-size: 20px;
    font-weight:normal;
    margin-top: 10px;
    margin-left: 40px;
}
.beijing{
    
    width: 600px;
    height: 600px;
    background:url('@/assets/bg.png');
    margin-left: 40px;
    margin-top: 20px;
}

.top{
  display: flex;
  width: 1230px;
  height: 140px;
  margin: 0 auto;
  align-items: center;
  justify-content: space-between;
}
#goods-detail .title{
  font-size: 32px;
  font-weight: bold;
  color: #FF0036;
  line-height: 60px;
}
.title-right{
  display: flex;
  align-items: center;
}
.merchant{
  margin-left: 60px;
  display: flex;
}
.merchant-name{
  font-weight: bold;
  line-height: 40px;
  height: 40px;
  border-left: 2px solid #f2f2f2;
  border-right: 2px dashed #f2f2f2;
  padding: 0 10px;
}
.merchant-label{
  font-weight: 100;
  letter-spacing: 4px;
}
.merchant-desc{
  height: 40px;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 0 10px;
  border-right: 2px solid #f2f2f2;
}
.merchant-num{
  color: #FF0036;
  font-weight: bold;
  letter-spacing: 2px;
  font-size: 14px;
}
.search-box{
  margin-left: 10px;
  height: 60px;
}
.search-input{
  display: flex;
}
.search-input input{
  height: 30px;
  width: 400px;
  border: 2px solid #FF0036;
  box-sizing: border-box;
}
.search-all{
  height: 30px;
  background: #FF0036;
  color: #FFFFFF;
  line-height: 30px;
  text-align: center;
  padding: 0 10px;
  cursor: pointer;
}
.search-now{
  height: 30px;
  background: #333333;
  color: #FFFFFF;
  line-height: 30px;
  text-align: center;
  padding: 0 10px;
  margin-left: 2px;
  cursor: pointer;
}
.search-fast{
  height: 30px;
  color: #a2a2a2;
  line-height: 30px;
  cursor: pointer;
}

.split-img{
  width: 1230px;
  margin: 0 auto;
}
.split-img img{
  width: 100%;
}
.content{
  width: 1230px;
  margin: 0 auto;
}
.goods-detail{
  display: flex;
  margin-top: 20px;
  justify-content: space-between;
  padding: 0 40px;
}
.left-img{
  width: 400px;
  height: 400px;
  border: 1px solid #f2f2f2;
  box-sizing: border-box;
}
.left-img img{
  width: 100%;
  height: 100%;
}
.right-desc{
  flex: 1;
  border-right: 1px solid #f2f2f2;
  padding-right: 120px;
  padding-left: 30px;
  box-sizing: border-box;
}
.goods-name{
  font-size: 18px;
  font-weight: bold;
  margin-top: 0;
  margin-bottom: 0;

}
.new-goods{
  color: #FF0036;
  margin-top: 10px;
}
.info-card{
  background: url("~@/assets/beijing.png");
  padding: 0 10px;
}
.origin-price-box{
  height: 60px;
  line-height: 60px;
}
.origin-price-box .label{
  font-size: 18px;
  color: #a4a4a4;
}
.origin-price-box .value{
  text-decoration:line-through;
  margin-left: 20px;
}
.price-box{
  height: 60px;
  line-height: 60px;
}
.price-box .label{
  font-size: 18px;
  color: #a4a4a4;
}
.price-box .value{
  margin-left: 20px;
  color: #FF0036;
  font-size: 24px;
  font-weight: bold;
}

.sale-count-box{
  display: flex;
  margin-top: 20px;
  width: 100%;
  justify-content: space-between;
  padding: 10px 20px;
  box-sizing: border-box;
  border-top: 2px dashed #f2f2f2;
  border-bottom: 2px dashed #f2f2f2;
}
.sale-count-item{
  flex: 1;
  text-align: center;
  border-left: 2px dashed #f2f2f2;
}
.sale-count-item .label{
  color: #a4a4a4;
}
.sale-count-item .value{
  font-size: 14px;
  color: #FF0036;
  margin-left: 10px;
}
.sale-count-item .green{
  color: #42b983;
}
.buy-box{
  margin-top: 20px;
  box-sizing: border-box;
}
.buy-box span{
  color: #a4a4a4;
}

.buy-bts{
  width: 80%;
  margin-top: 20px;
  display: flex;
  justify-content: space-between;
  padding: 0 70px;
  box-sizing: border-box;
}

.buy-bts .bt{
  flex: 1;
  border: 1px solid #FF0036;
  color: #FF0036;
  height: 40px;
  line-height: 40px;
  font-size: 18px;
  text-align: center;
  box-sizing: border-box;
  cursor: pointer;
}
.buy-bts .red{
  flex: 1;
  height: 40px;
  line-height: 40px;
  font-size: 18px;
  text-align: center;
  background: #FF0036;
  color: #FFFFFF;
  margin-left: 10px;
  cursor: pointer;
}
.goods-params{
  width: 1230px;
  padding: 0 40px;
  box-sizing: border-box;
  margin-top: 20px;
  margin-bottom: 40px;
  margin-left: 100px;
}
.goods-params /deep/.el-tabs--border-card>.el-tabs__header .el-tabs__item:not(.is-disabled):hover{
  color: #FF0036;
}
.goods-params /deep/.el-tabs--border-card>.el-tabs__header .el-tabs__item.is-active{
  color: #FF0036;
}
</style>