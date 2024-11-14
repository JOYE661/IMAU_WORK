import { promptAction, router } from '@kit.ArkUI'
@Extend(Image)function headIcon(){
  .width(40).margin({right:5})
}
@Extend(Text)function headText(){
  .fontSize(25)
}
@Extend(Image)function headRight(){
  .width(20)
}
@Extend(Row)function rowBlock(){
  .width("100%")
  .padding({left:15,right:15,top:15,bottom:15})
  .justifyContent(FlexAlign.SpaceBetween)
}

@Component
export default struct MyInfo {
  @State userName: string = ' '
  control: SwiperController = new SwiperController()
  array: Array<ResourceStr> = [
    $r("app.media.GY"),
    $r("app.media.GYY"),
    $r("app.media.GY"),
  ]
  dotIndicator: DotIndicator = new DotIndicator()

  aboutToAppear(): void {
    this.dotIndicator.itemWidth(15)
      .itemHeight(15)
      .selectedItemWidth(30)
      .selectedItemHeight(15)
      .selectedColor('#ff005eff')
      .color('#ff00ffd9')
  }

  build() {
    Column() {
      Stack({ alignContent: Alignment.Bottom }) {
        Stack({ alignContent: Alignment.Top }) {
          Stack({ alignContent: Alignment.TopEnd }) {
            Image($r("app.media.blue")).width("100%").height(120)
            Image($r("app.media.edit")).width(40)
          }.height("100%").width("100%")
          .onClick(() => {
            router.pushUrl({
              url: 'pages/MyPage',
              params: { 'userName': this.userName }

            })
          });

          Column() {
            Row() {
              Image($r("app.media.avatar")).width(70).margin({ bottom: 7 }).margin(15)
              Column() {
                Text("软通-旺旺").fontColor("#FFF").fontSize(20).margin({ bottom: 7 })
                Text("好好学生，天天向上").fontColor("#FFF").fontSize(20).margin({ bottom: 7 })
              }
            }


            Swiper(this.control) {
              ForEach(this.array, (item: Resource, index) => {
                Image(item).width('100%').height(100)
              })
            }.autoPlay(true).indicator(this.dotIndicator).height(130)
          }.margin({ top: 20 })
        }.width("100%")
        Row() {
          Column() {
            Text("家庭管理")
            Text("3").fontColor("#0064B3")
          }.flexGrow(1).justifyContent(FlexAlign.Center)
          .alignItems(HorizontalAlign.Center)

          Row().backgroundColor("#AAA").flexBasis(1).height("80%")
          Column() {
            Text("当前房间")
            Text("2").fontColor("#0064B3")
          }.flexGrow(1).justifyContent(FlexAlign.Center)
          .alignItems(HorizontalAlign.Center)
        }
        .width("95%")
        .height(60)
        .backgroundColor("#FFF")
        .borderRadius(10)
        .margin({ bottom: 3 })
      }.height(300) //endStack
      Scroll() {
        Column() {
          Row() {
            Row() {
              Image($r("app.media.myinfoListicon")).headIcon()
              Text("健康管理").headText().onClick(() => {
                router.pushUrl({
                  url: 'pages/HealthCenter',
                  params: { 'userName': this.userName }
                })
              })
            }

            Image($r("app.media.right")).headRight()
          }.rowBlock()

          Row() {
            Row() {
              Image($r("app.media.myinfoListicon2")).headIcon()
              Text("版本升级").headText().onClick(() => {
                promptAction.showToast({ message: "已更新到最新版本" })
              })
            }

            Image($r("app.media.right")).headRight()
          }.rowBlock()

          Row() {
            Row() {
              Image($r("app.media.myinfoListicon3")).headIcon()
              Text("帮助中心").headText().onClick(() => {
                router.pushUrl({
                  url: 'pages/HelpCenter',
                  params: { 'userName': this.userName }

                })
              })
            }

            Image($r("app.media.right")).headRight()
          }.rowBlock()

          Row() {
            Row() {
              Image($r("app.media.KF")).headIcon()
              Text("客服中心").headText().onClick(() => {
                router.pushUrl({
                  url: 'pages/Customer',
                  params: { 'userName': this.userName }

                })
              })
            }

            Image($r("app.media.right")).headRight()
          }.rowBlock()

          Row() {
            Row() {
              Image($r("app.media.myinfoListicon6")).headIcon()
              Text("关于我们").headText().onClick(() => {
                router.pushUrl({
                  url: 'pages/AboutPage',
                  params: { 'userName': this.userName }
                })
              })
            }

            Image($r("app.media.right")).headRight()
          }.rowBlock()

          Row() {
            Row() {
              Image($r("app.media.myinfoListicon5")).headIcon()
              Text("清理缓存").headText().onClick(() => {
                promptAction.showDialog({ message: "角色分配" })
              })
                .onClick(() => {
                  promptAction.showDialog({
                    message: "是否全部清除", buttons: [
                      { text: "确定", color: "#00F" },
                      { text: "取消", color: "#00F" }
                    ]
                  }).then((rst: promptAction.ShowDialogSuccessResponse) => {
                    promptAction.showToast({ message: rst.index + "" })
                  })
                })
            }

            Image($r("app.media.right")).headRight()
          }.rowBlock()
          Row() {
            Row() {
              Image($r("app.media.MDLL")).headIcon()
              Text("免登录").headText().onClick(() => {
                router.pushUrl({
                  url: 'pages/Index',
                  params: { 'userName': this.userName }
                })
              })
            }
            Image($r("app.media.right")).headRight()
          }.rowBlock()
          Row() {
            Row() {
              Image($r("app.media.ZX")).headIcon()
              Text("注销登录").headText().onClick(() => {
                router.pushUrl({
                  url: 'pages/Login',
                  params: { 'userName': this.userName }
                })
              })
            }
            Image($r("app.media.right")).headRight()
          }.rowBlock()
        }
      }.layoutWeight(1)
    }
  }
}