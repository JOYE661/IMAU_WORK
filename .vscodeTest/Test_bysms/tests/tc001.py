#测试代码
import  requests,pprint

payload = {
    'username': 'byhy',
    'password': '88888888'
}

response = requests.post('http://localhost/api/mgr/signin/',
              data=payload)

pprint.pprint(response.json())