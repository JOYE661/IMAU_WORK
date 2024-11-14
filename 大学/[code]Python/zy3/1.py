year=int(input('请输入年份：'))
if year%4==0:
    if year%100!=0:
        print(year,'是闰年')
    else:
        if year%400==0:
            print(year,'是闰年')
        else:
            print(year,'不是闰年')
else:
    print(year,'不是闰年')
