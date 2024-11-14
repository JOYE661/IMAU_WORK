import { router } from '@kit.ArkUI'
@CustomDialog
export struct Dialog {
  control:CustomDialogController
  @State curValue:number=40
  @State maxValue:number=300
  @State selectValue:number=140
  @State selectColor:ResourceColor='#fff'
  @State step:number=70
  build() {
    Column(){
      Stack(){
        Image($r("app.media.bj")).width(340)
        Image($r("app.media.hk")).width(65).position({y:0,x:this.curValue})
      }
      Slider({value:this.curValue,max:this.maxValue,step:this.step,style:SliderStyle.InSet}).onChange((val)=>{
        this.curValue=val
        if(this.curValue==this.selectValue){
          this.selectColor='#f00'
          router.replaceUrl({
            url: 'pages/Index'
          })
          this.control.close()
        }
        else{
          this.selectColor='#fff1f1ec'
        }
      }).width('95%').blockColor(this.selectColor).padding(10)
      Row(){
        Row(){
          Text($r('app.string.dialog_value'))
          Text(":"+this.curValue)
        }.justifyContent(FlexAlign.Start).width('50%')
        Row(){
          Text($r('app.string.dialog_max'))
          Text(":"+this.maxValue)
        }.justifyContent(FlexAlign.End).width('50%')

      }.width('70%').justifyContent(FlexAlign.SpaceBetween)
    }
  }
}