```toml
name = 'Create Poll (message not readable)'
method = 'POST'
url = 'http://localhost:8080/v2/polls'
sortWeight = 2000000
id = 'c78557ce-aa97-499e-8ccd-1557de7974ed'

[body]
type = 'JSON'
raw = '''
{
  "options": [
    {"value": "New England Patriots"},
    {"value": "New England Patriots"}
    {"value": "New England Patriots"}
  ]
}'''
```
