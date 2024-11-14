
import { router } from '@kit.ArkUI'
import DeviceKitchen, { KitchenType } from '../model/KitchenInfo'

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
@Entry
@Component
@Preview
struct Kitchen {
  @State deviceList:Array<DeviceKitchen> = [
    {
      message1: "状态",message2:"功能", value1:"open", value2:"清洗",name:"洗碗机",icon:$r("app.media.washdevice"),type:KitchenType.DishWasher
    },
    {
      message1: "状态",message2:"除油烟", value1:'close', value2:"50%",name:"抽油烟机",icon:$r("app.media.smokedevice"),type:KitchenType.Extractor
    },
    {
      message1: "状态",message2:"亮度", value1:"open", value2:"50%",name:"智能LED灯",icon:$r("app.media.kitchenled"),type:KitchenType.Kitchen_LedLight
    },
    {
      message1: "状态",message2:"温度", value1:'open', value2:"2℃",name:"冰箱",icon:$r("app.media.icedevice"),type:KitchenType.Fridge
    },
    {
      message1: "状态",message2:"功能", value1:"open", value2:"消毒",name:"消毒柜",icon:$r("app.media.xiaodu")
    },
    {
      message1: "状态",message2:"功能", value1:"close", value2:"煲汤", name:"电饭煲",icon:$r("app.media.dainfanbao")
    },
    {
      message1: "状态",message2:"功能", value1:"close", value2:"绞肉",name:"绞肉机",icon:$r("app.media.jiaorou")
    },
    {
      message1: "状态",message2:"功能", value1:"close", value2:"榨汁",name:"果蔬榨汁机",icon:$r("app.media.zhazhi")
    }
  ]
  build() {
    Column(){
      //TODO 顶部导航条
      Row(){
        Image($r("app.media.u386")).width(30).onClick(()=>{
          router.back()
        })
        Text("厨房").fontSize(20)
        Image($r("app.media.u001")).width(30)
      }.width("100%").justifyContent(FlexAlign.SpaceBetween)
      .padding(5).backgroundColor("#FFF").flexBasis(50)
      //TODO 厨房基本信息显示
      Stack(){
        Image($r("app.media.kitchen")).width("100%").height("30%")
        Column(){
          Row(){
            Text("厨房").itemFont()
            Text("8个设备").itemFont()
          }.width("100%").justifyContent(FlexAlign.SpaceBetween)
          .padding(10)

          Row(){
            Row(){
              Image($r("app.media.u316")).itemIcon()
              Text("30 °C").itemFont()
            }.rowBlock()

            Row(){
              Image($r("app.media.u319")).itemIcon()
              Text("49 %").itemFont()
            }.rowBlock()

            Row(){
              Image($r("app.media.u317")).itemIcon()
              Text("50%").itemFont()
            }.rowBlock()

          }.width(260).justifyContent(FlexAlign.SpaceBetween).padding(5)
        }.height(170).justifyContent(FlexAlign.SpaceBetween).alignItems(HorizontalAlign.Start)
      }
      //TODO 厨房家居内容显示
      Grid(){
        ForEach(this.deviceList,(item:DeviceKitchen)=>{
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
                    if(item.value1 === "open")
                    {
                      Text("关闭").fontColor("#2D7127").fontWeight(700)
                    }else if(item.value1 === "close"){
                      Text("开启").fontColor("#DD4743").fontWeight(700)
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
                Image($r("app.media.u395")).width(8).onClick(()=>{
                  if(item.type === KitchenType.DishWasher){
                    router.pushUrl({url:"pages/Purifier"})
                  }
                  else if(item.type == KitchenType.Extractor){
                    router.pushUrl({url:"pages/LedLight"})
                  }
                  else if(item.type == KitchenType.Kitchen_LedLight){
                    router.pushUrl({url:"pages/DoorLock"})
                  }
                  else if(item.type == KitchenType.Fridge){
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

    }.width("100%").height("100%").backgroundColor("#F8F8F0")
  }
}