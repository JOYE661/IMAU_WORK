from rest_framework.authentication import BaseAuthentication
from rest_framework import exceptions
import time
from django_vue_tushu import settings
import jwt
from .models import Guanli

class TokenAuthtication(BaseAuthentication):
    def authenticate(self, request):
        """
        先获取 header 中的token进行解析，在进行校验
            - 获取token，检查过期时间是否大于当前时间
        :param request:
        :return:
        """
        try:
            # 先从前端的 headers 里拿到当前登录用户 token
            token = request.headers.get("Ac-Token")
            # 通过 jwt 反解过期和验证信息
            data = jwt.decode(token, settings.SECRET_KEY, 'HS256')

            # 如果时间过期 需要重新登陆
            if data["exp"] < int(time.time()):
                raise exceptions.AuthenticationFailed("登录超时,请重新登录")
            # 如果时间没过期 需要判断一下存在 token 角色id是否存在于 Guanli Tearcher Student 三张数据库表里 如果三张表里都没有用户名 报错
            elif (Guanli.objects.filter(username=data["username"]).count() == 0):
                raise exceptions.AuthenticationFailed("认证用户不存在")

        except Exception as error:
            print(error)
            raise exceptions.AuthenticationFailed("用户未登录,请登录")