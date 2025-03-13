from django.urls import path

from api import handlers,wf_handlers

urlpatterns = [

    path('sign', handlers.SignHandler().dispatch),
    path('account', handlers.AccountHandler().dispatch),
    path('notice', handlers.NoticeHandler().dispatch),
    path('news', handlers.NewsHandler().dispatch),
    path('paper', handlers.PaperHandler().dispatch),
    path('config', handlers.ConfigHandler().dispatch),
    path('upload', handlers.UploadHandler().dispatch),

    # etc 其余操作，包括 学生点赞，学生关联老师，获取关联老师学生
    path('etc', handlers.ETCHandler().dispatch),

    # 毕业设计工作流
    path('wf_graduatedesign', handlers.WF_GraduateDesign_Handler().dispatch),

]