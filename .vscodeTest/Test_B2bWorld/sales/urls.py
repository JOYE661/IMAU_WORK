from django.urls import path
from .import views

urlpatterns= [
    
    path('orders1/',views.listorders1),
    path('orders2/',views.listorders2),
    path('orders3/',views.listorders3),
    #path("test1/",views.vue_test1),

    path('customDate/',views.customDate),
    #path('customList/',views.customList),
    path('customList/',views.customList),
]