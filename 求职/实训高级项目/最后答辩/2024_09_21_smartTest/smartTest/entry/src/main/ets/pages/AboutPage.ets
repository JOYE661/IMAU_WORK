import { router } from '@kit.ArkUI';

@Entry
@Component
export default struct AboutPage{
  build() {
    Column(){
      Column(){
        Column(){
          Row(){
          Image($r('app.media.back_white')).width(30).onClick(() => {
            router.back(); // 使用 router.back() 返回上一个页面
          });
            Text("关于我们").fontSize(25).fontColor("#fff")
          }.backgroundColor("#ffb7d6ee").width("100%").height(50)
          Image($r("app.media.GY")).width("100%")
        }
        Row(){
          Text("检测更新").fontSize(20)
          Row(){
            Text("6.3.1").fontSize(20)
          Image($r("app.media.u395")).width(10)}.justifyContent(FlexAlign.SpaceEvenly)
        }.rowBlock()
        Row(){
          Text("鼓励一下").fontSize(20)
          Image($r("app.media.u395")).width(10)
        }.rowBlock()
        Row() {
          Text("机构注册与服务协议").fontSize(20)
          Row() {
            Image($r("app.media.u395")).width(10)
          }.justifyContent(FlexAlign.SpaceAround)
          .onClick(() => {
            router.pushUrl({
              url: 'pages/MyPageList1',

            })
          });
        }.rowBlock()
        Row() {
          Text("隐私政策").fontSize(20)
          Row() {
            Image($r("app.media.u395")).width(10)
          }.justifyContent(FlexAlign.SpaceAround)
          .onClick(() => {
            router.pushUrl({
              url: 'pages/MyPageList3',

            })
          });
        }.rowBlock()
        Row() {
          Text("违规信息处置规范").fontSize(20)
          Row() {
            Image($r("app.media.u395")).width(10)
          }.justifyContent(FlexAlign.SpaceAround)
          .onClick(() => {
            router.pushUrl({
              url: 'pages/MyPageList2',

            })
          });
        }.rowBlock()
        Row() {
          Text("常见问题").fontSize(20)
          Row() {
            Image($r("app.media.u395")).width(10)
          }.justifyContent(FlexAlign.SpaceAround)
          .onClick(() => {
            router.pushUrl({
              url: 'pages/MyPageList4',

            })
          });
        }.rowBlock()
      }.backgroundColor("#FFF").margin({top:10})
    }.width("100%").height("100%").backgroundColor("#EEE")
  }
}
@Extend(Row) function rowBlock(){
  .width("100%")
  .padding(10)
  .justifyContent(FlexAlign.SpaceBetween)
  .border({width:{bottom:1},color:"#AAA"})
}