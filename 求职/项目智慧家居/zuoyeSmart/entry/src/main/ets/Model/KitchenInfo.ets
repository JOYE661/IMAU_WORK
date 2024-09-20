export enum KitchenType {

  /**
   * 洗碗机
   */
  DishWasher,
  /**
   * 抽油烟机
   */
  Extractor,
  /**
   * 智能LED灯
   */
  Kitchen_LedLight,
  /**
   * 冰箱
   */
  Fridge
}
export default interface DeviceKitchen{
  message1:string
  message2:string
  value1:string
  value2:string
  name:string
  icon:Resource
  type?: KitchenType
}