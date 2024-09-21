import { http } from '@kit.NetworkKit';
import CommonConstants from '../constants/CommonConstants';


class Header {
  public contentType: string;
  public token?:string;

  constructor(contentType: string,token?:string) {
    this.contentType = contentType;
    this.token = token;
  }
}
export default class HttpUtils {

  private static instance:HttpUtils;
  private url:string;
  private options : http.HttpRequestOptions



  constructor() {
    this.url = '';
    this.options = {
      method: http.RequestMethod.GET,
      connectTimeout: 60000,
      readTimeout: 60000,
      header: new Header('application/json')
    }
  }

  static getInstance(){
    if(HttpUtils.instance == null){
      HttpUtils.instance = new HttpUtils();
    }
    return HttpUtils.instance;
  }

  setUrl(url:string){
    this.url = url;
  }



  get(url:string,extraData:string | Object | ArrayBuffer):Promise<http.HttpResponse>{

    this.options.method = http.RequestMethod.GET;
    this.options.extraData = extraData;
    let httpRequest = http.createHttp();
    return httpRequest.request(CommonConstants.HTTP_HOST+url,this.options)

  }
  post(url:string,extraData:string | Object | ArrayBuffer):Promise<http.HttpResponse>{

    this.options.method = http.RequestMethod.POST;
    this.options.extraData = extraData;
    let httpRequest = http.createHttp();
    return httpRequest.request(CommonConstants.HTTP_HOST+ '/api/login',this.options)

  }



}