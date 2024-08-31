<template>
  <div class="login">
    <el-form ref="userForm" :model="user" :rules="loginRules" class="login-form">
      <h3 class="title">零跑新能源-登录</h3>
      <el-form-item prop="username">
        <el-input
            v-model="user.username"
            type="text"
            prefix-icon="el-icon-user"
            auto-complete="off"
            placeholder="账号"
        >
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
            v-model="user.password"
            type="password"
            prefix-icon="el-icon-view"
            auto-complete="off"
            placeholder="密码"
            @keyup.enter.native="handleLogin"
        >
        </el-input>
      </el-form-item>
      <el-checkbox v-model="user.rememberMe" style="margin:0px 0px 25px 0px;">记住密码</el-checkbox>
      <el-form-item style="width:100%;">
        <el-button
            :loading="loading"
            size="medium"
            type="primary"
            style="width:100%;"
            @click="login"
        >
          <span v-if="!loading">登 录</span>
          <span v-else>登 录 中...</span>
        </el-button>
        <div style="float: right;" v-if="register">
          <router-link class="link-type" :to="'/register'">立即注册</router-link>
        </div>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import Cookies from "js-cookie";
import { encrypt, decrypt } from '@/utils/jsencrypt'
import dynamicUser from "@/mock";
import {Message} from "element-ui";

export default {
  name: "login",
  data() {
    return {
      codeUrl: "",
      user: {
        username: "",
        password: "",
        rememberMe: false,
        code: "",
        uuid: ""
      },
      loginRules: {
        username: [
          { required: true, trigger: "blur", message: "请输入您的账号" }
        ],
        password: [
          { required: true, trigger: "blur", message: "请输入您的密码" }
        ],
        code: [{ required: true, trigger: "change", message: "请输入验证码" }]
      },
      loading: false,
      // 验证码开关
      // 注册开关
      register: false,
      redirect: undefined
    };
  },
  methods: {
    login() {
      this.$refs.userForm.validate(( valid ) => {
        if(valid) {
          let flag = !1
          window.localStorage.removeItem("userInfo")
          dynamicUser.forEach(item => {
            if(item["username"] == this.user['username'] && item["password"] == this.user['password']) {
              flag = !0
              Message({ type: 'success', message: "登录成功", showClose: true, duration: 3000 })
              window.localStorage.setItem("userInfo", JSON.stringify(item))
              this.$router.replace({ path: "/" })
            }
          })
          if(!flag) Message({ type: 'warning', message: "账号密码错误，请重试!", showClose: true, duration: 3000 })
        } else return false
      })
    },
  }
};
</script>

<style rel="stylesheet/scss" lang="scss">
.login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-image: url("../../assets/images/login-background.jpg");
  -webkit-filter: opacity(80%);
  background-size: cover;
}
.title {
  margin: 0px auto 30px auto;
  text-align: center;
  //color: #707070;
  color: black;
}

.login-form {
  border-radius: 6px;
  background-color: rgba(255, 255, 255, 0.6);
  width: 400px;
  padding: 25px 25px 5px 25px;
  .el-input {
    height: 38px;
    input {
      height: 38px;
    }
  }
  .input-icon {
    height: 39px;
    width: 14px;
    margin-left: 2px;
  }
}
.login-tip {
  font-size: 13px;
  text-align: center;
  color: #bfbfbf;
}
.login-code {
  width: 33%;
  height: 38px;
  float: right;
  img {
    cursor: pointer;
    vertical-align: middle;
  }
}
.el-login-footer {
  height: 40px;
  line-height: 40px;
  position: fixed;
  bottom: 0;
  width: 100%;
  text-align: center;
  color: #fff;
  font-family: Arial;
  font-size: 12px;
  letter-spacing: 1px;
}
.login-code-img {
  height: 38px;
}
</style>
