FROM java:8
ADD target/*.war app.war
ENTRYPOINT ["java","-Dspring.profiles.active=DOCKER","-jar","/app.war"]
