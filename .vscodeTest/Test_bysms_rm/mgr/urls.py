from django.urls import path
from .import customer,sign_in_out

urlpatterns = [
    path('customers', customer.dispatcher),

    path('signin', sign_in_out.signin),

    path('signout', sign_in_out.signout),
    
]