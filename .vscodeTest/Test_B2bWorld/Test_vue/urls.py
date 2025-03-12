from .import views
from django.urls import path

urlpatterns = [
    path('deepseek/',views.listorders),
    
    path('test1/', views.vue_test1),
    path('test2/', views.vue_test2),
    path('test3/', views.vue_test3),
]
