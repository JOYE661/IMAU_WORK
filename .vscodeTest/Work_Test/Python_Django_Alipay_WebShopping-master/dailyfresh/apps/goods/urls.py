# from django.conf.urls import url
# from goods.views import IndexView, DetailView, ListView

# urlpatterns = [
#     url(r'^$', IndexView.as_view(), name='index'), # 首页
#     url(r'^index$', IndexView.as_view(), name='index'), # 首页
#     url(r'^goods/(?P<goods_id>\d+)$', DetailView.as_view(), name='detail'), # 详情页
#     url(r'^list/(?P<type_id>\d+)/(?P<page>\d+)$', ListView.as_view(), name='list'), # 列表页

# ]
from django.urls import path, re_path
from goods.views import IndexView, DetailView, ListView

urlpatterns = [
    # 首页（保留两个路径但 name 重复，建议优化）
    path('', IndexView.as_view(), name='index'), 
    path('index/', IndexView.as_view(), name='index'),  # 添加结尾斜杠
    
    # 商品详情页（用 path 类型转换器简化）
    path('goods/<int:goods_id>/', DetailView.as_view(), name='detail'),
    
    # 列表页（保留正则表达式）
    re_path(r'^list/(?P<type_id>\d+)/(?P<page>\d+)/$', ListView.as_view(), name='list'),
]
