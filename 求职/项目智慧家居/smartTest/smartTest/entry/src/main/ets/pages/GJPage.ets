import { promptAction, router } from '@kit.ArkUI'

class BaoJEntity{
  name:string = ''
  tags:string = ''
  doc:string = ''
  minPrice:number = 0
}
@Entry
@Component
export default struct Task1 {
  @State private BaoJ: Array<BaoJEntity> = [
    { name: 'HW-KT-01', tags: '报警测试', doc: '15879541246', minPrice: 1 },
    { name: 'HW-KT-02', tags: '报警测试', doc: '13456988546', minPrice: 2 },
    { name: 'HW-KT-03', tags: '报警测试', doc: '13478522569', minPrice: 3 },
    { name: 'HW-KT-04', tags: '报警测试', doc: '15655744986', minPrice: 4 },
  ]
  build() {
    Column() {
      Row(){
        Image($r("app.media.back_white")).width(25)
          .onClick(()=>{
            router.back()
          })
        Row(){
          Text($r('app.string.Hijacking_Alert')).fontColor("#FFF").fontSize(20).fontWeight(700)
        }.flexGrow(1).justifyContent(FlexAlign.Center).margin({right:25})
      }.backgroundColor("#ff0977ca").width("100%").justifyContent(FlexAlign.SpaceBetween).padding(10)
      List({space:5}){
        ForEach(this.BaoJ,(item:BaoJEntity,index)=>{
          ListItem(){
            Column(){
              Row(){
                Image($r('app.media.gj')).width(30)
                Text(item.name+ '('+item.tags+')').fontColor('#ff0646c1')
                Text(item.minPrice +'级').fontColor('#ffff0000')
              }.width('100%').padding(10)
              .justifyContent(FlexAlign.SpaceBetween)
              Row(){
                Text(item.doc).fontColor('#ff0a1b6e')
                Button('报警').onClick(()=>{
                  AlertDialog.show({message:"是否报警",primaryButton:{
                    value:"确认",
                    action:()=>{
                      promptAction.showToast({message:"报警成功"})
                    }
                  },
                    secondaryButton:{
                      value:"取消",
                      action:()=>{
                        promptAction.showToast({message:"取消报警"})
                      }
                    }
                  })
                })
              }.width('100%').padding(10)
              .justifyContent(FlexAlign.SpaceBetween)
              .border({width:{bottom:1}})
            }
          }
        })
      }
      .height('100%')
      .width('100%')
    }
  }
}