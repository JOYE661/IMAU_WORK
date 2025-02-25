from django.contrib import admin
from app.models import *
# Register your models here.
@admin.register(User)
class UserAdmin(admin.ModelAdmin):
    # list_display用于设置列表页面要显示的不同字段
    list_display = ['id','name','tel','password']
    # search_fields用于设置搜索栏中要搜索的不同字段
    search_fields = ['id','name','tel','password']

@admin.register(Stock)
class UserAdmin(admin.ModelAdmin):
    # list_display用于设置列表页面要显示的不同字段
    list_display = ['code','name','date','open',
                    'high','close','low','volume',
                    'price_change','p_change','ma','turnover',
                    'lastclose','cjje'
                    ]
    # search_fields用于设置搜索栏中要搜索的不同字段
    search_fields = ['code','name','date','open',
                    'high','close','low','volume',
                    'price_change','p_change','ma','turnover',
                    'lastclose','cjje'
                    ]

