import router from "./index"
import Layout from "../layout/index"
import pageComponent from "../pagecomponent/index"
import NProgress from 'nprogress'
import fr from "element-ui/src/locale/lang/fr";
import {compile} from "vue-template-compiler";
import fa from "element-ui/src/locale/lang/fa";
import da from "element-ui/src/locale/lang/da"; // progress bar

NProgress.configure({ showSpinner: true }) // NProgress Configuration

const filterRoutes = ["/login"]   // 需要过滤掉的路由
router.beforeEach((to, from, next) => {
    // start progress bar
    NProgress.start()

    // 获取路由 meta 中的title，并设置给页面标题
    // document.title = "零跑新能源(" + to.meta.title + ")"
    document.title = "零跑新能源"

    // 判断路由指向是否在需要过滤的路由地址数组里
    // 如果在，则直接跳进页面，无需判断
    if(filterRoutes.indexOf(to.path) !== -1) {
        next()
        // 源路由是 '/', 目标路由是'/login', 使用next()可以进入到'/login'，
        // 即登录界面，return false后即退出'/'路由所在的生命周期，进入到'/login'
        // 所在的生命周期，这时候indexOf返回的是-1，则不执行此if语句
        return false
    }

    // 当router.options.routes.length为1时，即为登录页面
    if(router.options.routes.length == 1) {
        // 获取token和原始路由数组
        // 没输入账号密码时userInfo为undefined，需要使用空值合并操作符??，
        // 当左边做undefined或null时，使用??右边的字符串代替
        const userInfo = JSON.parse(window.localStorage.getItem('userInfo')) ?? ""
        // 当token和原始路由都存在的时候
        // 登录后路由跳转接口
        if(userInfo.token && userInfo.routes)
        {
            onFilterRoutes(to, next, userInfo.routes)
        }  // 执行路由过滤和跳转
        else{
            next({ path: "/login", replace: true })
        }
    } else {
        next()
    }
})

router.afterEach(() => {
    // finish progress bar
    NProgress.done()
})

// 路由拼接
function loadView(view) {
    return () => import(`@/views/${ view }`)
}

// 路由过滤和跳转
async function onFilterRoutes(to, next, e) {
    const routes = await filterASyncRoutes(e)    // 路由过滤
    routes.sort((a, b) => a['id'] - b['id'])
    routes.forEach(item => {
        router.options.routes.push(item)
        router.addRoute(item)
    })
    next({ ...to, replace: true })
}

// 路由过滤   遍历路由 转换为组件对象和路径
function filterASyncRoutes(data) {
    const routes = data.filter(item => {
        if(item["component"] === "pageComponent") item.component = pageComponent
        else item["component"] = loadView(item["component"])
        // 路由递归，转换组件对象和路径
        if(item["children"] && item["children"].length > 0) item["children"] = filterASyncRoutes(item.children)
        return true
    })
    return routes
}