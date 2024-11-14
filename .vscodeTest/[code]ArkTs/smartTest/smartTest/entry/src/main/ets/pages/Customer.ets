import { http, webSocket } from '@kit.NetworkKit'
import { Constant } from '../model/Constant'
import { promptAction, router } from '@kit.ArkUI'


class ChatRspEntity{
  msg:string = ""
  success:boolean = false
  description =  ""

}
@Entry
@Component
export default struct Customer{
  @State userIdArray:Array<SelectOption> = [
    {value:"客服1"},
    {value:"客服2"},
    {value:"客服3"},
  ]
  @State selectUserId:string = "service"
  @State selectIndex:number = 0
  @State sendMsg:string = "满意"
  @State charMsgArray:Array<string> = []

  ws:webSocket.WebSocket = webSocket.createWebSocket()

  httpRequest:http.HttpRequest  = http.createHttp();
  sendMsgHttp(){

    this.httpRequest.request(
      Constant.httpUrl+"/api/chat/room/sendMsg",
      {
        method: http.RequestMethod.POST,
        header:{
          'Content-Type': 'application/x-www-form-urlencoded'
        },
        extraData:`id=${this.selectUserId}&message=${this.sendMsg}`
      }
    ).then((data)=>{
      console.info("chatSocketServer request result:" + JSON.stringify(data.result))
    }).catch((err:Object)=>{
      console.info("chatSocketServer request err:" + JSON.stringify(err))
    })
  }

  webSocket(){
    // let ws:webSocket.WebSocket = webSocket.createWebSocket()

    this.ws.close()
    this.ws =  webSocket.createWebSocket()

    this.ws.on("open",(err,data)=>{
      if(err){
        console.info('chatSocketServer open fail:' + JSON.stringify(err) + " data:"
          + JSON.stringify(data))
        return;
      }

      console.info('chatSocketServer open success:'
        + JSON.stringify(data))
    })

    this.ws.on("message",(err,data)=>{
      if(err){
        console.info('chatSocketServer message fail:' + JSON.stringify(err) + " data:"
          + JSON.stringify(data))
        return;
      }

      console.info('chatSocketServer message success:'
        + JSON.stringify(data))
      this.charMsgArray.push(data.toString())
    })

    this.ws.connect(Constant.wsUrl + "/api/chatSocketServer/" + this.selectUserId)
      .then((data)=>{
        console.info("chatSocketServer connect success:" + JSON.stringify(data))
      }).catch((err:Object)=>{
      console.info("chatSocketServer connect fail:" + JSON.stringify(err))
    })
  }

  aboutToAppear(): void {
    this.webSocket()
  }

  build() {

  Column() {
    Row() {
      Row() {
        Image($r('app.media.exit')).width(35).onClick(() => {
          router.back(); // 使用 router.back() 返回上一个页面
        });
      }.margin(20)

      Text("客服反馈")
      Select(this.userIdArray).selected(this.selectIndex).value(this.selectUserId)
        .onSelect((index: number, value: string) => {
          this.selectUserId = value
          this.selectIndex = index
          this.webSocket()
        })
    }.width("100%").padding({ left: 10, right: 10, top: 10 }).justifyContent(FlexAlign.SpaceBetween)

    Divider()
    List() {
      ForEach(this.charMsgArray, (item: string) => {
        ListItem() {
          Text(item)
        }
      })
    }.height(600).backgroundColor("#EEE")

    Row() {
      TextInput({ text: this.sendMsg }).width("80%").onChange((val) => {
        this.sendMsg = val
      })
      Button("发送").onClick(() => {
        this.sendMsgHttp()
        promptAction.showToast({ message: '消息已接收' })
      })
    }.width("100%").padding({ left: 10, right: 10, top: 10 }).justifyContent(FlexAlign.End)

    Divider()
  }.width("100%").height("100%")

  }
}