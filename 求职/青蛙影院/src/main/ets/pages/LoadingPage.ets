import router from '@ohos.router'
@Entry
@Component
struct LoadingPage {
  build() {
    Column() {
      Text("正在登录...")
        .fontSize(30)
        .fontWeight(FontWeight.Bold)
        .width("90%")
        .textAlign(TextAlign.Center)
        .margin({
          top: 50
        })
      // 过渡组件
      LoadingProgress()
        .width("50%")
        .height("50%")
        .color(Color.Blue)
    }.width("100%")
    .height("100%")
  }
  //重写父类的方法
  onPageShow(){
    // setTimeout(()=>{}, 5000)
    setTimeout(()=>{
      router.pushUrl({
        url: "pages/MainPage"
      })
    }, 5000)
  }
}