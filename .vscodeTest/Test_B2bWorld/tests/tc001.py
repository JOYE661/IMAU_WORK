#测试代码
import  requests,pprint
import time
payload = {
    'username': 'byhy',
    'password': '88888888'
}

response = requests.post('http://localhost/api/mgr/signin',data=payload)

pprint.pprint(response.json())

time.sleep(1)

paydate = {
    'username': 'joye',
    'password': '64646464'
}

response = requests.post('http://localhost/api/mgr/signin',data=paydate)

pprint.pprint(response.json())



