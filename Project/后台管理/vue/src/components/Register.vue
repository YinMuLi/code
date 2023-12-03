<template>
  <div class="title">欢迎注册</div>
  <el-form
    :model="state"
    status-icon
    :rules="rules"
    ref="formRef"
    label-width="60px"
    :hide-required-asterisk="true"
  >
    <!-- 账号 -->
    <el-form-item prop="username" label="用户名">
      <el-input
        size="large"
        placeholder="请设置用户名"
        v-model="state.username"
      />
    </el-form-item>
    <!-- 昵称 -->
    <el-form-item prop="nickname" label="昵称">
      <el-input
        size="large"
        placeholder="请设置昵称"
        v-model="state.nickname"
      />
    </el-form-item>
    <!-- 密码 -->
    <el-form-item prop="password" label="密码">
      <el-input
        size="large"
        placeholder="请设置登录密码"
        type="password"
        v-model="state.password"
      />
    </el-form-item>
    <!-- 按钮 -->
    <div class="pc" style="margin-bottom: 10px">
      <el-button
        type="primary"
        style="width: 200px"
        @click="handleRegister(formRef)"
        >注册</el-button
      >
    </div>
  </el-form>
  <div style="text-align: right" class="link">
    已有账号? <RouterLink to="/login">点此登录</RouterLink>
  </div>
</template>
<script setup lang="ts">
import { msg, request } from "@/api";
import type { FormInstance, FormRules } from "element-plus";
import { reactive, ref } from "vue";
import { useRouter } from "vue-router";
const formRef = ref<FormInstance>();
const router = useRouter();
const state = reactive({
  username: "",
  nickname: "",
  password: "",
});
const rules = reactive<FormRules>({
  username: [
    {
      validator: validateUsername,
      trigger: "blur",
    },
  ],
  password: [{ required: true, message: "密码不能为空", trigger: "blur" }],
  nickname: [{ required: true, message: "昵称不能为空", trigger: "blur" }],
});
function validateUsername(rule: any, username: string, callback: Function) {
  if (username.length <= 0) {
    callback(new Error("用户名不能为空"));
    return;
  }
  request<boolean>({
    method: "Post",
    url: "/user/has",
    params: {
      username,
    },
  }).then(
    (res) => {
      if (res) {
        callback(new Error("用户名已被使用"));
        return;
      }
      callback();
    },
    (error) => {
      msg.error(error);
    }
  );
}
async function handleRegister(form: FormInstance | undefined) {
  if (!form) {
    return;
  }
  await form.validate((valid, fileds) => {
    if (valid) {
      request<boolean>({
        method: "POST",
        url: "/user/register",
        params: state,
      }).then(
        (res) => {
          if (res) {
            msg.success("注册成功");
            router.push("/login");
          }
        },
        (error) => {
          msg.error(error);
        }
      );
    }
  });
}
</script>
