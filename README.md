# springboot-meetup
Code du meetup dédié à Spring Boot (6 octobre 2016)


Branches
--------

- master => Code JPA
- mongo => Code MongoDB


Spring Profiles
---------------

- Par defaut : HSQLDB et Embedded Mongo 
- PROD : MySQL et Mongo

Redis
-----

Modifiez le fichier application-PROD.properties si vous disposez d'une instance Redis

Start
-----

mvn clean install

mvn spring-boot:run

target/meetup-0.0.1-SNAPSHOT.war 

java -jar target/meetup-0.0.1-SNAPSHOT.war

java -jar -Dspring.profiles.active=PROD target/meetup-0.0.1-SNAPSHOT.war


URLs de test
------------

- http://localhost:8080/welcome
- http://localhost:8080/accounts?page=0&size=10
- http://localhost:8080/browser/index.html
- http://localhost:8080/swagger-ui.html
- http://localhost:8080/manage/
- http://localhost:8080/manage/metrics
- http://localhost:8080/manage/logfile

Comptes
-------

- user@gmail.com  : 123soleil (ROLE_USER)
- admin@gmail.com : 123soleil (ROLE_ADMIN)
