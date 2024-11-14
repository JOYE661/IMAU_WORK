import viewmodel from '../../viewmodel/MainViewModel'
import VideoBean from '../bean/VideoBean'
@Preview
@Entry
@Component
export struct LookVideo{

  build(){
    Column(){
      Swiper(){
        ForEach(viewmodel.getAllVideos(),(item:VideoBean,index?:number)=>{
          PlayView({ videoBean: item})
        },item=>item.toString())
      }.vertical(true)
      .width("100%")
      .height("100%")
      .indicator(false)
    }
  }
}

@Component
struct PlayView{
  @State videoBean:VideoBean=null

  build() {
    Stack() {
      Video({
        src: this.videoBean.src
      }).width('100%')
        .height('40%')
        .autoPlay(true)
        .controls(false)

      Column() {
        //头像
        Image($r('app.media.frog_head_pic'))
          .width(50).height(50)
          .borderRadius(25)
          .borderWidth(1)
        // 点赞
        Column({ space: 5 }) {
          Image($r('app.media.like1'))
            .width(50).height(50)
          Text(this.videoBean.likeCount + "").fontColor(Color.White)
        }.alignItems(HorizontalAlign.Center).margin({ top: 10 })
        //评论
        Column({ space: 5 }) {
          Image($r('app.media.comment3'))
            .width(40).height(40)
          Text(this.videoBean.commentCount + "").fontColor(Color.White)
        }.alignItems(HorizontalAlign.Center).margin({ top: 15 })
        //分享
        Column({ space: 5 }) {
          Image($r('app.media.share3'))
            .width(40).height(40)
          Text(this.videoBean.shareCount + "").fontColor(Color.White)
        }.alignItems(HorizontalAlign.Center).margin({ top: 10 })
      }
      .width('100%')
      .alignItems(HorizontalAlign.End)
      .padding({right:15})
      //视频描述信息
      Column({ space: 5 }) {
        Text("@" +this.videoBean.author).fontColor(Color.White)
        Text(this.videoBean.title).fontColor(Color.White)
        Text(this.videoBean.desc).fontColor(Color.White)
      }
      .width("100%")
      .height("30%")
      .offset({ y:"40%"})
      .alignItems(HorizontalAlign.Start)
      .padding({ left: 5})
      }.backgroundColor(Color.Black)
    }
  }