import viewmodel from '../../viewmodel/MainViewModel'
import ServiceCard from '../bean/ServiceCard'

@Preview
@Component
export struct My {
  build() {
    Scroll() {
      Column({ space: 10 }) {
        //头像部分
        Header()
        // 想看&看过统计
        Xiangkan()
        //我的订单
        MyOrder()
        //我的卡券
        MyCard()
        // 精选服务
        MyServices()
      }
    }.margin({ bottom: 50 })
  }
}
@Component
struct Header {
  build() {
    Flex({ direction: FlexDirection.Row, justifyContent: FlexAlign.SpaceBetween }) {
      Row({ space: 5 }) {Column() {
        Image($r('app.media.frog_head_pic'))
          .width(50)
          .height(50)
          .border({
            width: 3,
            color: Color.White,
            radius: 25
          })
          .objectFit(ImageFit.Contain)
        Text('钻石VIP').fontSize(12)
      }
        Column({ space: 1 }) {
          Text('快乐的小青蛙').fontSize(20)
          Text('成长值：80/100').fontSize(15)
          Progress({ value: 80, total: 100, type: ProgressType.Linear })
            .color(Color.Grey).width('60%')
        }.alignItems(HorizontalAlign.Start)
      }.width('60%')
      Row() {
        Text('个人主页>').fontSize(16)
      }
    }.margin(10)
  }
}

@Component
struct Xiangkan{
  build(){
    Row({space:5}){
      Text('0 想看').fontSize(16)
      Blank()
      Text('>').fontSize(16)
      Divider().vertical(true).strokeWidth(2).color('#ffa5a5a9').height(30)
      Text('0 看过').fontSize(16)
      Blank()
      Text('>').fontSize(16)
    }.backgroundColor(Color.White)
    .width('90%')
    .height('8%')
    .borderRadius(10)
    .padding({left :15,right:15})
  }
}

@Component
struct MyOrder {
  build() {
    Column({ space: 5 }) {
      Text('我的订单').fontSize(18).width('90%').margin({ top: 8 })
      Flex({ direction: FlexDirection.Row,
        justifyContent: FlexAlign.SpaceAround }) {
        Column({ space: 5 }) {
          Image($r('app.media.movie_32x32')).width(48).height(48)
          Text('电影票').fontSize(15)
        }.margin({ top: 10 })
        Column({ space: 5 }) {
          Image($r('app.media.yanchu32x32')).width(48).height(48)
          Text('演出/玩乐').fontSize(15)
        }.margin({ top: 10 })
        Column({ space: 5 }) {
          Image($r('app.media.theater32x32')).width(48).height(48)
          Text('在线观影').fontSize(15)
        }.margin({ top: 10 })
        Column({ space: 5 }) {
          Image($r('app.media.local32x32')).width(48).height(48)
          Text('周边').fontSize(15)
        }.margin({ top: 10 })
      }.width('100%')
    }
    .backgroundColor(Color.White)
    .borderRadius(10)
    .width('90%')
    .height('18%')
  }
}
@Component
struct MyCard {
  build() {
    Flex({ direction: FlexDirection.Row,
      justifyContent: FlexAlign.SpaceAround,
      alignItems: ItemAlign.Center
    }) {
      Column({ space: 5 }) {
        Text('优惠券').fontSize(20).fontWeight(FontWeight.Bold)
        Text('25 张可用').fontSize(15)
 }
      Column({ space: 5 }) {
        Text('影城卡').fontSize(20).fontWeight(FontWeight.Bold)
        Text('21 张可用').fontSize(15)
      }
      Column({ space: 5 }) {
        Text('蛙享卡').fontSize(20).fontWeight(FontWeight.Bold)
        Text('22 张可用').fontSize(15)
      }
      Column({ space: 5 }) {
        Text('蛙币').fontSize(20).fontWeight(FontWeight.Bold)
        Text('0 张可用').fontSize(15)
      }
    }.width('90%').height('12%')
    .backgroundColor(Color.White)
    .borderRadius(10)
  }
}
@Component
struct MyServices {
  build() {
    Column() {
      Text('精选服务')
        .fontSize(20)
        .fontWeight(FontWeight.Medium)
        .width('90%')
        .margin({ top: 2 })
        Grid(){
          ForEach(viewmodel.getMyServiceCard(), (item: ServiceCard) => {
            GridItem() {
              Column({ space: 5 }) {
                Text(item.title).fontSize(20).fontWeight(FontWeight.Medium).margin({ top: 8 })
                Row({ space: 8 }) {
                  Column({ space: 5 }) {
                    Text('双享礼遇').fontSize(15)
                    Text('双享礼遇').fontSize(15)
                    Text('立即参加').fontSize(12)
                  }
                  Column() {
                    Image(item.img).width(60).height(60)
                      .borderRadius(5)
                  }
                }
                .padding({ bottom: 10 })
              }.backgroundColor(Color.White)
              .width('100%')
              .height(120)
              .borderRadius(10)
            }
          }, item => JSON.stringify(item))
        }
        .columnsTemplate('1fr 1fr')
        .rowsTemplate('1fr 1fr 1fr')
        .columnsGap(15)
        .rowsGap(15)
        .width('90%')
        .height(400)
    }
  }
}