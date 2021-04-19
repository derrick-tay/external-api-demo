# External API Demo
This is a demo of external API calling to https://jsonplaceholder.typicode.com/posts by using Java SpringBoot framework

## Getting Started
To sync maven project to ensure all the dependencies is downloaded and running.
This SpringBoot Application is running with Java SDK ver 1.8.

In order to run Springboot Application, Open up ExternalApiDemoApplication to run the project.
Once the application started, by default it will running in your localhost port 8080 (http://localhost:8080).

## Endpoint Listing
There will be 3 endpoints

```
GET api/posts/v1/inquiry/list
```
This endpoint is to retrieve the full listing from external API endpoint.

Example : 
* [URL] - http://localhost:8080/api/posts/v1/inquiry/list
```
GET api/posts/v1/inquiry/userlist/{userId}
```
This endpoint is to retrieve user's post listing from external API endpoint, so it will require input userId in endpoint path variable

Example :
* [URL] - http://localhost:8080/api/posts/v1/inquiry/userlist/1

```
POST api/posts/v1/search/posts
```
This endpoint is to retrieve user's specific post from external API endpoint, so it will have request payload of two specific fields to make the calling workable.

Example : 
* [URL] - http://localhost:8080/api/posts/v1/search/posts
* [Request Payload] - 
{
    "userId": 1,
    "id": 1
}

## Acknowledgement
Java Library used
* [Project Lombok] - For easy getter and setter for model classes, version 1.18
* [hibernate-validator] - Request payload field validation, version 6
