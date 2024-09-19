--在ecommerce数据库，针对会员表member首先创建一个“呼和浩特地区”会员的视图view_hohhot，然后通过该视图查询来自“呼和浩特”地区的会员信息，用批处理命令语句将问题进行分割，并分别以注释进行语句作用的说明描述
create view view_hohhot
as
select *
from member$
where address like'呼和浩特%';
go

--2、创建一个保存类别编号值的局部变量，并以set语句进行赋值，然后在product表中查询产品类别编号为局部变量值的产品名称proname、单价price、成本价cost、库存量stock。
declare @num int
set @num=10101
select proname,price,cost,stock
from product$
where prono=@num;

--3、查询供应商表supplier，如果存在供应商编号14001的记录，则显示“编号为14001的供应商记录已经存在”的消息，并输出此供应商的详细信息；否则插入一条供应商记录（14001，‘京顺通讯有限公司’，‘刘燕’，‘北京市朝阳区’，‘1111111’）

if exists(select supno from supplier$ where supno=14001)
begin
	print '编号为14001的供应商记录已经存在'
	select *
	from supplier$
	where supno=14001
end
else
	insert into supplier$(supno,supname,contactname,address,telephone)
	values(14001,'京顺通讯有限公司','刘燕','北京市朝阳区',1111111)
go
--4、查询商品表product的商品编号、商品名称、单价、库存量、商品类别名称信息，其中商品类别使用CASE语句，当类别编号为101时，则类别名称为手机；当类别编号为201时，则类别名称为激光打印机；当类别编号为202时，则类别名称为喷墨打印机，当类别编号为301时，则类别名称为平板电脑∙∙∙∙∙∙（具体参照商品表）

update product$
set brand=
case brand
when 101 then '手机'
when 201 then '激光打印机'
when 202 then '喷墨打印机'
when 301 then '平板电脑'
end
select prono,proname,price,stock,brand
from product$
go





