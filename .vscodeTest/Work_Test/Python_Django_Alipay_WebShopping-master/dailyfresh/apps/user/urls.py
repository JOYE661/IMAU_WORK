#from django.conf.urls import url
# from django.urls import path, re_path
# from django.contrib.auth.decorators import login_required
# from user.views import RegisterView, ActiveView, LoginView, LogoutView, UserInfoView, UserOrderView, AddressView

# urlpatterns = [
#     # url(r'^register$', views.register, name='register'), # 注册
#     # url(r'^register_handle$', views.register_handle, name='register_handle'), # 注册处理

#     url(r'^register$', RegisterView.as_view(), name='register'), # 注册
#     url(r'^active/(?P<token>.*)$', ActiveView.as_view(), name='active'), # 用户激活

#     url(r'^login$', LoginView.as_view(), name='login'), # 登录
#     url(r'^logout$', LogoutView.as_view(), name='logout'), # 注销登录

#     # url(r'^$', login_required(UserInfoView.as_view()), name='user'), # 用户中心-信息页
#     # url(r'^order$', login_required(UserOrderView.as_view()), name='order'), # 用户中心-订单页
#     # url(r'^address$', login_required(AddressView.as_view()), name='address'), # 用户中心-地址页

#     url(r'^$', UserInfoView.as_view(), name='user'), # 用户中心-信息页
#     url(r'^order/(?P<page>\d+)$', UserOrderView.as_view(), name='order'), # 用户中心-订单页
#     url(r'^address$', AddressView.as_view(), name='address'), # 用户中心-地址页
# ]

from django.urls import path, re_path
from django.contrib.auth.decorators import login_required
from user.views import RegisterView, ActiveView, LoginView, LogoutView, UserInfoView, UserOrderView, AddressView

urlpatterns = [
    # 注册 & 激活
    path('register/', RegisterView.as_view(), name='register'),
    re_path(r'^active/(?P<token>.*)/$', ActiveView.as_view(), name='active'),  # 保持正则匹配

    # 登录 & 注销
    path('login/', LoginView.as_view(), name='login'),
    path('logout/', LogoutView.as_view(), name='logout'),

    # 用户中心（需要登录）
    path('', login_required(UserInfoView.as_view()), name='user'),  # 信息页
    re_path(r'^order/(?P<page>\d+)/$', login_required(UserOrderView.as_view()), name='order'),  # 分页订单
    path('address/', login_required(AddressView.as_view()), name='address'),  # 地址页
]