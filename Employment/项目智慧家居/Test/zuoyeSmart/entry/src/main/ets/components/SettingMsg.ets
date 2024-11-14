import SettingMsgEntity from '../Model/SettingMsgEntity'

@Component
export default struct SettingMsg{
  @State settingMsgList:Array<SettingMsgEntity>=[
    {title:'今天又有优惠活动喔！',text:'新品家居上市，买一送二，绝不后悔！',time:'04月18日',imgSrc:$r("app.media.messageImg1")},
    {title:'今天又有优惠活动喔！',text:'新品家居上市，买一送二，绝不后悔！',time:'04月19日',imgSrc:$r("app.media.messageImg2")}
  ]
  build(){
    Column(){
      List(){

        ForEach(this.settingMsgList,(item:SettingMsgEntity)=>{
          ListItem(){
            Column(){
              Text(item.time).margin({top:10,bottom:10})
                .fontColor("#A7A7A7")
              Column(){
                Text(item.title)
                Image(item.imgSrc).width("100%")
                Text(item.text)
              }.backgroundColor("#FFF").width("100%")
              .height(220).alignItems(HorizontalAlign.Start)
              .padding(15).justifyContent(FlexAlign.SpaceEvenly)
            }.width("100%").margin({bottom:20})
          }//endListItem
        })//endForEach
      }
    }.width("100%").height("100%")//endColumn
    .alignItems(HorizontalAlign.Center)
    .backgroundColor("#F8F8F8")
  }
}