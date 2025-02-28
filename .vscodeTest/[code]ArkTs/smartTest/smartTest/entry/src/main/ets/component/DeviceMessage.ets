import AddMsg from './AddMsg';
interface DeviceMessageEntity {
  img:Resource;
  name: string;
  tips: string;
  time: string;
  readFlag: boolean;
}

@Preview
@Component
export default struct DeviceMessage {
  @State messageList: Array<DeviceMessageEntity> = [
    { img:$r("app.media.akr"),name: '监控摄像机', tips: '监测到可疑目标，请及时查看', time: '上午10:20', readFlag: false },
    { img:$r("app.media.rout"),name: '路由器', tips: '网络异常，无法联网，请及时查看', time: '上午9:15', readFlag: false },
    { img:$r("app.media.alq"),name: '监控摄像机', tips: '监测到可疑目标，请及时查看', time: '昨天', readFlag: true },
    { img:$r("app.media.rout"),name: '路由器', tips: '网络异常，无法联网，请及时查看', time: '星期二', readFlag: true },
    { img:$r("app.media.akr"),name: '门禁系统', tips: '门禁异常，请检查权限设置', time: '星期一', readFlag: false },
    { img:$r("app.media.akr"),name: '烟雾探测器', tips: '检测到烟雾，请立即检查', time: '星期一', readFlag: false },
    { img:$r("app.media.akr"),name: '监控摄像机', tips: '监测到可疑活动，请及时查看', time: '2024/2/12', readFlag: true },
    { img:$r("app.media.rout"),name: '路由器', tips: '网络连接恢复正常', time: '2024/2/11', readFlag: true },
    { img:$r("app.media.akr"),name: '门禁系统', tips: '门禁异常，请检查权限设置', time: '星期一', readFlag: false },
    { img:$r("app.media.akr"),name: '烟雾探测器', tips: '检测到烟雾，请立即检查', time: '星期一', readFlag: false },
    { img:$r("app.media.alq"),name: '监控摄像机', tips: '监测到可疑活动，请及时查看', time: '2024/2/12', readFlag: true },
    { img:$r("app.media.rout"),name: '路由器', tips: '网络连接恢复正常', time: '2024/2/11', readFlag: true }

  ];

  @State descArray: Array<DeviceMessageEntity> = [];
  @State selectedMessage: DeviceMessageEntity | null = null; // 新增状态用于存储选中的消息
  @State showAddMsg: boolean = false; // New state to manage the visibility of AddMsg

  aboutToAppear(): void {
    this.descArray = [...this.messageList];
  }

  build() {
    Stack({ alignContent: Alignment.BottomEnd }) {
      Column() {
        Search({ placeholder: $r("app.string.Message_enter_query_content"), value: "" })
          .onSubmit((val) => {
            this.descArray = this.messageList.filter((item: DeviceMessageEntity) => {
              return item.name.includes(val) || item.tips.includes(val) || item.time.includes(val);
            });
          });

        List() {
          ForEach(this.descArray, (item: DeviceMessageEntity) => {
            ListItem() {
              Row(){
                if (!item.readFlag) {
                  Text()
                    .backgroundColor("#ffe90417")
                    .width(15)
                    .height(15)
                    .borderRadius(15)
                    .margin({ right: 10 });
                }
                Image(item.img).width(30).height(30)
                Column() {
                  Row() {
                    Row() {

                      Text(item.name).fontWeight(700).fontSize(16).fontColor(item.readFlag ?"#A7A7A7" :"#333")
                        .onClick(() => {
                          this.selectedMessage = item;
                        });
                    }
                    Text(item.time).fontColor(item.readFlag ? "#A7A7A7" : "#000").fontSize(14).margin({right:25});
                  }.width("100%").justifyContent(FlexAlign.SpaceBetween);
                  Row() {
                    Text(item.tips).fontColor(item.readFlag ? "#A7A7A7" : "#555").fontSize(14);
                  }.width("100%");
                }.width("95%").padding(15).backgroundColor("#FFF")
                .margin({ top: 10 }).borderRadius(10);
              }
            }.height("auto")
          });
        }
        if (this.selectedMessage) {
          Column() {
            Text("详细信息").fontSize(18).fontWeight(700).margin({ bottom: 10 });
            Text(`名称: ${this.selectedMessage.name}`).fontSize(16).fontColor("#333");
            Text(`提示: ${this.selectedMessage.tips}`).fontSize(16).fontColor("#555");
            Text(`时间: ${this.selectedMessage.time}`).fontSize(16).fontColor("#555");
            Button("关闭").onClick(() => {
              this.selectedMessage = null;
            }).padding(10).margin({ top: 10 });
          }.backgroundColor("#f0f0f0").padding(15).borderRadius(10).margin({ top: 20 });
        }

      }.flexGrow(1).width("100%").alignItems(HorizontalAlign.Center).backgroundColor("#f9f9f9").padding(20);
      Image($r('app.media.u001')) .onClick(() => {
        this.showAddMsg=true;
      })
        .width(100)
        .height(100)
        .borderRadius(16)
        .margin({ bottom: 30, right: 20 })
        .padding({ bottom: 20, right: 20 })
        .position({ x: '70%', y: '70%' });
      if(this.showAddMsg){
        AddMsg();
      }
    }.margin({ top: 10 })

  }
}


