```toml
name = 'Update Poll'
method = 'PUT'
url = 'http://localhost:8080/polls/1'
sortWeight = 5000000
id = '731c22cc-7081-4405-94d4-e8c3b186be49'

[body]
type = 'JSON'
raw = '''
{
  "id": 1,
  "question": "Who will lose SuperBowl this year?",
  "options": [
    {
      "id": 1,
      "value": "Seattle Seahawks"
    },
    {
      "id": 2,
      "value": "Green Bay Packers"
    },
    {
      "id": 3,
      "value": "Denver Broncos"
    },
    {
      "id": 4,
      "value": "New England Patriots"
    },
    {
      "id": 5,
      "value": "None"
    }
  ]
}'''
```
