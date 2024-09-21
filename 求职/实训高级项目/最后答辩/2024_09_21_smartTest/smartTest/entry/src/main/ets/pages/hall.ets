import { router, Type } from '@kit.ArkUI';

@Extend(Text) function itemFont(){
  .fontColor("#FFF")
  .fontSize(20)
}
@Extend(Image) function itemIcon(){
  .width(24)
  .height(24)
}
@Extend(Row) function rowBlock(){
  .width(60)
  .justifyContent(FlexAlign.SpaceBetween)
}
interface DeviceInfo {
  message1: string;
  message2: string;
  value1: string;
  value2: string;
  name: string;
  icon: Resource;
  type?: DeviceType;
}
enum DeviceType {
  Unknown,
  Purifier,
  LedLight,
  DoorLock,
  Kettle
}
@Entry
@Component
struct Hall {
  @State deviceList: Array<DeviceInfo> = [
    {
      message1: '温度',
      message2: '湿度',
      value1: '30°C',
      value2: '40%',
      name: '空气净化器',
      icon: $r('app.media.u316'),
      type: DeviceType.Purifier
    },
    {
      message1: '状态',
      message2: '亮度',
      value1: 'open',
      value2: '50%',
      name: '智能LED灯',
      icon: $r('app.media.u317'),
      type: DeviceType.LedLight
    },
    {
      message1: '状态',
      message2: '功能',
      value1: 'open',
      value2: '运动追踪',
      name: '智能门锁',
      icon: $r('app.media.u445'),
      type: DeviceType.DoorLock
    },
    {
      message1: "状态",
      message2: "温度",
      value1: 'open',
      value2: "70℃",
      name: "电水壶",
      icon: $r("app.media.u446"),
      type: DeviceType.Kettle
    },
    {
      message1: "状态",
      message2: "功能",
      value1: "open",
      value2: "运动追踪",
      name: "智能摄像机",
      icon: $r("app.media.u417")
    },
    {
      message1: "状态",
      message2: "功能",
      value1: "close",
      value2: "运动追踪",
      name: "智能摄像机",
      icon: $r("app.media.u417")
    },
    {
      message1: "状态",
      message2: "连接",
      value1: "open",
      value2: "2个设备",
      name: "WiFi放大器",
      icon: $r("app.media.u433")
    },
    {
      message1: "状态",
      message2: "连接",
      value1: "open",
      value2: "2个设备",
      name: "路由器",
      icon: $r("app.media.u443")
    }
  ]

  build() {
    Column() {
      //顶部导航条
      Row() {
        Image($r('app.media.u386')).width(30).onClick(()=>{
          router.back()
        })
        Text('大厅').fontSize(20)
        Image($r('app.media.u001')).width(30)
      }
      .width('100%')
      .justifyContent(FlexAlign.SpaceBetween)
      .padding(5)
      .backgroundColor("FFF")
      .flexBasis(50)

      //大厅基本信息
      Stack() {
        Image($r('app.media.img_1')).width('100%')
        Column() {
          Row() {
            Text("大厅").itemFont()
            Text("8个设备").itemFont()
          }.width("100%").justifyContent(FlexAlign.SpaceBetween)
          .padding(10)

          Row() {
            Row() {
              Image($r('app.media.u316')).itemIcon()
              Text("30°C").itemFont()
            }.rowBlock()

            Row() {
              Image($r('app.media.u319')).itemIcon()
              Text("40%").itemFont()
            }.rowBlock()

            Row() {
              Image($r('app.media.u317')).itemIcon()
              Text("50%").itemFont()
            }.rowBlock()
          }.width(260).justifyContent(FlexAlign.SpaceBetween).padding(5)
        }.height(170).justifyContent(FlexAlign.SpaceBetween).alignItems(HorizontalAlign.Start)
      }

      //家居模块
      Grid(){
        ForEach(this.deviceList,(item:DeviceInfo)=>{
          GridItem(){
            Column(){
              Row(){
                Row(){
                  Image(item.icon).width(24)
                }.width(35).height(35).backgroundColor("#B0D7F8")
                .borderRadius(20).justifyContent(FlexAlign.Center)
                Column(){
                  Row(){
                    Text(item.message1).fontColor("#BCBCBC")
                    if(item.value1==="open")
                    {
                      Text("开启").fontColor("#2D7127").fontWeight(700)
                    }else if(item.value1==="close"){
                      Text("关闭").fontColor("#DD4743").fontWeight(700)
                    }else{
                      Text(item.value1).fontColor("#BCBCBC")
                    }
                  }.width(100).justifyContent(FlexAlign.SpaceBetween)
                  Row(){
                    Text(item.message2).fontColor("#BCBCBC")
                    Text(item.value2).fontColor("#BCBCBC")
                  }.width(100).justifyContent(FlexAlign.SpaceBetween)
                }.height(55).justifyContent(FlexAlign.SpaceEvenly)
              }.width("100%").justifyContent(FlexAlign.SpaceBetween)
              .padding(10)
              Row(){
                Text(item.name)
                Image($r("app.media.u395")).width(8)
                  .onClick(()=>{
                    if(item.type===DeviceType.Purifier){
                      router.pushUrl({url:"pages/Purifier"})
                    }
                    else if(item.type==DeviceType.LedLight){
                      router.pushUrl({url:"pages/LedLight"})
                    }
                    else if(item.type==DeviceType.DoorLock){
                      router.pushUrl({url:"pages/DoorLock"})
                    }
                    else if(item.type==DeviceType.Kettle){
                      router.pushUrl({url:"pages/Kettle"})
                    }
                  })
              }.width("100%").justifyContent(FlexAlign.SpaceBetween)
              .padding({left:10,right:10,bottom:10})
            }.width(180).height(100).backgroundColor("#FFF")
            .borderRadius(20).margin({top:6,bottom:6})
            .justifyContent(FlexAlign.SpaceAround)
          }
        })
      }.columnsTemplate("1fr 1fr")
    }.width('100%').height('100%').backgroundColor("#F8F8F0")
  }
}
