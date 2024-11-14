//注册页面
import router from '@ohos.router'

@Entry
@Component
struct Register {
  build() {
    Column() {
      Column(){
        Row() {
          Image($r('app.media.back_white')).width(30).height(30)
            .onClick(() => {
              router.back()
            })
          Text('忘记密码').fontSize(25).fontColor('#ffffffff').fontWeight(500)
          Text('').fontSize(25).fontColor('').fontWeight(500)
        }.justifyContent(FlexAlign.SpaceBetween)
        .backgroundColor('#ff5099ff')
        .width('100%')
        .height('7%')

        Row() {
          Image($r('app.media.sj')).width(30).height(30)
          TextInput({placeholder:'请输入手机号'}).width('95%').backgroundColor('#FFF')

        }.justifyContent(FlexAlign.SpaceBetween)
        .width('95%')
        .height('7%')
        Divider().strokeWidth(1).color('#ffe3e3e3')
        Row() {
          Image($r('app.media.yzm')).width(30).height(30)
          TextInput({placeholder:'请输入验证码'}).width('60%').backgroundColor('#FFF')
          Button('发送验证码').width('40%').backgroundColor('#ff4098f1').fontColor('#ff020202')

        }.justifyContent(FlexAlign.SpaceBetween)
        .width('95%')
        .height('7%')
        Divider().strokeWidth(1).color('#ffe3e3e3')

        Row() {
          Image($r('app.media.mm')).width(30).height(30)
          TextInput({placeholder:'请输入原密码'}).width('95%').backgroundColor('#FFF').type(InputType.Password)

        }
        .justifyContent(FlexAlign.SpaceBetween)
        .width('95%')
        .height('7%')
        Divider().strokeWidth(1).color('#ffe3e3e3')

        Row() {
          Image($r('app.media.mm')).width(30).height(30)
          TextInput({placeholder:'请输入新密码'}).width('95%').backgroundColor('#FFF').type(InputType.Password)

        }.justifyContent(FlexAlign.SpaceBetween)
        .width('95%')
        .height('7%')
        Divider().strokeWidth(1).color('#ffe3e3e3')

        Row() {
          Image($r('app.media.mm')).width(30).height(30)
          TextInput({placeholder:'请输入确认密码'}).width('95%').backgroundColor('#FFF').type(InputType.Password)

        }.justifyContent(FlexAlign.SpaceBetween)
        .width('95%')
        .height('7%')
        Divider().strokeWidth(1).color('#ffe3e3e3')
        Row(){
          Text('*请注意：密码长度为8-16位，并包括数字，小写字母，大写字母和特殊符合4类中至少3类').fontSize(13).fontColor('#ffd92626').fontWeight(400)
        }
        Row(){
          Button('提交').width('100%')
        }
      }


    }.width('100%')
    .height('100%')
    .alignItems(HorizontalAlign.Center)
    .justifyContent(FlexAlign.SpaceBetween)
  }
}

