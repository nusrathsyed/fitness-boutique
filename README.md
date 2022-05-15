# fitness-boutique

# Getting Started
Instructions for running the application from GitHub: 

1. Install Docker on your Desktop if you don't have it already https://www.docker.com/get-started/
2. Clone this repository
3. Open docker-compose.yaml file and click run, it should creates MongoDB and Mongo Express once it is done you can see it uses the command
 ```docker compose -f docker-compose.yaml up -d```
 OPTIONAL: You can also navigate to your terminal or shell and type ```docker compose -f docker-compose.yaml up -d``` or ```docker compose up -d```
4. Next, run the application using `./mvnw spring-boot:run` or through your IDE
5. Open your local browser to visualize the MongoDB Database using Mongo Express, accessing the application via the Docker service http://localhost:8081 



### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.7/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.7/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#boot-features-mongodb)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

