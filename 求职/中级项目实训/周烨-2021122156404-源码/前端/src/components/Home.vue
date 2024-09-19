  <template>
  <el-container class="home-container">
    <!-- 头部区域 -->
    <el-header>
      <div>
        <img src="../assets/logo.png" alt="" />
        <span>后台管理系统</span>
      </div>
      <el-button type="info" @click="logout"> 退出 </el-button>
    </el-header>
    <!-- 页面主体区域 -->
    <el-container>
      <!-- 侧边栏 -->
      <el-aside style="width: 200px">
        <el-menu
          background-color="#333744"
          text-color="#fff"
          active-text-color="#ffd04b"
          unique-opened
          router
        >
          <!-- 一级,index若相同,全部展开,全部折叠-->
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-menu"></i>
              <span>用户管理</span>
            </template>
            <!-- 二级 -->
            <el-menu-item index="/user/add">
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span>用户添加</span>
              </template>
            </el-menu-item>
            <el-menu-item index="/user/list">
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span>用户列表</span>
              </template>
            </el-menu-item>
          </el-submenu>


          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-menu"></i>
              <span>公司管理</span>
            </template>
            <!-- 二级 -->
            <el-menu-item index="/company/add">
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span>公司添加</span>
              </template>
            </el-menu-item>
            <el-menu-item index="/company/list">
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span>公司列表</span>
              </template>
            </el-menu-item>
          </el-submenu>
          
        </el-menu>
      </el-aside>
      <!-- 主体结构 -->
      <el-main><router-view></router-view></el-main>
    </el-container>
  </el-container>
</template>


<script>
export default {
  data() {
    return {
      // 左侧菜单数据
      menuList: [],
    };
  },
  methods: {
    logout() {
      this.$router.push("/login");
    },
    // 菜单的折叠与展开
    toggleCollapse() {
      this.isCollapse = !this.isCollapse;
      this.iconCollapse = this.isCollapse ? "el-icon-right" : "el-icon-back";
    },
  },
};
</script>


<style lang="less" scoped>
.home-container {
  height: 100%;
}
.el-header {
  background-color: #373d41;
  display: flex;
  justify-content: space-between;
  padding-left: 0;
  align-items: center;
  > div {
    display: flex;
    align-items: center;
    img {
      width: 60px;
      height: 60px;
    }
    span {
      color: #fff;
      font-size: 24px;
      margin-left: 20px;
    }
  }
}
.el-aside {
  background-color: #333744;
  .el-menu {
    border-right: 0;
  }
}
.el-main {
  background-color: #eaedf1;
}
.toggle-button {
  background-color: #4a5064;
  font-size: 12px;
  line-height: 24px;
  color: #fff;
  text-align: center;
  cursor: pointer;
}
</style>