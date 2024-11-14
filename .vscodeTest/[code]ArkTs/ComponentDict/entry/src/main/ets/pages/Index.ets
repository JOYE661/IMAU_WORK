//import { ComponentBean, initComponentsData } from '../model/ComponentModel'
import router from '@ohos.router';
import { initComponentsData } from '../model/ComponentModel';
import { ComponentBean } from '../model/ComponentModel';
@Entry
@Component
struct Index {
  build() {
    Row() {
      Column() {
        Text('ArkTS 常用组件字典')
          .fontSize(30)
          .fontWeight(700)
          .margin({top:15,bottom:5})
        Tabs() {
          TabContent(){
            BasicComponentList()
          }.tabBar('基础组件')
          TabContent(){
            ContainerComponentList()
          }.tabBar('容器组件')
          TabContent(){
            MediaComponentList()
          }.tabBar('媒体组件')
          TabContent(){
            DailogComponentList()
          }.tabBar('弹窗组件')
        }
        .barWidth('100%')
        .barHeight(50)
        .scrollable(true)
        .height('70%')
        .backgroundColor('#ffa9bacb')
      }
      .width('100%')
    }
    .height('100%')
  }
}
@Component
struct BasicComponentList {
  private listArray: Array<ComponentBean> = []
  aboutToAppear() {
    var newList = initComponentsData()
    this.listArray = newList.slice(0, 12)
  }
  build() {
    Column(){
      List({ space: 5 }) {
        ForEach(this.listArray,item =>{
          ListItem(){
            Button(item.compName)
              .type(ButtonType.Normal)
              .width('100%')
              .height(50)
              .fontColor(0x000000)
              .backgroundColor(0xffffff)
              .onClick(() => {
                router.pushUrl({
                  url: 'pages/ComponentDetails',
                  params: {
                    name: item.compName
                  }
                })
              })
          }
        },item=>item.id.toString())
      }
    }
  }
}
//容器组件列表
@Component
struct ContainerComponentList {
  private listArray: Array<ComponentBean> = []
  aboutToAppear() {
    var newList = initComponentsData()
    this.listArray = newList.slice(12, 16)
  }
  build() {
    Column(){
      List({ space: 5 }) {
        ForEach(this.listArray,item =>{
          ListItem() {
            Button(item.compName)
              .type(ButtonType.Normal)
              .width('100%')
              .height(50)
              .fontColor(0x000000)
              .backgroundColor(0xffffff)

          }
        },item=>item.id.toString())
      }
    }
  }
}
@Component
struct MediaComponentList {
  private listArray: Array<ComponentBean> = []
  aboutToAppear() {
    var newList = initComponentsData()
    this.listArray = newList.slice(16, 17)
  }
  build() {
    Column(){
    List({ space: 5 }) {
      ForEach(this.listArray,item =>{
        ListItem(){
          Button(item.compName)
            .type(ButtonType.Normal)
            .width('100%')
            .height(50)
            .fontColor(0x000000)
            .backgroundColor(0xffffff)
        }
      },item=>item.id.toString())
    }
  }
  }
}
@Component
struct DailogComponentList {
  private listArray: Array<ComponentBean> = []
  aboutToAppear() {
    var newList = initComponentsData()
    this.listArray = newList.slice(17, 20)
  }
  build() {
    Column(){
      List({ space: 5 }) {
        ForEach(this.listArray,item =>{
          ListItem(){
            Button(item.compName)
              .type(ButtonType.Normal)
              .width('100%')
              .height(50)
              .fontColor(0x000000)
              .backgroundColor(0xffffff)

          }
        },item=>item.id.toString())
      }
    }
  }
}

