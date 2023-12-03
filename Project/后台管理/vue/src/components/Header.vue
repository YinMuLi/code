<template>
  <el-row :gutter="5" class="mh">
    <!-- 折叠图标 -->
    <el-col :span="0.5">
      <AliIcon :icon-ref="icon" class="flod" @click="flodAside" />
    </el-col>
    <!-- 面包屑 -->
    <el-col :span="5">
      <el-breadcrumb separator="/" class="bread">
        <el-breadcrumb-item :to="{ path: '/back' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item
          v-for="item in getBreadList()"
          :to="{ path: item.path }"
          >{{ item.name }}</el-breadcrumb-item
        >
      </el-breadcrumb>
    </el-col>

    <el-col :span="2" :offset="16" id="pc">
      <el-avatar :src="user.avatarUrl" />
      <el-dropdown class="mh">
        <span style="margin: auto 10px">{{ user.nickname }} </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="router.push('/profile')"
              >个人简介</el-dropdown-item
            >
            <el-dropdown-item @click="handleQuit">退出</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </el-col>
  </el-row>
</template>
<script setup lang="ts">
import { mitter } from "@/api/index";
import AliIcon from "@/components/AliIcon.vue";
import { useStore } from "@/store";
import { ref } from "vue";
import { useRoute, useRouter, type RouteLocationMatched } from "vue-router";
const icons = ["icon-zhedie", "icon-zhankaicaidan"];
const icon = ref<string>("icon-zhedie");
const route = useRoute();
const router = useRouter();
const user = useStore().state.user;
function getBreadList() {
  let result: RouteLocationMatched[] = [];
  route.matched.forEach((item) => {
    if (item.name != null && item.name != "首页") {
      result.push(item);
    }
  });
  return result;
}
function flodAside() {
  icon.value = icon.value == icons[0] ? icons[1] : icons[0];
  mitter.emit("Flod", icon.value == icons[1]);
}
function handleQuit() {
  router.push("/");
}
</script>
<style scoped>
.flod:hover {
  cursor: pointer;
}
.bread {
  display: inline-block;
  margin-left: 15px;
}
.el-dropdown:deep():focus {
  outline: 0;
}
</style>
