```toml
name = 'Create Poll'
method = 'POST'
url = 'http://localhost:8080/v2/polls'
sortWeight = 2000000
id = '7c5a9360-87ae-4617-9ec8-8cdb20697e87'

[body]
type = 'JSON'
raw = '''
{
  "question": "Who will win SuperBowl this year?",
  "options": [
    {"value": "New England Patriots"},
    {"value": "Seattle Seahawks"},
    {"value": "Green Bay Packers"},
    {"value": "Denver Broncos"}
  ]
}'''
```
