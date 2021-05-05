#COSMOS ODYSSEY

## How to use
```
1. gh repo clone Nurech/uptime
2. opn cmd cd into uptime/, do mvn clean install (make sure to have Maven installed first)
2. Maven will do "npm install", and builds frontend. When building backend 
```

### project structure
```
uptime (Maven project)
├─┬ backend (Spring Boot)
│ ├── src
│ └── pom.xml
├─┬ frontend (Vue3.js)
│ ├── src
│ └── pom.xml
└── pom.xml (parent POM managing both modules)
```

### project structure
```
db
├─┬ id
│ ├─ validUntil
```


### what I did
```
1. New Maven project
2. Create Maven project module "frontend", "npm install vue", "vue create ."
3. Create Spring Boot module "backend", add Sring Web and PostgreSQL
4. Add liquibase IOT test-drop-rebuild
5. Use https://jsonlint.com/, to validate JSON https://cosmos-odyssey.azurewebsites.net/api/v1.0/TravelPrices, analyze paylod
6. Use https://sqlizer.io/#/ to consume API JSON into initial table to test with, create liquibase schema accordingly


```