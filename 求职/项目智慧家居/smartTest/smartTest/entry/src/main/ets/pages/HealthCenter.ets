import { router } from '@kit.ArkUI'

@Component
@Entry
export default struct HealthCenter{
  @State startFlag:boolean = true
  @State roleFlag:boolean = true
  @State stopFlag:boolean = true
  build() {
    Column(){
      Row(){
        Text("<").width(35).fontSize(30).onClick(() => {
          router.back(); // 使用 router.back() 返回上一个页面
        });
        Row(){
          Text("健康管理").fontSize(30).fontWeight(700).fontColor("#FFF")
        }.justifyContent(FlexAlign.Center).width('90%')

      }.width("100%").justifyContent(FlexAlign.SpaceBetween).backgroundColor("#ff158528").padding(
        10)
      Row(){
        Text("运动记录").fontSize(18)
        Toggle({type:ToggleType.Switch,isOn:this.startFlag}).onChange((val)=>{
          this.startFlag = val
        })
      }.block()
      Divider()
      Row(){
        Text("站立时间").fontSize(18)
        Text(this.startFlag + "")
      }.block()
      Divider()
      Row(){
        Text("切换模式").fontSize(18)
        Toggle({type:ToggleType.Checkbox,isOn:this.roleFlag}).onChange((val)=>{
          this.roleFlag = val
        })
      }.block()
      Divider()
      Row(){
        Text("记录模式").fontSize(18)
        Text(this.roleFlag + "")
      }.block()
      Divider()
      Row(){
        Text("是否停止").fontSize(18)
        Toggle({type:ToggleType.Button,isOn:this.stopFlag}).onChange((val)=>{
          this.stopFlag = val
        }).height(20).width(40).selectedColor("#ff4f95cb").backgroundColor("#888")
      }.block()
      Divider()
      Row(){
        Text("状态").fontSize(18)
        Text(this.stopFlag + "")
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