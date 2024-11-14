@Component
export struct MyText {
  build() {
    Flex({ direction: FlexDirection.Row,
      alignItems: ItemAlign.Start,
      justifyContent: FlexAlign.SpaceBetween }){
      //单行文本
      Text('单行文本').fontSize(20).borderWidth(1)
      //多行文本
      Text('多行文本多行文本多行文本多行文本多行文本多行文本多行文本多行文本')
        .fontSize(20).textAlign(TextAlign.Center).borderWidth(1)
    }
  }
}