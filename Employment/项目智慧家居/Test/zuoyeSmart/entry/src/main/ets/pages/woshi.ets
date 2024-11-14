//TODO扩展样式
import { router } from '@kit.ArkUI'
import { BedroomDevice } from '../model/BedroomDevice'

@Extend(Text)function itemFont(){
  .fontColor("#ffffffff")
  .fontSize(20)
}
@Extend(Image)function itemIcon(){
  .width(24)
  .height(24)
}
@Extend(Row)function rowBlock(){
  .width(60)
  .justifyContent(FlexAlign.SpaceBetween)
}

@Entry
@Component
struct Index {
  @State deviceList: Array<BedroomDevice> = [
    {
      deviceId: "1",
      message: "状态",
      value:"close",
      name: "床头灯1",
      icon: $r("app.media.BedLight")
    },
    {
      deviceId: "1",
      message: "状态",
      value:"open",
      name: "床头灯2",
      icon: $r("app.media.BedLight")
    },
    {
      deviceId: "1",
      message: "状态",
      value:"open",
      name: "空调",
      icon: $r("app.media.Air")
    },
    {
      deviceId: "1",
      message: "状态",
      value:"close",
      name: "窗帘",
      icon: $r("app.media.Curtain")
    },
    {
      deviceId: "1",
      message: "状态",
      value:"close",
      name: "投影仪",
      icon: $r("app.media.Projector")
    },
    {
      deviceId: "1",
      message: "状态",
      value:"close",
      name: "加湿器",
      icon: $r("app.media.Water")
    },
    {
      deviceId: "1",
      message: "状态",
      value:"open",
      name: "香薰",
      icon: $r("app.media.Humidifier")
    },
    {
      deviceId: "1",
      message: "状态",
      value:"open",
      name: "音响",
      icon: $r("app.media.Sound")
    }
  ]

  build() {
    Column() {
      //TODO顶部导航条
      Row() {
        Image($r("app.media.u386")).width(30)
          .onClick(() => {
            router.back()
          })
        Text("卧室").fontSize(20)
        Image($r("app.media.u001")).width(30)
      }
      .width("100%")
      .justifyContent(FlexAlign.SpaceBetween)
      .padding(5)
      .backgroundColor("#FFF")
      .flexBasis(50)

      //TODO大厅基本信息显示
      Stack() {
        Image($r("app.media.bedroom")).width("100%").height("30%")
        Column() {
          Row() {
            Text("卧室").itemFont()
            Text("8个设备").itemFont()
          }.width("100%").justifyContent(FlexAlign.SpaceBetween)
          .padding(10)

          Row() {
            Row() {
              Image($r("app.media.u316")).itemIcon()
              Text("25°C").itemFont()
            }.rowBlock()
            Row() {
              Image($r("app.media.u317")).itemIcon()
              Text("50%").itemFont()
            }.rowBlock()
            Row() {
              Image($r("app.media.u319")).itemIcon()
              Text("60%").itemFont()
            }.rowBlock()
          }.width(260).justifyContent(FlexAlign.SpaceBetween).padding(5)
        }.height(170).justifyContent(FlexAlign.SpaceBetween).alignItems(HorizontalAlign.Start)
      }

      Grid(){
        ForEach(this.deviceList,(item:BedroomDevice)=>{
          GridItem(){
            Column(){
              Row(){
                Row(){
                  Image(item.icon).width(24)
                }.width(35).height(35).backgroundColor("#B0D7F8")
                .borderRadius(20).justifyContent(FlexAlign.Center)
                Column(){
                  Row(){
                    Text(item.message).fontColor("#ff584f4f")
                    if(item.value==="open")
                    {
                      Text("开启").fontColor("#2D7127").fontWeight(700)
                    }else if(item.value==="close"){
                      Text("关闭").fontColor("#DD4743").fontWeight(700)
                    }else{
                      Text(item.value).fontColor("#BCBCBC")
                    }
                  }.width(100).justifyContent(FlexAlign.SpaceBetween)

                }.height(55).justifyContent(FlexAlign.SpaceEvenly)
              }.width("100%").justifyContent(FlexAlign.SpaceBetween)
              .padding(10)
              Row(){
                Text(item.name)
                Image($r("app.media.u395")).width(8)
              }.width("100%").justifyContent(FlexAlign.SpaceBetween)
              .padding({left:10,right:10,bottom:10})
            }.width(180).height(100).backgroundColor("#FFF")
            .borderRadius(20).margin({top:6,bottom:6})
            .justifyContent(FlexAlign.SpaceAround)
          }
        })
      }.columnsTemplate("1fr 1fr")

      //TODO大厅家居内容显示
    }.width("100%").height("100%").backgroundColor("#F8F8F0")
  }
}