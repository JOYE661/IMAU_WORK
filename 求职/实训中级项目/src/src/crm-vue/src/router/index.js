import Vue from "vue";
import VueRouter from "vue-router";
import Login from "@/components/Login.vue";
import Home from "@/components/Home.vue";
import Welcome from "@/components/Welcome.vue";
import UserList from "@/components/UserList.vue";
import UserAdd from "@/components/UserAdd.vue";
import CompanyAdd from "@/components/CompanyAdd.vue";
import CompanyList from "@/components/CompanyList.vue";

Vue.use(VueRouter);

const routes = [
  { path: "/", redirect: "/login" },
  { path: "/login", component: Login },
  {
    path: "/home",
    component: Home,
    redirect: "/welcome",
    children: [
      { path: "/welcome", component: Welcome },
      { path: "/user/list", component: UserList },
      { path: "/user/add", component: UserAdd },
      { path: "/company/add", component: CompanyAdd },
      { path: "/company/list", component: CompanyList },
    ],
  },
];

const router = new VueRouter({
  routes,
});

export default router;
