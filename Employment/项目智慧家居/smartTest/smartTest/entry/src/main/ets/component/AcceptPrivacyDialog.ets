import { router } from '@kit.ArkUI';

@CustomDialog

export default struct AcceptPrivacyDialog {

  controller:CustomDialogController = new CustomDialogController({
    builder:AcceptPrivacyDialog

  });

  cancel ?: ()=>void;
  confirm ?: ()=>void;

  build() {

    Column(){

      Text($r('app.string.privacy_message1'))
        .fontSize(20).fontWeight(700)
        .width('100%')
        .fontWeight(FontWeight.Bold)
        .margin({top:8})
      Text($r('app.string.privacy_message2'))
        .fontSize(14)
      Text($r('app.string.privacy_message3')).fontSize(14)
      Text($r('app.string.privacy_message4')).fontSize(20).fontWeight(700)
        .fontColor("#ff59a2dd")
        .onClick(()=>{
          router.pushUrl({
            url:"pages/PrivacyPage"
          })
          this.controller.close()

      })
        .fontSize(14)
        .width('100%')

      Row(){
        Button($r('app.string.button_cancel'))
          .onClick(()=>{
            this.controller.close();
            if(this.cancel){
              this.cancel()
            }
          })
        Button($r('app.string.button_ok'))
          .onClick(()=>{
            this.controller.close();
            if(this.confirm){
              this.confirm()
            }
          })
      }
      .width("100%")
      .justifyContent(FlexAlign.SpaceEvenly)
      .margin({top:10,bottom:10})



    }.width('95%')
    .padding(10)


  }
}

