from django.urls import path,re_path
from . import views

urlpatterns = [
    # 登录接口
    path('logintest/', views.LoginView.as_view()),
    # 前台注册接口
    path('signin/', views.RegistryView.as_view()),

    # 修改个人信息接口
    path('guanli/', views.GuanliApiview.as_view()),
    re_path('guanli/(?P<pk>\d+)/', views.GuanlidetailApiview.as_view()),

    # 图书管理
    path('ts/', views.TSview.as_view()),
    re_path('ts/(?P<pk>\d+)/', views.Tsdetailview.as_view()),

    # 出版社管理
    path('cbs/', views.Cbsview.as_view()),
    re_path('cbs/(?P<pk>\d+)/', views.Cbsdetailview.as_view()),

    # 作者管理
    path('zz/', views.Zzview.as_view()),
    re_path('zz/(?P<pk>\d+)/', views.Zzdetailview.as_view()),


]