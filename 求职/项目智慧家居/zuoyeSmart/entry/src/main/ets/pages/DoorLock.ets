import { router } from '@kit.ArkUI'
@Extend(Button) function deviceCarType(fontColor:string,borderColor:string){
  .type(ButtonType.Circle)
  .width(140)
  .backgroundColor("#1dffffff")
  .fontColor(fontColor)
  .border({width:3,color:borderColor })
  .fontSize(20)
  .fontWeight(700)
}
@Preview
@Entry
@Component
struct DoorLock {
  @State message: string = '智能门锁'

  build() {
    Row() {
      Column() {
        //TODO 顶部导航
        Row(){
          Image($r("app.media.u386")).width(40).onClick(()=>{
            router.back()
          })
          Text("智能指纹防盗锁").fontSize(20)
          Row(){
            Image($r("app.media.share")).width(30)
            Image($r("app.media.more")).width(50)
          }
        }.backgroundColor("#d8e7d1").justifyContent(FlexAlign.SpaceBetween)
        .width("100%").padding(10)

        //TDO 门锁LOGO
        Image($r("app.media.lock")).width("100%")
        //TODO 门锁状态
        Column(){
          Row(){
            Text("设备状态已连接").fontSize(20).fontWeight(700)
          }.padding(10).backgroundColor("#ffbde0e5").border({radius:{topLeft:20,topRight:20}})
          .width("100%").justifyContent(FlexAlign.Center)
          Stack(){
            Image($r("app.media.img_1")).border({radius:{bottomLeft:20,bottomRight:20}})
            Column(){
              Row(){
                Button("开门记录").deviceCarType("#FFF", "#175A08")
                Button("报修").deviceCarType("#FFF","#DBC30F")
              }.width("100%").justifyContent(FlexAlign.SpaceBetween)

              Row(){
                Button("录入新指纹").deviceCarType("#FFF","#51ABD6")
                Button("劫持报警").deviceCarType("#FFF","#F30006")
              }.width("100%").justifyContent(FlexAlign.SpaceBetween)

            }.height(300).width(310).justifyContent(FlexAlign.SpaceBetween)
          }.height(362).width("100%")

        }.width("95%").height(400).margin(10)

      }
      .width('100%')
    }
    .height('100%')
  }
}
