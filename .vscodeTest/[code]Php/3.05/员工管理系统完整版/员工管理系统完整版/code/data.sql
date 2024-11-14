
-- 创建数据库
create database `itcast`;

-- 员工表
create table `pre_emp`(
  `emp_id` int unsigned primary key auto_increment,
  `emp_dept_id` int unsigned not null comment '所属部门ID',
  `emp_name` varchar(12) not null comment '姓名',
  `emp_birth` timestamp default '1970-01-01 8:0:1' not null comment '出生日期',
  `emp_entry` timestamp default '1970-01-01 8:0:1' not null comment '入职时间'
)charset=utf8 engine=innodb;

-- 部门表
create table `pre_dept`(
  `dept_id` int unsigned primary key auto_increment,
  `dept_name` varchar(12) not null unique comment '部门名称'
)charset=utf8 engine=innodb;

-- 默认数据
insert into `pre_emp` values
(null,'1','张三','1990-02-03','2015-08-08'),
(null,'2','李四','1991-05-02','2015-07-02'),
(null,'3','王五','1989-07-12','2015-09-01'),
(null,'4','赵六','1989-12-03','2014-04-12');

insert into `pre_dept` values
(null,'市场部'),
(null,'开发部'),
(null,'媒体部'),
(null,'销售部'),
(null,'人事部');