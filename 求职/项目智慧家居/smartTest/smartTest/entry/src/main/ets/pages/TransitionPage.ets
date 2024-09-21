import { router } from '@kit.ArkUI'

const nextPage:string='pages/Login'
const firstIndex:number=0
PersistentStorage.persistProp('transFlag','')
@Entry
@Component
struct TransitionPage {
  @StorageLink('transFlag') transFlag:string=''
  @State arrayList:Array<Resource>=[
    $r('app.media.logo'),
    $r('app.media.logo1'),
    $r('app.media.logo2'),
  ]
  aboutToAppear(): void {
    if(this.transFlag!==''){
      router.replaceUrl({url:nextPage})
    }
  }
  build() {
    Stack({alignContent:Alignment.BottomEnd}){
      Swiper(){
        ForEach(this.arrayList,(item:Resource)=>{
          Image(item).width('100%').height('100%')
        })
      }.autoPlay(true).indicator(new DotIndicator()
        .itemWidth(20).itemHeight(20)
        .selectedItemWidth(30).selectedItemHeight(20)
        .selectedColor('#ff1b4b85').color('#ff43b6bc')
      )
      .onAnimationEnd((index)=>{
        if(index===firstIndex){
          router.replaceUrl({url:nextPage})
        }
      })
      Text($r('app.string.page_close')).fontSize(20).fontWeight(700).fontColor('#fff').margin(10)
        .onClick(()=>{
          router.replaceUrl({url:nextPage})
        })
    } .width('100%').height('100%')
  }
}