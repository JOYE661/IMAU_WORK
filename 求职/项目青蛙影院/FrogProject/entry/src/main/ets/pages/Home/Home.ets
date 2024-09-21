import viewmodel from '../../viewmodel/MainViewModel'
import ItemBean from '../bean/ItemBean'
import MovieBean from '../bean/MovieBean'
@Component
export struct Home{
//  @State message:string ='Page1'

  build(){
    Scroll(){
      Column(){
        MyTitle({title:'首页'})
        MySwiper()
        MyMenu()
        MyTitle({title:'热门电影'})
        MyHotMovie()
      }.width('100%')
      .height('100%').justifyContent(FlexAlign.Start)
    }
  }
}
@Component
struct MyTitle{
  @State title:string=''
  build(){
    Text(this.title)
      .fontSize(25)
      .margin({top:20,left:20,bottom:20})
      .width('100%')
      .textAlign(TextAlign.Start)
      .fontWeight(FontWeight.Bolder)
  }
}

@Component
struct MySwiper {
  build() {
    Swiper(){
      ForEach(viewmodel.getSwiperImages(),(item:Resource,index?:number)=>{
        Image(item)
          .width('90%')
          .height('25%')
          .borderRadius(10)
      },item=>item.toString())
    }.autoPlay(true)
  }
}

@Component
struct MyMenu {
  build() {
    Grid(){
      ForEach(viewmodel.getItemBeanData(),(item:ItemBean,index?:number)=>{
        GridItem(){
          Column(){
            Image(item.image)
              .width(40)
              .height(40)
            Text(item.name).margin({top:5})
          }
        }
      },item=>item.toString())
    }
    .columnsTemplate("1fr 1fr 1fr 1fr")
    .rowsTemplate('1fr 1fr')
    .rowsGap(15)
    .columnsGap(5)
    .height(150)
    .backgroundColor(Color.White)
    .borderRadius(10)
    .margin(20)
    .padding({top:10,bottom:10})
  }
}

@Component
struct MyHotMovie {
  build() {
    List(){
      ForEach(viewmodel.getHotMovieBeanData(),(item:MovieBean,index?:number)=>{
        ListItem(){
          Column(){
            Image(item.image)
              .width(96)
              .height(150)
              .borderRadius(8)
              .margin(2)
            Text(item.name)
              .fontSize(14)
            Button('预定').height(30)
          }
        }.margin(10)
      },item=>item.toString())
    }.width('90%')
    .height(220)
    .listDirection(Axis.Horizontal)
    .backgroundColor(Color.White)
    .margin({left:20,right:20})
    .borderRadius(15)
  }
}