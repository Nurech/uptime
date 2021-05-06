#COSMOS ODYSSEY

## How to use
```
1. gh repo clone Nurech/uptime
2. opn cmd and cd into project root, do "mvn clean install" (make sure to have Maven installed first)
3. Maven will do all the work, builds the front and the back
4. In project root do "java -jar backend/target/backend-1.0.0-SNAPSHOT.jar", to run backend server (keep server running)
5. Open new cmd and cd into uptime/frontend and do "npm run serve" to run frontend
6. Go to: http://localhost:5000/
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

### db structure
```
db
├── id, validUntil
├── [legs]
│     └─ id, routeInfo
│          └─ id, from, name
│           └─ id, to, name
│               └─ [providers]
│                   └─ id, company
│                       └─ id, name
│                           └─ price, flightStart, flightEnd

```


### what I did
```
1. New Maven project
2. Create Maven project module "frontend", "npm install vue", "vue create ."
3. Create Spring Boot module "backend", add Sring Web and PostgreSQL
4. Add liquibase IOT test-drop-rebuild
5. Use https://jsonlint.com/, to validate JSON https://cosmos-odyssey.azurewebsites.net/api/v1.0/TravelPrices, analyze paylod
6. Use https://sqlizer.io/#/ to consume API JSON into initial table
7. Looks like 14 routes, make liquibase schema
8. Create deployment enviorment on AWS Elastic Beanstalk
9. Create database-2 Postgres on AWS RDS
10. Download JSON from API to string, upload and use use SQLizer API to get SQL dialect
11. Use SQL dialect to keep db updated, setup scheduler to check for updates
12. Add use hibernate repository-service-controller models frontend->backend->db




```