import type {
  AxiosError,
  AxiosInstance,
  AxiosRequestConfig,
  AxiosResponse,
} from "axios";
import axios from "axios";
import mitt from "mitt";
const instance: AxiosInstance = axios.create({
  baseURL: "http://localhost:8080",
  timeout: 5000,
});
instance.interceptors.response.use(
  (response: AxiosResponse) => {
    let result = response.data;
    if (response.status == 200 && result.code == 200 && result.data != null) {
      return result.data;
    }
    return Promise.reject(result.msg);
  },
  (error: AxiosError) => Promise.reject(error.message)
);
export function request<T>(config: AxiosRequestConfig): Promise<T> {
  return instance.request(config);
}
export const smAxios: AxiosInstance = axios.create({
  baseURL: "/sm",
  method: "POST",
  headers: {
    "Content-Type": "multipart/form-data",
    Authorization: "bp1atFgX3FXqj61Ah8GrZfTIc3gkYdkH",
  },
});
export const blankAxios: AxiosInstance = axios.create({
  method: "POST",
});
// 全局事件总线
export const mitter = mitt();
// 消息框
export const msg = {
  success: function (message: string) {
    ElMessage({
      message,
      type: "success",
      grouping: true,
    });
  },
  error: function (message: string) {
    ElMessage({
      message,
      type: "error",
      grouping: true,
    });
  },
  warning: function (message: string) {
    ElMessage({
      message,
      type: "warning",
      grouping: true,
    });
  },
};
// 警告确认框
export function warningConfirm(msg: string, fun: Function) {
  ElMessageBox.confirm(msg, "警告", {
    confirmButtonText: "确认",
    cancelButtonText: "取消",
    type: "warning",
    center: true,
  }).then(() => {
    fun();
  });
}
export const store = {
  set(key: string, value: any) {
    window.localStorage.setItem(key, JSON.stringify(value));
  },
  get<T>(key: string) {
    const json: any = localStorage.getItem(key);
    return JSON.parse(json) as T;
  },
  remove(key: string) {
    localStorage.removeItem(key);
  },
  clear() {
    localStorage.clear();
  },
};
export const utils = {
  /**
   * 深拷贝对象
   */
  copy<T>(data: T) {
    return JSON.parse(JSON.stringify(data));
  },
};
