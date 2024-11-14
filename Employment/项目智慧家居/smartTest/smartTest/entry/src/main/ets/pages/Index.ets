import Home from '../component/Home';
import Message from '../component/Message';
import MyInfo from '../component/MyInfo';
import Scene from '../component/Scene';

@Entry
@Component
struct Index {
  @State selectIndex: number = 0;
  controller: TabsController = new TabsController();

  @Builder tabBarInfo(index:number,text:string,imageRsc:Resource,activeImage:Resource){
    Column(){
      if(index==this.selectIndex){
        Image(activeImage).width(30)
        Text(text).fontSize(18).fontColor('#ff5196c4')
      }else{
        Image(imageRsc).width(30)
        Text(text).fontSize(18).fontColor('#ffcabdbd')
      }
    }.padding(5)
    .onClick(()=>{
      this.selectIndex=index;
      this.controller.changeIndex(index);
    })
  }



  build() {
    Tabs({controller:this.controller,barPosition:BarPosition.End}) {
      TabContent() {
        Home()
      }
      .tabBar(this.tabBarInfo(0,'首页',$r('app.media.tab_home'),$r('app.media.tab_home_active')))
      TabContent() {
        Scene()
      }
      .tabBar(this.tabBarInfo(1,'场景',$r('app.media.tab_scene'),$r('app.media.tab_scene_active')))
      TabContent() {
        Message()
      }
      .tabBar(this.tabBarInfo(2,'消息',$r('app.media.tab_message'),$r('app.media.tab_message_active')))
      TabContent() {
        MyInfo()
      }
      .tabBar(this.tabBarInfo(3,'我的·',$r('app.media.tab_myinfo'),$r('app.media.tab_myinfo_active')))
    }
  }
}