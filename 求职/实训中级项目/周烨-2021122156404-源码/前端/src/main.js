import Vue from "vue";
import App from "./App.vue";
import router from "./router";

// 导入全局样式表
import "@/assets/css/common.css";

import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";

import axios from "axios";
import VueAxios from "vue-axios";

axios.defaults.baseURL = "http://localhost:9000";

// 请求拦截器
axios.interceptors.request.use((config) => {
  // 请求头中添加 Authorization 字段
  config.headers.Authorization = window.sessionStorage.getItem("token");
  return config;
});

Vue.prototype.$alert = ElementUI.MessageBox.alert;
Vue.prototype.$processResult = function (vm, res, success) {
  let result = res.data;
  if (result.code == 200) {
    success(result.data);
  } else if (result.code == 401) {
    vm.$router.push("/login");
  } else {
    vm.$alert(result.message);
  }
};

Vue.use(VueAxios, axios);

Vue.use(ElementUI);

Vue.config.productionTip = false;

new Vue({
  router,
  render: (h) => h(App),
}).$mount("#app");
