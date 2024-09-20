import Home from '../components/Home'
import Message from '../components/Message'
import MyInfo from '../components/MyInfo'
import Scene from '../components/Scene'

@Entry
@Component
struct Index {

  @State selectIndex:number=0
  controller:TabsController=new TabsController()

  @Builder
  tabBarInfo(index:number,text:string,imageRsc:Resource,activeImage:Resource){
    Column(){
      if(index===this.selectIndex){
        Image(activeImage).width(30)
        Text(text).fontSize(18).fontColor('#ff2e6b94')
      }else{
        Image(imageRsc).width(30)
        Text(text).fontSize(18).fontColor('#8E8E8E')
      }
    }.padding(5).onClick(()=>{
      this.selectIndex=index
      this.controller.changeIndex(index)
    })
  }

  build() {

    Tabs({controller:this.controller,barPosition:BarPosition.End}){
      TabContent(){
        Home()
      }.tabBar(this.tabBarInfo(0,'首页',$r('app.media.sy'),$r('app.media.sy1')))

      TabContent(){
        Scene()
      }.tabBar(this.tabBarInfo(1,'场景',$r('app.media.cj'),$r('app.media.cj1')))

      TabContent(){
        Message()
      }.tabBar(this.tabBarInfo(2,'消息',$r('app.media.xx'),$r('app.media.xx1')))

      TabContent(){
        MyInfo()
      }.tabBar(this.tabBarInfo(3,'我的',$r('app.media.wd'),$r('app.media.wd1')))
    }
  }



}