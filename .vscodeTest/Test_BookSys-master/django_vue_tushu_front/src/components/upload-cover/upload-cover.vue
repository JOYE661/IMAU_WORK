<template>
  <el-upload action="" :disabled="!!modelValue || (percentage === 0 ? false : true)" :http-request="httpRequest"
    :style="{ height: height }" class="upload-cover" :show-file-list="false">
    <template #trigger>
      <div class="f-c-c" style="height: 100%;width: 100%;" v-if="!modelValue">
        <div v-if="percentage === 0" style="font-size: 28px;color: #8c939d;text-align: center;">
          <el-icon>
            <Camera />
          </el-icon>
          <div style="font-size: 14px;color: #919ead;">上传图片</div>
        </div>
        <div v-else style="width: 100%;padding: 10px;text-align: center;">
          <el-progress :type="progressType" :percentage="percentage" :width="progressWidth" :text-inside="progressType == 'circle' ? false : true" :stroke-width="progressType == 'circle' ? 6 : 18" />
        </div>
      </div>
      <div v-else class="has-img f-c-c" style="height: 100%;width: 100%;position: relative;">
        <el-image :src="modelValue" :style="imageStyle" />
        <div class="mask f-c-c">
          <div style="cursor: pointer;" @click.stop="showImageViewer = true">
            <el-icon>
              <ZoomIn />
            </el-icon>
          </div>
          <div style="cursor: pointer; margin-left: 16px;" @click.stop="$emit('update:modelValue', '')">
            <el-icon>
              <Delete />
            </el-icon>
          </div>
        </div>
      </div>
    </template>
  </el-upload>

  <el-image-viewer v-if="showImageViewer" teleported :url-list="[modelValue]" @close="showImageViewer = false" />
</template>

<script>
export default {
  props: {
    modelValue: {
      type: String,
      default: "",
    },
    height: {
      type: String,
      default: "135px",
    },
    progressWidth:{
      type: Number,
      default: 100,
    },
    progressType:{
      type: String,
      default: "circle",
    },
    imageStyle: {
      type: String,
      default: "width:100%;height:100%;",
    }
  },
  data() {
    return {
      percentage: 0,
      showImageViewer: false,
    };
  },
  created() {

  },
  methods: {
    async httpRequest(options) {
      try {
        const url = await this.$uploadFile(options, this.onUploadProgress)
        this.$emit('update:modelValue', url)
        this.percentage = 0
      } catch (error) {
        this.percentage = 0
      }
    },
    onUploadProgress(progress) {
      this.percentage = +(progress.progress * 100 - 1).toFixed(0)
    },
  },
};
</script>

<style>
.upload-cover>.el-upload--text {
  display: flex !important;
  height: 100% !important;
}
</style>
<style scoped>
.f-c-c {
  display: flex;
  justify-content: center;
  align-items: center;
}

.upload-cover {
  background-color: rgb(145, 158, 171, 0.08);
  border-radius: 6px;
  overflow: hidden;
  box-sizing: border-box;
}

.mask {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  opacity: 0;
  transition: opacity .3s;
  color: #fff;
  background-color: rgba(0, 0, 0, 0.5);
  font-size: 20px;
  cursor: default;
}

.has-img:hover .mask {
  opacity: 1;
}
</style>