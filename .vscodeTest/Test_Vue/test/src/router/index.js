import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routers = [
   
    {
        // 客户端-----
        path: '/',
        name: 'ClientView',
        component: () => import('@/views/ClientView.vue'),
        children:[
            {
                path: '/home',
                name: 'Home',
                component: () => import('@/views/Home.vue')
            },
            {
                path: '/goodsDetail',
                name: 'GoodsDetail',
                component: () => import('@/views/GoodsDetail.vue')
            },
            {
                path: '/admin_login',
                name: 'Admin_login',
                component: () => import('@/views/Admin_login.vue')
            },
            {
                path: '/login',
                name: 'Login',
                component: () => import('@/views/Login.vue')
            },
            {
                path: '/register',
                name: 'Register',
                component: () => import('@/views/Register.vue')
            },
        ]
    },{
        path:"/admin",
        name: 'AdminView',
        component: () => import('@/views/AdminView.vue'),
        children:[
            {
                path: '/admin/product',
                name: 'Product',
                component: () => import('@/views/admin/Product.vue')
            },
            {
                path: '/admin/type',
                name: 'Type',
                component: () => import('@/views/admin/Type.vue')
            },
            
        ]
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: routers
})

export default router;

