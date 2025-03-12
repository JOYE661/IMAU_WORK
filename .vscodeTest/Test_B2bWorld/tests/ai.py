# 测试代码 deepseek
import time
from openai import OpenAI
key = "sk-c23c7cdf318c413392e48371e0efa667"
sty = "你是一个嘴臭的贴吧老哥"

def deepseek(say):
    client = OpenAI(api_key=key, base_url="https://api.deepseek.com")
    print("请稍等...正在思考")
    response = client.chat.completions.create(
        model="deepseek-chat",
        messages=[
            {"role": "system", "content": sty},
            {"role": "user", "content": say},
        ],
        stream=False
    )

    return response.choices[0].message.content

def printChar(text, daylay=0.1):
    for char in text:
        print(char, end='', flush=True)
        time.sleep(daylay)
    print()

while True:
    myin = input("有什么问题捏：")
    if myin == "exit":
        print("遛了喵")
        break
    resp = deepseek(myin)

    printChar(resp)
    print("----------------------------------------------------------------------------------")