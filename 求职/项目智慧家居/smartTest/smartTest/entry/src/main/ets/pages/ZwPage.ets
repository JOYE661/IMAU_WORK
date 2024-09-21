import { router } from '@kit.ArkUI'

@Component
@Entry
struct ZwPage{
  @State startFlag1:boolean = false
  @State startFlag2:boolean = false
  @State startFlag3:boolean = false
  build() {
    Column(){
      Row(){
        Image($r("app.media.back_white")).width(25)
          .onClick(()=>{
            router.back()
          })
        Row(){
          Text($r('app.string.Enroll_NewFingerprint')).fontColor("#FFF").fontSize(20).fontWeight(700)
        }.flexGrow(1).justifyContent(FlexAlign.Center).margin({right:25})
      }.backgroundColor("#ff0977ca").width("100%").justifyContent(FlexAlign.SpaceBetween).padding(10)
      Row(){
        Text($r('app.string.first_fingerprint'))
        Toggle({type:ToggleType.Switch,isOn:this.startFlag1}).onChange((val)=>{
          this.startFlag1 = val
        })
      }.block()
      Divider()
      Row(){
        Text($r('app.string.Second_fingerprint'))
        Toggle({type:ToggleType.Switch,isOn:this.startFlag2}).onChange((val)=>{
          this.startFlag2 = val
        })
      }.block()
      Divider()
      Row(){
        Text($r('app.string.Third_fingerprint'))
        Toggle({type:ToggleType.Switch,isOn:this.startFlag3}).onChange((val)=>{
          this.startFlag3 = val
        })
      }.block()
      Divider()
    }.width("100%").height("100%")
  }
}
@Extend(Row) function block(){
  .width("100%")
  .justifyContent(FlexAlign.SpaceBetween)
  .padding(10)
}