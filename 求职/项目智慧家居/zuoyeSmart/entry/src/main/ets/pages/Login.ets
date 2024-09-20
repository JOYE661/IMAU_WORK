import router from '@ohos.router'
import { promptAction } from '@kit.ArkUI'
import http from '@ohos.net.http'
import { HttpUtil } from '../Model/HttpUtil'

interface  UserInfo{
  //唯一标识,
  userUuid:string

}
interface  LoginMsg{
  msg:string
  success:boolean
  data:UserInfo
}
@Entry
@Component
struct Login {
  @State userName: string = ''
  @State password: string = ''
  @State userUuid: string = ''
  build() {

    Column(){
      Column(){
        Image($r('app.media.u35')).width(120).height(120)
        Text('通鸿智能家居').fontSize(18).fontColor('#ff5196c4').fontWeight(500)
      }.height(150)
      .justifyContent(FlexAlign.SpaceBetween)

      Column(){
        Row(){
          Image($r('app.media.user_name')).width(30).height(30)
          TextInput({placeholder:'请输入用户名',text:this.userName}).width('88%')
            .onChange((val) => {
              this.userName = val;
            })
        }.width('95%')
        .justifyContent(FlexAlign.SpaceBetween)

        Row(){
          Image($r('app.media.pwd')).width(30).height(30)
          TextInput({placeholder:'请输入密码',text:this.password}).width('88%')
            .onChange((val) => {
              this.password = val;
            })
        }.width('95%')
        .justifyContent(FlexAlign.SpaceBetween)

        Row(){
          Text('忘记密码').fontSize(13).onClick(()=>{
            router.pushUrl({
              url: 'pages/ForgetPassword'
            })
          })
          Text('立即注册').fontSize(13)
            .onClick(()=>{
              router.pushUrl({
                url: 'pages/Register'
              })
            })
        }.width('95%')
        .justifyContent(FlexAlign.SpaceBetween)

        Button('登录').width('95%').onClick(()=>{
          //要求用户名不少于4位，密码不少于6位
          let userInfoReg=new RegExp('^.{4,}$')
          let passwordReg=new RegExp('^.{6,}$')
          if(!userInfoReg.test(this.userName)){
            promptAction.showToast({
              message:'用户名格式不正确',
              duration: 3000,
            })
            return;
          }
          if (!passwordReg.test(this.password)) {
            promptAction.showToast({
              message: '密码格式不正确',
              duration: 3000

            })
            return;
          }
          this.sendLoginMsg()
          //router.replaceUrl({url:'pages/Index'})
        })

      }.height(190)
      .justifyContent(FlexAlign.SpaceBetween)

      Row(){
        Text('')
      }.height(30)

    }.width('100%')
    .height('100%')
    .alignItems(HorizontalAlign.Center)
    .justifyContent(FlexAlign.SpaceBetween)
  }

  sendLoginMsg(){
    HttpUtil.sendHttpMsg({
      url: '/user/login',
      extraData: [
        {name:'userName',value: this.userName},
        { name: 'password', value: this.password }
      ],
      method: http.RequestMethod.POST,
      success: (loginMag: LoginMsg) => {
        promptAction.showToast({ message: loginMag.msg })
        if(loginMag.success){
          //this.userUuid=loginMag.obj.userUuid
          router.replaceUrl({url:'pages/Index'})
        }
      }
    })
  }
}