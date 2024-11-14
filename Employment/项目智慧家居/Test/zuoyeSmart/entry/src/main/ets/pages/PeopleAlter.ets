//用户信息修改页面
import router from '@ohos.router'
import { LoadingDialog, promptAction } from '@kit.ArkUI'
import { HttpUtil } from '../Model/HttpUtil'
import { http } from '@kit.NetworkKit'
import UserEntity from '../Model/UserEntity'

interface  UserInfo{
  //唯一标识,
  dvcUuid:string

}
interface  LoginMsg{
  msg:string
  success:boolean
  data:UserInfo
}
@Entry
@Component
struct Register {
  dialogControllerProgress: CustomDialogController = new CustomDialogController({
    builder: LoadingDialog({
      content: '保存成功',
    }),
  })
 @State user:UserEntity={
   userName: 'aaa',
   myword: 'bbb',
   password: '111',
   dvcUuid: 'aa1',
   homeNum:'3',
   roomNum:'2'
 }
  @State text: string = "请添加家庭设备"
  @State index: number = -1
  @State arrowPosition: ArrowPosition = ArrowPosition.END
  build() {
    Column() {
      Column(){
        Row() {
          Image($r('app.media.back_white')).width(30).height(30)
            .onClick(() => {
              router.back()
            })
          Text('用户修改').fontSize(25).fontColor('#ffffffff').fontWeight(500)
          Text('').fontSize(25).fontColor('').fontWeight(500)
        }.justifyContent(FlexAlign.SpaceBetween)
        .backgroundColor('#ff5099ff')
        .width('100%')
        .height('7%')

        Row() {
          Image($r('app.media.touxiang')).width(40).height(30)
          Image($r('app.media.jt')).width(30).height(30)
        }.justifyContent(FlexAlign.SpaceBetween)
        .width('95%')
        .height('10%')
        Divider().strokeWidth(1).color('#ffe3e3e3')

        Row() {
          Image($r('app.media.name')).width(30).height(30)
          TextInput({placeholder:'请输入新昵称',text:''}).width('95%').backgroundColor('#FFF')
            .onChange((val)=>[
              this.user.userName=val
            ])
        }
        .justifyContent(FlexAlign.SpaceBetween)
        .width('95%')
        .height('7%')
        Divider().strokeWidth(1).color('#ffe3e3e3')

        Row() {
          Image($r('app.media.qm')).width(30).height(30)
          TextInput({placeholder:'请输入个性签名'}).width('95%').backgroundColor('#FFF')
            .onChange((val:string)=>{
              this.user.myword=val
            })

        }.justifyContent(FlexAlign.SpaceBetween)
        .width('95%')
        .height('7%')
        Divider().strokeWidth(1).color('#ffe3e3e3')

        Row() {
          Image($r('app.media.jtgl')).width(30).height(30)
          //TextInput({placeholder:'请添加家庭设备'}).width('60%').backgroundColor('#FFF')
          Select([{ value: '洗碗机' },
            { value: '智能LED灯' },
            { value: '净化器' },
            { value: '智能门锁'},
            { value: '电水壶'},
            { value: '扫地机器人'}
          ])
            .width('85%')
            .selected(this.index)
            .value(this.text)
            .font({ size: 16, weight: 300 })
            .fontColor('#ff777b7e')
            .selectedOptionFont({ size: 16, weight: 400 })
            .optionFont({ size: 16, weight: 400 })
            .arrowPosition(this.arrowPosition)
            .menuAlign(MenuAlignType.START, {dx:0, dy:0})
            .optionWidth(200)
            .optionHeight(300)
            .divider( null )
            .onSelect((index:number, text?: string | undefined)=>{
              console.info('Select:' + index)
              this.index = index;
              if(text){
                this.text = text;
               this.user.homeNum+=1
              }
            })
        }.width('100%')
        .justifyContent(FlexAlign.SpaceBetween)
        .width('95%')
        .height('7%')
        Divider().strokeWidth(1).color('#ffe3e3e3')

        Row(){
          Image($r('app.media.fj')).width(30).height(30)
          TextInput({placeholder:'请添加房间数量'}).width('60%').backgroundColor('#FFF')
            .onChange((val)=>{
              this.user.roomNum=val
            })
          Button('').width('60%').backgroundColor('#fff').fontColor('#ff020202')
        }.justifyContent(FlexAlign.SpaceBetween)
          .width('95%')
          .height('7%')
        Divider().strokeWidth(1).color('#ffe3e3e3')


      }
      Row(){
        Button('保存').width('50%')
          .onClick(() => {
            this.sendUpdateMsg()
            //this.dialogControllerProgress.open()

          })
        Button('取消').width('50%')
      }.justifyContent(FlexAlign.SpaceBetween)

    }.width('100%')
    .height('100%')
    .alignItems(HorizontalAlign.Center)
    .justifyContent(FlexAlign.SpaceBetween)
  }
  sendUpdateMsg(){
    HttpUtil.sendHttpMsg({
      url: '/user/updateUserAll',
      extraData: [
        {name:'dvcUuid',value:this.user.dvcUuid},
        {name:'userName',value: this.user.userName},
        {name:'myword',value:this.user.myword},
        {name:'homeNum',value:this.user.homeNum},
        {name:'roomNum',value:this.user.roomNum}
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

