select supname
from supplier;

select supname,telephone
from supplier;

select catno as �����,catname as �������,describe as ����
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

select prono,stock as �������
from product;

select price as ��߼�,cost as ��ͼ�,(price+cost)/2 as ƽ����
from product
where catno=401

