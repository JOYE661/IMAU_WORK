from django.shortcuts import render
from django.http import HttpResponse


# Create your views here.
def orders(request):
    return HttpResponse("下面是系统中所有的订单信息")


def medicines(request):
    return HttpResponse("下面是系统中所有的药物信息")
