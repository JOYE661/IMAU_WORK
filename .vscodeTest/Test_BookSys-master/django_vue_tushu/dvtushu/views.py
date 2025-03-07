from .TokenAuthtication import TokenAuthtication
from rest_framework.response import Response
from django.core.paginator import Paginator
from rest_framework.views import APIView
from django.views import View
from django.http import HttpResponse,JsonResponse
from django_vue_tushu import settings
from .Serializer import *
from .models import *
import datetime
import jwt
import os

# 前台返回格式
ret = {
    "data": {},
    "meta": {
        "status": 200,
        "message": "注册成功"
    }
}

# 图片上传接口
class img_uploadApiview(View):
    def get(self, request):
        return JsonResponse(data={'code': 200, 'message': '方法测试'})

    # 图片上传接口通过 request.data 可以接收到前端发来的
    def post(self,request):
        response = {}
        dataduixiang = request.POST.get('data','')
        file = request.FILES.get('file')
        # try:
        # 构造图片保存路径 路径为<USER_AVATAR_ROOT + 文件名>
        # USER_AVATAR_ROOT刚刚在settings.py中规定过，需要导入进来
        file_path = os.path.join(settings.MEDIA_ROOT, file.name)
        # 保存图片
        print(dataduixiang,file)
        with open(file_path, 'wb+') as f:
            f.write(file.read())
            f.close()
        response['file'] = file.name  # 返回新的文件名
        response['code'] = 0
        response['msg'] = "图片上传成功！"
        return JsonResponse(data={'code': 200, 'message': '上传成功', 'data': response})

# 前台注册接口
class RegistryView(APIView):
    def post(self, request):
        username = request.data.get("accountNumber")
        password = request.data.get("userPassword")
        value = request.data.get("value")
        if value == '1':
            pass

# 前台后台登录接口
class LoginView(APIView):
    def post(self, request):
        ret = {
            "data": {},
            "meta": {
                "status": 200,
                "message": ""
            }
        }
        try:
            username = request.data["username"]
            password = request.data["password"]
            value = int(request.data["value"])

            if value == 1:
                user = Guanli.objects.filter(username=username,password=password)
                print(username,password,value,user)
                if user.count == 0:
                    ret["meta"]["status"] = 500
                    ret["meta"]["message"] = "用户不存在或密码错误"
                    return Response(ret)
                elif user and user.first().password:
                    dict = {
                        "exp": datetime.datetime.now() + datetime.timedelta(days=1),  # 过期时间
                        "iat": datetime.datetime.now(),  # 开始时间
                        "id": user.first().id,
                        "username": user.first().username,
                    }
                    token = jwt.encode(dict, settings.SECRET_KEY, algorithm="HS256")
                    ret["data"]["token"] = token
                    ret["data"]["username"] = user.first().username
                    ret["data"]["user_id"] = user.first().id
                    # 这里需要根据数据库判断是不是管理员
                    ret["data"]["isAdmin"] = 1
                    ret["meta"]["status"] = 200
                    ret["meta"]["message"] = "登录成功"
                    print(ret,type(ret))
                    return Response(ret)
                else:
                    ret["meta"]["status"] = 500
                    ret["meta"]["message"] = "用户不存在或密码错误"
                    return Response(ret)
        except Exception as error:
            print(error)
            ret["meta"]["status"] = 500
            ret["meta"]["message"] = "用户不存在或密码错误"
            return Response(ret)

# 管理员
class GuanliApiview(APIView):
    # 单个禁用 token 验证
    authentication_classes = []
    def get(self, request):
        isAdmin=request.GET.get('isAdmin', '')
        nickName=request.GET.get('nickName', '')


        # 获取数据集（学生模型对象）
        if isAdmin=='1':
            print(isAdmin, type(isAdmin), nickName, type(nickName))
            guanli_data = Guanli.objects.filter(username=nickName)
            print('wwewewewewewe',guanli_data)
            ser = GuanliModelSerializers(instance=guanli_data, many=True)
            data = ser.data
            # print(data,type(data))
            return Response(data={'code': 200, 'data': data})
class GuanlidetailApiview(APIView):
    # 获取一个学生的信息
    # authentication_classes = [TokenAuthtication, ]
    authentication_classes = []
    # 修改一个学生的信息
    def put(self, request, pk):
        print(request.data)
        # 通过拿过来的字段信息判断当前想修改的是谁 ??????
        id_obj = request.data.get('id','')
        isAdmin = request.data.get('isAdmin','')
        userInfoid = request.data.get('userInfoid','')
        img_url = request.data.get('img_url','')
        password = request.data.get('password','')

        instance = Guanli.objects.get(pk=pk)
        ser = GuanliModelSerializers(instance=instance, data=request.data)
        if not ser.is_valid():
            return Response(data={'code': 500,'message': ser.errors})
        ser.save()
        return Response(data={'code': 200,'message':'修改成功','data': ser.data})

class TSview(APIView):
    # 单个禁用 token 验证
    authentication_classes = [TokenAuthtication]

    def get(self, request):
        # 获取数据集（学生模型对象）
        students_data = Book.objects.all()
        pageNum = request.GET.get('pageNum', '')
        pageSize = request.GET.get('pageSize', '')
        # 过滤
        search_nick_term = request.GET.get('title', '')
        if search_nick_term:
            search_nick_term = search_nick_term.strip()
            students_data = students_data.filter(title__icontains=search_nick_term)
        # 自定义分页 过滤后再次分页
        paginator = Paginator(students_data, pageSize)
        page_obj = paginator.get_page(pageNum)
        # 拿到分页对象
        page_obj_dq = page_obj.object_list
        # 拿到总数
        page_obj_zs = paginator.count
        # 实例化序列化器，得到序列化器对象
        # 分页对象进行序列化
        ser = BookInfoModelSerializermodel(instance=page_obj_dq, many=True)
        # 调用序列化器对象的data属性方法获取转换后的数据
        data = ser.data

        # 响应数据
        return Response(data={'code': 200, 'zs': page_obj_zs, 'data': data})

    def post(self, request):
        print(request.data)
        # 反序列化数据
        student = BookInfoModelSerializermodel(data=request.data)
        # 校验不通过
        if not student.is_valid():
            # 返回错误信息
            return Response(data={'code': 500, 'data': student.errors})
        # 校验通过，保存数据
        student.save()
        # 响应数据
        return Response(data={'code': 200, 'message': '增加成功', 'data': student.data})
class Tsdetailview(APIView):
    authentication_classes = [TokenAuthtication]

    def get(self, request, pk):
        student = Book.objects.get(pk=pk)
        ser = BookInfoModelSerializermodel(instance=student)
        return Response(ser.data)

    # 修改一个学生的信息
    def put(self, request, pk):
        print(request.data)
        instance = Book.objects.get(pk=pk)
        ser = BookInfoModelSerializermodel(instance=instance, data=request.data)
        if not ser.is_valid():
            return Response(data={'code': 500, 'message': ser.errors})
        ser.save()
        return Response(data={'code': 200, 'message': '修改成功', 'data': ser.data})

    # 删除一个学生的信息
    def delete(self, request, pk):
        Book.objects.get(pk=pk).delete()
        return Response(data={'code': 200, 'message': '删除成功'})

class Cbsview(APIView):
    # 单个禁用 token 验证
    authentication_classes = [TokenAuthtication]

    def get(self, request):
        # 获取数据集（学生模型对象）
        students_data = Publish.objects.all()
        pageNum = request.GET.get('pageNum', '')
        pageSize = request.GET.get('pageSize', '')
        # 过滤
        search_nick_term = request.GET.get('name', '')
        if search_nick_term:
            search_nick_term = search_nick_term.strip()
            students_data = students_data.filter(name__icontains=search_nick_term)
        # 自定义分页 过滤后再次分页
        paginator = Paginator(students_data, pageSize)
        page_obj = paginator.get_page(pageNum)
        # 拿到分页对象
        page_obj_dq = page_obj.object_list
        # 拿到总数
        page_obj_zs = paginator.count
        # 实例化序列化器，得到序列化器对象
        # 分页对象进行序列化
        ser = PublishSerializer(instance=page_obj_dq, many=True)
        # 调用序列化器对象的data属性方法获取转换后的数据
        data = ser.data

        # 响应数据
        return Response(data={'code': 200, 'zs': page_obj_zs, 'data': data})

    def post(self, request):
        print(request.data)
        # 反序列化数据
        student = PublishSerializer(data=request.data)
        # 校验不通过
        if not student.is_valid():
            # 返回错误信息
            return Response(data={'code': 500, 'data': student.errors})
        # 校验通过，保存数据
        student.save()
        # 响应数据
        return Response(data={'code': 200, 'message': '增加成功', 'data': student.data})
class Cbsdetailview(APIView):
    authentication_classes = [TokenAuthtication]

    def get(self, request, pk):
        student = Publish.objects.get(pk=pk)
        ser = PublishSerializer(instance=student)
        return Response(ser.data)

    # 修改一个学生的信息
    def put(self, request, pk):
        print(request.data)
        instance = Publish.objects.get(pk=pk)
        ser = PublishSerializer(instance=instance, data=request.data)
        if not ser.is_valid():
            return Response(data={'code': 500, 'message': ser.errors})
        ser.save()
        return Response(data={'code': 200, 'message': '修改成功', 'data': ser.data})

    # 删除一个学生的信息
    def delete(self, request, pk):
        Publish.objects.get(pk=pk).delete()
        return Response(data={'code': 200, 'message': '删除成功'})

class Zzview(APIView):
    # 单个禁用 token 验证
    authentication_classes = [TokenAuthtication]

    def get(self, request):
        # 获取数据集（学生模型对象）
        students_data = Author.objects.all()
        pageNum = request.GET.get('pageNum', '')
        pageSize = request.GET.get('pageSize', '')
        # 过滤
        search_nick_term = request.GET.get('name', '')
        if search_nick_term:
            search_nick_term = search_nick_term.strip()
            students_data = students_data.filter(name__icontains=search_nick_term)
        # 自定义分页 过滤后再次分页
        paginator = Paginator(students_data, pageSize)
        page_obj = paginator.get_page(pageNum)
        # 拿到分页对象
        page_obj_dq = page_obj.object_list
        # 拿到总数
        page_obj_zs = paginator.count
        # 实例化序列化器，得到序列化器对象
        # 分页对象进行序列化
        ser = AuthorSerializer(instance=page_obj_dq, many=True)
        # 调用序列化器对象的data属性方法获取转换后的数据
        data = ser.data

        # 响应数据
        return Response(data={'code': 200, 'zs': page_obj_zs, 'data': data})

    def post(self, request):
        print(request.data)
        # 反序列化数据
        student = AuthorSerializer(data=request.data)
        # 校验不通过
        if not student.is_valid():
            # 返回错误信息
            return Response(data={'code': 500, 'data': student.errors})
        # 校验通过，保存数据
        student.save()
        # 响应数据
        return Response(data={'code': 200, 'message': '增加成功', 'data': student.data})
class Zzdetailview(APIView):
    authentication_classes = [TokenAuthtication]

    def get(self, request, pk):
        student = Author.objects.get(pk=pk)
        ser = AuthorSerializer(instance=student)
        return Response(ser.data)

    # 修改一个学生的信息
    def put(self, request, pk):
        print(request.data)
        instance = Author.objects.get(pk=pk)
        ser = AuthorSerializer(instance=instance, data=request.data)
        if not ser.is_valid():
            return Response(data={'code': 500, 'message': ser.errors})
        ser.save()
        return Response(data={'code': 200, 'message': '修改成功', 'data': ser.data})

    # 删除一个学生的信息
    def delete(self, request, pk):
        Author.objects.get(pk=pk).delete()
        return Response(data={'code': 200, 'message': '删除成功'})
