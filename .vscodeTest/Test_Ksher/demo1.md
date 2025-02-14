### **2.12笔记**

### **自动化代码**

`python3 -m playwright codegen --target python -o 'my.py' -b chromium https://www.baidu.com`

`python3 -m playwright codegen --target python -o 'autoTest.py' -b chromium https://air.1688.com/app/1688-global/main-site-channel/inner-rank.html?spm=a260k.home2024.leftmenu_EXPEND.dzhanneishangji0of0kuajing.663335e4jLVMS8`

`playwright codegen`

#### with…as…语句

Python 的 with…as… 语句，就像一个贴心的管家，负责照顾你的资源，让你不再担心忘记关闭文件、[网络连接](https://so.csdn.net/so/search?q=%E7%BD%91%E7%BB%9C%E8%BF%9E%E6%8E%A5&spm=1001.2101.3001.7020)或数据库事务等。这个管家在你进入“房间”时自动打开门，离开时帮你把门关上，真的是非常贴心！

例如，当你打开一个文件时，你可能会这样写：

```python
file = open("example.txt", "r")  # 手动打开
content = file.read()  
file.close()  # 手动关闭
```

但是这样写有个问题，如果代码在读取文件内容或关闭文件时出现异常，文件可能不会被正确关闭。这时，你就可以请出 with…as… 语句来帮忙：

```python
with open("example.txt", "r") as file:  
    content = file.read()  
    # 在这里你可以放心地使用file，不必担心忘记关闭它
```

这样，无论在 `with` 块中的代码是否出现异常，文件都会在退出块时被自动关闭，你就不必再担心忘记关闭文件了。with…as…语句，在Python中叫做：上下文管理器，它在 Python 中实现了自动分配并释放资源。with…as 语句是简化版的 try…except…finally语句。

#### try…except 语句

```python
a = 1 / 0
print(a)
# ZeroDivisionError: division by zero
```

如果你想避免这个错误，你可以使用 `try`和 `except`语句来捕获这个异常：

```python
# 声明变量a，并赋值为1除以0，这会导致ZeroDivisionError  
a = 1 / 0  
  
# 尝试执行接下来的代码块，如果发生异常，则执行except块  
try:  
    # 打印变量a的值，因为a = 1 / 0，所以这里会引发ZeroDivisionError  
    print(a)  
  
# 如果try块中的代码引发ZeroDivisionError异常，则执行此except块  
except ZeroDivisionError:  
    # 当除以零时，打印一个错误消息  
    print("Division by zero is not allowed!")
```

##### **try…except 的标准格式**

```python
try:
    # normal block
except A:
    # exc A block
except:
    # exc other block
else:
    # noError block 

```

##### **try…finallly 语句**

```python
try:  
    execution block  # 正常执行模块  
except A:  
    exc A block # 发生A错误时执行  
except B:  
    exc B block # 发生B错误时执行  
except:  
    other block # 发生除了A,B错误以外的其他错误时执行  
else:  
    if no exception, jump to here # 没有错误时执行  
finally:  
    final block  # 总是执行  

```
