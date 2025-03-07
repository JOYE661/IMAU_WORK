<template>
  <el-drawer ref="elDrawer" v-bind="$attrs">
    <slot></slot>
    <template #footer>
      <div class="drawer-footer">
        <div></div>
        <div>
          <slot name="footer"></slot>
        </div>
      </div>
    </template>
  </el-drawer>
</template>

<script>
export default {
  props: {},
  data() {
    return {};
  },
  created() {},
  methods: {
    handleClose() {
      this.$refs.elDrawer.handleClose();
    },
  },
};
</script>

<style>
.el-drawer__header {
  margin-bottom: 0;
}
.el-drawer__footer {
  padding: 0;
}
</style>
<style scoped>
.drawer-footer {
  position: sticky;
  bottom: 0;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 11px 24px;
  background-color: #fff;
  box-shadow: 0 -2px 9px rgba(153, 169, 191, 0.17);
}
</style>