import { router } from '@kit.ArkUI'
class moviesEntity{
  name:string = ''
  time:string = ''
}
@Entry
@Component
struct OpenPage {
  @State private list: Array<moviesEntity> = [
    {name:'芦佳仪',time:'2024 : 07 : 26'},{name:'李泽',time:'2024 : 09 : 25'},
    {name:'乌尼日',time:'2024 : 10 : 06'},{name:'翟家骥',time:'2024 : 16 : 22'},
    {name:'卻雅君',time:'2024 : 08 : 21'},{name:'张明泽',time:'2024 : 17 : 16'},
    {name:'乌云巴依拉嘎',time:'2024 : 04 : 26'},{name:'张扬',time:'2024 : 18 : 06'},
    {name:'靳静',time:'2024 : 15 : 23'},{name:'刘越洋',time:'2024 : 15 : 18'},
    {name:'赵晗宇',time:'2024 : 14 : 27'},{name:'徐欢',time:'2024 : 14 : 15'},
    {name:'包芒来',time:'2024 : 17 : 02'},{name:'来丹',time:'2024 : 11 : 16'},
    {name:'高春雪',time:'2024 : 18 : 13'},{name:'荆竞',time:'2024 : 13 : 29'},
    {name:'崔志林',time:'2024 : 19 : 20'},{name:'武心茹',time:'2024 : 12 : 35'},
    {name:'景蓉',time:'2024 : 20 : 18'},{name:'蔺少杰',time:'2024 : 07 : 56'},
    {name:'张扬',time:'2024 : 21 : 19'},{name:'南高嫒',time:'2024 : 09 : 14'},
    {name:'王凯',time:'2024 : 22 : 07'},{name:'于万福',time:'2024 : 21 : 06'},
    {name:'王帅',time:'2024 : 23 : 03'},{name:'王儒伊',time:'2024 : 22 : 26'},

  ]

  build() {
    Column(){
      Row(){
        Image($r("app.media.back_white")).width(25)
          .onClick(()=>{
            router.back()
          })
        Row(){
          Text("开门记录").fontColor("#FFF").fontSize(20).fontWeight(700)
        }.flexGrow(1).justifyContent(FlexAlign.Center).margin({right:25})
      }.backgroundColor("#ff0977ca").width("100%").justifyContent(FlexAlign.SpaceBetween).padding(10)
    Column(){
      List({space:5}){
        ForEach(this.list,(item:moviesEntity,index)=>{
          ListItem(){
            Column(){
              Row(){
                Text(item.name).fontColor('#ff0a1b6e')
                Text(item.time).fontColor('#ffff0000')
              }.width('100%').padding(10)
              .justifyContent(FlexAlign.SpaceBetween)
            }
          }
        })
      }
      .height('100%')
      .width('100%')
      }.width("100%").height("100%").backgroundColor('#FFF').justifyContent(FlexAlign.SpaceBetween)
    }
  }
}