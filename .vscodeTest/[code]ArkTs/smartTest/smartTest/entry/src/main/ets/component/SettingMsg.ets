interface SettingMsgEntity{
  title:string
  text:string
  time:string
  imgSrc:Resource
}
@Preview
@Component
export default struct SettingMsg {
  @State settingMsgList: Array<SettingMsgEntity> = [
    {
      title: '好消息！好消息！今天又有优惠活动喔！',
      text: '水星家居新品发布，给您带来不一样的视觉与触感，期待大家光临！',
      time: '06月18日',
      imgSrc: $r("app.media.messageImg1")
    },
    {
      title: '今天又有优惠活动喔！',
      text: '新品家居上市，带来低至5折的优惠、买1赠N的新品福利，让消费者畅享“一件新品，加倍赠品”的购物体验！',
      time: '06月20日',
      imgSrc: $r("app.media.messageImg2")
    },
    {
      title: '今天又有优惠活动喔！',
      text: '新品家居上市，带来低至5折的优惠、买1赠N的新品福利，让消费者畅享“一件新品，加倍赠品”的购物体验！',
      time: '06月21日',
      imgSrc: $r("app.media.messageImg3")
    },
    {
      title: '今天又有优惠活动喔！',
      text: '新品家居上市，让消费者畅享“一件新品，加倍赠品”的购物体验！',
      time: '06月24日',
      imgSrc: $r("app.media.messageImg4")
    },
    {
      title: '今天又有优惠活动喔！',
      text: '新品家居上市，让消费者畅享“一件新品，加倍赠品”的购物体验！',
      time: '06月24日',
      imgSrc: $r("app.media.messageImg4")
    },
    {
      title: '今天又有优惠活动喔！',
      text: '新品家居上市，让消费者畅享“一件新品，加倍赠品”的购物体验！',
      time: '06月24日',
      imgSrc: $r("app.media.messageImg4")
    }

  ]

  @State descArray: Array<SettingMsgEntity> = [];

  aboutToAppear(): void {
    this.descArray = [...this.settingMsgList];
  }
  build() {
    Column() {
      Search({ placeholder:$r("app.string.Message_enter_query_content"), value: "" })
        .onSubmit((val) => {
          this.descArray = this.settingMsgList.filter((item: SettingMsgEntity) => {
            return item.title.includes(val) || item.text.includes(val) || item.time.includes(val);
          });
        });

      List({ space: 2 }) {
        ForEach(this.descArray, (item: SettingMsgEntity) => {
          ListItem() {
            Column() {
              Text(item.time)
                .margin({ top: 5, bottom: 5 })
                .fontColor("#A7A7A7");

              Column() {
                Text(item.title).fontWeight("bold");
                Image(item.imgSrc).width("100%").height("700px");
                Text(item.text).margin({ top: 5 });
              }
              .backgroundColor("#FFF")
              .width("100%")
              .padding(10)
              .alignItems(HorizontalAlign.Start)
              .justifyContent(FlexAlign.SpaceEvenly);
            }.width("100%").margin({ bottom: 10 });
          }.height("auto");
        })
      }
    }.width("100%").height("100%")
    .alignItems(HorizontalAlign.Center)
    .backgroundColor("#F8F8F8");
  }
}
