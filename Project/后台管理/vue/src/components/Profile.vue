<template>
  <div class="title">公开头像</div>
  <div style="color: #737278">在这里可以修改你的头像</div>
  <el-row style="margin-top: 10px">
    <el-col :span="4">
      <el-avatar :size="200" :src="user.avatarUrl" />
    </el-col>
    <el-col :span="20">
      <div style="font-weight: bold; margin-bottom: 10px">上传新头像</div>
      <el-upload
        :auto-upload="false"
        :on-change="handleChange"
        :show-file-list="false"
        accept="image/jpg,image/jpeg,image/png"
      >
        <el-button>选择文件</el-button>
      </el-upload>
    </el-col>
  </el-row>
  <!-- 设置头像 -->
  <el-dialog
    destroy-on-close
    v-model="dialogVisible"
    :close-on-click-modal="false"
    :close-on-press-escape="false"
    width="400px"
  >
    <template #header>
      <h3>设置头像的位置和大小</h3>
    </template>
    <div style="height: 300px">
      <VueCropper
        ref="cropper"
        :img="options.img"
        :autoCropWidth="200"
        :autoCropHeight="200"
        :autoCrop="true"
        :canMoveBox="false"
        :fixedBox="true"
        :centerBox="true"
        outputType="png"
      />
    </div>
    <template #footer>
      <el-button type="primary" @click="handleUpload">
        设置新的个人资料图片
      </el-button>
    </template>
  </el-dialog>
  <el-button type="primary" @click="handelSave" style="margin-top: 50px"
    >更新个人资料</el-button
  >
</template>
<script setup lang="ts">
//一定是VueCropper这个名字，不然会报错。
//env.d.ts声明了vue-cropper
import { msg, request } from "@/api";
import { upload, type ICallback } from "@/api/cos";
import type { User } from "@/api/entity";
import { useStore } from "@/store";
import type { UploadFile } from "element-plus";
import { reactive, ref } from "vue";
import { VueCropper } from "vue-cropper";
import "vue-cropper/dist/index.css";
import { utils } from "../api/index";
const cropper: any = ref();
const user = reactive<User>(utils.copy<User>(useStore().state.user));
const dialogVisible = ref<boolean>(false);
const options = reactive({
  img: "",
});
function handleChange(file: UploadFile) {
  let reader = new FileReader();
  reader.readAsDataURL(file.raw as Blob);
  // base64
  reader.onload = (e) => {
    if (typeof e.target?.result == "string") {
      options.img = e.target.result;
      dialogVisible.value = true;
    } else {
      msg.error("文件上传失败");
    }
  };
}
function handleUpload() {
  cropper.value.getCropBlob((blob: Blob) => {
    let file = new File([blob], `${user.username}.png`);
    const callback: ICallback = {
      success: function (res: any): void {
        dialogVisible.value = false;
        user.avatarUrl = `https://${res.Location}`;
      },
      error: function (res: any): void {
        console.log(res);
      },
    };
    upload(file, callback);
  });
}
function handelSave() {
  request<boolean>({
    method: "POST",
    url: "/user/save",
    data: user,
  }).then(
    (res) => {
      msg.success("更新成功");
      useStore().state.user = utils.copy(user);
    },
    (error) => {
      msg.error(error);
    }
  );
}
</script>
<style scoped>
.title {
  font-weight: bold;
  font-size: 25px;
  margin-bottom: 5px;
}
</style>
