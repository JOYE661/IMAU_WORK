from django.db import models

# Create your models here.
class Customer(models.Model):
    name=models.CharField(max_length=200)  #CharField:varchar
    #客户名称
    phonenumber=models.CharField(max_length=200)
    #联系电话
    address=models.CharField(max_length=200)
    #地址

from django.contrib import admin
admin.site.register(Customer)