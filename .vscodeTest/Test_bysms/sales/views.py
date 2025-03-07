from django.shortcuts import render
from django.http import HttpResponse
# 导入 Customer 对象定义
from  common.models import  Customer

def listorders(request):
    return HttpResponse("下面是系统中所有的订单信息。。。")


# 先定义好HTML模板
html_template = '''
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table {
    border-collapse: collapse;
}
th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}
</style>
</head>
<body>
    <table>
    <tr>
    <th>id</th>
    <th>姓名</th>
    <th>电话号码</th>
    <th>地址</th>
    </tr>

    
    {% for customer in customers %}
      <tr>
      {% for name, value in customer.items %}
      
      <td>{{ value }}</td>
      
      {% endfor %}
      </tr>
    {% endfor %}

    </table>
</body>
</html>
'''


from django.template import engines
django_engine = engines['django']
template = django_engine.from_string(html_template)

def listcustomers(request):
    # 返回一个 QuerySet 对象 ，包含所有的表记录
    qs = Customer.objects.values()

    # 检查url中是否有参数phonenumber
    ph =  request.GET.get('phonenumber',None)

    # 如果有，添加过滤条件
    if ph:
        qs = qs.filter(phonenumber=ph)

    # 传入渲染模板需要的参数
    rendered = template.render({'customers':qs})

    return HttpResponse(rendered)







