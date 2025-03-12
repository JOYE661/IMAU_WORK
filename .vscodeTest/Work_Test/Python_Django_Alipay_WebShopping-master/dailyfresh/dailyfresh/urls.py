"""dailyfresh URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.8/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Add an import:  from blog import urls as blog_urls
    2. Add a URL to urlpatterns:  url(r'^blog/', include(blog_urls))
"""
#from django.conf.urls import include, url
# from django.urls import include, path, re_path
# from django.contrib import admin

# urlpatterns = [
#     path(r'^admin/', include(admin.site.urls)),
#     path(r'^tinymce/', include('tinymce.urls')), # 富文本编辑器
#     path(r'^search', include('haystack.urls')), # 全文检索框架
#     path(r'^user/', include('user.urls', namespace='user')), # 用户模块
#     path(r'^cart/', include('cart.urls', namespace='cart')), # 购物车模块
#     path(r'^order/', include('order.urls', namespace='order')), # 订单模块
#     path(r'^', include('goods.urls', namespace='goods')), # 商品模块
# ]
from django.urls import include, path
from django.contrib import admin

urlpatterns = [
    # 错误1: 正则语法 ^admin/ 在 path() 中不适用，且 admin.site.urls 不需要 include()
    path('admin/', admin.site.urls),  # ✔️ 直接引用 admin.site.urls

    # 错误2: 路径应去掉 ^ 和 $ 符号
    path('tinymce/', include('tinymce.urls')),  # ✔️ 使用普通路径

    # 错误3: 路径末尾建议加 /，且无需正则
    path('search/', include('haystack.urls')),  # ✔️ 路径改为 search/

    # 错误4: include() 参数应传递元组 (模块, app_name)，namespace 用关键字参数
    path('user/', include(('user.urls', 'user'), namespace='user')), 

    # 同理修改其他模块
    path('cart/', include(('cart.urls', 'cart'), namespace='cart')),
    path('order/', include(('order.urls', 'order'), namespace='order')),
    path('', include(('goods.urls', 'goods'), namespace='goods')),
]