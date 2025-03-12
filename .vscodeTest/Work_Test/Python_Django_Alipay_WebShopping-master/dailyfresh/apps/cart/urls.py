# from django.conf.urls import url
# from cart.views import CartAddView, CartInfoView, CartUpdateView, CartDeleteView

# urlpatterns = [
#     url(r'^add$', CartAddView.as_view(), name='add'), # 购物车记录添加
#     url(r'^$', CartInfoView.as_view(), name='show'), # 购物车页面显示
#     url(r'^update$', CartUpdateView.as_view(), name='update'), # 购物车记录更新
#     url(r'^delete$', CartDeleteView.as_view(), name='delete'), # 购物车记录删除
# ]
from django.urls import path
#from cart.views import CartAddView, CartInfoView, CartUpdateView, CartDeleteView

urlpatterns = [
    # path('add/', CartAddView.as_view(), name='add'),  # 购物车添加（注意结尾斜杠）
    # path('', CartInfoView.as_view(), name='show'),    # 购物车首页（路径为空）
    # path('update/', CartUpdateView.as_view(), name='update'),  # 购物车更新
    # path('delete/', CartDeleteView.as_view(), name='delete'),  # 购物车删除
]
