import { createRouter, createWebHistory } from "vue-router";
import NProgress from "nprogress"; //进度条
import "nprogress/nprogress.css";

NProgress.configure({
  showSpinner: false, //通过将其设置为 false 来关闭加载微调器。
});

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      redirect: "/order/list",
      path: "/",
      redirect: "/user/list",
      hidden: true,
    },
    {
      path: "/login",
      name: "login",
      meta: { title: "登陆" },
      component: () => import("@/views/login/login.vue"),
      hidden: true,
    },
    {
      path: "/media",
      name: "media",
      meta: { title: "媒体" },
      component: () => import("@/views/main/main.vue"),
      children: [
        {
          path: "list",
          name: "media-list",
          meta: { title: "媒体资源列表" },
          component: () => import("@/views/media/media-list.vue"),
        },
      ],
    },
    {
      path: "/user",
      name: "user",
      meta: { title: "用户" },
      component: () => import("@/views/main/main.vue"),
      children: [
        {
          path: "list",
          name: "user-list",
          meta: { title: "用户列表" },
          component: () => import("@/views/user/user-list.vue"),
        },
      ],
    },

    {
      path: "/user",
      name: "user",
      meta: { title: "用户" },
      component: () => import("@/views/main/main.vue"),
      children: [
        {
          path: "list",
          name: "user-list",
          meta: { title: "图书管理" },
          component: () => import("@/views/user/user-list.vue"),
        },
      ],
    },
    {
      path: "/user",
      name: "user",
      meta: { title: "用户" },
      component: () => import("@/views/main/main.vue"),
      children: [
        {
          path: "list",
          name: "user-list",
          meta: { title: "出版社管理" },
          component: () => import("@/views/user/user-list.vue"),
        },
      ],
    },

    {
      path: "/dd",
      name: "dd",
      meta: { title: "用户" },
      component: () => import("@/views/main/main.vue"),
      children: [
        {
          path: "ddgl",
          name: "user-list",
          meta: { title: "用户列表" },
          component: () => import("@/views/ddgl/ddgl.vue"),
        },
      ],
    },

    // 卖家管理
    {
      path: "/cs",
      name: "cs",
      meta: { title: "卖家管理" },
      component: () => import("@/views/main/main.vue"),
      children: [
        {
          path: "csgl",
          name: "csgl",
          meta: { title: "卖家管理" },
          component: () => import("@/views/csgl/csgl.vue"),
        },
      ],
    },

    // 商品管理
    {
      path: "/sp",
      name: "sp",
      meta: { title: "商品管理" },
      component: () => import("@/views/main/main.vue"),
      children: [
        {
          path: "spgl",
          name: "spgl",
          meta: { title: "商品管理" },
          component: () => import("@/views/spgl/spgl.vue"),
        },
      ],
    },

    // 审批管理
    {
      path: "/review",
      name: "review",
      meta: { title: "审批管理" },
      component: () => import("@/views/main/main.vue"),
      children: [
        {
          path: "list1",
          name: "review-list1",
          meta: { title: "待审批列表" },
          component: () => import("@/views/review/review-list1.vue"),
        },
        {
          path: "list",
          name: "review-list",
          meta: { title: "全部审批列表" },
          component: () => import("@/views/review/review-list.vue"),
        },
      ],
    },

    /// 审批管理
    {
      path: "/apply",
      name: "apply",
      meta: { title: "审批管理" },
      component: () => import("@/views/main/main.vue"),
      children: [
        {
          path: "list",
          name: "apply-list",
          meta: { title: "未通过审批列表" },
          component: () => import("@/views/apply/apply-list.vue"),
        },
        {
          path: "list1",
          name: "apply-list1",
          meta: { title: "同意审批列表" },
          component: () => import("@/views/apply/apply-list1.vue"),
        },
        {
          path: "list2",
          name: "apply-list2",
          meta: { title: "待审批列表" },
          component: () => import("@/views/apply/apply-list2.vue"),
        },
      ],
    },
  ],
});

import defaultSettings from "@/settings";

//路由全局前置钩子
router.beforeEach((to, from, next) => {
  NProgress.start();
  document.title = `${to.meta.title || "数智兴华"} - ${defaultSettings.title}`;
  let token = localStorage.getItem("token");
  if (token) {
    next();
  } else {
    if (to.path == "/login") {
      next();
    } else {
      next({
        path: "/login",
      });
    }
  }
});

// //路由全局后置钩子
router.afterEach(() => {
  NProgress.done();
});

export default router;
