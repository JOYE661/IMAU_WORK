"""django_vue_tushu URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.2/topics/http/urls/
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
from django.urls import path,re_path,include
from django_vue_tushu.settings import MEDIA_ROOT
from django.contrib import admin
from dvtushu import views
from django.views.static import serve
from rest_framework.documentation import include_docs_urls

urlpatterns = [
    # 接口文档
    path('docs/', include_docs_urls(title='tushu')),
    path('admin/', admin.site.urls),
    path('django_vue_tushu/', include('dvtushu.urls'),name='dvtushu'),
    # 图片上传接口
    re_path('img_upload/', views.img_uploadApiview.as_view()),
    # 前端查找图片地址
    re_path('upimg/(?P<path>.*)', serve, {"document_root": MEDIA_ROOT})
]