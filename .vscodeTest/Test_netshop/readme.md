# 1p:

构建商品表，setting里面

```json
DATABASES = {
    "default": {
        "ENGINE": "django.db.backends.mysql",
        "NAME": "netshop",
        "USER": "root",
        "PASSWORD": "64646464",
        "HOST": "127.0.0.1",
        "PORT": "3306",
    }
}
```

下一步去 **python manage.py startapp goods**创建good表，构建各种class数据

下一步去**python manage.py makemigrations goods**创建sql表

**
    python manage.py migrate**

（配环境 Expand:brew install mysql ;  pip install mysqlclient ）
