```toml
name = 'GetAll'
method = 'GET'
url = 'http://localhost:8080/v3/polls'
sortWeight = 1000000
id = 'd90210ca-c697-479c-9e35-1f2f022d4641'

[[queryParams]]
key = 'page'
value = '0'
disabled = true

[[queryParams]]
key = 'size'
value = '2'
disabled = true

[[queryParams]]
key = 'sort'
value = 'question,asc'
disabled = true

[[queryParams]]
key = 'sort'
value = 'id,desc'
disabled = true

[[queryParams]]
key = 'sort'
value = 'question'
disabled = true

[auth]
type = 'BASIC'
```
