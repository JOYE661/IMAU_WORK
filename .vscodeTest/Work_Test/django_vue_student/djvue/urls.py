from django.urls import path,re_path
from . import views

urlpatterns = [
    # 学生批量_改进版apiview_改进版本serializer 数据类型一对一
    path('xs_gj/', views.Studentviewgj.as_view()),
    re_path('xs_gj/(?P<pk>\d+)/', views.Studentdetailviewgj.as_view()),
]