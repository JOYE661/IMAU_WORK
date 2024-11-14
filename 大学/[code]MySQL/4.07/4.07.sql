select supname
from supplier;

select supname,telephone
from supplier;

select catno as 类别编号,catname as 类别名称,describe as 描述
from category;

select top 5 *
from product;

select distinct empno
from employee;

select prono,proname,price
from product order by price;

select prono,proname,supno
from product
where stock=0;

select proname,price
from product
where catno=201 and price>1299;

select prono,stock as 库存数量
from product;

select price as 最高价,cost as 最低价,(price+cost)/2 as 平均价
from product
where catno=401

