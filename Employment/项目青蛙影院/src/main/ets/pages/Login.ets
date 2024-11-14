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
      //标题
      Text("青蛙影院")
        .fontSize(50)
        .margin({
          top: 50,
          bottom: 50
        })
      //用户名输入框
      TextInput({
        placeholder: "请输入用户名"
      })
        .myInput()
        .onChange((value: string) => {
          this.username = value
        })
        .borderRadius(5)
      //密码输入框
      TextInput({
        placeholder: "请输入密码"
      })
        .myInput()
        .onChange((value: string) => {
          this.password = value
        })
        .type(InputType.Password)
      //登录按钮
      Button("Login")
        .width("60%")
        .height(40)
        .onClick((event?: ClickEvent) => {
          //获取用户名和密码
          //校验数据库
          //是否勾选用户协议
          if (!this.isSelect) {
            //弹出对话框进行用户提醒
            AlertDialog.show({
              title: "提示",
              message: "请勾选隐私协议",
              autoCancel: true
            })
            return
          }
          if (this.username == "admin" && this.password == "123456") {
            //跳转
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
        .margin({
          top: 50
        })
      //勾选隐私协议
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