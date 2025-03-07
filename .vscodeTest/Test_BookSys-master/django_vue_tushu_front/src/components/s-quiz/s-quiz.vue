<template>
  <el-drawer ref="elDrawer" v-bind="$attrs" :with-header="false">
    <div class="document-title">问卷内容:</div>
    <div v-for="(qItem,qIndex) in quiz.answers" :key="qIndex" class="document">
      <div class="q-title">{{qIndex+1}}.{{qItem.text}}</div>
      <div class="q-option">
        用户选项:
        <el-tag style="margin-right:5px;" size="small" v-for="(oItem,oIndex) in qItem.options" :key="oIndex">{{oItem.text}}</el-tag>
      </div>
    </div>
    <div class="document-title">推荐商品：</div>
    <div v-for="(pItem,pIndex) in quiz.products" :key="pIndex" class="q-option" style="margin-bottom:5px;">
      {{`商品ID:${pItem.productId}-商品名:${pItem.title}`}}
    </div>
  </el-drawer>
</template>

<script>
export default {
  props: {
    quiz: {
      type: Object,
      default: () => {},
    },
  },
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

<style scoped>
.document-title {
  font-size: 16px;
  font-weight: 700;
  margin: 30px 0 20px 0;
}
.document-title:first-child{
  margin-top:0;
}
.q-title{
  font-size: 14px;
  margin: 10px 0;
  color: #333;
}
.q-option{
  padding-left: 1em;
  color: #949494;
}
</style>