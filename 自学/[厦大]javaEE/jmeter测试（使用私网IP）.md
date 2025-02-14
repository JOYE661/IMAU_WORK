# jmeter测试（使用私网IP）

## 测试步骤

### 本地编辑jmx文件

![image-20231114131044955](C:\Users\CC507\AppData\Roaming\Typora\typora-user-images\image-20231114131044955.png)

### 通过ssh上传到服务端

` scp C:\Users\CC507\Desktop\ReadProduct.jmx root@124.70.53.157:/root`

![image-20231114131421431](C:\Users\CC507\AppData\Roaming\Typora\typora-user-images\image-20231114131421431.png)

### 修改参数

![image-20231114131655516](C:\Users\CC507\AppData\Roaming\Typora\typora-user-images\image-20231114131655516.png)

### 生成jtl文件

jmeter -n -t WriteProduct.jmx -l Read8000.jtl

![image-20231114132239208](C:\Users\CC507\AppData\Roaming\Typora\typora-user-images\image-20231114132239208.png)

### 生成结果文件

`jmeter -g Read4000.jtl -o result/`

scp root@124.70.53.157:/root/Write_1000_10_1.jtl C:\Users\CC507\Desktop

docker exec -it 42169eba296f mysql -uroot -p

use oomall_demo;

docker exec -it 42169eba296f bash

source /sql/product.sql;

select count(*) from goods_product;

alter table goods_product add index name_index(name);

show index from goods_product;

ssh -o ServerAliveInterval=60 root@120.46.62.239

jmeter -n -t WriteProduct.jmx -l result/Write400Index1.jtl

scp -r root@124.70.53.157:/root/result C:\Users\CC507\Desktop

python3 convert.py

SHOW COLUMNS FROM goods_product;
