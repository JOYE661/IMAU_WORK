@Entry
@Component
struct LedLight {
  @State message: string = '智能LED灯';

  build() {
    Row(){
      Column(){
        Text(this.message)
          .fontSize(50)
          .fontWeight(FontWeight.Bold)
      }.width('100%')
    }.height('100%')
  }
}