### 基于 Django 框架的b2b海外仓储平台

```
django-admin startproject bysms

python manage.py runserver 0.0.0.0:80
```

```
python manage.py startapp sales
```

所以，所谓 `路由` 就是指 ： 根据 HTTP请求的url路径， 设置 由哪个 函数来处理这个请求。

首先我们需要创建数据库，执行如下命令

```
python manage.py migrate
```

现在Django知道了我们的 common 应用， 我们可以在项目根目录下执行命令

***python manage.py makemigrations common***

```
d:\projects\bysms>python manage.py makemigrations common
```

Migrations for 'common':
  common\migrations\0001_initial.py
    - Create model Customer

这个命令，告诉Django ， 去看看common这个app里面的models.py ，我们已经修改了数据定义， 你现在去产生相应的更新脚本。

执行一下，会发现在 common\migrations 目录下面出现了0001_initial.py, 这个脚本就是相应要进行的数据库操作代码。

随即，执行如下命令

***python manage.py migrate***

```
d:\projects\bysms>python manage.py migrate

Operations to perform:
  Apply all migrations: admin, auth, common, contenttypes, sessions
Running migrations:
  Applying common.0001_initial... OK
```

如果以后我们修改了Models.py 里面的库表的定义，

都需要再次运行 **python manage.py makemigrations common** 和 **python manage.py migrate** 命令，

使数据库同步该修改结果

Django提供了一个管理员操作界面可以方便的 添加、修改、删除你定义的 model 表数据。

首先，我们需要创建 一个超级管理员账号。

进入到项目的根目录，执行如下命令，依次输入你要创建的管理员的 登录名、email、密码。

***python manage.py createsuperuser***

```
d:\projects\bysms>python manage.py createsuperuser
Username (leave blank to use 'byhy'): byhy
Email address: byhy@163.com
Password:
Password (again):
Superuser created successfully.
```

注意密码至少8个字符。 这里，我们设置密码为 `88888888`

现在尝试接入deepseek接口：sk-c23c7cdf318c413392e48371e0efa667
