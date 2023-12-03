<template>
  <div class="bg">
    <div class="contain">
      <RouterView />
    </div>
  </div>
</template>
<script setup lang="ts"></script>
<style scoped>
.bg {
  height: 100%;
  width: 100%;
  overflow: hidden;
  background-image: url("@/assets/电脑壁纸 [28].jpg");
  background-size: cover;
  background-repeat: no-repeat;
  background-attachment: fixed;
}
.contain {
  width: 350px;
  height: 350px;
  overflow: hidden;
  background-color: rgb(244, 242, 244);
  border-radius: 8px;
  backdrop-filter: blur(3px);
  margin: 100px auto;
  padding: 10px 30px;
}

.el-input {
  margin: 10px auto;
}
.btn {
  margin-top: 20px;
  text-align: center;
}
:deep() .title {
  text-align: center;
  font-size: 30px;
  font-weight: bold;
}
:deep() .el-form {
  margin-top: 20px;
}
:deep() .link {
  font-size: 14px;
}
</style>
