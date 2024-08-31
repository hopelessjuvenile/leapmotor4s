import axios from 'axios'

let downloadLoadingInstance;
// 是否显示重新登录
export let isRelogin = { show: false };

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
// axios.defaults.headers['Content-Type'] = 'application/json'

// 对应国际化资源文件后缀
axios.defaults.headers['Content-Language'] = 'zh_CN'
// 创建axios实例
const service = axios.create({
  // axios中请求配置有baseURL选项，表示请求URL公共部分
  baseURL: 'http://localhost:9090',
  // 超时
  timeout: 10000
})

export default function request(config) {
  return service(config)
      .then((response) => {
          // 处理响应
          return response.data;
      })
      .catch((error) => {
        // Handle error
          console.error('Request error:', error);
          throw error;
      });
}
