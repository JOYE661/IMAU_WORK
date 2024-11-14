import { Cinema } from './Cinema/Cinema'
import { Home } from './Home/Home'
import { LookVideo } from './LookVideo/LookVideo'
import { My } from './My/My'
@Preview
@Entry
@Component
struct MainPage{
  @State currentIndex:number=0
  tabController:TabsController=new TabsController()
  @Builder
  TabBuilder(title:string,index:number,selectImg:Resource,normalImg:Resource){
    Column(){
      Image(this.currentIndex==index?selectImg:normalImg)
        .width(30)
        .height(30)
      Text(title)
        .fontColor(this.currentIndex==index?'#ff0a1a6c':'#ff7c5454')
    }.onClick(()=>{
      this.currentIndex=index
      console.log(`---->index:${index}`)
      this.tabController.changeIndex(index)
    })
  }
  build(){
    Tabs({barPosition:BarPosition.End,controller:this.tabController}){
      TabContent(){
        Home()
//        Text('Page1')
      }.backgroundColor('#f1f3f5').tabBar(this.TabBuilder('首页',0,$r('app.media.home_1'),$r('app.media.home_0')))

      TabContent(){
        Cinema()
//        Text('Page2')
      }.backgroundColor('#f1f3f5').tabBar(this.TabBuilder('影院',1,$r('app.media.movie_1'),$r('app.media.movie_0')))

      TabContent(){
        LookVideo()
//        Text('Page3')
      }.backgroundColor('#f1f3f5').tabBar(this.TabBuilder('抢先看',2,$r('app.media.play_1'),$r('app.media.play_0')))

      TabContent(){
        My()
//        Text('Page4')
      }.backgroundColor('#f1f3f5').tabBar(this.TabBuilder('个人中心',3,$r('app.media.me_1'),$r('app.media.me_0')))
    }.onChange((index)=>{
      this.currentIndex=index
    })
  }
}