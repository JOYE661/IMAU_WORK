--��1����ѯ��Ӧ�̱�supplier�����й�Ӧ�̵���Ϣ
select supname
from supplier

--��2�� ��ѯ��Ʒ����category��������Ʒ������Ϣ�����ԡ�����š�����������ơ�������������Ϊ�������ֶ�����
select catno as �����,catname as �������,describe as ����
from category

--��3����ѯ��Ʒ��product����Ʒ�����Ϊ201���ҵ��۸���1299����Ʒ������proname�͵���price
select proname, price
from product
where catno=201 and price>1299;

--��4��������Ʒ��product����Ʒ�����Ϊ401����Ʒ����߼ۡ���ͼۺ�ƽ���ۣ����ԡ���߼ۡ�������ͼۡ�����ƽ���ۡ���Ϊ�������ֶ�����
select max(price)as ��߼�,min(price)as ��ͼ�,avg(price)as ƽ����
from product
where catno=401

--��5) ��ѯ��Ʒ�������Ϊ���ֻ�����������Ʒ���乩Ӧ����Ϣ����ѯ�������proname��stock��supname��price��cost��ontime
select proname,stock,supname,price,cost,ontime
from product,supplier,category
where product.supno=supplier.supno AND category.catno=product.catno AND category.catname='�ֻ�';

--��6�� ��ѯ��Ʒ�����а������������͡����ڻ����������ؼ��ֵĹ�Ӧ�̵�����supname
select supname
from supplier,product,category
where supplier.supno=product.supno AND category.catno=product.catno AND category.catname='���ڻ�' AND product.brand='����';

--��7�� �Ӷ�����orders�м�����Ʒ�������Ϊ���ֻ�����������������ǰ10������Ʒ�ı��prono����������qty
select product.prono,qty
from orders,category,product
where orders.prono=product.prono AND product.catno=category.catno AND category.catname='�ֻ�'

--��8�� ��ѯ��Ʒ�������Ϊ���ʼǱ����ԡ����ҵ�����3000��5000֮�����Ʒ������proname������price���ɱ���cost������stock
select proname,price,cost,stock
from category,product
where product.catno=category.catno AND catname='�ʼǱ�����'AND cost between 3000 and 5000;

--��9�� ��ѯ��������Ϊ��2021-11-11������Ʒ�������Ϊ���ֻ�������Ʒ������������
select sum(qty) ����������
from orders
where orderdate='2021-11-11'

--��10����ѯ��ַ�ǹ����еĹ�Ӧ�̵�����supname����Ʒ����proname
select supname,proname
from supplier,product
where address like'������%'AND product.supno=supplier.supno;
