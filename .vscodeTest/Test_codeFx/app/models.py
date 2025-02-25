from django.db import models
# Create your models here.
class User(models.Model):
    id = models.AutoField(primary_key=True)
    name = models.CharField(max_length=128)
    tel = models.CharField(max_length=128)
    password = models.CharField(max_length=128)
    class Meta:
        verbose_name_plural = '用户表'  # 此时，admin中表的名字就是‘用户表‘
    def __str__(self):
        return self.name


class Stock(models.Model):
    id = models.AutoField(primary_key=True)
    code = models.CharField(max_length=128,verbose_name='股票代码')
    name = models.CharField(max_length=128,verbose_name='股票简称')
    date = models.DateField(verbose_name='日期')

    open = models.FloatField(verbose_name='开盘价',null=True)
    high = models.FloatField(verbose_name='最高价',null=True)
    close = models.FloatField(verbose_name='收盘价',null=True)
    low = models.FloatField(verbose_name='最低价',null=True)
    volume = models.FloatField(verbose_name='成交量',null=True)

    price_change = models.FloatField(verbose_name='价格变动',null=True)
    p_change = models.FloatField(verbose_name='涨跌幅',null=True)
    ma = models.FloatField(verbose_name='均价',null=True)
    turnover = models.FloatField(verbose_name='换手率',null=True)



    lastclose = models.FloatField(verbose_name='前收盘价',null=True)
    cjje = models.FloatField(verbose_name='成交金额',null=True)



    class Meta:
        verbose_name_plural = '股票管理'  # 此时，admin中表的名字就是‘用户表‘

    def __str__(self):
        return self.code + str(self.date)


class News(models.Model):
    id = models.AutoField(primary_key=True)
    title = models.CharField(max_length=256,verbose_name='标题')
    date = models.DateTimeField(verbose_name='时间')
    src = models.CharField(max_length=256,verbose_name='来源')
    today = models.CharField(max_length=256,verbose_name='爬取时间')
    class Meta:
        verbose_name_plural = '股票新闻表'  # 此时，admin中表的名字就是‘用户表‘

    def __str__(self):
        return self.title
class StockInfo(models.Model):
    id = models.AutoField(primary_key=True)
    code = models.CharField(max_length=128,verbose_name='股票代码')
    name = models.CharField(max_length=128,verbose_name='股票简称')
    url  = models.CharField(max_length=256,verbose_name='详情页')
    class Meta:
        verbose_name_plural = '股票信息表'  # 此时，admin中表的名字就是‘用户表‘

class Star(models.Model):
    id = models.AutoField(primary_key=True)
    stock = models.ForeignKey(StockInfo, on_delete=models.CASCADE, verbose_name='股票')
    user = models.ForeignKey(User, on_delete=models.CASCADE, verbose_name='用户')
    date = models.DateField(auto_now_add=True, verbose_name='收藏时间')
    class Meta:
        verbose_name = '收藏表'  # 定义在管理后台显示的名称
        verbose_name_plural = verbose_name  # 定义复数时的名称（去除复数的s）


class See(models.Model):
    id = models.AutoField(primary_key=True)
    stock = models.ForeignKey(StockInfo, on_delete=models.CASCADE, verbose_name='股票')
    user = models.ForeignKey(User, on_delete=models.CASCADE, verbose_name='用户')
    date = models.DateField(auto_now_add=True,verbose_name='浏览时间')
    class Meta:
        verbose_name = '浏览表'  # 定义在管理后台显示的名称
        verbose_name_plural = verbose_name  # 定义复数时的名称（去除复数的s）


################################下面可能没用的



