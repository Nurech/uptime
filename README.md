#COSMOS ODYSSEY

Assignment: https://smallpdf.com/result#r=106d0db12b1fdcb0e563bafc6b42d56d&t=share-document

![](images/img_1.png)

Deployed: http://cosmos-env1.eba-d4k5v2eu.us-east-2.elasticbeanstalk.com/

![](images/img_2.png)


## How to use
```
1. gh repo clone Nurech/uptime
2. opn cmd and cd into root, do "mvn clean install"
3. Maven will do all the work, builds the front and the back
4. In project root do "java -jar backend/target/backend-1.0.0-SNAPSHOT.jar", to run backend server (keep server running)
5. Open new cmd and cd into uptime/frontend and do "npm run serve" to run frontend
6. Go to: http://localhost:8080/
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

![](images/img_3.png)

### what I did
```
1. New Maven project
2. Create Maven project module "frontend", "npm install vue", "vue create ."
3. Create Spring Boot module "backend", add dependencies as we go (it's quite bloated)
4. Add liquibase IOT test-drop-rebuild
5. Use https://jsonlint.com/, to validate JSON and analyze paylod
6. Use https://sqlizer.io/ to consume API JSON into initial table
7. Looks like 14 routes, make liquibase schema
8. Create deployment environment on AWS Elastic Beanstalk, set roles, ports and permissions
9. Create database-2 Postgres on AWS RDS
10. Download JSON from API as String 
    https://www.codejava.net/java-se/networking/use-httpurlconnection-to-download-file-from-an-http-url
11. Use Jackson @JSON annotations to deserialize, https://www.jsonschema2pojo.org/
12. Persist JSON data to db
13. Read how long data is valid with @Scheduled fetch new data after refresh using Spring @Scheduled
14. Add use hibernate repository-service-controller models frontend->backend->db
15. Scratch Vue3 frontend, switch back to Vue2 (node issues and Typescript...)
16. Add vuetify frontend to display data, some broilerplate included 
17. Add components, entity, dao and service logic for bookings
18. Add user_bookings table, show last 10 bookings, check if they are in valid 15 price list
```

```
Problems to understand here:
1. API JSON gets pulled as string and needs to be desirialized
2. Setting up @Scheduled to keep data fresh
3. Inserting deconstructred JSON data into db
4. Setting up frontend and backend communication
5. Selecting appropiate user UI for data interaction
6. Use Security (data transfrer with apropiate DTO's) since were also taking user input (bookings)
```
