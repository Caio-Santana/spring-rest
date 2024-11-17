```toml
name = 'Create Poll'
method = 'POST'
url = 'http://localhost:8080/polls'
sortWeight = 1000000
id = 'b42e6142-aea5-4cd0-b588-355b2b2dea6d'

[body]
type = 'JSON'
raw = '''
{
  "options": [
    {"value": "New England Patriots"},
  ]
}'''
```
