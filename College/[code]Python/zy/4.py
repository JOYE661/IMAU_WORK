for n in range(100,1000):
    a=n//100
    b=n//10%10
    c=n%10
    s=a**3+b**3+c**3
    if n==s:
        print('水仙花数：',n)
