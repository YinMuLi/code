<template>
  <el-container>
    <!-- 左侧导航栏 -->
    <el-aside :width="asideWidth + 'px'"> <Aside /> </el-aside>
    <!-- 右侧 -->
    <el-container>
      <el-header><Header /></el-header>
      <el-main>
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>
<script setup lang="ts">
import { mitter } from "@/api/index";
import Aside from "@/components/Aside.vue";
import Header from "@/components/Header.vue";
import { ref } from "vue";
const asideWidth = ref<number>(200);
mitter.on("Flod", (value) => {
  asideWidth.value = value ? 65 : 200;
});
</script>
<style scoped>
.el-container {
  height: 100%;
}

.el-aside {
  height: 100%;
  background-color: #545c64;
}
.el-header {
  height: 60px;
  /* 垂直居中 */
  line-height: 60px;
  box-shadow: var(--el-box-shadow-lighter);
}
</style>
