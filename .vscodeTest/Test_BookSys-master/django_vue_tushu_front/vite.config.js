import { fileURLToPath, URL } from "node:url";

import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

// https://cn.vitejs.dev/config/
export default defineConfig({
  server: {
    host: "127.0.0.1",
    port: "8080",
  },
  plugins: [vue()],
  resolve: {
    alias: {
      "@": fileURLToPath(new URL("./src", import.meta.url)),
    },
  },
});
// module.exports = {
//   devServer: {
//     proxy: {
//       "/api": {
//         target: "http://112.6.234.145:30016", // 后端API服务器地址
//         changeOrigin: true, // 允许跨域
//         pathRewrite: {
//           "^/api": "/api", // 将/api重写为空字符串，这样请求路径会被正确映射到目标服务器
//         },
//       },
//     },
//   },
// };
