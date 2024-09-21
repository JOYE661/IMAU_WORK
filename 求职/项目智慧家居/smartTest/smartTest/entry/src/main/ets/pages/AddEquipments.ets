import webSocket from '@ohos.net.webSocket'

import { router } from '@kit.ArkUI'
const WS_BASE_URL:string='ws://1.92.113.192:8090/api'

@Entry
@Preview
@Component
export default struct AddEquipments {

  @State dvcUuid: string = 'aa1'
  ws:webSocket.WebSocket=null!

  build() {
    Column() {
      Row() {
        Image($r('app.media.u386')).width(30).onClick(()=>{
          router.back()
        })
        Text('添加设备').fontSize(20)
        Row().width(30)
      }
      .width('100%')
      .justifyContent(FlexAlign.SpaceBetween)
      .padding(5)
      .backgroundColor("FFF")
      .flexBasis(50)


      Column() {

        Row() {
          Column() {
            Text($r("app.string.my_family")).fontSize(18).fontWeight(700)
            Text($r("app.string.devices_number")).fontSize(12).fontColor('#9999')
          }.alignItems(HorizontalAlign.Start)

          Image($r('app.media.add')).width(40).onClick(()=>{
            router.pushUrl({
              url:"pages/AddRoomPage"
            })
          })
        }
        .width('100%')
        .justifyContent(FlexAlign.SpaceBetween)
        .height(60)
        .alignItems(VerticalAlign.Center)
        .padding({ left: 10, right: 10 })
        .backgroundColor('#e8ffffff')
      }

      Column() {
        Column() {
          Image($r('app.media.home_big')).width(110)
          Text($r("app.string.addEquipments_string1")).fontSize(18).fontColor('#666')
          Text($r("app.string.addEquipments_string2")).fontSize(11).fontColor('#999')
          Button($r("app.string.addEquipments_string3")).width(180).onClick(()=>{
            router.pushUrl({
              url:"pages/hall"
            })
          })
        }.height(300).justifyContent(FlexAlign.SpaceEvenly)
      }.flexGrow(1)
      .width('100%')
      .justifyContent(FlexAlign.Center)
      .alignItems(HorizontalAlign.Center)


    }.width('100%')
    .height('100%')
    .backgroundColor('#F8F8F8')
  }
}
