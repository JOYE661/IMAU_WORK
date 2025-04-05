"""
URL configuration for Test_bysms project.

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/5.1/topics/http/urls/
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

from django.contrib import admin
from django.urls import path, include
from sales.views import listorders1,listorders1,listorders2
from Test_vue.views import *
# 静态文件服务
from django.conf.urls.static import static

urlpatterns = [
    path("admin/", admin.site.urls),

    path('sales/',include('sales.urls')),  

    path('api/mgr/',include('mgr.urls')), 

    path('Test_vue/',include('Test_vue.urls')),
   
]+  static("/", document_root="./z_dist")
