@Component
export struct MyTextInput {
  @State message:string =''
  build(){
    Column(){
      TextInput({placeholder:'请输入你想说的话！'}).height(50)
        .onChange((value)=>{
          this.message = value;
        }
        )
      Text(`你想说：${this.message}`).fontSize(30)
    }
  }
}