from django.urls import path
from .import views

urlpatterns= [
    path('orders/',views.listorders),
    path('orders1/',views.listorders1),
    path('orders2/',views.listorders2),

    path('customDate/',views.customDate),
    path('customList/',views.customList),
    path('custom_List/',views.custom_List),
]