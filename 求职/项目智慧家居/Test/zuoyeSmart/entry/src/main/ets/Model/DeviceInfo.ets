export enum DeviceType {
  /**
   * 未知类型
   */
  Unknown,
  /**
   * 空气净化器
   */
  Purifier,
  /**
   * 智能LED灯
   */
  LedLight,
  /**
   * 智能门锁
   */
  DoorLock,
  /**
   * 电水壶
   */
  Kettle
}

export  interface  DeviceInfo{
  message1:string
  message2:string
  value1:string
  value2:string
  name:string
  icon:Resource
  type?:DeviceType
}
