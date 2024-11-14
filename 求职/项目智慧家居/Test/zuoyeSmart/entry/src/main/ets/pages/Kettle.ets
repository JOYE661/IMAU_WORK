import { router } from '@kit.ArkUI'
@Preview
@Entry
@Component
struct Kettle {
  private settings: RenderingContextSettings = new RenderingContextSettings(true)
  private context: CanvasRenderingContext2D = new CanvasRenderingContext2D(this.settings)
  private offContext: OffscreenCanvasRenderingContext2D = new OffscreenCanvasRenderingContext2D(1700, 1200, this.settings)

  build() {


    Column() {
      //TODO 顶部导航
      Row() {
        Image($r("app.media.back_white")).width(30).onClick(() => {
          router.back()
        })
        Text("电水壶").fontSize(20).fontColor("#FFF").fontWeight(700)
        Image($r("app.media.more")).width(50)
      }.width("100%").padding(10).backgroundColor("#ff0586f3")
      .justifyContent(FlexAlign.SpaceBetween)

      //TODO 水的温度
      Stack() {
        Canvas(this.context)
          .width('100%')
          .height('100%')
          .onReady(() => {
            let grad = this.offContext.createLinearGradient(0, 0, 0, 400)
            grad.addColorStop(0.0, '#319FFE')
            grad.addColorStop(1, '#FFF')
            this.offContext.fillStyle = grad
            this.offContext.fillRect(0, 0, 700, 700)
            let image = this.offContext.transferToImageBitmap()
            this.context.transferFromImageBitmap(image)
          })
        Column() {
          Text("39℃").fontSize(50).fontWeight(700).fontColor("#FFF")
          Text("空闲中").fontSize(25).fontColor("#FFF").margin({ top: 20 })
        }
      }.width("100%").flexBasis(400)

      //TODO 保温信息
      Column() {
        Row() {
          Row() {
            Image($r("app.media.clock")).width(30)
          }.justifyContent(FlexAlign.Center).flexBasis(90)

          Column() {
            Text("保温时长").fontSize(20)
            Text("持续保温2小时").fontColor("#CFCFCF")
            Progress({ value: 2, total: 12 }).width(300)
            Row() {
              Text("0小时")
              Text("12小时")
            }.width(270).justifyContent(FlexAlign.SpaceBetween)
          }.flexGrow(1).alignItems(HorizontalAlign.Start)
          .justifyContent(FlexAlign.SpaceBetween).height(100)

        }.width("100%").alignItems(VerticalAlign.Top).flexBasis(100)

        Row() {
          Row() {
            Image($r("app.media.temp")).width(30)
          }.justifyContent(FlexAlign.Center).flexBasis(90)

          Column() {
            Text("保温温度").fontSize(20)
            Text("最佳温度50℃").fontColor("#CFCFCF")
            Row() {
              Column() {
                Row() {
                  Image($r("app.media.temperature90")).width(30)
                }.width(50).height(50).border({ width: 1, radius: 25, color: "#E0E1E2" })
                .justifyContent(FlexAlign.Center)

                Text("90℃").margin({ top: 10 })
              }.flexGrow(1).justifyContent(FlexAlign.Center)

              Column() {
                Row() {
                  Image($r("app.media.temperature80")).width(30)
                }.width(50).height(50).border({ width: 1, radius: 25, color: "#E0E1E2" })
                .justifyContent(FlexAlign.Center)

                Text("80℃").margin({ top: 10 })
              }.flexGrow(1).justifyContent(FlexAlign.Center)

              Column() {
                Row() {
                  Image($r("app.media.temperature70")).width(30)
                }.width(50).height(50).border({ width: 1, radius: 25, color: "#E0E1E2" })
                .justifyContent(FlexAlign.Center)

                Text("70℃").margin({ top: 10 })
              }.flexGrow(1).justifyContent(FlexAlign.Center)

              Column() {
                Row() {
                  Image($r("app.media.temperature60")).width(30)
                }.width(50).height(50).border({ width: 1, radius: 25, color: "#E0E1E2" })
                .justifyContent(FlexAlign.Center)

                Text("自定义").margin({ top: 10 })
              }.flexGrow(1).justifyContent(FlexAlign.Center)

            }.width(270).justifyContent(FlexAlign.SpaceBetween)

          }.alignItems(HorizontalAlign.Start).flexGrow(1)
          .justifyContent(FlexAlign.SpaceBetween).height(140)

        }.width("100%").alignItems(VerticalAlign.Top)

      } // end Column
      .flexGrow(1).justifyContent(FlexAlign.SpaceAround)

    }.width("100%").height("100%").justifyContent(FlexAlign.SpaceBetween)
  }
}