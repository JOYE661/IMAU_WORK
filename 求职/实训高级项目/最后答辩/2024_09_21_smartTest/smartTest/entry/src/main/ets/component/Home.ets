import { HttpUtil } from '../model/HttpUtil'
import http from '@ohos.net.http'
import webSocket from '@ohos.net.webSocket'
import  RoomEntity  from '../model/RoomEntity'
import { url } from '@kit.ArkTS'
import { router } from '@kit.ArkUI'
import AddEquipments from '../pages/AddEquipments';

const WS_BASE_URL:string='ws://192.168.72.1:8091/api'

@Preview
@Component
export default struct Home {
  @State roomList: Array<RoomEntity> = [
   {
      roomName: $r("app.string.Home_roomName1"),
      sensorNum: 4,
      temperature: '30',
      humidity: '48',
      brightness: '51',
      roomIcon: $r("app.media.home1"),
      roomid:'1',
    },
    {
      roomName: $r("app.string.Home_roomName2"),
      sensorNum: 6,
      temperature: '31',
      humidity: '47',
      brightness: '50',
      roomIcon: $r("app.media.home2"),
      roomid:'2'
    },
    {
      roomName: $r("app.string.Home_roomName3"),
      sensorNum:12,
      temperature: '32',
      humidity: '46',
      brightness: '52',
      roomIcon: $r("app.media.home3"),
      roomid:'3'
    }
  ]
  @State dvcUuid: string = '66e4ea1bd671df42eb36a828_IMEA'
 public  totalNum: number=22
  ws:webSocket.WebSocket=null!
  queryRoomList() {
    //this.totalNum=0
    this.roomList.splice(0,this.roomList.length)
    HttpUtil.sendHttpMsg({
      url:'hall/queryRoomListByDvcId',
      extraData:[
        {name:'dvcUuid',value:this.dvcUuid}
      ],
      method: http.RequestMethod.GET,
      success:(roomList:Array<RoomEntity>)=>{
        roomList.forEach(item=>{
          this.roomList.push(item)
          this.totalNum+=item.sensorNum;
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
   /* this.ws.on('open',(err,value)=>{
      console.info("websocket open msg,[err:" + JSON.stringify(err) + " value:" + JSON.stringify(value) + "]")
      this.queryRoomList()
    })*/
    this.ws.connect(WS_BASE_URL+'/amqpSocketServer/'+this.dvcUuid,(err,value)=>{
      console.info("websocket connect success,[err:" + JSON.stringify(err) + " value:" + JSON.stringify(value) + "]")
    })
  }
  aboutToAppear(): void {
    this.roomSocket()
  }
  build() {
    Column() {
      Row() {
        Column() {
          Text('我的家庭').fontSize(25).fontWeight(700)
          Text('共' + this.totalNum + 'Devices').fontSize(15).fontColor("#999999")
        }.alignItems(HorizontalAlign.Start)
            Image($r("app.media.add")).width(40).onClick(()=>{
              router.pushUrl({
                url: "pages/AddEquipments"
              })
            })
      }.width("100%").justifyContent(FlexAlign.SpaceBetween)
      .height(60).alignItems(VerticalAlign.Center)
      .padding({left:10,right:10}).backgroundColor("#fff")

      if (this.roomList.length !== 0) {
        List() {
          ForEach(this.roomList, (item: RoomEntity) => {
            ListItem(){
              Stack() {
                Image(item.roomIcon)

                Column(){
                  Row(){
                    Text(item.roomName).fontSize(20).fontWeight(700).fontColor('#FFF')
                      .onClick(() => {
                        router.pushUrl({
                          url: "pages/hall"
                        })
                      })
                    Text(item.sensorNum+'Devices').fontColor('#FFF')
                  }.width('100%').padding({left:10,right:10})
                  .justifyContent(FlexAlign.SpaceBetween)

                  Row(){
                    Row(){
                      Image($r('app.media.u316')).width(30).onClick(()=>{
                        this.roomSocket()
                      })
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
            Image($r('app.media.add')).width(40).onClick(()=>{
              router.pushUrl({
                url: "pages/AddRoomPage"
              })
            })
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
            Button('立即添加设备').width(180).onClick(()=>{
              router.pushUrl({
                url:"pages/hall"
              })
            })
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
