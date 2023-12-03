<template>
  <el-menu
    active-text-color="#ffd04b"
    background-color="#545c64"
    :default-active="route.path"
    text-color="#fff"
    :collapse-transition="false"
    :collapse="isCollapse"
    :router="true"
  >
    <div class="logo">
      <AliIcon icon-ref="icon-shuyem" style="font-size: 25px" />
      <span v-if="!isCollapse" style="margin-left: 10px">后台管理系统</span>
    </div>
    <el-menu-item index="/home">
      <el-icon> <AliIcon icon-ref="icon-zhuye" /></el-icon>
      <span>主页</span>
    </el-menu-item>
    <el-sub-menu index="/user">
      <!-- 系统管理 -->
      <template #title>
        <el-icon><AliIcon icon-ref="icon-yingyongguanli" /></el-icon>
        <span>系统管理</span>
      </template>
      <!-- 子项 -->
      <el-menu-item index="/user">
        <el-icon><AliIcon icon-ref="icon-yonghu" /></el-icon>
        <span>用户管理</span>
      </el-menu-item>
    </el-sub-menu>
  </el-menu>
</template>
<script setup lang="ts">
import { mitter } from "@/api/index";
import AliIcon from "@/components/AliIcon.vue";
import { ref } from "vue";
import { useRoute } from "vue-router";
const route = useRoute();
const isCollapse = ref<boolean>(false);
mitter.on("Flod", (value) => {
  isCollapse.value = value as boolean;
});
</script>
<style scoped>
.el-menu {
  overflow-x: hidden;
}
.logo {
  height: 56px;
  line-height: 60px;
  text-align: center;
  color: #fff;
  font-weight: bold;
}
</style>
