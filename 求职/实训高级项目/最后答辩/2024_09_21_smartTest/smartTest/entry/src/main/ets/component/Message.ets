import DeviceMessage from './DeviceMessage';
import SettingMsg from './SettingMsg';
import { router } from '@kit.ArkUI'
const select_background_color = "#ff3a18d4";
const select_font_color = "#FFF";
const default_font_color = "#000";

@Preview
@Component
export default struct Message {
  @State selectIndex: number = 0;
  @State backgroundColor0: string = "";
  @State fontColor0: string = "";
  @State backgroundColor1: string = "";
  @State fontColor1: string = "";
  @State showSideBar: boolean = false;
  @State userName: string = ''

  changeIndex(index: number) {
    this.selectIndex = index;
    this.backgroundColor0 = "";
    this.fontColor0 = default_font_color;
    this.backgroundColor1 = "";
    this.fontColor1 = default_font_color;

    if (index === 0) {
      this.backgroundColor0 = select_background_color;
      this.fontColor0 = select_font_color;
    } else {
      this.backgroundColor1 = select_background_color;
      this.fontColor1 = select_font_color;
    }
  }

  aboutToAppear() {
    this.changeIndex(0);
  }

  toggleSideBar() {
    this.showSideBar = !this.showSideBar;
  }

  build() {

    SideBarContainer(SideBarContainerType.Overlay) {
      Column() {
        Text('新消息是否通知');
        Text('通知显示消息详情');
      }.height('50%')
      .foregroundColor("#232454")
      .justifyContent(FlexAlign.SpaceAround)
      .padding({ top: 30 });

      Column() {
        Row() {
          Row() {
            Row() {
              Row() {
                Text($r("app.string.Message_device_message")).fontColor(this.fontColor0);
              }
              .flexGrow(1)
              .justifyContent(FlexAlign.Center)
              .backgroundColor(this.backgroundColor0)
              .height("100%")
              .borderRadius({ topLeft: 30, bottomLeft: 30 })
              .onClick(() => {
                this.changeIndex(0);
              });

              Row() {
                Text($r("app.string.Message_system_message")).fontColor(this.fontColor1);
              }
              .flexGrow(1)
              .justifyContent(FlexAlign.Center)
              .borderRadius({ topRight: 30, bottomRight: 30 })
              .backgroundColor(this.backgroundColor1)
              .height("100%")
              .onClick(() => {
                this.changeIndex(1);
              });
            }.backgroundColor("#EFEEF4").width(180).height(50)
            .borderRadius(30);
          }.flexGrow(1).justifyContent(FlexAlign.Center).margin({ left: 30 });
        }.width("100%").backgroundColor("#FFF").padding(10);

        if (this.selectIndex === 0) {

          DeviceMessage();
        } else {
          SettingMsg();
        }
      }.width("100%").height("100%")
      .alignItems(HorizontalAlign.Center)
      .backgroundColor("#F8F8F8");
    }.sideBarWidth(100)
    .backgroundColor('#EEE')
    .showSideBar(this.showSideBar)
    .sideBarPosition(SideBarPosition.End)
    .controlButton({ top: 10 });
  }
}