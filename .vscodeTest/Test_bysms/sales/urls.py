from django.urls import path

from sales.views import listorders,listcustomers

urlpatterns = [

    path('orders/', listorders),
    path('customers/', listcustomers),
]