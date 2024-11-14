--��1������Ʒ����category�в���һ����¼��801���������ס���������Ʒ�Ƶ��������ס���
insert
into category(catno,catname,describe)
values(801,'������','����Ʒ�Ƶ���������');

--��2������Ʒ��product�в���һ����¼����Ʒ���80101����Ʒ���ơ��ļ�ͨ���������ס����������100������308���ɱ���288����Ʒ�����801���ϼ�ʱ�䡰2018-01-01����
--����Ʒ��product�ж�ÿ���࣬��ѧ����ƽ�����䣬���ѽ���������ݿ⡣
insert
into product(prono,proname,stock,price,cost,catno,ontime)
values('80101','�ļ�ͨ����������','100','308','288','801','2018-01-01')

--��3����ѯ��������Ϊ��2021-11-11����ÿ����Ʒ��������������������ѯ���¼�뵽��sale��
create table sale
(
	qty int
);
insert into sale
select qty
from orders
where orderdate='2021/11/11'

--(4������Ӧ������Ϊ��˳��ͨѶ���޹�˾������ϵ�绰�޸�Ϊ��010-4358779��
update supplier
set telephone=010-4358779
where supname='˳��ͨѶ���޹�˾'

--��5������Ʒ�������Ϊ�������ӡ������������Ʒ�ĵ��۽���10%
update product
set price=price*0.9
where proname='�����ӡ��'

--(6)��Ʒ80101�Ѿ��¼ܣ�����Ʒ����ɾ������ϸ��¼��Ϣ
delete
from product
where prono=10101

--��7������Ա���ʵ����ж����и�������paydateΪ�յĶ�����Ϣȫ��ɾ��
delete
from orders
where memno in(
	select memno
	from orders,member
	where paydate=NULL AND memname='����'
);

--��8�� ������Ա������Ʒ��ͼview_buy��Ҫ����ͼ���԰�����Ʒ���prono����Ʒ����proname������price���������orderno����������qty���Ż�discount��ʵ���ܽ��totalmoney�����һ��ڸ���ͼ�޸�����totalmoney��ֵΪ������*��������-�Ż�
create view view_buy
as
select product.prono,proname,price,orderno,qty,discount,tatalmoney
from product,orders
where product.prono=orders.prono;
UPDATE view_buy
SET tatalmoney=price*qty-discount;

--��9��������Ʒ��͹�Ӧ�̱���һ����Ϊview_renbaocomputer����ͼ��Ҫ���ܹ�ͨ������ͼ�鿴��Ӧ������Ϊ���ʱ��������޹�˾����������Ʒ��Ϣ��������Ʒ���pronno����Ʒ����proname�����stock������price���ɱ��ۡ���Ӧ������supname����ϵ�绰telephone��Ϣ
create view view_renbaocomputer
as 
select prono,proname,stock,price,cost,supname,telephone
from product,supplier
where supname='�ʱ��������޹�˾' and supplier.supno=product.supno;

--(10)������Ʒ��product����һ����ͼview_product��Ҫ����ͼ�ܰ���prono��proname��stock��price��cost��catno��Ϣ��Ȼ��ͨ������ͼ������²�����
--ͨ����ͼview_product���һ����¼����60102��������37Ӣ�缤����ӻ�����15��1600��
CREATE VIEW view_product
AS 
SELECT prono,proname,stock,price,cost,catno
FROM product
INSERT 
INTO view_product(prono,proname,stock,price,cost,catno)
VALUES ('60102','����37Ӣ�缤����ӻ�','15','1600','1300','601')
--ͨ����ͼview_product�޸���Ʒ���Ϊ60201�ļ۸�Ϊ2499
--ͨ����ͼview_productɾ����Ʒ���Ϊ60201����Ʒ
UPDATE view_product
SET price='2499'
WHERE prono='60201';

DELETE 
FROM view_product
WHERE prono='60201';


