import { router } from '@kit.ArkUI'
@Observed
class Param{
  showFlag:boolean = true
  title?:ResourceStr = ''
  height:Length = 300
}

@CustomDialog
struct DialogUI{
  control?:CustomDialogController
  @Prop contents:string
  build() {
    Column(){
      Row(){
        Text($r("app.string.MyPage_QRcode")).fontSize(20)
      }.width("100%").padding(10)
      .justifyContent(FlexAlign.Center)
      Divider()
      Column(){
        QRCode("https:www.baidu.com")
      }.height(300).width("100%").justifyContent(FlexAlign.Center)
      Divider().margin({top:10,bottom:10})
      Row(){
        Button($r("app.string.page_close")).onClick(()=>{
          this.control?.close()
        }).margin(15)
      }.width("100%").justifyContent(FlexAlign.SpaceEvenly)
    }
  }
}

@Component
struct PanelCom{
  @ObjectLink param:Param
  @BuilderParam body?:()=>void
  @Builder titleBar(){
    Row(){
      if (this.param.title){
        Row(){
          Text(this.param.title)
        }.width('100').padding(10).justifyContent(FlexAlign.Center)
        .border({width:{bottom:1}})
      }
    }
  }
  build() {
    Row().bindSheet($$this.param.showFlag,this.body,{
      dragBar:true,
      title:this.titleBar(),
      detents:[this.param.height,800,100]
    })
  }
}
@Entry
@Component
export default struct MyPage{
  @State userParam:Param = {
    showFlag:false,
    title:$r("app.string.MyPage_ChangeName"),
    height:200
  }
  @State ncParam:Param = {
    showFlag:false,
    title:$r("app.string.MyPage_ChangeNickname"),
    height:200
  }
  @State emailParam:Param = {
    showFlag:false,
    title:$r("app.string.MyPage_ChangeEmail"),
    height:200
  }
  @State phoneParam:Param = {
    showFlag:false,
    title:$r("app.string.MyPage_ChangePhone"),
    height:200
  }
  @State userName:string ='zhang san'
  @State userNc:string='zs111'
  @State userEmail:string='qyx@163.com'
  @State userPhone:string='16253647'
  @State temp:string =''
  control:CustomDialogController = new CustomDialogController({
    builder:DialogUI({
      contents:"111"
    }),
    autoCancel:false,
    alignment:DialogAlignment.Bottom
  })
  build() {
    Column(){
      Row(){
        Row() {
          Image($r("app.media.back_white")).width(30)
        }.justifyContent(FlexAlign.Start)
        .onClick(()=>{
          router.back()
        })
        Row() {
          Text($r("app.string.MyPage_Usermessage")).fontColor("#FFF").fontSize(20).fontWeight(700)
        }
      }.width("100%").padding(10).backgroundColor("#ffc4bff5")
      Column() {
        Row() {
          Text($r("app.string.MyPage_avatar")).fontSize(20)
          Row(){
            Image($r("app.media.avatar")).width(80).borderRadius(50)
            Image($r("app.media.u395")).width(10)
          }

        }.rowBlock()

        Row(){
          Text($r("app.string.MyPage_Username")).fontSize(20)
          Row() {
            Text(this.userName+"  ").fontSize(20)

            Image($r("app.media.u395")).width(10)
          }.justifyContent(FlexAlign.SpaceAround)
        }.rowBlock()

        .onClick(()=>{
          this.userParam.showFlag = true
        })

        Row() {
          Text($r("app.string.MyPage_PQRcode")).fontSize(20)
          Row() {
            Image($r("app.media.u395")).width(10)
          }.justifyContent(FlexAlign.SpaceAround)
          .onClick(()=>{
            this.control.open()
          }).margin({top:10})
        }.rowBlock()

        Row() {
            Text($r("app.string.MyPage_nickame")).fontSize(20)
          Row() {
            Text(this.userNc + "  ").fontSize(20)
            Image($r("app.media.u395")).width(10)
          }.justifyContent(FlexAlign.SpaceAround)
        }.rowBlock()
        .onClick(()=>{
          this.ncParam.showFlag = true
        })

        Row(){
          Text($r("app.string.MyPage_email")).fontSize(20)
          Row() {
            Text(this.userEmail+"  ").fontSize(20)
            Image($r("app.media.u395")).width(10)
          }.justifyContent(FlexAlign.SpaceAround)
        }.rowBlock()
        .onClick(()=>{
          this.emailParam.showFlag = true
        })

        Row(){
          Text($r("app.string.MyPage_phoneNumber")).fontSize(20)
          Row() {
            Text(this.userPhone+"  ").fontSize(20)
            Image($r("app.media.u395")).width(10)
          }.justifyContent(FlexAlign.SpaceAround)
        }.rowBlock()
        .onClick(()=>{
          this.phoneParam.showFlag = true
        })

        PanelCom({param:this.userParam}){
          Column(){
            TextInput({text:this.temp}).onChange((val)=>{
              this.temp = val;
            }).onAppear(()=>{
              this.temp = this.userName
            })
            Button($r("app.string.button_ok")).fontColor("#fff17171").width('95%').backgroundColor("#fee").margin(20).onClick(()=>{
              this.userName = this.temp
              this.userParam.showFlag = false
            })
          }.width('100%').height('100%').justifyContent(FlexAlign.Center)
        }
        PanelCom({param:this.ncParam}){
          Column(){
            TextInput({text:this.temp}).onChange((val)=>{
              this.temp = val;
            }).onAppear(()=>{
              this.temp = this.userNc
            })
            Button($r("app.string.button_ok")).fontColor("#fff17171").width('95%').backgroundColor("#fee").margin(20).onClick(()=>{
              this.userNc = this.temp
              this.ncParam.showFlag = false
            })
          }.width('100%').height('100%').justifyContent(FlexAlign.Center)
        }
        PanelCom({param:this.emailParam}){
          Column(){
            TextInput({text:this.temp}).onChange((val)=>{
              this.temp = val;
            }).onAppear(()=>{
              this.temp = this.userEmail
            })
            Button($r("app.string.button_ok")).fontColor("#fff17171").width('95%').backgroundColor("#fee").margin(20).onClick(()=>{
              this.userEmail = this.temp
              this.emailParam.showFlag = false
            })
          }.width('100%').height('100%').justifyContent(FlexAlign.Center)
        }
        PanelCom({param:this.phoneParam}){
          Column(){
            TextInput({text:this.temp}).onChange((val)=>{
              this.temp = val;
            }).onAppear(()=>{
              this.temp = this.userPhone
            })
            Button($r("app.string.button_ok")).fontColor("#fff17171").width('95%').backgroundColor("#fee").margin(20).onClick(()=>{
              this.userPhone = this.temp
              this.phoneParam.showFlag = false
            })
          }.width('100%').height('100%').justifyContent(FlexAlign.Center)
        }
      }.backgroundColor("#FFF")
    }.width("100%").height("100%").backgroundColor("#EEE")
  }
}
@Extend(Row) function rowBlock(){
  .width("100%")
  .padding(10)
  .justifyContent(FlexAlign.SpaceBetween)
  .border({width:{bottom:1},color:"#AAA"})
}