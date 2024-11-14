--��1��	��ѯÿλԱ����Ա�����empno��Ա������empname����ϵ�绰telephone�����ڲ�������depname
select empno,empname,telephone,depname
from employee,department
where employee.depno=department.depno;
--��2��	��ѯ���¶�������Ʒ��orderno��memname��proname��qty��tatalmoney��Ϣ
select orderno,memname,proname,qty,tatalmoney
from orders,member,product
where orders.memno=member.memno AND orders.prono=product.prono;
--��3��	��ѯ��Ա�����ܽ���2000�Ļ�Ա��memname��������Ʒ��proname����������qty��totalmoney��Ϣ
select memname,proname,qty,tatalmoney
from member,product,orders
where orders.memno=member.memno AND orders.prono=product.prono AND tatalmoney>2000
--��4��	��ѯ��Ʒ�������Ϊ���ֻ�����������Ʒ���乩Ӧ����Ϣ����ѯ�������proname��stock��supname��price��cost��ontime
select proname,stock,supname,price,cost,ontime
from product,supplier,category
where product.supno=supplier.supno AND category.catno=product.catno AND category.catname='�ֻ�';
--��5��	��ѯ��Ʒ�����а������������͡����ڻ����������ؼ��ֵĹ�Ӧ�̵�����supname
select supname
from supplier,product,category
where supplier.supno=product.supno AND category.catno=product.catno AND category.catname='���ڻ�' AND product.brand='����';
--��6��	��ѯ�����¹������Ļ�Ա��ϸ��Ϣ
select distinct member.*
from member,orders
where member.memno=orders.memno;
--��7��	�Ӷ�����orders�м�����Ʒ�������Ϊ���ֻ�����������������ǰ10������Ʒ�ı��prono����������qty
select product.prono,qty
from orders,category,product
where orders.prono=product.prono AND product.catno=category.catno AND category.catname='�ֻ�'
--��8��	��ѯ��Ʒ�������Ϊ���ʼǱ����ԡ����ҵ�����3000��5000֮�����Ʒ������proname������price���ɱ���cost������stock
select proname,price,cost,stock
from category,product
where product.catno=category.catno AND catname='�ʼǱ�����'AND cost between 3000 and 5000;
--��9��	��ѯ��������Ϊ��2021-11-11������Ʒ�������Ϊ���ֻ�������Ʒ������������
select sum(qty) ����������
from orders
where orderdate='2021-11-11'
--��10����ѯ��ַ�ǹ����еĹ�Ӧ�̵�����supname����Ʒ����proname
select supname,proname
from supplier,product
where address like'������%'AND product.supno=supplier.supno;