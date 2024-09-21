import { promptAction, router } from '@kit.ArkUI'

@Entry
@Component
struct PrivacyPage {
  build() {

    Column() {
      Row() {

        Image($r('app.media.u386')).width(20)
          .onClick(()=>{
          router.replaceUrl({
            url: "pages/Login"
          })
        })
        Row(){
          Text($r("app.string.privacy_message"))
        }.width("95%").justifyContent(FlexAlign.Center)

      }.width("100%").justifyContent(FlexAlign.SpaceBetween)

      Scroll() {
        Column() {


          Row() {



            Text($r("app.string.Specific_Privacy_Agreement"))
          }.width('100%').justifyContent(FlexAlign.Center)
          /* Row() {
             Text("点此关闭所有隐私协议")
                .onClick(() => {
                  router.replaceUrl({
                    url: "pages/Login"
                  })
                })
            }.width('100%').margin({left:10,right:10,bottom:10})*/
        }

      }

    }
  }
}