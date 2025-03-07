<template>
  <div style="display:flex;flex-wrap: wrap;">
    <div class="image-item" :style="{ width: size, height: size }" v-for="(pItem,pIndex) in modelValue" :key="pIndex">
      <img :src="pItem" style="width:100%;height:100%;" />
      <span class="item-actions" @click.stop="deleteItem(pIndex)">
        <el-icon>
          <Delete />
        </el-icon>
      </span>
    </div>
    <el-upload class="avatar-uploader" action="" :show-file-list="false"
    :http-request="(option) => { $uploadFile(option) }" :on-success="onsuccess">
    <div class="f-c-c" :style="{ width: size, height: size }">
      <el-icon class="avatar-uploader-icon">
        <el-icon>
          <plus />
        </el-icon>
      </el-icon>
    </div>
  </el-upload>
  </div>
</template>

<script>
export default {
  props: {
    modelValue: {
      type: Array,
      default: () => [],
    },
    size: {
      type: String,
      default: "90px",
    },
  },
  data() {
    return {}
  },
  created() {

  },
  methods: {
    onsuccess(url) {
      if (url) {
        let pics = this.$deepClone(this.modelValue)
        pics.push(url)
        this.$emit('update:modelValue', pics)
      }
    },
    deleteItem(index){
      let pics = this.$deepClone(this.modelValue)
      pics.splice(index,1)
      this.$emit('update:modelValue', pics)
    }
  },
};
</script>

<style scoped>
.f-c-c {
  display: flex;
  justify-content: center;
  align-items: center;
}

.item-actions {
  position: absolute;
  width: 100%;
  height: 100%;
  left: 0;
  top: 0;
  cursor: default;
  display: inline-flex;
  justify-content: center;
  align-items: center;
  color: #fff;
  opacity: 0;
  font-size: 20px;
  background-color: rgba(0, 0, 0, 0.5);
  transition: opacity .3s;
}

.item-actions:hover {
  opacity: 1;
}
.image-item{
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
  margin-right: 5px;
  margin-bottom: 5px;
}
</style>

<style>
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  text-align: center;
}
</style>