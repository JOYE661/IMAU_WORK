import router from '@ohos.router'
import promptAction from '@ohos.promptAction'
import http from '@ohos.net.http'
import { HttpUtil } from '../model/HttpUtil'
import { common } from '@kit.AbilityKit'
import AcceptPrivacyDialog from '../component/AcceptPrivacyDialog'
import { Dialog } from '../component/Dialog'

//import { JSON } from '@kit.ArkTS'
interface UserInfo {
  userUuid: string
}
interface  LoginMsg {
  // msg: string
  // success: boolean
  // obj: UserInfo

  username:string,
  password:string
}
@Entry
@Component
struct Login {
  @State username: string = ''
  @State password: string = ''
@State userUuid:string=''
  control:CustomDialogController = new CustomDialogController({
    builder:Dialog(),
    autoCancel:false,
    alignment:DialogAlignment.Center
  })

  context: common.UIAbilityContext = getContext(this) as common.UIAbilityContext

  dialogController: CustomDialogController = new CustomDialogController(
    {
      builder: AcceptPrivacyDialog({
        cancel:()=>{
          this.closeApp()
        }
      }),
      autoCancel:false,
      alignment:DialogAlignment.Bottom,
      offset:{dx:0,dy:-26}
    }
  )
  closeApp(){
    console.info('退出应用中>>>>')
    this.context.terminateSelf();
  }
  aboutToAppear(): void {
    this.dialogController.open();
  }

  build() {
    Column() {
      Column() {
        Image($r('app.media.u35')).width(120).height(120)
        Text($r('app.string.app_name')).fontSize(20).fontColor('#ff518fb8').fontWeight(500)
      }.height(170)
      .justifyContent(FlexAlign.SpaceBetween)

      Column() {
        Row() {
          Image($r('app.media.user_name')).width(30).height(30)
          TextInput({ placeholder: $r('app.string.user_prompt'), text: this.username }).width('88%')
            .onChange((value: string) => {
              this.username = value
            })
        }.width('95%')
        .justifyContent(FlexAlign.SpaceBetween)

        Row() {
          Image($r('app.media.pwd')).width(30).height(30)
          TextInput({ placeholder: $r('app.string.password_prompt'), text: this.password }).width('88%')
            .type(InputType.Password)//将密码进行隐藏

          .onChange((value: string) => {
              this.password = value
            })
        }.width('95%')
        .justifyContent(FlexAlign.SpaceBetween)

        Row() {
          Text($r('app.string.forgot_password')).fontSize(19)
            .onClick(()=>{
              router.pushUrl({
                url: "pages/LostPasswordPage"
              })
            })
          Text($r('app.string.register')).fontSize(19)
            .onClick(() => {
              router.pushUrl({
                url: 'pages/Register'
              })
            })
        }.width('95%')
        .justifyContent(FlexAlign.SpaceBetween)

        Button($r('app.string.app_login')).width('95%')//要求用户名不少于4位，密码不少于6位
          .onClick(() => {
            let userInFoReg = new RegExp('^.{4,}$')
            let passwordReg = new RegExp('^.{6,}$')
            if (!userInFoReg.test(this.username)) {
              promptAction.showToast({
                message: $r('app.string.username_err'),
                duration: 3000
              })
              return;
            }
            if (!passwordReg.test(this.password)) {
              promptAction.showToast({
                message: $r('app.string.password_err'),
                duration: 3000
              })
              return;
            }
            this.sendLoginMsg()
            router.pushUrl({
            url: 'pages/index'
            })
          })
      }.height(300)
      .justifyContent(FlexAlign.SpaceBetween)

    }.width('100%')
    .height('78%')
    .alignItems(HorizontalAlign.Center)
    .justifyContent(FlexAlign.SpaceBetween)
  }

  /*sendLoginMsg() {
    let httpRequest = http.createHttp()
    httpRequest.request('http://1.92.113.192:8090/api/user/login', {
      method: http.RequestMethod.POST,
      header: {
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      extraData: `userName=${this.userName}&password=${this.password}`
    }, (err, data) => {
      if (!err) {
        console.info('http request success:' + JSON.stringify(data.result))
        let loginMsg: LoginMsg =JSON.parse(`${data.result}`);
if(loginMsg.success){
  promptAction.showToast({message:'登录成功'})
  router.pushUrl({
    url: 'pages/Index'
  })
}
      } else {
        console.info('http request failed:' + JSON.stringify(data) + '.err: ' + JSON.stringify(err))
        httpRequest.destroy();
      }
    }
    )
  }*/
  // sendLoginMsg() {
  //   HttpUtil.sendHttpMsg({
  //     url:'/user/login',
  //     extraData:[
  //       {name:'userName',value:this.userName},
  //       {name:'password',value:this.password}
  //     ],
  //     method:http.RequestMethod.POST,
  //     success:(loginMsg:LoginMsg)=>{
  //       //promptAction.showToast({message:loginMsg.msg})
  //       if(loginMsg.success){
  //         this.userUuid=loginMsg.obj.userUuid
  //         this.control.open()
  //         /*router.replaceUrl({
  //           url:'pages/Index'
  //         })*/
  //       }
  //     }
  //   })
  // }


  sendLoginMsg(){
    HttpUtil.sendHttpMsg({
      url: '/user/login',
      extraData: [
        {name:'username',value: this.username},
        { name: 'password', value: this.password }
      ],
      method: http.RequestMethod.POST,
      success: (loginMag: LoginMsg) => {
        if(loginMag!=null){
          promptAction.showToast({ message: '登陆成功'})
          router.replaceUrl({url:'pages/Index'})

        }else{
          promptAction.showToast({ message: '登陆失败'})
        }


      }
    })
  }
}