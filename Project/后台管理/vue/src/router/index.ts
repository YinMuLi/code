import { createRouter, createWebHashHistory } from "vue-router";
export default createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: "/back",
      component: () => import("@/views/Manage.vue"),
      redirect: "/home",
      children: [
        {
          path: "/user",
          name: "用户管理",
          component: () => import("@/components/UserManagement.vue"),
        },
        {
          path: "/home",
          name: "首页",
          component: () => import("@/components/Home.vue"),
        },
        {
          path: "/profile",
          name: "个人简介",
          component: () => import("@/components/Profile.vue"),
        },
      ],
    },
    {
      path: "/",
      component: () => import("@/views/Show.vue"),
      redirect: "/login",
      children: [
        {
          path: "/login",
          component: () => import("@/components/Login.vue"),
        },
        {
          path: "/register",
          component: () => import("@/components/Register.vue"),
        },
      ],
    },
  ],
});
