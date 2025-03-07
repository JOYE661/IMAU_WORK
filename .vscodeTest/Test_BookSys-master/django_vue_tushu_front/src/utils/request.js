import axios from 'axios'
import { ElMessage } from 'element-plus'
import Router from '../router'

let hostURL = 'http://127.0.0.1:8000'

// 创建axios实例
const request = axios.create({
  baseURL: hostURL,
  timeout: 15000,// 请求超时时间
})

//响应拦截器
request.interceptors.response.use(res => {
  if (!!res.data.code && res.data.code != 200) {
    if (res.data.code === 401) {
      Router.push("/login") //跳转到登陆页面
      localStorage.clear()
    }
    ElMessage({
      showClose: true,
      message: res.data.message || "未知错误",
      type: 'warning',
    })
  }
  return res
}, error => {
  let errorMessage = error.response.data?.message
  ElMessage({
    showClose: true,
    message: errorMessage || "内部错误",
    type: 'error',
  })
  return error.response
});

//请求拦截器
request.interceptors.request.use(config => {
  let token = localStorage.getItem("token");
  if (token) {
    config.headers['Ac-Token'] = token
  }
  return config
}, error => {
  console.log('请求出错了', error)
});

export default request