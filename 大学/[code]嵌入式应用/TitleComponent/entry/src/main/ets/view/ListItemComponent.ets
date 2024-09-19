 @Preview
  @Component
  export struct ListItemComponent {
  index: number = 1
  movieName:string = '满江红'
  tickets:string = '12345'

  isCircleText(): boolean {
    if(this.index === 1
    || this.index === 2
    || this.index === 3 ){
      return true
    }
    return false
  }

  @Builder CircleText(index:number){
    Row(){
      Text(this.index.toString())
        .fontSize(15)
        .fontWeight(400)
        .fontColor(Color.White)
    }.justifyContent(FlexAlign.Center)
      .borderRadius(25)
      .width(25)
      .height(25)
      .backgroundColor(Color.Blue)
  }
  build(){
    Row(){
      Column(){
        if(this.isCircleText()){
          this.CircleText(this.index)
        }else{
          Text(this.index.toString()).lineHeight(25)
            .textAlign(TextAlign.Center)
            .fontSize(15)
            .width(24)
            .fontWeight(400)
        }
      }.width('30%')
      .alignItems(HorizontalAlign.Start)
      Text(this.movieName)
        .width('50%')
        .fontWeight(500)
        .fontSize(16)
        .fontColor(Color.Blue)
      Text(this.tickets)
        .width('20%')
        .fontWeight(500)
        .fontSize(16)
        .fontColor(Color.Blue)
    }
  }
}
