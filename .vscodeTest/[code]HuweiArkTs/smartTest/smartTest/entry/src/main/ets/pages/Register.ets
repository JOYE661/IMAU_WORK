//注册页面
import router from '@ohos.router'
import { promptAction } from '@kit.ArkUI'
import http from '@ohos.net.http'
import { HttpUtil } from '../model/HttpUtil'

interface  UserInfo{
  //唯一标识,
  userUuid:string

}
interface  LoginMsg{
  username:string,
  password:string
}
@Entry
@Component
struct Register {
  @State userName: string = ''
  @State password1: string = ''
  @State password2: string = ''
  build() {
    Column() {
      Column(){
        Row() {
          Image($r('app.media.back_white')).width(30).height(30)
            .onClick(() => {
              router.back()
            })
          Text('注册用户').fontSize(25).fontColor('#ffffffff').fontWeight(500)
          Text('').fontSize(25).fontColor('').fontWeight(500)
        }.justifyContent(FlexAlign.SpaceBetween)
        .backgroundColor('#ff5099ff')
        .width('100%')
        .height('7%')

        Row() {
          //Image($r('app.media.own')).width(30).height(30)
          TextInput({placeholder:'请输入用户名',text:this.userName}).width('95%').backgroundColor('#FFF')
            .onChange((val)=>{
              this.userName=val;
            })

        }.justifyContent(FlexAlign.SpaceBetween)
        .width('95%')
        .height('7%')
        Divider().strokeWidth(1).color('#ffe3e3e3')

        Row() {
          Image($r('app.media.confirm')).width(30).height(30)
          TextInput({placeholder:'请输入新密码',text:this.password1}).width('95%').backgroundColor('#FFF').type(InputType.Password)
            .onChange((val)=>{
              this.password1=val;
            })

        }
        .justifyContent(FlexAlign.SpaceBetween)
        .width('95%')
        .height('7%')
        Divider().strokeWidth(1).color('#ffe3e3e3')

        Row() {
          Image($r('app.media.confirm')).width(30).height(30)
          TextInput({placeholder:'请输入确认密码',text:this.password2}).width('95%').backgroundColor('#FFF').type(InputType.Password)
            .onChange((val)=>{
              this.password2=val;
            })

        }.justifyContent(FlexAlign.SpaceBetween)
        .width('95%')
        .height('7%')
        Divider().strokeWidth(1).color('#ffe3e3e3')

        // Row() {
        //   Image($r('app.media.send')).width(30).height(30)
        //   TextInput({placeholder:'请输入验证码'}).width('60%').backgroundColor('#FFF')
        //   Button('获取验证码').width('40%').backgroundColor('#fff').fontColor('#ff020202')
        //
        // }.justifyContent(FlexAlign.SpaceBetween)
        // .width('95%')
        // .height('7%')
        //   Divider().strokeWidth(1).color('#ffe3e3e3')
        Button('注册').width('100%').onClick(()=>{
          if(this.password1===this.password2){
            this.sendLoginMsg()
          }else{
            promptAction.showToast({message:'密码不一致'})
          }

        })
      }

      Column() {
        Row() {
          Toggle({ type: ToggleType.Checkbox, isOn: false })
          Text('请勾选同意').fontSize(18).fontColor('#ff5dcde2').fontWeight(500)
          Text('《用户使用协议》').fontSize(18).fontWeight(500)
        }
      }
    }.width('100%')
    .height('100%')
    .alignItems(HorizontalAlign.Center)
    .justifyContent(FlexAlign.SpaceBetween)
  }


  // sendLoginMsg(){
  //   HttpUtil.sendHttpMsg({
  //     url: '/user/register',
  //     extraData: [
  //       {name:'username',value: this.userName},
  //       { name: 'password', value: this.password1 }
  //     ],
  //     method: http.RequestMethod.POST,
  //     success: (loginMag: LoginMsg) => {
  //       promptAction.showToast({ message: loginMag.msg })
  //       if(loginMag!=null){
  //         //this.userUuid=loginMag.obj.userUuid
  //         router.replaceUrl({url:'pages/Login'})
  //       }
  //     }
  //   })
  // }
  sendLoginMsg(){
    HttpUtil.sendHttpMsg({
      url: '/user/register',
      extraData: [
        {name:'username',value: this.userName},
        { name: 'password', value: this.password1 }
      ],
      method: http.RequestMethod.POST,
      success: (loginMag: LoginMsg) => {
        if(loginMag!=null){
          promptAction.showToast({ message: '注册成功'})
          router.replaceUrl({url:'pages/Login'})

        }else{
          promptAction.showToast({ message: '注册失败'})
        }


      }
    })
  }
}

/*  Column() {
      Row() {
        Image($r('app.media.back_white')).width(40)
        Row() {
          Text('用户注册').fontSize(30)
            .fontWeight(700).fontColor('#FFF')
        }.margin({ right: 30 }).flexGrow(1)
        .justifyContent(FlexAlign.Center)
      }.width('95%').backgroundColor(Color.Blue)
      Divider().strokeWidth(5).color('#ff807a7a')
    }.height('100%')
    .width('100%')
    .alignItems(HorizontalAlign.Center)

  }
}
*/