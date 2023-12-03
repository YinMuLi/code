<template>
  <!-- 搜索 -->
  <el-row :gutter="15">
    <!-- 一共24span -->
    <el-col :span="4">
      <el-input v-model="state.query.username" placeholder="请输入名称">
        <template #suffix>
          <AliIcon icon-ref="icon-yonghu" />
        </template>
      </el-input>
    </el-col>
    <el-col :span="4">
      <el-input v-model="state.query.email" placeholder="请输入邮箱">
        <template #suffix>
          <AliIcon icon-ref="icon-youxiang" />
        </template>
      </el-input>
    </el-col>
    <el-col :span="4">
      <el-input v-model="state.query.address" placeholder="请输入地址">
        <template #suffix>
          <AliIcon icon-ref="icon-dizhi" />
        </template>
      </el-input>
    </el-col>
    <el-col :span="4">
      <el-button type="primary" @click="load">搜索</el-button>
      <el-button type="warning" @click="reset">重置</el-button>
    </el-col>
  </el-row>
  <!-- 数据整体操作 -->
  <el-row :gutter="15">
    <el-col :span="1.5">
      <el-button type="primary" @click="state.dialog = !state.dialog">
        新增
        <AliIcon icon-ref="icon-zengjiatianjiajiahao" class="ml-5" />
      </el-button>
    </el-col>
    <el-col :span="1.5">
      <el-button type="danger" @click="handleDelBatch">
        批量删除
        <AliIcon icon-ref="icon-jianshao" class="ml-5" />
      </el-button>
    </el-col>
    <el-col :span="1.5">
      <el-button type="primary"> 导入 </el-button>
    </el-col>
    <el-col :span="1.5">
      <el-button type="primary" @click="handleExport">
        导出
        <AliIcon icon-ref="icon-daochu" class="ml-5" />
      </el-button>
    </el-col>
  </el-row>
  <!-- 表格 -->
  <el-table
    :data="state.users"
    :show-overflow-tooltip="true"
    style="width: 100%"
    @selection-change="handleSelectionChange"
  >
    <el-table-column type="selection" width="55" />
    <el-table-column prop="username" label="用户名" width="120" />
    <el-table-column prop="nickname" label="昵称" width="120" />
    <el-table-column prop="email" label="邮箱" width="210" />
    <el-table-column prop="phone" label="手机号码" width="120" />
    <el-table-column prop="address" label="地址" width="120" />
    <el-table-column label="操作">
      <template #default="scope">
        <el-button type="warning" @click="handleEdit(scope.row)">
          编辑
          <AliIcon icon-ref="icon-bianji" class="ml-5" />
        </el-button>
        <el-button type="danger" @click="handleDel(scope.row.id)">
          删除
          <AliIcon icon-ref="icon-jianshao" class="ml-5" />
        </el-button>
      </template>
    </el-table-column>
  </el-table>
  <!-- 分页 -->
  <el-pagination
    v-model:current-page="state.query.pageNum"
    v-model:page-size="state.query.pageSize"
    :page-sizes="[5, 10, 15]"
    :background="true"
    layout="total, sizes, prev, pager, next, jumper"
    :total="state.total"
    @size-change="load"
    @current-change="load"
  />
  <!-- 添加用户 -->
  <el-dialog
    v-model="state.dialog"
    :close-on-click-modal="false"
    title="用户信息"
    width="30%"
    destroy-on-close
    center
  >
    <el-form label-position="right" label-width="50px" :model="state.user">
      <el-form-item label="账号">
        <el-input v-model="state.user.username" />
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="state.user.nickname" />
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="state.user.email" />
      </el-form-item>
      <el-form-item label="电话">
        <el-input v-model="state.user.phone" />
      </el-form-item>
      <el-form-item label="地址">
        <el-input v-model="state.user.address" />
      </el-form-item>
    </el-form>
    <template #footer>
      <div style="margin-top: -30px">
        <el-button @click="state.dialog = !state.dialog">取消</el-button>
        <el-button type="primary" @click="save">确认</el-button>
      </div>
    </template>
  </el-dialog>
</template>
<script setup lang="ts">
import { User, type IQuery } from "@/api/entity";
import { msg, request, warningConfirm } from "@/api/index";
import AliIcon from "@/components/AliIcon.vue";
import { onMounted, reactive } from "vue";
interface IState {
  users: User[];
  total: number;
  query: IQuery;
  dialog: boolean;
  user: User;
  ids: number[];
}
interface IResponse {
  records: User[];
  total: number;
}
const state = reactive<IState>({
  users: [],
  total: 0,
  query: {
    pageNum: 1,
    pageSize: 5,
    username: "",
    email: "",
    address: "",
  },
  dialog: false,
  user: new User(),
  ids: [],
});
function reset() {
  state.query.username = "";
  state.query.email = "";
  state.query.address = "";
  load();
}
function load() {
  request<IResponse>({
    method: "GET",
    url: "/user/query",
    params: state.query,
  }).then((res) => {
    state.users = res.records;
    state.total = res.total;
  });
}
function save() {
  request<boolean>({
    method: "POST",
    url: "/user/save",
    data: state.user,
  }).then(
    () => {
      msg.success("保存成功");
      state.dialog = false;
      load();
    },
    (error) => {
      msg.error(error);
    }
  );
}
function handleExport() {
  request<string>({
    method: "GET",
    url: "/user/export",
    responseType: "blob",
  }).then((res) => {
    const link = document.createElement("a");
    const blob = new Blob([res], { type: "application/vnd.ms-excel" });
    link.href = URL.createObjectURL(blob);
    link.download = "用户信息.xlsx"; //下载的文件名
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
  });
}
function handleEdit(data: User) {
  state.user = JSON.parse(JSON.stringify(data));
  state.dialog = true;
}
function handleSelectionChange(users: User[]) {
  state.ids = users.map((u) => u.id) as number[];
}
function handleDelBatch() {
  if (state.ids.length <= 0) {
    msg.warning("请勾选要删除的数据");
    return;
  }
  warningConfirm("是否删除选中的数据", () => {
    request<boolean>({
      url: "/user/del/batch",
      method: "DELETE",
      data: state.ids,
    }).then(
      () => {
        msg.success("批量删除成功");
        load();
      },
      (error) => {
        msg.error(error);
      }
    );
  });
}
function handleDel(id: number) {
  warningConfirm("是否删除该数据", () => {
    request<boolean>({
      method: "DELETE",
      url: "/user/del",
      params: { id },
    }).then(
      () => {
        msg.success("删除成功");
        load();
      },
      (error) => {
        msg.error(error);
      }
    );
  });
}
onMounted(load);
</script>
<style scoped>
.el-table,
.el-row {
  margin-bottom: 15px;
}
.el-form {
  margin: auto;
  max-width: 350px;
}
.ml-5 {
  margin-left: 5px;
}
</style>
