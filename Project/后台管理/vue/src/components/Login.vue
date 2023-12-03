<template>
  <div class="title">LOGIN</div>
  <el-form :model="state" status-icon :rules="rules" ref="instanceRef">
    <!-- 账号 -->
    <el-form-item prop="username">
      <el-input
        size="large"
        placeholder="请输入用户名"
        v-model="state.username"
      >
        <template #prefix>
          <AliIcon icon-ref="icon-yonghu" />
        </template>
      </el-input>
    </el-form-item>
    <!-- 密码 -->
    <el-form-item prop="password">
      <el-input
        size="large"
        placeholder="请输入登录密码"
        type="password"
        v-model="state.password"
      >
        <template #prefix>
          <AliIcon icon-ref="icon-mima1" />
        </template>
      </el-input>
    </el-form-item>
    <!-- 记住我 -->
    <el-form-item>
      <el-switch v-model="state.maintain" />
      <span style="margin-left: 10px">记住我</span>
      <span style="margin-left: auto" class="link"
        >没有账号? <RouterLink to="/register">点此注册</RouterLink></span
      >
    </el-form-item>
    <!-- 按钮 -->
    <el-form-item>
      <el-button
        type="primary"
        @click="handleLogin(instanceRef)"
        style="width: 200px; margin: 0 auto"
        >登录</el-button
      >
    </el-form-item>
  </el-form>
</template>
<script setup lang="ts">
import { msg, request } from "@/api";
import { User } from "@/api/entity";
import router from "@/router";
import { useStore } from "@/store";
import type { FormInstance, FormRules } from "element-plus";
import { reactive, ref } from "vue";
const store = useStore();
const instanceRef = ref<FormInstance>();
const state = reactive({
  username: "",
  password: "",
  // 是否保持登录状态
  maintain: false,
});
const rules = reactive<FormRules>({
  username: [{ required: true, message: "用户名不能为空", trigger: "blur" }],
  password: [{ required: true, message: "登录密码不能为空", trigger: "blur" }],
});
async function handleLogin(form: FormInstance | undefined) {
  if (!form) {
    return;
  }
  await form.validate((valid, fields) => {
    if (valid) {
      request<User>({
        url: "/user/login",
        method: "POST",
        params: state,
      }).then(
        (res) => {
          store.state.user = res;
          router.push("/back");
          msg.success("登录成功");
        },
        (error) => {
          msg.error(error);
        }
      );
    }
  });
}
</script>
<style scoped></style>
