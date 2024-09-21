import SceneEntity from '../Model/SceneEntity'
@Preview
@Component
export default struct Scene{
  @State sceneList:Array<SceneEntity>=[
    {text:'离家时自动打扫',imgSrc:$r("app.media.Scene")},
    {text:'PM2.5过高时自动开启',imgSrc:$r("app.media.Scene1")},
    {text:'回家时自动开启',imgSrc:$r("app.media.Scene2")}
  ]
  build() {
    Column(){
      Row(){
        Text('智慧场景').fontSize(20).fontColor('#6a534d')
      }.height(50).width('100%').padding({left:10,right:10})
      .alignItems(VerticalAlign.Center).justifyContent(FlexAlign.Center)
      .backgroundColor('#fff')

      List(){
        ForEach(this.sceneList,(item:SceneEntity)=>{
          ListItem(){
            Stack({alignContent:Alignment.TopStart}){
              Image(item.imgSrc).width('100%').height(200)
              Text(item.text).fontColor('#ffffffff').fontSize(18)
                .fontWeight(800).margin({top:20,left:20})
            }.margin({top:15})
          }
        })
      }

    }.width('100%')
    .height('100%')
    .backgroundColor('#f8f8f8')
  }
}