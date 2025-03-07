// 上传
export async function uploadFile(option,onUploadProgress) {
  const type = option.file.type //文件类型
  let formData = new FormData()
  formData.append("file", option.file)
  let url
  console.log(type)
  if (type == 'image/png' || type == 'image/jpeg') {
    url = "/api-mall/admin/api/v1/products/uploadfile"
  } else if (type == 'video/mp4') {
    this.$message.warning("不支持该格式的文件")
    option.onError()
    return
  } else {
    this.$message.warning("不支持该格式的文件")
    option.onError()
    return
  }
  const res = await this.$request.post(url, formData, { headers: { "Content-Type": "multipart/form-data" },onUploadProgress})
  if (res.data.code === 200) {
    option.onSuccess(res.data.data)
    return res.data.data
  } else {
    option.onError()
    return
  }
}