<template >
     <div id="bottom">
    <div class="top" v-if="showProm">
      <div class="promise">
        <div class="pro-item" v-for="(item,index) in promiseList" :key="'p-i-'+index">
          <div class="big">{{ item.big }}</div>
          <div class="content">
            <div class="title">{{ item.title }}</div>
            <div class="desc">{{ item.desc }}</div>
          </div>
        </div>
      </div>
      <div class="fast-link">
        <div class="fl-item" v-for="(item,index) in fastLinkList" :key="'f-i-'+index">
          <div class="type">{{item.type}}</div>
          <div class="link" v-for="(it,ind) in item.list" :key="`f-i-${index}-i-${ind}`">
            {{it}}
          </div>
        </div>
        <div class="fl-item">
          <div class="type">手机网站</div>
          <img src="@/assets/barCode.png">
        </div>
      </div>
    </div>
    <div :class="theme == 'black' ? 'black' : 'white'" class="bottom">
      <div class="links" :class="theme == 'black' ? 'black-links' : 'white-links'">
        <div class="link" v-for="(item,index) in linksList" :key="`l-l-${index}`">{{item}}</div>
      </div>
      <div class="website-info">
        <div class="row">
          <div>增值电信业务经营许可证：A0-20230101</div>
          <div>网络文化经营许可证：A0-20230101</div>
        </div>
        <div class="row">
          <div>互联网药品信息服务资质证书编号： （经营性）-2022-0002</div>
          <div>公网安备 21020302000220号</div>
        </div>
        <div class="copyright">
          © 2023 版权所有
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
    name:'MyFooter',
    methods:{
        toLogin(){
            this.$router.push('/login');
        }
    },
    props:{
    theme:{
      type:String,
      default:'black'
    },
    showProm:{
      type:Boolean,
      default: true
    }
  },
  data() {
    return {
      promiseList: [
        {
          title: '品质保障',
          desc: '品质护航',
          big: '优'
        },
        {
          title: '七天五理由退换货',
          desc: '为您提供售后无忧保障',
          big: '七'
        },
        {
          title: '特色服务体验',
          desc: '为您呈现不一样的服务',
          big: '特'
        },
        {
          title: '帮助中心',
          desc: '您的购物指南',
          big: '帮'
        }
      ],
      fastLinkList: [
        {
          type: '购物指南',
          list: ['免费注册']
        },
        {
          type: '网站保障',
          list: ['发票保障', '售后规则', '缺货赔付']
        },
        {
          type: '支付方式',
          list: ['快捷支付', '信用卡', '货到付款']
        },
        {
          type: '商家服务',
          list: ['网站规则','商家入驻','商家中心','网站智库','物流服务','运营服务']
        }
      ],
      linksList:['关于我们','帮助中心','开放平台','诚聘英才','联系我们','网站合作','法律声明及隐私权政策','知识产权','廉正举报']
    }
  }
}
</script>
<style scoped> 
#bottom {
  font-family: "Microsoft YaHei";
}

.top {
  width: 1230px;
  margin: 0 auto;
}

.top .promise {
  display: flex;
  justify-content: space-between;
}

.top .promise .pro-item {
  display: flex;
  align-items: center;
  margin-top: 36px;
  margin-bottom: 36px;
}

.top .promise .pro-item .big {
  border: 3px solid #ff335e;
  border-radius: 50%;
  width: 45px;
  height: 45px;
  text-align: center;
  line-height: 45px;
  font-size: 30px;
  color: #ff335e;
}

.top .promise .pro-item .content {
  margin-left: 20px;
}

.top .promise .pro-item .content .title {
  font-size: 20px;
  font-weight: 600;
}

.top .promise .pro-item .content .desc {
  color: #999999;
  font-weight: 200;
}

.top .fast-link{
  display: flex;
  justify-content: space-between;
  border-top: 1px solid #f2f2f2;
  padding-top: 30px;
  padding-bottom: 30px;
  box-sizing: border-box;
  background: url("~@/assets/cat.png") 0 bottom no-repeat;
  background-size: 68px 25px;
}
.top .fast-link .type{
  color: #646464;
  font-size: 16px;
  font-weight: 700;
  height: 30px;
  line-height: 30px;
  text-align: left;
}
.top .fast-link .link{
  font-size: 12px;
  display: block;
  width: 100px;
  overflow: hidden;
  text-align: left;
  height: 20px;
  line-height: 20px;
  color: #8b8b8b;
  cursor: pointer;
}
.top .fast-link .link:hover{
  text-decoration: underline;
}

.bottom,.black{
  border-top: 2px solid #FF0036;
  background: #000;
  text-align: left;
  min-height: 177px;
}
.white{
  border-top: 2px solid #FFFFFF00;
  background: #FFFFFF;
  text-align: left;
  min-height: 177px;
}
.bottom .links,.bottom .website-info{
  width: 1230px;
  margin: 0 auto;
}
.bottom .links{
  display: flex;
}
.white-links{
  color: #999999;
}
.black-links{
  color: #FFFFFF;
}
.bottom .links .link{

  margin-right: 6px;
  line-height: 35px;
  font-size: 12px;
  cursor: pointer;
}
.bottom .links .link:hover{
 text-decoration: underline;
}
.bottom .website-info .row{
  display: flex;
}
.bottom .website-info .row div,.bottom .website-info .copyright{
  color: #a4a4a4;
  line-height: 25px;
  font-size: 12px;
  margin-right: 10px;
}
</style>