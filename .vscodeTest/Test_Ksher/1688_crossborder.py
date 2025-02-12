# -*- coding:utf-8 -*-
# 1688 爬虫
# 爬虫框架采用最新的功能最强大的微软21年开源的自动化测试与爬虫框架，playwright。感谢微软
# 最好用Python3.9以上
# install chromium 就可以，默认安装chromium，firfox，edga，webkit
#pip install playwright
            
#playwright install chromium
import traceback
import logging

from playwright.sync_api import sync_playwright
import re
import json
import random
import time

log = logging.getLogger()
# 设置日志级别为DEBUG，这样可以输出所有级别的日志（DEBUG、INFO、WARNING、ERROR、CRITICAL）
log.setLevel(logging.DEBUG)

# 创建一个StreamHandler，用于将日志输出到控制台（标准输出）
ch = logging.StreamHandler()

# 设置处理程序的日志级别
ch.setLevel(logging.DEBUG)

# 创建一个格式化器，用于定义日志的输出格式
# formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')

# 将格式化器添加到处理程序
# ch.setFormatter(formatter)

# 将处理程序添加到日志记录器
log.addHandler(ch)


user_agents = [
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.107 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.63 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.125 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.54 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36",
    "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/82.0.4085.122 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36",
    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.54 Safari/537.36",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/605.1.15",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/605.1.15",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/605.1.15",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/605.1.15 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/605.1.15",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/605.1.15",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/605.1.15 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/605.1.15",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/605.1.15 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/605.1.15",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/82.0.4085.128 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.125 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36",
    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.90 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.107 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.110 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/605.1.15 (KHTML, like Gecko) Chrome/82.0.4085.128 Safari/605.1.15",
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/605.1.15",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36",
]



def get_contactinfo(data_item, popup_contactinfo):
    temp_item = popup_contactinfo.locator(".module-wrapper").get_by_text(re.compile("女士|先生"))
    if len(temp_item.all()) > 0:
        data_item["联系人"] = temp_item.nth(0).inner_text()
    # 公司名称
    temp_item = popup_contactinfo.locator(".module-wrapper").get_by_text("联系方式")
    if len(temp_item.all()) > 0:
        data_item["公司名称"] = temp_item.nth(0).locator("+div").inner_text()
    temp_item = popup_contactinfo.locator(".module-wrapper").get_by_text("手机")
    if len(temp_item.all()) > 0:
        data_item["手机"] = temp_item.nth(0).locator("+div").inner_text()
    temp_item = popup_contactinfo.locator(".module-wrapper").get_by_text("电话")
    if len(temp_item.all()) > 0:
        data_item["电话"] = temp_item.nth(0).locator("+div").inner_text()
    temp_item = popup_contactinfo.locator(".module-wrapper").get_by_text("传真")
    if len(temp_item.all()) > 0:
        data_item["传真"] = temp_item.nth(0).locator("+div").inner_text()
    # 实际经验地址
    temp_item = popup_contactinfo.locator(".module-wrapper").get_by_text("地址")
    if len(temp_item.all()) > 0:
        data_item["实际经验地址"] = temp_item.nth(0).locator("+div").inner_text()
    # 底部地址（注册地址）
    temp_item = popup_contactinfo.locator("span").get_by_text("地址：")
    if len(temp_item.all()) > 0:
        data_item["底部地址（注册地址）"] = temp_item.nth(0).inner_text()
    # 店铺名称
    temp_item = popup_contactinfo.locator("span").get_by_text("地址：")
    if len(temp_item.all()) > 0:
        data_item["店铺名称"] = temp_item.nth(0).locator(
            "xpath=preceding-sibling::span[1]").inner_text()
    # 评价
    temp_item = popup_contactinfo.get_by_text("评价")
    if len(temp_item.all()) > 0:
        data_item["评价"] = temp_item.nth(0).locator('xpath=..').text_content()[2:]
    log.info(popup_contactinfo.locator(".module-wrapper").text_content())

def run_1688(type_name, start, count, interval=10000, headless=False):
    result_data = []
    all_fail_urls = []
    custom_user_agent = random.choice(user_agents)
    log.info(f"当前UA：{custom_user_agent}")                         
    with sync_playwright() as p:                                        #———————— 启动Playwright，赋值为p  //该对象会在进入 with 代码块时启动 Playwright，并在退出 with 代码块时自动关闭 Playwright。
            browser_type = p.chromium                                   #———————— 启动浏览器
            browser = browser_type.launch(headless=headless)        
            context = browser.new_context(user_agent=custom_user_agent) #———————— 模拟真实用户创建浏览器上下文
            page = context.new_page()                                   #———————— 创建浏览器页面
            #page.route("**/*.{png,jpg,jpeg}", lambda route: route.abort())
            page.goto('https://air.1688.com/app/1688-global/main-site-channel/inner-rank.html?spm=a260k.home2024.leftmenu_EXPEND.dzhanneishangji0of0kuajing.663335e4jLVMS8', wait_until="load")
            page.wait_for_load_state('domcontentloaded')
            page.wait_for_timeout(2000)

            yield page                                                   #———————— yield 暂停一级页面等待回调  //将当前页面对象返回给调用者，并暂停函数执行，保持状态以便后续继续执行。

            page.goto(
                'https://air.1688.com/app/1688-global/main-site-channel/inner-rank.html?spm=a260k.home2024.leftmenu_EXPEND.dzhanneishangji0of0kuajing.663335e4jLVMS8',
                wait_until="load")
            page.wait_for_load_state('domcontentloaded')
            page.wait_for_timeout(3000)
            page.get_by_text(type_name).click()                         #————————点击type_name:马来西亚?
            page.wait_for_load_state('domcontentloaded')
            page.wait_for_timeout(3000)
            listitem = page.get_by_role("listitem").filter(has_text="商品详情").all()
            last_count = start + count                                  #————————page.get_by_role("listitem")//使用 Playwright 的 get_by_role 方法查找页面中所有具有 listitem 角色（role）的元素
            current_count = len(listitem)                               #————————.filter(has_text="商品详情") //过滤出所有包含 "商品详情" 文本的元素
            log.info(current_count)                                     #————————last_count 计算出的结束索引位置，即从 start 开始往后数 count 个商品项后的索引位置。
            has_end= 0                                                  #————————current_count 计算出的当前索引位置，即当前已遍历的元素数量。


            def new_page_listener(detail_page):
                nonlocal has_end
                max_retries = 3  # 最大重试次数
                retry_delay = 2000  # 重试延迟（秒）
                fail_url = ""
                #detail_page.route("**/*.{png,jpg,jpeg}", lambda route: route.abort())
                if detail_page.url.startswith("https://detail.1688.com/"):
                    has_end = has_end + 1
                    log.info(f'新页面被创建:{detail_page.url}')
                    data_item = {"url": detail_page.url}
                    try:
                        for attempt in range(max_retries):
                            try:
                                first_contact_url = ""
                                detail_page.wait_for_load_state('domcontentloaded')
                                log.info("成功加载页面！")
                                detail_page.wait_for_timeout(random.randint(4, 10)*1000)
                                img_close = detail_page.locator(
                                    'img[src="https://gw.alicdn.com/tfs/TB1QZN.CYj1gK0jSZFuXXcrHpXa-200-200.png"]')
                                if len(img_close.all()) > 0:
                                    img_close.wait_for(state='visible')
                                    img_close.click()
                                    log.info("点击弹出窗口的关闭按钮")

                                # frame = detail_page.frame(url=r'.*ogin.taobao.com.*')
                                # if frame:
                                #     log.info(frame.all())
                                # iframe_locator = detail_page.locator('iframe')
                                # # 获取 iframe 的 frame 对象
                                # for iframe_element in iframe_locator.all():  # 获取第一个 iframe
                                #     frame = iframe_element.content_frame
                                #     if frame:
                                #         # 在 iframe 中查找关闭按钮
                                #         img_close = detail_page.locator(
                                #             'img[src="https://gw.alicdn.com/tfs/TB1QZN.CYj1gK0jSZFuXXcrHpXa-200-200.png"]')
                                #         if len(img_close.all()) > 0 :
                                #             img_close.wait_for(state='visible')
                                #             img_close.click()
                                #             log.info("点击弹出窗口的关闭按钮")
                                detail_page.wait_for_timeout(1000)

                                # if len(detail_page.get_by_text("通过验证以确保正常访问").all()) > 0:
                                #     log.info("详情页弹出人机识别可以叉掉")
                                #     img_close = detail_page.locator(
                                #         'img[src="https://gw.alicdn.com/tfs/TB1QZN.CYj1gK0jSZFuXXcrHpXa-200-200.png"]')
                                #     img_close.click()
                                #     detail_page.wait_for_timeout(1000)
                                # if len(detail_page.get_by_text("密码登录").all()) > 0 and len(
                                #         detail_page.get_by_text("短信登录").all()) > 0:
                                #     log.info("详情页登录可以叉掉")
                                #     img_close = detail_page.locator(
                                #         'img[src="https://gw.alicdn.com/tfs/TB1QZN.CYj1gK0jSZFuXXcrHpXa-200-200.png"]')
                                #     img_close.click()
                                #     detail_page.wait_for_timeout(1000)

                                # 开始采集联系方式
                                with detail_page.expect_popup() as popup_info:
                                    detail_page.get_by_text("联系方式").click()
                                popup_contactinfo = popup_info.value
                                log.info("点击联系方式！")
                                first_contact_url = popup_contactinfo.url
                                if first_contact_url.startswith("https://login.taobao.com/?redirect_url"):
                                    popup_contactinfo.close()
                                    raise Exception("跳到大登录页面，需要重试")

                                break  # 成功后退出循环
                            except Exception as e:
                                log.info(f"第 {attempt + 1} 次尝试加载页面并点击联系方式失败：{e}")
                                if attempt < max_retries - 1:
                                    log.info("重新加载页面并重试...")
                                    detail_page.reload()  # 重新加载页面
                                    detail_page.wait_for_timeout(retry_delay)
                                else:
                                    log.info("所有重试都失败")
                                    raise e



                        try:
                            log.info(f"联系方式页面：{popup_contactinfo.url}")
                            for attempt in range(max_retries):
                                try:
                                    popup_contactinfo.wait_for_load_state("domcontentloaded")
                                    break  # 成功后退出循环
                                except Exception as e:
                                    log.info(f"第 {attempt + 1} 次尝试加载联系方式页面失败：{e}")
                                    if attempt < max_retries - 1:
                                        log.info("重新加载页面并重试...")
                                        popup_contactinfo.reload()  # 重新加载页面
                                        popup_contactinfo.wait_for_timeout(retry_delay)
                                    else:
                                        log.info("所有重试都失败")
                                        raise e



                            popup_contactinfo.wait_for_timeout(1000)

                            try:
                                popup_contactinfo.wait_for_selector('.module-wrapper', state='attached', timeout=5000)
                            except Exception as e:
                                # 通过验证以确保正常访问
                                if len(popup_contactinfo.get_by_text("通过验证以确保正常访问").all()) > 0:
                                    fail_url = first_contact_url
                                    log.info(f"联系方式页面被人机识别拦截尝试反爬, {popup_contactinfo.url}：{e}")
                                if popup_contactinfo.url.startswith("https://login.taobao.com/?redirect_url"):
                                    fail_url = first_contact_url
                                    log.info(f"联系方式页面被强制调整大登录页面")
                                raise e

                            get_contactinfo(data_item, popup_contactinfo)

                        except Exception as e:
                            log.info(f"{e}, {traceback.format_exc()}")
                        finally:
                            popup_contactinfo.close()

                        detail_page.wait_for_timeout(random.randint(4, 10)*1000)
                        #开始采集工厂档案
                        if len(detail_page.get_by_text("工厂档案").all()) > 0:
                            for attempt in range(max_retries):
                                try:
                                    with detail_page.expect_popup() as popup_info:
                                        detail_page.get_by_text("工厂档案").click()
                                    popup_sale = popup_info.value
                                    break
                                except Exception as e:
                                    log.info(f"第 {attempt + 1} 次尝试点击工厂档案失败：{e}")
                                    if attempt < max_retries - 1:
                                        detail_page.wait_for_timeout(retry_delay)
                                    else:
                                        log.info("所有重试都失败")
                                        raise e

                            try:

                                log.info(f"工厂档案页面加载：{popup_sale.url}")
                                for attempt in range(max_retries):
                                    try:
                                        popup_sale.wait_for_load_state("domcontentloaded")
                                        break  # 成功后退出循环
                                    except Exception as e:
                                        log.info(f"第 {attempt + 1} 次尝试加载工厂档案页面失败：{e}")
                                        if attempt < max_retries - 1:
                                            log.info("重新加载页面并重试...")
                                            popup_sale.reload()  # 重新加载页面
                                            popup_sale.wait_for_timeout(retry_delay)
                                        else:
                                            log.info("所有重试都失败")
                                            raise e
                                popup_sale.wait_for_timeout(1000)
                                # 成立时间
                                temp_item = popup_sale.locator(".container").get_by_text("成立时间")
                                if len(temp_item.all()) > 0:
                                    data_item["成立时间"] =temp_item.nth(0).locator("+span").inner_text()
                                # 年交易额
                                temp_item = popup_sale.locator(".container").get_by_text("年交易额")
                                if len(temp_item.all()) > 0:
                                    data_item["年交易额"] = temp_item.nth(0).locator("+span").inner_text()
                                # 工厂面积
                                temp_item = popup_sale.locator(".container").get_by_text("工厂面积")
                                if len(temp_item.all()) > 0:
                                    data_item["工厂面积"] = temp_item.nth(0).locator("+span").inner_text()
                                # 员工总数
                                temp_item = popup_sale.locator(".container").get_by_text("员工总数")
                                if len(temp_item.all()) > 0:
                                    data_item["员工总数"] = temp_item.nth(0).locator("+span").inner_text()
                                # 商标/品牌
                                temp_item = popup_sale.locator(".container").get_by_text("商标/品牌")
                                if len(temp_item.all()) > 0:
                                    data_item["商标/品牌"] = temp_item.nth(0).locator("+div").text_content()
                                # 接外贸订单
                                temp_item = popup_sale.get_by_text("接外贸订单")
                                if len(temp_item.all()) > 0:
                                    data_item["接外贸订单"] = temp_item.nth(0).locator("+span").inner_text()
                                # 工厂展厅
                                temp_item = popup_sale.get_by_text("工厂展厅")
                                if len(temp_item.all()) > 0:
                                    data_item["工厂展厅"] = temp_item.nth(0).locator("+div").text_content()
                                # 主营业务
                                data_item["主营业务"] = popup_sale.get_by_text("主营").nth(0).locator('xpath=..').text_content()
                                # 入住年份
                                data_item["入住年份"] = popup_sale.locator("div").get_by_text("主营").nth(0).locator('xpath=..').locator(
                                    "xpath=preceding-sibling::div[1]").text_content()

                            except Exception as e:
                                log.info(f"{e}, {traceback.format_exc()}")
                            finally:
                                popup_sale.close()


                    except Exception as e:
                        log.info(f"{e}, {traceback.format_exc()}")
                    finally:
                        detail_page.close()

                    result_data.append(data_item)
                    index = len(result_data) - 1
                    if fail_url:
                        all_fail_urls.append({"index": index, "url": fail_url})

                    has_end = has_end - 1
                    log.info(f'页面被关闭:{detail_page.url}')



            context.on('page', new_page_listener)

            # curr_item = listitem[3]
            # curr_item.wait_for()
            # btn = curr_item.get_by_role("button").filter(has_text="商品详情")
            # btn.click()


            while current_count < last_count:
                lastitem = listitem[-9]
                lastitem.wait_for()
                lastitem.scroll_into_view_if_needed()
                page.wait_for_timeout(3000)
                listitem = page.get_by_role("listitem").filter(has_text="商品详情").all()
                current_count = len(listitem)
                log.info(current_count)

            page.wait_for_timeout(1000)

            for i in range(start, last_count):
                curr_item = listitem[i]
                curr_item.wait_for()
                curr_item.scroll_into_view_if_needed()
                log.info(f"第：{i}行数据开始点击")
                curr_item.get_by_role("button").filter(has_text="商品详情").click()
                log.info(f"第：{i}行数据点击点击完毕")
                #验证在我电脑5s成功率100%，太快了，并发太多，会网络失败
                page.wait_for_timeout(interval)
            page.wait_for_timeout(5000)
            while has_end != 0:
                page.wait_for_timeout(3000)
            page.wait_for_timeout(1000)
            #page.screenshot(path=f'example-{browser_type.name}.png')
            context.close()
            browser.close()
    log.info(f"被人机识别反爬而失败的联系人共{len(all_fail_urls)}个")
    if len(all_fail_urls) > 0 and False:
        log.info(f"开始重试！")

        max_retries = 3  # 最大重试次数
        retry_delay = 2000  # 重试延迟（秒）
        for fail in all_fail_urls:
            for attempt in range(max_retries):
                try:
                    with sync_playwright() as p:
                        custom_user_agent = random.choice(user_agents)
                        log.info(f"重试的UA：{custom_user_agent}")
                        # https://shop6979x86k59909.1688.com/page/contactinfo.htm
                        url = re.compile(r'^(.*?)\?').search(fail["url"]).group(1)
                        browser_type = p.chromium
                        browser = browser_type.launch(headless=False)
                        context_temp = browser.new_context(user_agent=custom_user_agent)
                        page_temp = context_temp.new_page()
                        # page.route("**/*.{png,jpg,jpeg}", lambda route: route.abort())
                        page_temp.goto(
                            url,
                            wait_until="load")
                        page_temp.wait_for_load_state('networkidle')
                        page_temp.wait_for_timeout(1000)

                        page_temp.wait_for_selector('.module-wrapper', state='visible', timeout=5000)

                        get_contactinfo(result_data[fail["index"]], page_temp)
                        page_temp.wait_for_timeout(3000)
                        context_tmp = context.close()
                        browser.close()
                    break  # 成功后退出循环
                except Exception as e:
                    log.info(f"第 {attempt + 1} 次尝试重新爬被人机识别的联系人页面{fail['url']}失败：{e}")
                    if attempt < max_retries - 1:
                        pass
                    else:
                        log.info("所有重试都失败")
                        #raise e

    yield result_data

if __name__ == "__main__":
    run_exec = run_1688(type_name="马来西亚" , start=0, count=30, interval=10*1000, headless=False)
    page = next(run_exec)
    page.wait_for_timeout(2*1000)
    ret_data = next(run_exec)
    run_exec = None
    log.info(f"爬虫结果为： {json.dumps(ret_data, ensure_ascii=False) }")