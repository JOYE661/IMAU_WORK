import re
from playwright.sync_api import Playwright, sync_playwright, expect


def run(playwright: Playwright) -> None:
    browser = playwright.chromium.launch(headless=False)
    context = browser.new_context()
    page = context.new_page()
    page.goto("https://air.1688.com/app/1688-global/main-site-channel/inner-rank.html?spm=a260k.home2024.leftmenu_EXPEND.dzhanneishangji0of0kuajing.663335e4jLVMS8")
    page.get_by_text("马来西亚").click()
    page.get_by_text("更多类目").first.click()
    page.locator("div:nth-child(16)").click()
    page.locator("div:nth-child(16)").first.click()
    with page.expect_popup() as page1_info:
        page.get_by_role("listitem").filter(has_text="01").get_by_role("button").first.click()
    page1 = page1_info.value
    page1.get_by_text("揭阳市揭东区新亨镇泽斯服装店（个体工商户）2年综合服务评价上身效果棒哒 725购买推荐 581穿上刚好 393服务态度超好").click()
    page1.get_by_text("揭阳市揭东区新亨镇泽斯服装店（个体工商户）2年综合服务评价上身效果棒哒 725购买推荐 581穿上刚好 393服务态度超好").click()
    page1.locator("div:nth-child(2) > div > div > div:nth-child(2)").first.click()
    with page1.expect_popup() as page2_info:
        page1.get_by_title("揭阳市揭东区新亨镇泽斯服装店（个体工商户）").click()
    page2 = page2_info.value
    page2.close()
    page1.close()
    page.close()

    # ---------------------
    context.close()
    browser.close()


with sync_playwright() as playwright:
    run(playwright)
