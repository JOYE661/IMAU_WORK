import pandas as pd
import datetime


def load_Data():
    # 加载数据
    df0 = pd.read_csv("Path/power.csv", index_col='user_id')
    df0['record_date'] = pd.to_datetime(df0['record_date'])
    return df0


# 把datetime转成字符串
def datetime_toString(dt):
    return dt.strftime("%Y-%m-%d")


# 把字符串转成datetime
def string_toDatetime(string):
    return datetime.strptime(string, "%Y-%m-%d")


# 缺失值处理，插值替换
def data_Full():
    df1 = load_Data()  # 加载数据
    date_start = df1.iloc[0, 0]  # 初始时间
    df1_date = df1['record_date'].tolist()  # 数据日期转为列表
    df1_data = df1['value'].tolist()  # 数据值转为列表
    act = 365  # 实际期望日期序列长度
    for j in range(0, len(df1_date)):
        if len(df1_date) < act:
            date0 = date_start
            date_s = datetime_toString(date0)  # 日期转换为字符串类型，使日期可进行逻辑比较
            date_i = df1_date[j]  # 顺序选取数据中日期列表里对应各日期
            date_is = datetime_toString(date_i)
            while date_is != date_s:  # 如数据中日期列表与期望日期序列不相等，即存在缺失值执行while程序
                nada = (df1_data[j] + df1_data[j + 1]) / 2  # 计算缺失处左右相邻插值
                adda = [date0, nada]
                date_da = pd.DataFrame(adda).T
                date_da.columns = df1.columns
                df1 = pd.concat([df1, date_da])  # 将缺失日期加入数据列表中
                date0 += datetime.timedelta(days=1)  # 日期加一
                date_s = datetime_toString(date0)  # 日期字符串转日期时间类型
            date0 += datetime.timedelta(days=1)  # 日期加一
            date_s = datetime_toString(date0)  # 日期字符串转日期时间类型
    df1 = df1.sort_values(by=['record_date'])
    return df1