import viewmodel from '../../viewmodel/MainViewModel'
import CinemaBean from '../bean/CinemaBean'
@Preview
@Component
export struct Cinema{
//  @State message:string ='Page2'

  build(){
    Scroll(){
      Column(){
        MySwiper()
        MyCinemaList()
      }
    }
  }
}

@Component
struct MySwiper {
  build() {
    Swiper(){
      ForEach(viewmodel.getSwiperAdvImages(),(item:Resource,index?:number)=>{
        Image(item)
      },item=>item.toString())
    }.autoPlay(true)
  }
}

@Component
struct MyCinemaList {
  build() {
    List(){
      ForEach(viewmodel.getAllCinemas(),(item:CinemaBean,index?:number)=>{
        ListItem(){
          Column(){
            Row(){
              Row(){
                Text(item.name)
                  .fontSize(20)
                Text(`(${item.branchName})`).fontSize(20)
              }
              Text(`${item.minPrice}元起`).fontColor(Color.Red)
            }.width('100%').justifyContent(FlexAlign.SpaceBetween)
            Text(item.address).width('100%').fontColor(Color.Blue)
            Row({space:5}){
              ForEach(item.tags, (item2: string, index?: number) => {
                Text(`${item2}`).borderWidth(1).fontColor(Color.Gray)
              }, item2 => item2.toString)
            }.width('100%')
          }.padding(5)
        }
      },item=>item.toString())
    }.listDirection(Axis.Vertical)
    .divider({
      strokeWidth: 1,
      color: Color.Gray,
      startMargin: 5,
      endMargin: 5
    })
    .width("100%")
    .height("100%")
  }
}