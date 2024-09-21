class PersonEntity{
  name:string = ""
  email:string = ""
  mobile:string = ""
}
@Preview
@Entry
@Component
struct Health{
  @Link person:PersonEntity
  build() {
    Column(){
      Row(){
        Text("名称")
        Text(this.person.name)
      }.rowBlock()
      Row(){
        Text("邮箱")
        Text(this.person.email)
      }.rowBlock()
      Row(){
        Text("电话")
        Text(this.person.mobile)
      }.rowBlock()
    }.height(120).width("95%").border({width:1,radius:15})
  }
}
@Component
export default struct Test4{
  @State person1:PersonEntity = {
    name:"张三",
    email:"zhansan@163.com",
    mobile:"17354975987"
  }
  @State person2:PersonEntity = {
    name:"李四",
    email:"lisi@163.com",
    mobile:"18354975987"
  }
  @State person3:PersonEntity = {
    name:"王五",
    email:"lisi@163.com",
    mobile:"18354975987"
  }
  build() {
    Column(){
      Health({person:this.person1})
      Health({person:this.person2})
      Health({person:this.person3})
    }.width("100%").height("100%")
    .justifyContent(FlexAlign.SpaceEvenly)
  }
}
@Extend(Row) function rowBlock() {
  .width("100%")
  .padding(10)
  .border({ width: { bottom: 1 }, color: "#AAA" })
  .justifyContent(FlexAlign.SpaceBetween)
}