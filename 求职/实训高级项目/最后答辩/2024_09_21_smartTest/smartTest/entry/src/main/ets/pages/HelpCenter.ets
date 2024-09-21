import { router } from '@kit.ArkUI'

@Extend(Image)function headIcon(){
  .width(40).margin({right:5})
}
@Extend(Text)function headText(){
  .fontSize(20)
}
@Extend(Image)function headRight(){
  .width(20)
}
@Extend(Row)function rowBlock(){
  .width("100%")
  .padding({left:15,right:15,top:15,bottom:15})
  .justifyContent(FlexAlign.SpaceBetween)
}
@Entry
@Component
export default struct HelpCenter{
  build(){
    Column(){
      Row(){
      Image($r('app.media.exit')).width(35).onClick(() => {
        router.back(); // 使用 router.back() 返回上一个页面
      });
      Text("帮助中心").fontSize(30).margin(20)}
      Row(){
        Row(){
          Image($r("app.media.myinfoListicon6")).headIcon()
          Text("账号与登录").headText()
        }
        Image($r("app.media.right")).headRight()
      }.rowBlock()
      Row(){
        Row(){
          Image($r("app.media.myinfoListicon2")).headIcon()
          Text("通讯录").headText()
        }
        Image($r("app.media.right")).headRight()
      }.rowBlock()
      Row(){
        Row(){
          Image($r("app.media.myinfoListicon3")).headIcon()
          Text("青少年模式").headText()
        }
        Image($r("app.media.right")).headRight()
      }.rowBlock()
      Row(){
        Row(){
          Image($r("app.media.myinfoListicon4")).headIcon()
          Text("意见反馈").headText()
        }
        Image($r("app.media.right")).headRight()
      }.rowBlock()
      Row(){
        Row(){
          Image($r("app.media.clock")).headIcon()
          Text("关怀模式").headText()
        }
        Image($r("app.media.right")).headRight()
      }.rowBlock()
      Row(){
        Row(){
          Image($r("app.media.more")).headIcon()
          Text("其他问题").headText()
        }
        Image($r("app.media.right")).headRight()
      }.rowBlock()
    }.width("100%").height("100%")//endpage
    .backgroundColor("#F8F8F8")
  }
}