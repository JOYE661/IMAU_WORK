import Brightness from '@system.brightness'
//@Preview
@Component
export struct TitleComponent{
  @Link isUpdataDataSource:Boolean;
  build(){
    Row(){
      Row(){
        Image($r("app.media.arrowcircleleft"))
          .width(30)
          .height(30)
          .margin({right:5})
        Text("电影排行榜").fontSize(20)
      }.width('50%').height(30).justifyContent(FlexAlign.Start)
      Row(){
        Image($r('app.media.redo'))
          .width(25)
          .height(25)
          .onClick(()=>{
            this.isUpdataDataSource = !this.isUpdataDataSource;
          })
      }.width('50%').height(30).justifyContent(FlexAlign.End)
    }.width('100%')
    .padding({left:25,right:25})
    .margin({top:10})
    .height(45)
    .justifyContent(FlexAlign.SpaceAround)
  }

}
