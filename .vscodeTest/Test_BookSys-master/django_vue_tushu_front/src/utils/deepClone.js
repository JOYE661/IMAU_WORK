// 1.先封装判断数据类型函数
// 1.1 先获取数据类型
function getdataType(val) {
    return Object.prototype.toString.call(val)
}
// 1.2 判断是否为对象
function isObj(val) {
    return getdataType(val) == '[object Object]'
}
// 1.3 判断是否为数组
function isArr(val) {
    return getdataType(val) == '[object Array]'
}
// 1.4 判断是否为函数
function isFn(val) {
    return getdataType(val) == '[object Function]'
}
// 2.cloneDeep函数进行判断
function cloneDeep(val) {
    // 2.1 定义克隆对象,用三元的目的是防止递归时修改数据类型(禁止:let cloneVal = {})
    let cloneVal = isObj(val)?{}:[]
    // 2.2 遍历传进来的val，拿到所有的key然后进行不同数据类型的拷贝
    for (const key in val) {
        // 这里主要判断当前 属性和方法是自己的还是原型链上的
        if (Object.hasOwnProperty.call(val, key)) {
            // 2.3 拿到每一个键值
            const element = val[key];
            // 2.4 判断遍历的这个key是数组还是对象
            if (isObj(element)||isArr(element)) {
                // 2.5 递归克隆对象或者数组
                cloneVal[key] = cloneDeep(element)
                // 2.6 克隆函数
            }else if (isFn(element)) {
                // eval可以解析字符串 然后直接执行
                cloneVal[key] = eval(element)
                // 2.7 克隆基础数据类型
            }else{
                cloneVal[key] = element
            }
        }
    }
    // 3. 克隆后返回
    return cloneVal
}

export default cloneDeep