from django.db import models

# Create your models here.

# 管理表
class Guanli(models.Model):
    username = models.CharField(max_length=255)
    password = models.TextField()

from django.db import models

# Create your models here.


class Book(models.Model):
    title = models.CharField(max_length=32, verbose_name="书籍名称")
    price = models.IntegerField(verbose_name="价格")
    # pub_date = models.DateField(verbose_name="出版日期")
    img_url = models.CharField(max_length=255, null=True,blank=True,verbose_name="")
    bread = models.IntegerField(verbose_name="阅读量")
    bcomment = models.IntegerField(verbose_name="评论量")
    publish = models.ForeignKey("Publish", on_delete=models.CASCADE, verbose_name="出版社")
    authors = models.ManyToManyField("Author",verbose_name="作者")

    def __str__(self):
        return self.title


class Publish(models.Model):
    name = models.CharField(max_length=32, verbose_name="出版社名称")
    email = models.EmailField(verbose_name="出版社邮箱")

    def __str__(self):
        return self.name


class Author(models.Model):
    name = models.CharField(max_length=32, verbose_name="作者")
    age = models.IntegerField(verbose_name="年龄")

    def __str__(self):
        return self.name