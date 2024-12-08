```toml
name = 'Create Vote'
method = 'POST'
url = 'http://localhost:8080/v1/polls/1/votes'
sortWeight = 1000000
id = '7fa08699-965b-4b25-9a13-1e2f5fc7bb42'

[body]
type = 'JSON'
raw = '''
{
  "option": {
    "id": 1,
    "value": "New England Patriors"
  }
}'''
```
