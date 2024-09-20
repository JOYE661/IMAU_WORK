import DeviceMessageEntity from '../Model/DeviceMessageEntity'

@Component
export default struct DeviceMessage{
  @State messageList:Array<DeviceMessageEntity>=[
    {name:'监控摄像机',tips:'监测到可疑目标，请及时查看',time:'上午10:20',readFlag:false},
    {name:'路由器',tips:'网络异常，无法联网，请及时查看',time:'昨天',readFlag:false},
    {name:'监控摄像机',tips:'监测到可疑目标，请及时查看',time:'星期一',readFlag:true},
    {name:'路由器',tips:'网络异常，无法联网，请及时查看',time:'2019/2/11',readFlag:true}
  ]
  build(){
    Column(){
      List(){
        ForEach(this.messageList,(item:DeviceMessageEntity)=>{
          ListItem(){
            Column(){
              Row(){
                Row(){
                  Text(item.name).fontWeight(700)
                  if(!item.readFlag){
                    Text().backgroundColor("#FF7733").width(15).height(15)
                      .borderRadius(15).margin({left:10})
                  }
                }
                Text(item.time).fontColor("#A7A7A7")
              }.width("100%").justifyContent(FlexAlign.SpaceBetween)
              Row(){
                Text(item.tips)
              }.width("100%")
            }.width("95%").padding(10).backgroundColor("#FFF")
            .margin({top:10}).borderRadius(10)
          }//endListItem
        })//endForEach
      }
    }.flexGrow(1).width("100%").alignItems(HorizontalAlign.Center)
  }
}