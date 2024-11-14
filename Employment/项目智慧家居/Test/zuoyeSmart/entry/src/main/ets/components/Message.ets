import DeviceMessage from './DeviceMessage'
import SettingMsg from './SettingMsg'

const select_background_color="#FF7733"
const select_font_color="#FFF"
const default_font_color="#000"
@Preview
@Component
export default struct Message{
  @State selectIndex:number=0
  @State backgroundColor0:string=""
  @State fontColor0:string=""
  @State backgroundColor1:string=""
  @State fontColor1:string=""
  changIndex(index:number){
    this.selectIndex=index
    this.backgroundColor0=""
    this.fontColor0=default_font_color
    this.backgroundColor1=""
    this.fontColor1=default_font_color
    if(index===0){
      this.backgroundColor0=select_background_color
      this.fontColor0=select_font_color
    }else if(index===1){
      this.backgroundColor1=select_background_color
      this.fontColor1=select_font_color
    }
  }
  aboutToAppear(){
    this.changIndex(0)
  }
  build(){
    Column(){
      Row(){
        Row(){
          Row(){
            Row(){
              Text("设备消息").fontColor(this.fontColor0)
            }.flexGrow(1).justifyContent(FlexAlign.Center)
            .backgroundColor(this.backgroundColor0).height("100%")
            .borderRadius({topLeft:30,bottomLeft:30})
            .onClick(()=>{
              this.changIndex(0)
            })
            Row(){
              Text("系统消息").fontColor(this.fontColor1)
            }.flexGrow(1).justifyContent(FlexAlign.Center)
            .borderRadius({topRight:30,bottomRight:30})
            .backgroundColor(this.backgroundColor1).height("100%")
            .onClick(()=>{
              this.changIndex(1)
            })
          }.backgroundColor("#EFEEF4").width(180).height(50)
          .borderRadius(30)
        }.flexGrow(1).justifyContent(FlexAlign.Center).margin({left:30})
        Image($r("app.media.setting")).width(30)

      }.width("100%").backgroundColor("#FFF").padding(10)

      if(this.selectIndex===0){
        DeviceMessage()
      }else{
        SettingMsg()
      }

    }.width("100%").height("100%")//endColumn
    .alignItems(HorizontalAlign.Center)
    .backgroundColor("#F8F8F8")
  }
}
