# Weather service

This project describes on how to integrate SpringBoot and Redis as cache implementation

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites

What things you need to install the software and how to install them

```
Java 8
Maven 3
Redis
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Spring](http://www.http://spring.io) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Redis](https://redis.io/) - Redis

## Authors

* **Tapaswini Mohanty** - *Initial work* - [github](https://github.com/tapaswinimohanty

steps to start app
===================
1.start redis server in port 6379 in localhost.if you are starting in a diffrent port and ip,please give these details in application.properties
2.check mvn path 
3.java version(should be java8)
4.Run mvn clean install
5.In eclipse Project Explorer, right click the project name -> select "Run As" -> "Maven Build..."
In the goals, enter spring-boot:run then click Run button.