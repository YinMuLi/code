<template>
  <svg class="icon" aria-hidden="true">
    <use :xlink:href="getIconName()" />
  </svg>
</template>
<script setup lang="ts">
const props = defineProps<{
  iconRef: string;
}>();
function getIconName() {
  return `#${props.iconRef}`;
}
</script>
<style>
/* 阿里图标整体样式 */
.icon {
  width: 1em;
  height: 1em;
  vertical-align: -0.15em;
  fill: currentColor;
  overflow: hidden;
  font-size: 20px;
}
</style>
