import http from '@ohos.net.http'

//const BASE_URL = 'http://1.92.113.192:8090/api'

const BASE_URL = 'http://10.213.76.72:8181'

interface AjaxEntity {
  name: string,
  value: Object
}

interface Param {
  url: string,
  extraData: Array<AjaxEntity>,
  method: http.RequestMethod,
  success: Function
}

export class HttpUtil {

  static changeJsonToForm(extraData: Array<AjaxEntity>) {
    let rst: string = '';
    extraData.forEach((item) => {
      rst += item.name + "=" + item.value + "&"
    })
    if (rst !== '') {
      rst = rst.substring(0, rst.length - 1)
    }
    console.info("changJsonToForm:" + rst)
    return rst
  }

  static sendHttpMsg(param: Param) {
    // 每一个httpRequest对应一个HTTP请求任务，不可复用
    let httpRequest = http.createHttp();
    httpRequest.on('headersReceive', (header) => {
      console.info('header: ' + JSON.stringify(header));
    });

    httpRequest.request(BASE_URL + param.url, {
      method: param.method,
      header: {
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      extraData: HttpUtil.changeJsonToForm(param.extraData)
    }, (err, data) => {
      if (!err) {
        if(data.result){
          try {
            param.success(JSON.parse(`${data.result}`))
            console.log('http request success:' + JSON.stringify(data.result))
          }catch(error){
            console.log('http request error:' + JSON.stringify(error));
          }
        }else{
          param.success(null)
        }
      } else {
        console.log('http request failed'+JSON.stringify(data)+'err'+JSON.stringify(err))
        // 当该请求使用完毕时，调用destroy方法主动销毁
        httpRequest.destroy();
      }
    }
    )
  }
}
