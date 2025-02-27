"""meteorological URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/2.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.conf.urls.static import static
from django.contrib import admin
from django.urls import path

from app import views
from meteorological import settings

urlpatterns = [

    path('admin/', admin.site.urls),
    path('', views.index, name='index'), # 新闻列表
    path('data2mysql/',views.data2mysql,name='data2mysql'), # 数据录入
    path('login/', views.login, name='login'),
    path('logout/', views.logout, name='logout'),
    path('register/', views.register, name='register'),
    path('gupiaoList/', views.gupiaoList.as_view(), name='gupiaoList'), # 股票列表
    path('plot/', views.plot.as_view(), name='plot'), # 股票价格列表
    path('plotAll/', views.plotAll, name='plotAll'), # 全部可视化
    path('stockInfoList/', views.stockInfoListView.as_view(), name='stockInfoList'), # 股票信息

    path('star',views.star,name='star'),# 收藏
    path('see',views.see,name='see'),# 收藏
    path('tuijian',views.tuijian,name='tuijian'),# 推荐

    ################################下面可能没用的





    path('test/', views.test, name='test'),
    path('my/',views.my,name='my'),

]+ static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
