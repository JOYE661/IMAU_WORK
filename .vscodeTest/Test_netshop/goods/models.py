from django.db import models

# Create your models here.
class Category(models.Model):
    cname = models.CharField(max_length=10)

    def __unicode__(self):
        return u'category: %s'%self.cname                           #不懂

class Goods(models.Model):
    gname = models.CharField(max_length=100)
    gdesc = models.CharField(max_length=100)
    oldprice = models.DecimalField(max_digits=5,decimal_places=2)   #代表小数，长度5位，小数点后两位
    price = models.DecimalField(max_digits=5,decimal_places=2)      #代表小数，长度5位，小数点后两位
    category=models.ForeignKey(Category, on_delete=models.CASCADE)

    def __unicode__(self):
        return u'goods: %s'%self.gname
    
class GoodDetailName(models.Model):
    gdname = models.CharField(max_length=100)

    def __unicode__(self):
        return u'GoodDetailName: %s'%self.gdname
    
class GoodDetail(models.Model):
    gdurl=models.ImageField(upload_to='')
    gdname=models.ForeignKey(GoodDetailName,on_delete=models.CASCADE)                        #外键
    goods=models.ForeignKey(Goods ,on_delete=models.CASCADE)

class Size(models.Model):
    sname = models.CharField(max_length=10)

    def __unicode__(self):
        return u'Size: %s'%self.sname
    
class Color(models.Model):
    colorname=models.CharField(max_length=10)
    colorurl=models.ImageField(upload_to='color/')          
    def __unicode__(self):
        return u'Color: %s'%self.sname

class Inventory(models.Model):                                       #库存表
    count=models.PositiveIntegerField()
    Color=models.ForeignKey(Color, on_delete=models.CASCADE)
    goods=models.ForeignKey(Goods, on_delete=models.CASCADE)
    size=models.ForeignKey(Size, on_delete=models.CASCADE)