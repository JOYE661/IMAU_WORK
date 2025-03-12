from django.shortcuts import render
from django.http import HttpResponse, JsonResponse
from common.models import Customer
from Test_api.deepseek import deepseek
def listorders(request):
    ret=deepseek("评价一下你自己")
    str = f"{ret}"
    return HttpResponse(str)
def vue_test1(request):
    return render(request,'test1.html')
def vue_test2(request):
    person_obj=Customer.objects.all()
    print(person_obj)

    #return render(request,'test1.html')
    return HttpResponse("test1")
def vue_test3(request):
    person_obj=Customer.objects.values("id","name","phonenumber","address")

    res={"status": True, "data": ""}
    obj_list=list(person_obj)
    res["data"]=obj_list

    print(res)
    return JsonResponse(res,safe=False )

