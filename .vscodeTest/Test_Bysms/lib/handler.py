from django.http import JsonResponse
import json


def dispatcherBase(request,action2HandlerTable):
    # 根据session判断用户是否是登录的管理员用户
    # if 'usertype' not in request.session:
    #     return JsonResponse({
    #         'ret': 302,
    #         'msg': '未登录',
    #         'redirect': '/mgr/sign.html'},
    #         status=302)
    #
    # if request.session['usertype'] != 'mgr':
    #     return JsonResponse({
    #         'ret': 302,
    #         'msg': '用户非mgr类型',
    #         'redirect': '/mgr/sign.html'},
    #         status=302)


    # 将请求参数统一放入request 的 params 属性中，方便后续处理

    # GET请求 参数 在 request 对象的 GET属性中
    if request.method == 'GET':
        request.params = request.GET

    # POST/PUT/DELETE 请求 参数 从 request 对象的 body 属性中获取
    elif request.method in ['POST','PUT','DELETE']:
        # 根据接口，POST/PUT/DELETE 请求的消息体都是 json格式
        request.params = json.loads(request.body)


    # 根据不同的action分派给不同的函数进行处理
    action = request.params['action']
    if action in action2HandlerTable:
        handlerFunc = action2HandlerTable[action]
        return handlerFunc(request)

    else:
        return JsonResponse({'ret': 1, 'msg': 'action参数错误'})