--（1）	查询每位员工的员工编号empno、员工姓名empname、联系电话telephone和所在部门名称depname
select empno,empname,telephone,depname
from employee,department
where employee.depno=department.depno;
--（2）	查询已下订单的商品的orderno、memname、proname、qty、tatalmoney信息
select orderno,memname,proname,qty,tatalmoney
from orders,member,product
where orders.memno=member.memno AND orders.prono=product.prono;
--（3）	查询会员订单总金额超过2000的会员的memname、所购商品名proname、订购数量qty和totalmoney信息
select memname,proname,qty,tatalmoney
from member,product,orders
where orders.memno=member.memno AND orders.prono=product.prono AND tatalmoney>2000
--（4）	查询商品类别名称为“手机”的所有商品及其供应商信息，查询结果包含proname、stock、supname、price、cost、ontime
select proname,stock,supname,price,cost,ontime
from product,supplier,category
where product.supno=supplier.supno AND category.catno=product.catno AND category.catname='手机';
--（5）	查询商品名称中包含“得力“和”考勤机”这两个关键字的供应商的名称supname
select supname
from supplier,product,category
where supplier.supno=product.supno AND category.catno=product.catno AND category.catname='考勤机' AND product.brand='得力';
--（6）	查询所有下过订单的会员详细信息
select distinct member.*
from member,orders
where member.memno=orders.memno;
--（7）	从订单表orders中检索商品类别名称为“手机”且销售数量排在前10名的商品的编号prono和销售数量qty
select product.prono,qty
from orders,category,product
where orders.prono=product.prono AND product.catno=category.catno AND category.catname='手机'
--（8）	查询商品类别名称为“笔记本电脑”并且单价在3000到5000之间的商品的名称proname、单价price、成本价cost和数量stock
select proname,price,cost,stock
from category,product
where product.catno=category.catno AND catname='笔记本电脑'AND cost between 3000 and 5000;
--（9）	查询订单日期为“2021-11-11”，商品类别名称为“手机”类商品的销售总数量
select sum(qty) 销售总数量
from orders
where orderdate='2021-11-11'
--（10）查询地址是广州市的供应商的名称supname和商品名称proname
select supname,proname
from supplier,product
where address like'广州市%'AND product.supno=supplier.supno;