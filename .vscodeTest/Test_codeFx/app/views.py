import datetime
import json
import os
import random
import warnings

import pandas as pd
import tushare as ts
from django.http import JsonResponse
from django.shortcuts import render, redirect, HttpResponse
from django.views import View
from tqdm import tqdm

from app.itemBasedCF import ItemBasedCF
from app.models import *

warnings.filterwarnings('ignore')


# 验证登录
def check_login(func):
    def wrapper(request):
        # print("装饰器验证登录")
        cookie = request.COOKIES.get('uid')
        if not cookie:
            return redirect('/login/')
        else:
            return func(request)

    return wrapper


# Create your views here.
# 股票新闻列表
@check_login
def index(request):
    uid = int(request.COOKIES.get('uid', -1))
    if uid != -1:
        username = User.objects.filter(id=uid)[0].name
    today = datetime.datetime.now()  # 日期对象
    today_str = today.strftime('%Y-%m-%d')  # 字符串
    if not News.objects.filter(today=today_str):
        end_date = f'{today_str} 00:00:00'
        pro = ts.pro_api('1e22fa60e76eefe016a6bbf3ecfe84d1cb55d5af8415ecd787067e3f')
        #
        df = pro.major_news(src='', start_date='2022-03-01 00:00:00', end_date=end_date)
        print(df)
        if not df.empty:
            for i in range(len(df)):
                title = df.iloc[i]['title']
                date = df.iloc[i]['pub_time']
                src = df.iloc[i]['src']
                if not News.objects.filter(title=title, date=date, src=src, today=today_str):
                    News.objects.create(title=title, date=date, src=src, today=today_str)


    newlist = News.objects.all().order_by('-date')[:20]

    return render(request, 'index.html', locals())


def data2sql1(raw_json):
    code = raw_json['代码']
    name = raw_json['简称']
    date = raw_json['日期']

    # 有空的特征
    open = raw_json['开盘价(元)']
    open = float(open)

    high = raw_json['最高价(元)']
    high = float(high)

    low = raw_json['最低价(元)']
    low = float(low)

    close = raw_json['收盘价(元)']
    close = float(close)

    volume = raw_json['成交量(股)']
    try:
        volume = float(volume)
    except:
        volume = None

    price_change = raw_json['涨跌(元)']
    price_change = float(price_change)

    p_change = raw_json['涨跌幅(%)']
    try:
        p_change = float(p_change)
    except:
        p_change = None

    ma = raw_json['均价(元)']
    try:
        ma = float(ma)
    except:
        ma = None

    turnover = raw_json['换手率(%)']
    try:
        turnover = float(turnover)
    except:
        turnover = None

    lastclose = raw_json['前收盘价(元)']
    try:
        lastclose = float(lastclose)
    except:
        lastclose = None

    cjje = raw_json['成交金额(元)']
    try:
        cjje = float(cjje)
    except:
        cjje = None
    if not Stock.objects.filter(code=code, name=name, date=date, open=open, high=high, close=close,
                                low=low, volume=volume, price_change=price_change, ma=ma,
                                turnover=turnover, lastclose=lastclose, cjje=cjje, p_change=p_change):
        Stock.objects.create(code=code, name=name, date=date, open=open, high=high, close=close,
                             low=low, volume=volume, price_change=price_change, ma=ma,
                             turnover=turnover, lastclose=lastclose, cjje=cjje, p_change=p_change)
    # tmp = raw_json['A股流通市值(元)']
    # tmp = raw_json['B股流通市值(元)']
    # tmp = raw_json['总市值(元)']
    # tmp = raw_json['A股流通股本(股)']
    # tmp = raw_json['B股流通股本(股)']
    # tmp = raw_json['总股本(股)']
    # tmp = raw_json['市盈率']
    # tmp = raw_json['市净率']
    # tmp = raw_json['市销率']
    # tmp = raw_json['市现率']
    return 'finished'


# 加载数据到数据库中  并且对数据进行一定的清洗
def data2mysql(request):
    # 股票信息表字典
    stock_info_dict = dict()
    Stock.objects.all().delete()
    cnt = 0  # 统计股票数量
    for file in os.listdir(os.path.join('data', '上证A股')):
        if '.CSV' not in file:
            continue
        file_path = os.path.join('data', '上证A股', file)
        raw_json = pd.read_csv(file_path, encoding='gbk')

        for i in tqdm(range(len(raw_json))):
            code = raw_json.iloc[i]['代码']
            name = raw_json.iloc[i]['简称']
            date = raw_json.iloc[i]['日期']
            stock_info_dict[code] = name
            # 有空的特征
            open = raw_json.iloc[i]['开盘价(元)']
            open = float(open)

            high = raw_json.iloc[i]['最高价(元)']
            high = float(high)

            low = raw_json.iloc[i]['最低价(元)']
            low = float(low)

            close = raw_json.iloc[i]['收盘价(元)']
            close = float(close)

            volume = raw_json.iloc[i]['成交量(股)']
            try:
                volume = float(volume)
            except:
                volume = None

            price_change = raw_json.iloc[i]['涨跌(元)']
            price_change = float(price_change)

            p_change = raw_json.iloc[i]['涨跌幅(%)']
            try:
                p_change = float(p_change)
            except:
                p_change = None

            ma = raw_json.iloc[i]['均价(元)']
            try:
                ma = float(ma)
            except:
                ma = None

            turnover = raw_json.iloc[i]['换手率(%)']
            try:
                turnover = float(turnover)
            except:
                turnover = None

            lastclose = raw_json.iloc[i]['前收盘价(元)']
            try:
                lastclose = float(lastclose)
            except:
                lastclose = None

            cjje = raw_json.iloc[i]['成交金额(元)']
            try:
                cjje = float(cjje)
            except:
                cjje = None
            # 股票历史价格
            if not Stock.objects.filter(code=code, name=name, date=date, open=open, high=high, close=close,
                                        low=low, volume=volume, price_change=price_change, ma=ma,
                                        turnover=turnover, lastclose=lastclose, cjje=cjje, p_change=p_change):
                Stock.objects.create(code=code, name=name, date=date, open=open, high=high, close=close,
                                     low=low, volume=volume, price_change=price_change, ma=ma,
                                     turnover=turnover, lastclose=lastclose, cjje=cjje, p_change=p_change)
        cnt += 1
        if cnt >= 48:
            break
    for code, name in stock_info_dict.items():
        url = f'https://stock.quote.stockstar.com/{code}tml'
        url = url.lower()
        if not StockInfo.objects.filter(url=url, code=code, name=name):
            StockInfo.objects.create(url=url, code=code, name=name)

    # 从 数据中信息复制到股票信息表中

    return JsonResponse({'status': 1, 'msg': '操作成功'})


# 股票列表
class gupiaoList(View):
    def get(self, request):
        uid = int(request.COOKIES.get('uid', -1))
        if uid != -1:
            username = User.objects.filter(id=uid)[0].name
        raw_data = Stock.objects.all()

        code_list = list(set([i.code for i in raw_data]))
        code_list = sorted(code_list)

        if 'code' in request.GET:
            code = request.GET.get('code')
        else:
            code = code_list[0]

        # 没有就需要爬取了
        # if not GuPiao.objects.filter(code=code):
        #     df = ts.get_hist_data(code)
        #
        #     df['date'] = df.index
        #     for i in tqdm(range(len(df))):
        #         date = df.iloc[i]['date']
        #         open = df.iloc[i]['open']
        #         high = df.iloc[i]['high']
        #         close = df.iloc[i]['close']
        #         low = df.iloc[i]['low']
        #         volume = df.iloc[i]['volume']
        #         price_change = df.iloc[i]['price_change']
        #         p_change = df.iloc[i]['p_change']
        #         ma5 = df.iloc[i]['ma5']
        #         ma10 = df.iloc[i]['ma10']
        #         ma20 = df.iloc[i]['ma20']
        #         v_ma5 = df.iloc[i]['v_ma5']
        #         v_ma10 = df.iloc[i]['v_ma10']
        #         v_ma20 = df.iloc[i]['v_ma20']
        #         turnover = df.iloc[i]['turnover']
        #         if not GuPiao.objects.filter(date=date, open=open, high=high, close=close, low=low, volume=volume,
        #                                      price_change=price_change, p_change=p_change,
        #                                      ma5=ma5, ma10=ma10, ma20=ma20, v_ma5=v_ma5, v_ma10=v_ma10, v_ma20=v_ma20,
        #                                      turnover=turnover, code=code):
        #             GuPiao.objects.create(date=date, open=open, high=high, close=close, low=low, volume=volume,
        #                                   price_change=price_change, p_change=p_change,
        #                                   ma5=ma5, ma10=ma10, ma20=ma20, v_ma5=v_ma5, v_ma10=v_ma10, v_ma20=v_ma20,
        #                                   turnover=turnover, code=code)

        if 'page' not in request.GET:
            page = 1
        else:
            page = int(request.GET.get('page'))
        data_list = Stock.objects.filter(code=code)[(page - 1) * 20: page * 20]
        return render(request, 'gupiaoList.html', locals())

    def post(self, request):

        return JsonResponse({'status': 1, 'msg': '操作成功'})


# 可视化
# @method_decorator(check_login,name='get') #
class plot(View):
    def get(self, request):

        """
        0  K线图
        1 股票走势图 折线图
        2 股票 4个指数图折线图
        3 价格区间个数
        4 价格排行榜
        5 成交量和价格散点图
        :param request:
        :return:
        """
        uid = int(request.COOKIES.get('uid', -1))
        if uid != -1:
            username = User.objects.filter(id=uid)[0].name
        code_list = list(set([itme.code for itme in Stock.objects.all()]))
        if 'code' in request.GET:
            code = request.GET.get('code')
        else:
            code = code_list[0]

        raw_data = Stock.objects.filter(code=code)
        # 0 K线图
        # open，close，lowest，highest
        main0_data = [[
            str(i.date).replace('-', '/'),
            i.open, i.close, i.low, i.high
        ]
            for i in raw_data.order_by('date')
        ]
        # print(main0_data)

        # 1 股票走势图

        main1 = raw_data.order_by('date')
        main1_x = [str(itme.date) for itme in main1]

        main1_y = [itme.close for itme in main1]

        # 2 股票 五个指数图折线图
        main2_legend = ['开盘价', '最高价', '收盘价', '最低价']
        main2 = raw_data.order_by('date')
        main2_x = [str(itme.date) for itme in main1]
        main2_y = [
            {
                'name': '开盘价',
                'type': 'line',
                'data': [itme.open for itme in main1]
            },
            {
                'name': '最高价',
                'type': 'line',
                'data': [itme.high for itme in main1]
            },
            {
                'name': '收盘价',
                'type': 'line',
                'data': [itme.close for itme in main1]
            },
            {
                'name': '最低价',
                'type': 'line',
                'data': [itme.low for itme in main1]
            },
        ]

        # 3 价格区间个数 2-10，
        main3_raw = raw_data
        main3 = [f'成交价{i}-{i + 1}区间' for i in range(2, 10)]
        main3_data = [{'name': item, 'value': 0} for item in main3]
        for item in main3_raw:
            close = item.close
            if close < 3:
                main3_data[0]['value'] = main3_data[0]['value'] + 1
            elif close < 4:
                main3_data[1]['value'] = main3_data[1]['value'] + 1
            elif close < 5:
                main3_data[2]['value'] = main3_data[2]['value'] + 1
            elif close < 6:
                main3_data[3]['value'] = main3_data[3]['value'] + 1
            elif close < 7:
                main3_data[4]['value'] = main3_data[4]['value'] + 1
            elif close < 8:
                main3_data[5]['value'] = main3_data[5]['value'] + 1
            elif close < 9:
                main3_data[6]['value'] = main3_data[6]['value'] + 1
            else:
                main3_data[7]['value'] = main3_data[7]['value'] + 1

        # 4 价格排行榜
        main4 = raw_data.order_by('-close')[:10]
        main4_x = [str(itme.date) for itme in main4]
        main4_y = [itme.close for itme in main4]

        # 5 成交量和价格散点图

        main5 = [[_.volume, _.close] for _ in raw_data if _.volume and _.close]
        # print(main5)

        return render(request, 'plot.html', locals())

    def post(self, request):
        return HttpResponse('post方法')
        return JsonResponse({'status': 1, 'msg': '操作成功'})


@check_login
def my(request):
    uid = int(request.COOKIES.get('uid', -1))
    if uid != -1:
        username = User.objects.filter(id=uid)[0].name
    if request.method == "POST":
        name, tel, password = request.POST.get('name'), request.POST.get('tel'), request.POST.get('password1')
        User.objects.filter(id=uid).update(name=name, tel=tel, password=password)
        return redirect('/')
    else:
        my_info = User.objects.filter(id=uid)[0]
        return render(request, 'my.html', locals())


def test(request):
    return HttpResponse('测试完成')


# 登录
def login(request):
    if request.method == "POST":
        tel, pwd = request.POST.get('tel'), request.POST.get('pwd')
        if User.objects.filter(tel=tel, password=pwd):

            obj = redirect('/')
            obj.set_cookie('uid', User.objects.filter(tel=tel, password=pwd)[0].id, max_age=60 * 60 * 24)
            return obj
        else:
            msg = "用户信息错误，请重新输入！！"
            return render(request, 'login.html', locals())
    else:
        return render(request, 'login.html', locals())


# 注册
def register(request):
    if request.method == "POST":
        name, tel, pwd = request.POST.get('name'), request.POST.get('tel'), request.POST.get('pwd')
        print(name, tel, pwd)
        if User.objects.filter(tel=tel):
            msg = "你已经有账号了，请登录"
        else:
            User.objects.create(name=name, tel=tel, password=pwd)
            msg = "注册成功，请登录！"
        return render(request, 'login.html', locals())
    else:
        msg = ""
        return render(request, 'register.html', locals())


# 注销
def logout(request):
    obj = redirect('/')
    obj.delete_cookie('uid')
    return obj


# @method_decorator(check_login,name='get') #
class stockInfoListView(View):
    def get(self, request):
        uid = int(request.COOKIES.get('uid', -1))
        if uid != -1:
            username = User.objects.filter(id=uid)[0].name
        #
        tmp = []
        data_list = StockInfo.objects.all()
        for i in data_list:
            is_star = 1 if Star.objects.filter(user_id=uid, stock_id=i.id) else 0
            see = See.objects.filter(stock_id=i.id).count()
            star = Star.objects.filter(stock_id=i.id).count()
            tmp.append({
                'code': i.code,
                'name': i.name,
                'id': i.id,
                'url': i.url,
                'see': see,
                'star': star,
                'is_star': is_star,

            })
        data_list = tmp
        return render(request, 'stockInfoList.html', locals())

    def post(self, request):
        return HttpResponse('post方法')
        return JsonResponse({'status': 1, 'msg': '操作成功'})


################################下面可能没用的

def star(request):
    hid = request.POST.get('hid')
    uid = int(request.COOKIES.get('uid', -1))

    if Star.objects.filter(user_id=int(uid), stock_id=int(hid)):
        Star.objects.filter(user_id=int(uid), stock_id=int(hid)).delete()
        return JsonResponse({'color': 'black', 'msg': '取消收藏啦'})
    else:
        Star.objects.create(user_id=int(uid), stock_id=int(hid))
        return JsonResponse({'color': 'red', 'msg': '收藏啦'})


def see(request):
    hid = request.POST.get('hid')
    uid = int(request.COOKIES.get('uid', -1))
    See.objects.create(user_id=uid, stock_id=hid)
    return JsonResponse({'msg': 'ok'})


def tuijian(request):
    uid = int(request.COOKIES.get('uid', -1))
    if uid != -1:
        username = User.objects.filter(id=uid)[0].name
    #

    train = dict()
    history = Star.objects.all()  # 0.1
    for item in history:
        if item.user_id not in train.keys():
            train[item.user_id] = {item.stock_id: 1}
        else:
            train[item.user_id][item.stock_id] = train[item.user_id].get(item.stock_id, 0) + 1
    history = See.objects.all()  # 0.1
    for item in history:
        if item.user_id not in train.keys():
            train[item.user_id] = {item.stock_id: 0.1 * 1}
        else:
            train[item.user_id][item.stock_id] = train[item.user_id].get(item.stock_id, 0) + 0.1 * 1
    # 声明一个ItemBasedCF的对象
    try:
        item = ItemBasedCF(train)
        item.ItemSimilarity()
        recommedDict = item.Recommend(int(uid))  # 字典
    except:
        recommedDict = dict()
    if len(recommedDict) == 0:
        msg = "你还没有在该网站有过收藏、浏览行为，请去浏览吧！"
        id_list = [i.id for i in StockInfo.objects.all()]
        random.shuffle(id_list)

        data_list = StockInfo.objects.filter(id__in=id_list[:6])
        score_list = [0, ] * len(data_list)

    else:
        msg = ""
        id_list = recommedDict.keys()
        score_list = recommedDict.keys()
        data_list = [StockInfo.objects.get(id=i) for i in id_list]

    tmp = []

    for i, score in zip(data_list, score_list):
        is_star = 1 if Star.objects.filter(user_id=uid, stock_id=i.id) else 0
        see = See.objects.filter(stock_id=i.id).count()
        star = Star.objects.filter(stock_id=i.id).count()
        tmp.append({
            'code': i.code,
            'name': i.name,
            'id': i.id,
            'url': i.url,
            'see': see,
            'star': star,
            'is_star': is_star,
            'score': score,

        })
    data_list = tmp
    return render(request, 'tuijian.html', locals())


def plotAll(request):
    uid = int(request.COOKIES.get('uid', -1))
    if uid != -1:
        username = User.objects.filter(id=uid)[0].name

    if os.path.exists('plotAll1.json'):
        main1_x, main1_y = json.load(open('plotAll1.json',encoding='utf-8'))
        main2_legend, main2_x, main2_y = json.load(open('plotAll2.json',encoding='utf-8'))
        # main1_x, main1_y = json.load(open('plotAll1.json'))
        # main2_legend, main2_x, main2_y = json.load(open('plotAll2.json'))
    else:
        raw_data = Stock.objects.all()

        date_list = [i.date for i in raw_data]
        date_list = sorted(list(set(date_list)))

        # 1 股票走势图

        main1_x = [datetime.datetime.strftime(i, '%Y-%m-%d') for i in date_list]
        main1_y = [raw_data.filter(date=item).count() for item in date_list]
        json.dump(
            [main1_x, main1_y],
            open('plotAll1.json', 'w', encoding='utf-8'),
            indent=4,
            ensure_ascii=False
        )
        # # 2 股票 折线图
        main2_legend = ['最高价', '最低价']
        main2 = raw_data.order_by('date')
        main2_x = main1_x
        main2_y = [

            {
                'name': '最高价',
                'type': 'line',
                'data': [max([i.close for i in raw_data.filter(date=item)]) for item in date_list]
            },
            {
                'name': '最低价',
                'type': 'line',
                'data': [min([i.close for i in raw_data.filter(date=item)]) for item in date_list]
            },
        ]
        json.dump(
            [main2_legend, main2_x, main2_y],
            open('plotAll2.json', 'w', encoding='utf-8'),
            indent=4,
            ensure_ascii=False
        )
    return render(request, 'plotAll.html', locals())
