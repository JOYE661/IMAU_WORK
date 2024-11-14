--（1）向商品类别表category中插入一条记录（801，‘座椅套’，‘各种品牌的汽车座套’）
insert
into category(catno,catname,describe)
values(801,'座椅套','各种品牌的汽车座套');

--（2）向商品表product中插入一条记录：商品编号80101，商品名称“四季通用汽车座套”，库存数量100，单价308，成本价288，商品类别编号801，上架时间“2018-01-01”）
--将商品表product中对每个班，求学生的平均年龄，并把结果存入数据库。
insert
into product(prono,proname,stock,price,cost,catno,ontime)
values('80101','四季通用汽车座套','100','308','288','801','2018-01-01')

--（3）查询订单日期为“2021-11-11”的每种商品的销售总数量，并将查询结果录入到表sale中
create table sale
(
	qty int
);
insert into sale
select qty
from orders
where orderdate='2021/11/11'

--(4）将供应商名称为“顺京通讯有限公司”的联系电话修改为“010-4358779”
update supplier
set telephone=010-4358779
where supname='顺京通讯有限公司'

--（5）将商品类别名称为“激光打印机”的所有商品的单价降低10%
update product
set price=price*0.9
where proname='激光打印机'

--(6)商品80101已经下架，从商品表中删除其详细记录信息
delete
from product
where prono=10101

--（7）将会员周晔的所有订单中付款日期paydate为空的订单信息全部删除
delete
from orders
where memno in(
	select memno
	from orders,member
	where paydate=NULL AND memname='周晔'
);

--（8） 建立会员订购商品视图view_buy，要求视图属性包括商品编号prono、商品名称proname、单价price、订单编号orderno、购买数量qty、优惠discount、实付总金额totalmoney，并且基于该视图修改属性totalmoney的值为：单价*购买数量-优惠
create view view_buy
as
select product.prono,proname,price,orderno,qty,discount,tatalmoney
from product,orders
where product.prono=orders.prono;
UPDATE view_buy
SET tatalmoney=price*qty-discount;

--（9）基于商品表和供应商表创建一个名为view_renbaocomputer的视图，要求能够通过该视图查看供应商名称为“仁宝电脑有限公司”的所有商品信息：包括商品编号pronno、商品名称proname、库存stock、单价price、成本价、供应商名称supname、联系电话telephone信息
create view view_renbaocomputer
as 
select prono,proname,stock,price,cost,supname,telephone
from product,supplier
where supname='仁宝电脑有限公司' and supplier.supno=product.supno;

--(10)基于商品表product创建一个视图view_product，要求视图总包括prono、proname、stock、price、cost、catno信息。然后通过该视图完成以下操作：
--通过视图view_product添加一条记录：（60102，‘海信37英寸激光电视机’，15，1600，
CREATE VIEW view_product
AS 
SELECT prono,proname,stock,price,cost,catno
FROM product
INSERT 
INTO view_product(prono,proname,stock,price,cost,catno)
VALUES ('60102','海信37英寸激光电视机','15','1600','1300','601')
--通过视图view_product修改商品编号为60201的价格为2499
--通过视图view_product删除商品编号为60201的商品
UPDATE view_product
SET price='2499'
WHERE prono='60201';

DELETE 
FROM view_product
WHERE prono='60201';


