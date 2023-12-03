import { User } from "@/api/entity";
import { defineStore } from "pinia";
import { reactive } from "vue";

export const useStore = defineStore(
  "main",
  () => {
    const state = reactive({
      user: new User(),
    });
    return { state };
  },
  {
    persist: true,
  }
);
