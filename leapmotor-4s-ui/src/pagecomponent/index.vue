<template>
  <div class="body-bg">
    <el-container>
      <el-header>
          <header-menu-container></header-menu-container>
      </el-header>
      <el-container>
  <!--      <el-aside width="200px"><sidebar class="sidebar-container"></sidebar></el-aside>-->
        <el-main><sys-main></sys-main></el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script>

import SysMain  from './sysMain'      // 页面布局的右侧区域
import HeaderMenuContainer from "@/pagecomponent/headerMenu"; // 页面布局的header菜单
export default {
  name: 'pageComponent',
  components: {HeaderMenuContainer, SysMain}
}
</script>
<style>
.el-header{padding: 0!important;margin-left: 180px;}
.el-main{padding: 0;}
.body-bg {
  position: absolute;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  overflow-y: auto;
  background-image: url("../assets/images/index_background.jpg");
  background-repeat: no-repeat;
  background-size: cover;
}
</style>