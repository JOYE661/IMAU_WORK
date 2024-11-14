--（1）查询供应商表supplier中所有供应商的信息
select supname
from supplier

--（2） 查询商品类别表category中所有商品类别的信息，并以“类别编号”、“类别名称”、“描述”作为输出表的字段名称
select catno as 类别编号,catname as 类别名称,describe as 描述
from category

--（3）查询商品表product中商品类别编号为201并且单价高于1299的商品的名称proname和单价price
select proname, price
from product
where catno=201 and price>1299;

--（4）计算商品表product中商品类别编号为401的商品的最高价、最低价和平均价，并以“最高价”、“最低价”、“平均价”作为输出表的字段名称
select max(price)as 最高价,min(price)as 最低价,avg(price)as 平均价
from product
where catno=401

--（5) 查询商品类别名称为“手机”的所有商品及其供应商信息，查询结果包含proname、stock、supname、price、cost、ontime
select proname,stock,supname,price,cost,ontime
from product,supplier,category
where product.supno=supplier.supno AND category.catno=product.catno AND category.catname='手机';

--（6） 查询商品名称中包含“得力“和”考勤机”这两个关键字的供应商的名称supname
select supname
from supplier,product,category
where supplier.supno=product.supno AND category.catno=product.catno AND category.catname='考勤机' AND product.brand='得力';

--（7） 从订单表orders中检索商品类别名称为“手机”且销售数量排在前10名的商品的编号prono和销售数量qty
select product.prono,qty
from orders,category,product
where orders.prono=product.prono AND product.catno=category.catno AND category.catname='手机'

--（8） 查询商品类别名称为“笔记本电脑”并且单价在3000到5000之间的商品的名称proname、单价price、成本价cost和数量stock
select proname,price,cost,stock
from category,product
where product.catno=category.catno AND catname='笔记本电脑'AND cost between 3000 and 5000;

--（9） 查询订单日期为“2021-11-11”，商品类别名称为“手机”类商品的销售总数量
select sum(qty) 销售总数量
from orders
where orderdate='2021-11-11'

--（10）查询地址是广州市的供应商的名称supname和商品名称proname
select supname,proname
from supplier,product
where address like'广州市%'AND product.supno=supplier.supno;
