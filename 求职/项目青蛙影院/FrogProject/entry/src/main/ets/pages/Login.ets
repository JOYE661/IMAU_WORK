import router from '@ohos.router'
@Styles function myInput(){
  .width("80%")
  .height(40)
  .margin({
    top: 10,
    bottom: 10
  })
  .backgroundColor(Color.White)
}
@Entry
@Component
struct Login {
  @State username: string = ""
  @State password: string = ""
  @State isSelect: boolean = false
  build() {
    Column() {
      Text("青蛙影院")
        .fontSize(50)
        .margin({
          top: 50,
          bottom: 50
        })
      TextInput({
        placeholder: "请输入用户名"})
        .myInput()
        .onChange((value: string) => {
          this.username = value
        })
        .borderRadius(5)
      TextInput({
        placeholder: "请输入密码"
      })
        .myInput()
        .onChange((value: string) => {
          this.password = value
        })
        .type(InputType.Password)
      Button("Login")
        .width("60%")
        .height(40)
        .onClick((event?: ClickEvent) => {
          if (!this.isSelect) {
            AlertDialog.show({
              title: "提示",
              message: "请勾选隐私协议",
              autoCancel: true
            })
            return
          }
          if (this.username == "admin" && this.password == "123456") {
            router.pushUrl({
              url: "pages/LoadingPage"
            })
          } else {
            AlertDialog.show({
              title: "提示",
              message: "用户名或密码错误",
              autoCancel: true
            })
          }
        })
        .margin({ top: 50 })
      Row({
        space: 5
      }) {
        Checkbox()
          .select(this.isSelect)
          .onChange((value: boolean) => {
            this.isSelect = value
          })
        Text("请勾选隐私协议").fontColor(Color.White)
      }.margin({
        top: 20
      })
    }.width("100%")
    .height("100%")
    .backgroundImage($r('app.media.frog'))
    .backgroundImageSize(ImageSize.Cover)
  }
}