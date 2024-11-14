import RoomEntity from '../model/RoomEntity';
import { router } from '@kit.ArkUI';

@Entry
@Component
struct AddRoomPage {
  @State message: Resource = $r("app.string.add_room");
  @State roomList: Array<RoomEntity> = [
   {
      roomName: $r("app.string.AddRoomPage_roomName4"),
      sensorNum: 12,
      temperature: '30',
      humidity: '48',
      brightness: '51',
      roomIcon: $r("app.media.home4"),
      roomid:'4',
    },
    {
      roomName: $r("app.string.AddRoomPage_roomName5"),
      sensorNum: 6,
      temperature: '31',
      humidity: '47',
      brightness: '50',
      roomIcon: $r("app.media.home5"),
      roomid:'5'
    },
    /*{
      roomName: '车库',
      sensorNum:12,
      temperature: '32',
      humidity: '46',
      brightness: '52',
      roomIcon: $r("app.media.home6"),
      roomid:'6'
    }*/
  ]
  @State widthSize: number = 30
  @State heightSize: number = 100
  build() {
    Scroll(){
    Column() {
      Row() {
        Image($r('app.media.u386')).width(40).onClick(() => {
          router.back()
        })
        Text(this.message).fontSize(25).fontColor(Color.Black)
      }.width("100%").justifyContent(FlexAlign.SpaceBetween).backgroundColor("#fff")

      Scroll() {
        List() {
          ForEach(this.roomList, (item: RoomEntity) => {
            ListItem() {
              Stack() {
                Image(item.roomIcon).size({ width: "100%", height: 250 })
                Column() {
                  Row() {
                    Text(item.roomName).fontSize(20).fontWeight(700).fontColor("#ff122ee3")
                    Text(item.sensorNum +'Devices').fontColor("#FFF")
                  }.width("100%").padding({ left: 10, right: 10 })
                  .justifyContent(FlexAlign.SpaceBetween)

                  Row() {
                    Row() {
                      Image($r('app.media.u316')).width(30)
                      Text(item.temperature + '°C').fontColor('#FFF').fontWeight(700)
                    }

                    Row() {
                      Image($r('app.media.u319')).width(30)
                      Text(item.humidity + '%').fontColor('#FFF').fontWeight(700)
                    }

                    Row() {
                      Image($r('app.media.u317')).width(30)
                      Text(item.brightness + '%').fontColor('#FFF').fontWeight(700)
                    }
                  }.width('260').justifyContent(FlexAlign.SpaceBetween)
                }.width('100%').justifyContent(FlexAlign.SpaceBetween)
                .height(150).alignItems(HorizontalAlign.Start)
              }.margin({ bottom: 5 })
            }
          })
        }
      }

      Row() {
        Button('添加').fontSize(20).onClick(() => {

        })
        Button('取消').fontSize(20).onClick(() => {
          router.replaceUrl({
            url: "pages/Index"
          })
        })
      }.width("100%").justifyContent(FlexAlign.SpaceBetween)
    }
      }
    }
}