import { promptAction } from '@kit.ArkUI'
@CustomDialog
export default struct AddMsg{
  control:CustomDialogController

  @State startFlag1:boolean=true;
  @State startFlag2:boolean=false;
  @State startFlag3:boolean=true;
  build() {
    Column(){
      Row(){
        Text("提醒和通知")
      }.width("100%").justifyContent(FlexAlign.Center).padding(10)
      Divider().margin({top:10,bottom:10})
      Column(){
        Row(){
          Text("显示预览内容")
          Toggle({type:ToggleType.Switch,isOn:this.startFlag1}).onChange((val)=>{
            this.startFlag1 = val
          })
        }.width("100%").padding(10)// Divider()
        Row(){
          Text("推广消息通知")
          Toggle({type:ToggleType.Switch,isOn:this.startFlag2}).onChange((val)=>{
            this.startFlag2 = val
          })
        }.width("100%").padding(10)// Divider()
        Row(){
          Text("消息声音通知")
          Toggle({type:ToggleType.Switch,isOn:this.startFlag3}).onChange((val)=>{
            this.startFlag3 = val
          })
        }.width("100%").padding(10)// Divider()
      }
      Divider().margin({top:10,bottom:10})
      Row(){
        Button("确定")
          .onClick(()=>{
            promptAction.showToast({message:"点击确认按钮"})
          })

        Button("取消").onClick(()=>{
          this.control.close()
        })
      }.justifyContent(FlexAlign.SpaceEvenly).width("100%").padding(10)


    }.width(300).backgroundColor("#ffebecec")
  }
}


