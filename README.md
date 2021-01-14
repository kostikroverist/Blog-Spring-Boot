#Blog Spring-Boot
##Guidelines
Run the blog application


- Clone this repository
```
git clone https://github.com/kostikroverist/Blog-Spring-Boot.git
```


- Go to release directory and enter mvn spring-boot:run
```
cd Blog-Spring-Boot
```
and
```
mvn spring-boot:run
```
##Postman
- First  url POST http://localhost:8080/authenticate  
in this url we must login user and paste in the body.raw.json
 ```
 {
         "userName":"Kostya",
         "password":"123"
 }
 ```

 - After that we have some token 
 
 and we go to the Headers write in "key": "Authorization" in the "value" : "Bearer someToken " 
 
 example:
```
 key: Authorization
 value : "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJLb3N0eWEiLCJleHAiOjE2MTA2NzQ5MjQsImlhdCI6MTYxMDYzODkyNH0.TFGbpp4_8tBcnkU7sA_4CLzToA3y7a3Ce4tEbfhvOjU " 
 ```
and with this key and value we must make request 
- Other url:

"Get all Users in which age is greater than some value"

http://localhost:8080/users/user/ (_write age_) 

"Get all Users from Articles in which color has some specific value from enum"

http://localhost:8080/users/findColor/blue

"Get unique names from Users that have more than 3 Articles"

http://localhost:8080/users/findMoreArticles

"save User and Article" 

http://localhost:8080/users/saveUser
 
 if you want save  you  must write in body.raw.json
 
 example:

```
 {
         "name": "Kostya0",
         "age": 20,
         "articles": [
             {
                 "text": "Article 0",
                 "color": "BLUE"
             }
         ]
  }
 ```
