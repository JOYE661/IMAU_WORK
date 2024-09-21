import router from '@ohos.router'
import { promptAction } from '@kit.ArkUI'
import http from '@ohos.net.http'
import { HttpUtil } from '../Model/HttpUtil'
import UserEntity from '../Model/UserEntity'

interface  UserInfo{
  //唯一标识,
  userUuid:string

}
interface  LoginMsg{
  msg:string
  success:boolean
  data:UserInfo
}
@Extend (Image) function headIcon(){
  .width(30).margin({right:5})
}
@Extend (Text)function headText(){
  .fontSize(25)
}
@Extend(Image)function headRight(){
  .width(20)
}
@Extend(Row)function rowBlock(){
  .width("100%")
    .padding({left:15,right:15,top:15,bottom:15})
    .justifyContent(FlexAlign.SpaceBetween)}


@Component
export default struct MyInfo{
  @State user:UserEntity= {
    userName: '农大学生',
    myword: 'zbcd',
    password: '111',
    dvcUuid: 'aa1',
    homeNum:'5',
    roomNum:'8'
  }
  @State dvcUuid:string='aa1'
  queryUserDetails(){
    HttpUtil.sendHttpMsg({
      url:'/user/showDetails',
      extraData:[{name:'dvcUuid',value:this.dvcUuid}],
      method:http.RequestMethod.GET,
      success: (user: UserEntity) => {
        console.log("user1: "+JSON.stringify(user))
        this.user=user;
        console.log("user2: "+JSON.stringify(this.user))
      }
    })
  }

  aboutToAppear(): void {
    this.queryUserDetails();
    console.log('username: '+this.user.userName)
  }

  build(){
    Column(){
      Stack({alignContent:Alignment.Bottom}){
        Stack({alignContent:Alignment.Top}){
          Stack({alignContent:Alignment.TopEnd}){
            Swiper() {
              Image($r('app.media.MyInfo1')).width(25).height(25)
                .width('90%')
                .height('100%')

              Image($r('app.media.MyInfo2')).width(25).height(25)
                .width('90%')
                .height('100%')

              Image($r('app.media.MyInfo3')).width(25).height(25)
                .width('90%')
                .height('100%')
            }.loop(true)
            .autoPlay(true)
            .interval(1000)
            .width('100%')
            .height('100%')
            Image($r("app.media.edit")).width(40).onClick(()=>{
              router.pushUrl({url:"pages/People"})
            })
          }.height("100%").width("100%")//endStack
          Column(){
            Image($r("app.media.sdq")).width(70).margin({bottom:7})
            Text(this.user.userName).fontColor("#ff020202").fontSize(20).margin({bottom:7})
            Text(this.user.myword).fontColor("#ff181818").fontSize(20).margin({bottom:7})
          }.margin({top:20})
        }.width("100%")//endStack
        Row(){
          Column(){
            Text("家庭管理")
            Text(this.user.homeNum.toString()).fontColor("#0064B3")
          }.flexGrow(1).justifyContent(FlexAlign.Center)
          .alignItems(HorizontalAlign.Center)
          Row().backgroundColor("#AAA").flexBasis(1).height("80%")
          Column(){
            Text("当前房间")
            Text(this.user.roomNum.toString()).fontColor("#0064B3")
          }.flexGrow(1).justifyContent(FlexAlign.Center)
          .alignItems(HorizontalAlign.Center)
        }.width("95%").height(60).backgroundColor("#FFF")
        .borderRadius(10).margin({bottom:3})
      }.height(230)//endStack
      Row(){
        Row(){
          Image($r("app.media.myinfoListicon")).headIcon()
          Text("健康管理").headText()
        }
        Image($r("app.media.right")).headRight()
      }.rowBlock()
      Row(){
        Row(){
          Image($r("app.media.myinfoListicon2")).headIcon()
          Text("版本升级").headText()
        }
        Image($r("app.media.right")).headRight()
      }.rowBlock()
      Row(){
        Row(){
          Image($r("app.media.myinfoListicon3")).headIcon()
          Text("帮助中心").headText()
        }
        Image($r("app.media.right")).headRight()
      }.rowBlock()
      Row(){
        Row(){
          Image($r("app.media.myinfoListicon4")).headIcon()
          Text("意见反馈").headText()
        }
        Image($r("app.media.right")).headRight()
      }.rowBlock()
      Row(){
        Row(){
          Image($r("app.media.myinfoListicon5")).headIcon()
          Text("清理缓存").headText()
        }
        Image($r("app.media.right")).headRight()
      }.rowBlock()
      Row(){
        Row(){
          Image($r("app.media.myinfoListicon6")).headIcon()
          Text("关于我们").headText()
        }
        Image($r("app.media.right")).headRight()
      }.rowBlock()
    }.width("100%").height("100%")//endpage
    .backgroundColor("#F8F8F8")
  }


}