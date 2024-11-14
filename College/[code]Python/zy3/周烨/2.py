n=int(input('整数n;'))
if n%3==0:
    if n%5==0:
        print(n,'能被3和5同时整除')
    else:
        print(n,'能被3整除')
else:
    if n%5==0:
        print(n,'能被5整除')
    else:
        print(n,'不能被3或5整除')
