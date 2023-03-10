# Etisalat_BE

Etisalat [Spring Boot](http://projects.spring.io/spring-boot/) phone validator app.

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

At first, let's run 
```shell
mvn clean install 
```
this will start installing the needed dependencies, index the project & clean it

Then there are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.etisalat.EtisalatProgrammingExerciseApplication.java` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
## Running tests
```shell
mvn test
```

## Building the container
First lets package our app and create an executable jar
```shell
mvn clean package
```
then run docker commands as follows
```shell
docker build --tag=etisalat-be:latest
```
```shell
docker run -p8080:8080 --tag=etisalat-be:latest
```
