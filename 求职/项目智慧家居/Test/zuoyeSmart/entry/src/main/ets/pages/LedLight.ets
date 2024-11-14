import { router } from '@kit.ArkUI'

@Preview
@Entry
@Component

struct LedLight {

 @State resource: Resource = $r("app.media.BigRedLed")
  @State iled: boolean = false
  build() {
    Column({space:200}) {
      Column(){
      Row() {
        Image($r("app.media.back_white")).onClick(() => {
          router.back()
        }).width('10%').height('8%')
        Text("智能LED灯").fontSize(25).fontColor("#ff3595bf").fontWeight(700).width('60%')
        Text(' ')
      }.justifyContent(FlexAlign.SpaceBetween).width('100%')
      Column() {
        if(this.iled){
          Image($r("app.media.BigRedLed")).width('45%').onClick(()=>{
            this.iled=false
          })
        }else{
          Image($r("app.media.BigGreenLed")).width('45%').onClick(()=>{
            this.iled=true
          })
        }
      }
      }.height("40%").justifyContent(FlexAlign.SpaceAround)

      Column() {
        Grid(){
          GridItem(){
            Column(){
              Image($r("app.media.kitchen")).width('90%').height('20%')
              Row(){
                Text("厨房").fontSize(18).fontColor("#ff7e7474").width('20%')
                Toggle({type: ToggleType.Switch, isOn: false})
                  .width('65%').selectedColor('#ffe0e06f')
              }

            }
          }.width('50%')
          GridItem(){
            Column(){
              Image($r("app.media.Washroom")).width('90%').height('20%')
              Row(){
                Text("卫生间").fontSize(18).fontColor("#ff7e7474")
                Toggle({type: ToggleType.Switch, isOn: false})
                  .width('60%').selectedColor('#ffe0e06f')
              }
            }

          }
          GridItem(){
            Column(){
              Image($r("app.media.Bookroom")).width('90%').height('20%')
              Row(){
                Text("书房").fontSize(18).fontColor("#ff4a4646").width('20%')
                Toggle({type: ToggleType.Switch, isOn: false})
                  .width('65%').selectedColor('#ff71c6c1')
              }
            }

          }
          GridItem(){
            Column(){
              Image($r("app.media.Livingroom")).width('90%').height('20%')
              Row(){
                Text("客厅").fontSize(18).fontColor("#ff4a4646").width('20%')
                Toggle({type: ToggleType.Switch, isOn: false})
                  .width('65%').selectedColor('#ff71c6c1')
              }
            }

          }
          GridItem(){
            Column(){
              Image($r("app.media.Bedroom1")).width('90%').height('20%')
              Row(){
                Text("卧室1").fontSize(18).fontColor("#ff090909").width('30%')
                Toggle({type: ToggleType.Switch, isOn: false})
                  .width('65%').selectedColor('#ff2fa4e7')
              }
            }

          }
          GridItem(){
            Column(){
              Image($r("app.media.Bedroom2")).width('90%').height('20%')
              Row(){
                Text("卧室2").fontSize(18).fontColor("#ff090909").width('30%')
                Toggle({type: ToggleType.Switch, isOn: false})
                  .width('65%').selectedColor('#ff2fa4e7')
              }
            }

          }
        }
        .rowsGap(15)
        .columnsTemplate('1fr 1fr')
        .height('60%')
      }
      }.backgroundImage($r("app.media.LedBackdround"))
    .backgroundImageSize({ width: '100%', height: '100%' })
    .width('100%')
    .height('100%')

    .alignItems(HorizontalAlign.Center)
    .justifyContent(FlexAlign.SpaceBetween)

    }
}