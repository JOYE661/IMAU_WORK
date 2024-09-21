import { promptAction, router } from '@kit.ArkUI';

@CustomDialog

struct DialogUI{

  @State tel:string=''

  @State address:string=''

  @State message:string=''

  control?:CustomDialogController

  build() {

    Scroll(){

      Column() {

        Row() {

          Text('报修信息').fontSize(20).fontColor(Color.Black)

        }.width(400).padding(10).justifyContent(FlexAlign.Center)

        Row() {

          Text("联系方式:").fontSize(15).fontColor(Color.Black)

          TextInput({ placeholder: '手机号码' }).width(250)

        }.justifyContent(FlexAlign.Start).width("100%")

        Row() {

          Text("位置信息:").fontSize(15).fontColor(Color.Black)

          TextInput({ placeholder: '家庭住址' }).width(250)

        }.justifyContent(FlexAlign.Start).width("100%")

        Row() {

          Text("故障描述:").fontSize(15).fontColor(Color.Black)

          TextArea({ placeholder: '请详细描述故障特征'}).width(250).height(120)

        }.justifyContent(FlexAlign.Start).width(400)

        Row() {

          Button('提交').onClick(() => {

            promptAction.showToast({ message: "报修成功!" })

            this.control?.close()

          }).backgroundColor("#ff007dd7")

          Button('取消').onClick(() => {

            this.control?.close()

          }).backgroundColor("#ff007dd7")

        }.justifyContent(FlexAlign.SpaceEvenly).width(400).padding(10)

      }.width(400).height(300)

    }

  }

}

@Extend(Button) function deviceCarType(fontColor:string,borderColor:string){

  .type(ButtonType.Circle)

  .width(140)

  .backgroundColor("")

  .fontColor(fontColor)

  .border({width:3,color:borderColor})

  .fontSize(20)

  .fontWeight(700)

}

@Entry

@Component

struct DoorLock {

  @State message: string = '智能门锁';

  control?: CustomDialogController = new CustomDialogController({

    builder: DialogUI(),

    autoCancel: false,

    alignment: DialogAlignment.Bottom

  })



  build() {

    Column() {

      //顶部导航

      Row() {

        Image($r('app.media.u386')).width(40).onClick(() => {

          router.back()

        })

        Text($r('app.string.SmartFingerprint_AntitheftLock')).fontSize(20)

        Row() {

          Image($r('app.media.share')).onClick(()=>{

            AlertDialog.show({message:"是否进行分享",primaryButton:{

              value:"确认",

              action:()=>{

                promptAction.showToast({message:"分享成功"})

              }

            },

              secondaryButton:{

                value:"取消",

                action:()=>{

                  promptAction.showToast({message:"取消分享"})

                }

              }

            })

          }).width(30)

          Image($r('app.media.more')).onClick(()=>{

            AlertDialog.show({message:$r('app.string.more_action'),buttons:[

              {

                value:$r('app.string.add_favorites'),

                action:()=>{

                  promptAction.showToast({message:$r('app.string.add_success')})

                }

              },

              {

                value:$r('app.string.refresh_page'),

                action:()=>{

                  promptAction.showToast({message:$r('app.string.refresh_success')})

                }

              },

              {

                value:$r('app.string.copy_link'),

                action:()=>{

                  promptAction.showToast({message:$r('app.string.action_success')})

                }

              },

              {

                value:$r('app.string.exit'),

                action:()=>{

                  promptAction.showToast({message:$r('app.string.cancel_action')})

                }

              },

            ]})

          }).width(30)

        }

      }.backgroundColor("#d8e7d1").justifyContent(FlexAlign.SpaceBetween).width('100%').padding(10)



      //门锁

      Image($r('app.media.lock')).width('100%')

      //门锁状态

      Column() {

        Row() {

          Text($r('app.string.Devicestatus_isconnected')).fontSize(20).fontWeight(700)

        }

        .padding(10)

        .backgroundColor("#ffbde0e5")

        .border({ radius: { topLeft: 20, topRight: 20 } })

        .width("100%")

        .justifyContent(FlexAlign.Center)



        Stack() {

          Image($r("app.media.img_1")).border({ radius: { bottomLeft: 20, bottomRight: 20 } })

          Column() {

            Row() {

              Button($r('app.string.Access_Log')).deviceCarType("#FFF", "#fffae44e").backgroundColor("#ff034fc3")

                .onClick(() => {

                  router.pushUrl({ url: "pages/OpenPage" })

                })

              Button($r('app.string.Repair_Request')).onClick(() => {

                this.control?.open()

              }).deviceCarType("#FFF", "#ff00ff1b").backgroundColor("#ff034fc3")

            }.width("100%").justifyContent(FlexAlign.SpaceBetween)



            Row() {

              Button($r('app.string.Enroll_NewFingerprint')).onClick(() => {

                router.pushUrl({ url: 'pages/ZwPage' })

              }).deviceCarType("#FFF", "#ffff9800").backgroundColor("#ff034fc3")

              Button($r('app.string.Hijacking_Alert')).onClick(() => {

                router.pushUrl({ url: 'pages/GJPage' })

              }).deviceCarType("#FFF", "#ffff0000").backgroundColor("#ff034fc3")

            }.width("100%").justifyContent(FlexAlign.SpaceBetween)

          }.height(300).width(310).justifyContent(FlexAlign.SpaceBetween)

        }.height(362).width("100%")

      }.width("95%").height(400).margin(10)

    }.width('100%').height('100%')

  }

}