import { router } from '@kit.ArkUI'
@Entry
@Component
struct Register {
  build() {
    Column() {
      Row() {
        Image($r('app.media.back_white')).flexBasis(30).width(30)
          .onClick(() => {
            router.back()
          })
        Row() {
          Text($r("app.string.forgot_password")).fontSize(30)
            .fontWeight(700).fontColor('#fff5eeee')
        }.margin({ right: 30 }).flexGrow(1)
        .justifyContent(FlexAlign.Center)
      }.width('100%').height(60).backgroundColor(Color.Blue)

      Divider().strokeWidth(5).color('Color.green')
      Row() {
        Image($r('app.media.email')).width(30).height(30)
        TextInput({ placeholder: $r("app.string.Enter_email")}).width('88%')
      }.width('100%')
      .justifyContent(FlexAlign.SpaceBetween)
      .margin({ top: 20 })

      Row() {
        Image($r('app.media.pwd')).width(30).height(30)
        TextInput({ placeholder: $r("app.string.New_password") }).width('88%').type(InputType.Password)
      }.width('100%')
      .justifyContent(FlexAlign.SpaceBetween)
      .margin({ top: 20 })

      Row() {
        Image($r('app.media.confirm')).width(30).height(30)
        TextInput({ placeholder: $r("app.string.Confirm_password") }).width('88%').type(InputType.Password)
      }.width('100%')
      .justifyContent(FlexAlign.SpaceBetween)
      .margin({ top: 20 })

      Row() {
        Image($r('app.media.send')).width(30).height(30)
        TextInput({ placeholder: $r("app.string.code1")}).width('50%')
        Text($r("app.string.code2")).fontSize(20).fontWeight(15)
      }.width('95%')
      .justifyContent(FlexAlign.SpaceBetween)
      .margin({ top: 20 })

      Button($r("app.string.button_ok"))
        .onClick(()=>{
          router.pushUrl({
            url:'Pages/Login'
          })
        })
        .width('100%').height(50).margin({ top: 20 })
      Row() {
        Checkbox()
        Text($r("app.string.privacy_message5")).fontSize(20)
      }//.height('100%')
      .margin({top:230})
    }.width('100%')
    .height('100%')
    .alignItems(HorizontalAlign.Center)

  }


}