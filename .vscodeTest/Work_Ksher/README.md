# 1688 爬虫

爬虫框架采用最新的功能最强大的微软21年开源的自动化测试与爬虫框架，playwright。感谢微软

最好用Python3.9以上

install chromium 就可以，默认安装chromium，firfox，edga，webkit

pip install playwright

playwright install chromium

# 方式一：全装，会在当前 python 版本中

$ python -m playwright install

# 方式二：只安装 chromium，会在当前 python 版本中

$ python -m playwright install chromium

# 方式三：只安装 chromium，只会在当前项目中

按需安装，重新安装一下（chromium 是其中一个浏览器插件，看自己用什么就装什么） # Expecting one of: chromium, chrome, chrome-beta, msedge, msedge-beta, msedge-dev, firefox, webkit

PLAYWRIGHT_BROWSERS_PATH=0 是为了支持 pyinstaller 打包报错 Please run the following command to download new browsers 问题

PLAYWRIGHT_BROWSERS_PATH=0 会让浏览器安装在项目本地的 `.playwright` 目录中，而不会使用全局的 Playwright 浏览器安装目录。

$ PLAYWRIGHT_BROWSERS_PATH=0 python -m playwright install chromium

通过《方式三》安装后，需要指定一下浏览器插件路径，要不然会报错，可以通过卸载获得安装路径，在重新安装一遍就行。

$ PLAYWRIGHT_BROWSERS_PATH=0 python -m playwright uninstall chromium

作者：卡尔特斯
链接：https://juejin.cn/post/7167303115984044040
来源：稀土掘金
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
