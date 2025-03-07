<template>
    <div id="admin-view">
        
        <div class="header">
           
            <i class="el-icon-s-goods" >
            </i> 农产品数据管理后台
        </div>
        <div class="content">
            <div class="left-menu">
                <el-menu
                class="el-menu-vertical-demo"
                background-color="#545c64"
                text-color="#fff"
                router
                active-text-color="#ffd04b">
                <el-menu-item index="2" disabled><i class="el-icon-s-home"></i>首页</el-menu-item>
                <el-menu-item index="/admin/product"><i class="el-icon-edit"></i>所有产品</el-menu-item>
                <el-menu-item index="/admin/type"><i class="el-icon-menu"></i>产品分类</el-menu-item>
                <el-menu-item index="2" disabled><i class="el-icon-user-solid"></i>用户管理</el-menu-item>
                <el-menu-item index="2" disabled><i class="el-icon-document-copy"></i>全部订单</el-menu-item>
                <el-menu-item index="2" disabled><i class="el-icon-s-tools"></i>我的账户</el-menu-item>
              </el-menu>
            </div>
            <div class="views">
                <router-view></router-view>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name:"AdminView",
    data(){
        return {

        }
    }
}
</script>

<style scoped>
.header{
    background: #f5f6fb;
    padding: 5px;
    color: #18b958;
    font-size: 30px;
}
.content{
    display: flex;
}
.left-menu{
    width:200px
}
.views{
    width: calc(100% - 200px);
     padding: 20px;
}
.el-icon-s-goods{
    color: #18b958;
}

</style>