<template>
  <div id="header">
    <div class="nav">
      <div class="left">
        <div class="title" @click="$router.push('/home')">农产品mall</div>
        <div class="login link" @click="handleLogin">请登录</div>
        <div class="regrister link" @click="handleRegister">免费注册</div>
      </div>
      <div class="right">
        <!-- <el-dropdown>
          <div class="person link">个人中心</div>
        </el-dropdown> -->
        <el-dropdown>
          <!-- <span class="el-dropdown-link">
            个人中心<i class="el-icon-arrow-down el-icon--right"></i>
          </span> -->
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item></el-dropdown-item>
            <el-dropdown-item></el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <div class="shop-cart link">
          <i class="el-icon-shopping-cart-1"></i>
          购物车
        </div>
        <div class="mobile-version link">
          <i class="el-icon-mobile"></i>
          手机版
        </div>
        <div class="title-zh link" @click="$router.push('/home')">农产品网</div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
    name:'MyHeader',
    methods:{
        handleLogin(){
            this.$router.push('/admin_login');
        },
        handleRegister(){
           this.$router.push('/register');
        },
        
    }
}
</script>
<style scoped>
#header{
  background-color: #f2f2f2;
  height: 32px;
}
.title{
  cursor: pointer;
}
.nav{
  width: 1230px;
  display: flex;
  margin: 0 auto;
  justify-content: space-between;
  font-size: 12px;
  line-height: 32px;
}
.nav .left,.nav .right{
  display: flex;
  justify-content: space-between;
  color: #999;
}
.nav .left{
  width: 190px;
}
.nav .right{
  width: 290px;
}
.link{
  font-size: 12px;
  cursor: pointer;
}
.link img{
  position: relative;
  top: 2px;
}
.link:hover{
  color: #ff335e;
}
</style>
