from django.http import JsonResponse
from django.db.models import F
from django.db import IntegrityError, transaction

# 导入 Order 对象定义
from  common.models import  Order,OrderMedicine

import json,traceback

from django.core.paginator import Paginator, EmptyPage
from django.db.models import Q


def listorder(request):

    try:

        # 返回一个 QuerySet 对象 ，包含所有的表记录
        qs = Order.objects \
            .annotate(
                    customer_name=F('customer__name')
            )\
            .values(
            'id', 'name', 'create_date',
            'customer_name',
            'medicinelist'
        ).order_by('-id')

        # 查看是否有 关键字 搜索 参数
        keywords = request.params.get('keywords',None)
        if keywords:
            conditions = [Q(name__contains=one) for one in keywords.split(' ') if one]
            query = Q()
            for condition in conditions:
                query &= condition
            qs = qs.filter(query)


        # 要获取的第几页
        pagenum = request.params['pagenum']

        # 每页要显示多少条记录
        pagesize = request.params['pagesize']

        # 使用分页对象，设定每页多少条记录
        pgnt = Paginator(qs, pagesize)

        # 从数据库中读取数据，指定读取其中第几页
        page = pgnt.page(pagenum)

        # 将 QuerySet 对象 转化为 list 类型
        retlist = list(page)

        # total指定了 一共有多少数据
        return JsonResponse({'ret': 0, 'retlist': retlist,'total': pgnt.count})

    except EmptyPage:
        return JsonResponse({'ret': 0, 'retlist': [], 'total': 0})

    except:
        return JsonResponse({'ret': 2,  'msg': f'未知错误\n{traceback.format_exc()}'})




def addorder(request):
    info = request.params['data']


    with transaction.atomic():
        medicinelist  = info['medicinelist']

        new_order = Order.objects.create(name=info['name'],
            customer_id=info['customerid'],
            # 写入json格式的药品数据到 medicinelist 字段中
            medicinelist=json.dumps(medicinelist,ensure_ascii=False),)

        batch = [OrderMedicine(order_id=new_order.id,
                               medicine_id=medicine['id'],
                               amount=medicine['amount'])
                 for medicine in medicinelist]

        OrderMedicine.objects.bulk_create(batch)

    return JsonResponse({'ret': 0, 'id': new_order.id})


def deleteorder(request):
    # 获取订单ID
    oid = request.params['id']

    try:

        one = Order.objects.get(id=oid)
        with transaction.atomic():

            # 一定要先删除 OrderMedicine 里面的记录
            OrderMedicine.objects.filter(order_id=oid).delete()
            # 再删除订单记录
            one.delete()

        return JsonResponse({'ret': 0, 'id': oid})

    except Order.DoesNotExist:
        return JsonResponse({
            'ret': 1,
            'msg': f'id 为`{oid}`的订单不存在'
        })

    except:
        err = traceback.format_exc()
        return JsonResponse({'ret': 1, 'msg': err})


from lib.handler import dispatcherBase

Action2Handler = {
    'list_order': listorder,
    'add_order': addorder,
    'delete_order': deleteorder,
}

def dispatcher(request):
    return  dispatcherBase(request, Action2Handler)