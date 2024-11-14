import SceneEntity from '../model/ScenceEntity'
@Preview
@Component
export default struct Scene {
  @State sceneList: Array<SceneEntity>=[
    {text:$r('app.string.scene_clean'),imgSrc:$r('app.media.u1500')},
    {text:$r('app.string.scene_openair'),imgSrc:$r('app.media.u1533')},
    {text:$r('app.string.scene_openLight'),imgSrc:$r('app.media.u1534')},
  ]
  @State openArray:Array<boolean>=[true,true,true]
  @Builder
  headerGroup(text:Resource,index:number){
    Row(){
      Text(text).fontSize(20).fontWeight(700).fontColor('#fff')
      if (this.openArray[index]){
        Image($r("app.media.tree1")).width(25)
      }
      else{
        Image($r("app.media.tree")).width(25)
      }
    }.width('100%').padding(10).justifyContent(FlexAlign.SpaceBetween).backgroundColor('#ff75a6ee')
    .onClick(()=>{
      this.openArray[index]=!this.openArray[index]
    })
  }
  build() {
    Column() {
      Row() {
        Text($r('app.string.scene_name')).fontSize(18).fontColor(Color.Black)
      }
      .height(50)
      .width('100%')
      .padding("left:10.right:10")
      .justifyContent(FlexAlign.Center)
      .alignItems(VerticalAlign.Center)
      .backgroundColor("#fff")
      List({ space: 5 }) {
        ForEach(this.sceneList, (item: SceneEntity, index) => {
          ListItemGroup({ header: this.headerGroup(item.text, index) }) {
            if (this.openArray[index]) {
              ListItem() {
                Row() {
                  Image(item.imgSrc).width('100%').height(200)
                }.width('100%').margin(0)
              }
            }
          }
        })
      }.width('100%').height('100%').backgroundColor('#f8f8f8')
    }.margin({bottom:50})
  }
}