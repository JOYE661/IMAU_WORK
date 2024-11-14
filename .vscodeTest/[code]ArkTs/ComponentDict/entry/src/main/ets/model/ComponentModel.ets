export const ComponentData: any[] =[
  {
    'catId': 1,
    'catName':'基础组件',
    'id': 1,
    'compName':'Text'
  },
  {
    'catId': 1,
    'catName': '基础组件',
    'id': 2,
    'compName': 'TextInput'
  },
  {
   'catId': 1,
    'catName':'基础组件',
    'id': 3,
    'compName':'TimePicker'
   },
  {
   'catId': 1,
   'catName':'基础组件',
   'id': 4,
   'compName':'Button'
   },
  {
   'catId': 1,
   'catName':'基础组件',
   'id': 5,
   'compName':'Checkbox'
   },
  {
   'catId': 1,
   'catName':'基础组件',
   'id': 6,
   'compName':'CheckboxGroup'
   },
  {
   'catId': 1,
   'catName':'基础组件',
   'id': 7,
   'compName':'Radio'
   },
  {
   'catId': 1,
   'catName':'基础组件',
   'id': 8,
   'compName':'LoadingProgress'
   },
  {
   'catId': 1,
   'catName':'基础组件',
   'id': 9,
   'compName':'Image'
   },
  {
   'catId': 1,
   'catName':'基础组件',
   'id': 10,
   'compName':'Progress'
   },
  {
   'catId': 1,
   'catName':'基础组件',
   'id': 11,
   'compName':'Select'
   },
  {
   'catId': 1,
   'catName':'基础组件',
   'id': 12,
   'compName':'Slider'
   },
  {
   'catId': 2,
   'catName':'容器组件',
   'id': 13,
   'compName':'Column'
   },
  {
   'catId': 2,
   'catName':'容器组件',
   'id': 14,
   'compName':'Row'
   },
  {
   'catId': 2,
   'catName':'容器组件',
   'id': 15,
   'compName':'Panel'
   },
  {
   'catId': 2,
   'catName':'容器组件',
   'id': 16,
   'compName':'swiper'
   },
  {
   'catId': 3,
   'catName':'媒体组件',
   'id': 17,
   'compName':'Video'
   },
  {
   'catId': 4,
   'catName':'弹窗',
   'id': 18,
   'compName':'AlertDialog'
   }
  ,
  {
   'catId': 4,
   'catName':'弹窗',
   'id': 19,
   'compName':'DatePickerDialog'
   }
  ,
  {
   'catId': 4,
   'catName':'弹窗',
   'id': 20,
   'compName':'TextPickerDialog'
   }
]
export class ComponentBean {
  catId: number; //组件分类 ID
  catName: string; //组件分类名
  id: number; //组件 id
  compName: string ; //组件名
  //构造方法
  constructor(catId: number, catName: string, id: number, compName: string) {
    this.catId = catId
    this.catName = catName
    this.id = id
    this.compName = compName
  }
}
export function initComponentsData():Array<ComponentBean> {
  let componentArray: Array<ComponentBean> = []
  //迭代原始数据封装成 bean 并存储到数组中，然后返回
  ComponentData.forEach((item)=>{
    componentArray.push(new ComponentBean(item.catId,item.catName,item.id,item.compName))
  })
  return componentArray;
}