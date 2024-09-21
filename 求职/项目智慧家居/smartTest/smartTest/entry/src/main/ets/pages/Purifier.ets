import { router } from '@kit.ArkUI';
@Extend(Row)function animateCire(){
  .width(250)
  .height(250)
  .border({
    width:2,
    radius:120,
    color:"#FFF"
  })
}
//const total:number=360

@Entry
@Component
struct Purifier {
  //@State message: string = '空气净化器';
  @State scaleX1:number=1
  @State scaleX2:number=1
  @State scaleX3:number=1

  /*
    @State curVal:number=0
    addStep(){
      setTimeout(()=>{
        this.addStep()
        this.curVal+=180;
        if (this.curVal%(total+180)==0) {
          this.curVal=0
        }
      },1000)

    }
    aboutToAppear(): void {
      this.addStep()
    }

  */
  build() {
    Column() {
      //顶部导航
      Column() {
        Row() {
          Image($r("app.media.back_white")).width(30).onClick(() => {
            router.back()
          })
          Text($r("app.string.air_cleaner")).fontColor("#FFF").fontSize(20).fontWeight(700)
          Image($r("app.media.more")).width(50)
        }.width("100%").padding(10).justifyContent(FlexAlign.SpaceBetween)
        .backgroundColor("#0e8f57")

        //指标
        Column(){
          Column(){
            Stack(){
              Column(){
                Text($r("app.string.particulate_matter_air_cleaner")).fontColor("#FFF").fontSize(30)
                Text("33").fontColor("#FFF").fontSize(40).fontWeight(800)
                Text($r("app.string.indoor_air_quality_air_cleaner")).fontColor("#FFF").fontSize(25).fontWeight(600)
              }//endColumn
              Row().animateCire().scale({x:this.scaleX1})
                .onAppear(()=>{
                  animateTo({
                    iterations:-1,
                    curve:Curve.Smooth,
                    playMode:PlayMode.Alternate,
                  },()=>{
                    this.scaleX1=0.4
                  })
                })
              Row().animateCire().scale({x:this.scaleX2})
                .onAppear(()=>{
                  animateTo({
                    iterations:-1,
                    curve:Curve.Smooth,
                    playMode:PlayMode.Alternate,
                    delay:500
                  },()=>{
                    this.scaleX2=0.4
                  })
                })
              Row().animateCire().scale({x:this.scaleX3})
                .onAppear(()=>{
                  animateTo({
                    iterations:-1,
                    curve:Curve.Smooth,
                    playMode:PlayMode.Alternate,
                    delay:1500
                  },()=>{
                    this.scaleX3=0.4
                  })
                })
            }//endStack
          }.flexGrow(1).justifyContent(FlexAlign.Center)//endColumn
          Row(){
            Column(){
              Text($r("app.string.filterlife_air_cleaner")).fontColor("#FFF")
              Text("20").fontColor("#FFF")
            }.flexGrow(1)
            Column(){
              Text($r("app.string.temperature_air_cleaner")).fontColor("#FFF")
              Text("30").fontColor("#FFF")
            }.flexGrow(1).border({width:{left:1,right:1},color:"#FFF"})
            Column(){
              Text($r("app.string.humidity_air_cleaner")).fontColor("#FFF")
              Text("66").fontColor("#FFF")
            }.flexGrow(1)
          }.width("100%").flexBasis(80)
          Row() {
            Row().flexGrow(1).height("100%").border({ width: 1, color: "#B8E2DE" })
            Row().flexGrow(1).height("100%").border({ width: 1, color: "#B8E2DE" })
          }.width("100%").flexBasis(45)
        }.width("100%").height(600).backgroundColor("#58A9A2")


        Row() {
          Column() {
            Row() {
              Image($r("app.media.open_close_active")).width(30)
            }.width(50).height(50).border({ width: 1, radius: 25, color: "#E0E1E2" })
            .justifyContent(FlexAlign.Center)

            Text($r("app.string.open_air_cleaner")).fontColor("#2FB99C").margin({ top: 10 })
          }.flexGrow(1).justifyContent(FlexAlign.Center)

          Column() {
            Row() {
              Image($r("app.media.sw_auto_active")).width(30)
            }.width(50).height(50).border({ width: 1, radius: 25, color: "#E0E1E2" })
            .justifyContent(FlexAlign.Center)

            Text($r("app.string.auto_air_cleaner")).fontColor("#2FB99C").margin({ top: 10 })
          }.flexGrow(1).justifyContent(FlexAlign.Center)

          Column() {
            Row() {
              Image($r("app.media.sw_moon")).width(30)
            }.width(50).height(50).border({ width: 1, radius: 25, color: "#E0E1E2" })
            .justifyContent(FlexAlign.Center)

            Text($r("app.string.sleep_air_cleaner")).fontColor("#D5D6D7").margin({ top: 10 })

          }.flexGrow(1).justifyContent(FlexAlign.Center)
        }.width("100%").flexGrow(1)
      }.width("100%").height("100%")
    }
  }
}