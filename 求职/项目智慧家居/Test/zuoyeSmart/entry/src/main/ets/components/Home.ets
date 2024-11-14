import RoomEntity from '../model/RoomEntity'
import {  router } from '@kit.ArkUI'
import { HttpUtil } from '../Model/HttpUtil'
import http from '@ohos.net.http'
import webSocket from '@ohos.net.webSocket'
const  WS_BASE_URL:string='http://localhost:8989'

@Preview
@Component
export default struct Home {
  @State roomList: Array<RoomEntity> = [ ]
  @State dvcUuid:string='aa1'
  @State totalNum:number=0
  ws:webSocket.WebSocket=null!
  queryRoomList(){
    HttpUtil.sendHttpMsg({
      url:'/hall/queryRoomListByDvcId',
      extraData:[{name:'dvcUuid',value:this.dvcUuid}],
      method:http.RequestMethod.GET,
      success: (roomList: Array<RoomEntity>) => {
        roomList.forEach((item:RoomEntity)=>{
          this.roomList.push(item)
          this.totalNum+=item.sensorNum
        })
        console.log("queryRoomList"+JSON.stringify(this.roomList))
      }
    })
  }
  roomSocket(){
    this.ws=webSocket.createWebSocket()
    this.ws.on('message',(err,value)=>{
      console.info("websocket receive msg,[err:" + JSON.stringify(err) + " value:" + JSON.stringify(value) + "]")
      this.queryRoomList()
    })

    this.ws.connect(WS_BASE_URL+'/roomSocketServer/'+this.dvcUuid,(err,value)=>{
      console.info("websocket connect success,[err:" + JSON.stringify(err) + " value:" + JSON.stringify(value) + "]")
    })
  }

  aboutToAppear(): void {
    //this.queryRoomList()
    //this.roomSocket()

    this.queryRoomList()


  }



  build() {
    Column() {
      Column(){
        Text('我的家庭').fontSize(18).fontWeight(700)
        Text('共'+this.totalNum+'设备').fontSize(12).fontColor('#999999')
      }.alignItems(HorizontalAlign.Start)

       if (this.roomList.length !== 0) {
        List() {

          ForEach(this.roomList, (item: RoomEntity) => {
            ListItem(){

              Stack(){
                Image(item.roomIcon).onClick(()=>{
                  if(item.roomId=='rr4'){
                    router.pushUrl({url:'pages/hallDetail'})
                  }
                }).height('30%').width('100%')
                Column(){
                  Row(){
                    Text(item.roomName).fontSize(16).fontWeight(700).fontColor('#FFF').onClick(()=>{
                      if(item.roomId=='rr4'){
                        router.pushUrl({url:'pages/hallDetail'})
                      }
                    })
                    Text(item.sensorNum+'个设备').fontColor('#FFF')
                  }.width('100%').padding({left:10,right:10})
                  .justifyContent(FlexAlign.SpaceBetween)

                  Row(){
                    Row(){
                      Image($r('app.media.u316')).width(30)
                      Text(item.temperature+'°C').fontColor('#FFF').fontWeight(700)
                    }
                    Row(){
                      Image($r('app.media.u319')).width(30)
                      Text(item.humidity+'%').fontColor('#FFF').fontWeight(700)
                    }
                    Row(){
                      Image($r('app.media.u317')).width(30)
                      Text(item.brightness+'%').fontColor('#FFF').fontWeight(700)
                    }
                  }.width('260').justifyContent(FlexAlign.SpaceBetween)
                }.width('100%').justifyContent(FlexAlign.SpaceBetween)
                .height(150).alignItems(HorizontalAlign.Start)
              }.margin({bottom:5})

            }
          })
        }

      } else {
        Column() {

          Row() {
            Column() {
              Text('我的家庭').fontSize(18).fontWeight(700)
              Text('共0个设备').fontSize(12).fontColor('#9999')
            }.alignItems(HorizontalAlign.Start)

            Image($r('app.media.add')).width(40)
          }
          .width('100%')
          .justifyContent(FlexAlign.SpaceBetween)
          .height(60)
          .alignItems(VerticalAlign.Center)
          .padding({ left: 10, right: 10 })
          .backgroundColor('#e8ffffff')
        }

        Column() {
          Column() {
            Image($r('app.media.home_big')).width(110)
            Text('您还没有智能设备').fontSize(18).fontColor('#666')
            Text('添加设备后，将为您管理智能家居').fontSize(11).fontColor('#999')
            Button('立即添加设备').width(180)
          }.height(300).justifyContent(FlexAlign.SpaceEvenly)
        }.flexGrow(1)
        .width('100%')
        .justifyContent(FlexAlign.Center)
        .alignItems(HorizontalAlign.Center)
      }


    }.width('100%')
    .height('100%')
    .backgroundColor('#F8F8F8')
  }


}