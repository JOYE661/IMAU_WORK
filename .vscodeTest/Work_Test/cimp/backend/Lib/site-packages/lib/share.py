from django.http import JsonResponse
import json
from project.settings import USER_TYPE

from project.settings import FRONT_VERSION

# 前端用来校验版本
def getFrontEndMatchVersion(request):
    # 获取前端类型  ?type=webfront
    frontType = request.GET['type']
    return JsonResponse({'version': FRONT_VERSION.get(frontType)})


class BaseRequestHandler():

    def dispatch(self, request, *args, **kwargs):
        # 如果 子类定义了 直接处理 直传给子类
        if hasattr(self, 'directHandler') :
            return self.directHandler(request, *args, **kwargs)

        # PRE_HANDLE_CHECK方法是 dispatch 之前的统一检查
        # 如果有，在子类中定义
        if hasattr(self, 'PRE_HANDLE_CHECK') :
            ret = self.PRE_HANDLE_CHECK(request)
            if ret != 'ok':
                return ret

            
        # action_table 字典定义了请求处理分派， 在子类中定义
        if request.method not in self.action_table:
            return JsonResponse({'retcode': 1, 'msg': '不支持的 method 类型'})

        if request.method == 'GET':
            pd = request.GET
        else:
            pd = json.loads(request.body)

        # 将参数字典存入request对象中
        request.pd = pd

        method_action_table = self.action_table[request.method]

        # method_action_table 就是函数，直接调用
        if hasattr(method_action_table, '__call__'):
            handler = method_action_table

        # method_action_table 是字典, 根据 action 参数 匹配处理的函数
        else:
            if 'action' not in pd:
                return JsonResponse({'ret': 1,'msg': '需要参数`action`'})

            action = pd['action']
            if action not in method_action_table:

                return JsonResponse({'ret': 1,
                'msg': f'不支持的action类型:{action}\n\n{method_action_table.keys()}'})

            handler = method_action_table[action]


        return handler(request, *args, **kwargs)


    # 装饰器，确保登录，没有用django内置的因为，我们需要返回的响应不同
    @staticmethod
    def login_required(func):
        def wrapper(self,request, *args, **kargs):
            # 根据session判断用户是否登录的
            if 'usertype' not in request.session:
                response = JsonResponse({
                    'ret': 302,
                    'msg': '未登录'})
                return response
            return func(self,request, *args, **kargs)

        return wrapper

    # 装饰器，确保是管理员，
    @staticmethod
    def admin_required(func):
        def wrapper(self, request, *args, **kargs):
            # 根据session判断用户是否是登录的管理员用户
            if 'usertype' not in request.session:
                response = JsonResponse({
                    'ret': 302,
                    'msg': '未登录'})
                return response
            #
            start, end = [USER_TYPE.SUPPER_ADMIN, USER_TYPE.REGULAR_ADMIN]
            if not start <= request.session['usertype'] <= end:
                response = JsonResponse({
                    'ret': 402,
                    'msg': '用户必须是管理员类型'})
                return response

            return func(self, request, *args, **kargs)

        return wrapper


    # 装饰器，确保是学生，
    @staticmethod
    def student_required(func):
        def wrapper(self, request, *args, **kargs):
            # 根据session判断用户是否是登录的管理员用户
            if 'usertype' not in request.session:
                response = JsonResponse({
                    'ret': 302,
                    'msg': '未登录'})
                return response


            if  request.session['usertype'] != USER_TYPE.STUDENT:
                response = JsonResponse({
                    'ret': 402,
                    'msg': '用户必须是学生类型'})
                return response

            return func(self, request, *args, **kargs)

        return wrapper


    # 装饰器，确保是老师，
    @staticmethod
    def teacher_required(func):
        def wrapper(self, request, *args, **kargs):
            # 根据session判断用户是否是登录的管理员用户
            if 'usertype' not in request.session:
                response = JsonResponse({
                    'ret': 302,
                    'msg': '未登录'})
                return response


            if  request.session['usertype'] != USER_TYPE.TEACHER:
                response = JsonResponse({
                    'ret': 402,
                    'msg': '用户必须是老师类型'})
                return response

            return func(self, request, *args, **kargs)

        return wrapper


    # 装饰器，确保是老师或学习，
    @staticmethod
    def teacher_or_student_required(func):
        def wrapper(self, request, *args, **kargs):
            # 根据session判断用户是否是登录的管理员用户
            if 'usertype' not in request.session:
                response = JsonResponse({
                    'ret': 302,
                    'msg': '未登录'})
                return response


            if  request.session['usertype'] not in [USER_TYPE.TEACHER,USER_TYPE.STUDENT] :
                response = JsonResponse({
                    'ret': 402,
                    'msg': '用户必须是老师或学生'})
                return response

            return func(self, request, *args, **kargs)

        return wrapper