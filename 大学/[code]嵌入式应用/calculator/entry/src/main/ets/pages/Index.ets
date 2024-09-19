@Entry
@Component
struct Index {
  @State Number: Array<string> = ['1', '2', '3', '+', '4', '5', '6', '-', '7', '8', '9', '*', '0', '.', '/']
  // 定义计时器按钮样式
  @Styles textStyle(){
    .backgroundColor(0xd0d0d0)
    .width('100%')
    .height('100%')
    .borderRadius(5)
  }

  build() {
    Column({ space: 5 }) {
      Grid() {
        GridItem() {
          Text('0')
            .fontSize(30)
            .textStyle()
        }.columnStart(1).columnEnd(4)

        GridItem() {
          Text('清空')
            .fontSize(16)
            .textAlign(TextAlign.Center)
            .textStyle()
        }.columnStart(1).columnEnd(2)

        GridItem() {
          Text('回退')
            .fontSize(16)
            .textAlign(TextAlign.Center)
            .textStyle()
        }.columnStart(3).columnEnd(4)

        ForEach(this.Number, (day: string) => {
          if (day === '0') {
            GridItem() {
              Text(day)
                .fontSize(16)
                .textAlign(TextAlign.Center)
                .textStyle()
            }.columnStart(1).columnEnd(2)
          } else {
            GridItem() {
              Text(day)
                .fontSize(16)
                .textAlign(TextAlign.Center)
                .textStyle()
            }
          }
        })
      }
      .columnsTemplate('1fr 1fr 1fr 1fr')
      .rowsTemplate('2fr 1fr 1fr 1fr 1fr 1fr')
      .columnsGap(10)
      .rowsGap(15)
      .width('90%')
      .backgroundColor(0xF0F0F0)
      .height('70%')
    }.width('100%').margin({ top: 5 })
  }
}