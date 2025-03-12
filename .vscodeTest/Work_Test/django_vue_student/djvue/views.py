from django.shortcuts import render

# Create your views here.
from django.shortcuts import render
from rest_framework.response import Response
from rest_framework.views import APIView

# 一对一
from .models import *
from .serializer import StudentSerializergj

# 改进apiview_改进serializer 一对一serializer
# 查看所有学生 添加学生
class Studentviewgj(APIView):
    def get(self,request):
        students = Student.objects.all()
        print('原生 serializer 改进')
        # 本质上序列化器就是帮我们把所有所有学生对象做一个for循环 根据 serializer限制字段返回
        # [{student.name,student.aget},{student.name,student.aget}]
        serializer = StudentSerializergj(instance=students,many=True)
        return Response(serializer.data)
    def post(self,request):
        # post数据从 request.data拿到
        print('原生 serializer 改进')
        serializer = StudentSerializergj(data=request.data)
        try:
            # 校验是否符合格式
            serializer.is_valid(raise_exception=True)
            serializer.save()
            return Response(serializer.data)
        except Exception as e:
            return Response(serializer.errors)
class Studentdetailviewgj(APIView):
    def get(self,request,pk):
        students = Student.objects.get(pk=pk)
        serializer = StudentSerializergj(instance=students,many=False)
        return Response(serializer.data)

    def put(self, request,pk):
        # post数据从 request.data拿到
        # 拿到instance对象
        print(request.data)
        stu = Student.objects.get(pk=pk)
        # 修改传入 instance 和 data 对象和数据两字段
        ser = StudentSerializergj(data=request.data,instance=stu)
        try:
            # 校验是否符合格式
            ser.is_valid(raise_exception=True)
            ser.save()
            return Response(ser.data)

        except Exception as e:
            return Response(ser.errors)

    def delete(self, request,pk):
        Student.objects.get(pk=pk).delete()
        return Response('删除成功')