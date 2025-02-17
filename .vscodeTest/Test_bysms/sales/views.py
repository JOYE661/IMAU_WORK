from django.shortcuts import render
from django.http import HttpResponse
# Create your views here.

def listorders(request):
    return HttpResponse("下面是系统中所有的订单信息。。。你好listorder")

def listorders1(request):
    return HttpResponse("下面是系统中所有的订单信息。。。你好listorder1")

def listorders2(request):
    return HttpResponse("下面是系统中所有的订单信息。。。你好listorder2")

