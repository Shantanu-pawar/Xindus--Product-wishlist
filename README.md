
# Xindus product-wishlist

## Features

```
User Authentication         :   Secure user login and signup with Spring Security.
Wishlist API                :   Manage wishlists via RESTful endpoints (/add, /get, /delete).
Authentication Required     :   Only logged-in users can access wishlists and he can manage the WishList items.
Spring Data JPA Integration :   Data storage and retrieval using JPA and a database.
WishlistItem Entity         :   Database schema for users and wishlist items.
Unit Tests                  :   Ensure robust functionality through comprehensive testing.

```
### Spring boot Initialization

1. Visit Spring Initializer 
2. create the project by providing necessary details such as Java as Language

### Dependencies Features

**Spring Web:** Enables building web applications and REST APIs with Spring's powerful features and annotations.
<br>
**Lombok:** Reduces boilerplate code by automating getters, setters, toString, and other common methods.
<br>
**Spring JPA:** Provides an abstraction layer for interacting with relational databases using JPA and Hibernate.
<br>
**MySQL Connector:** Allows your application to connect and interact with MySQL databases.
<br>
**Spring Security:** Implements Spring-based security features like authentication, authorization, and access control
<br>
**Junit Test :** For testing
<br>

### Project Setup

Design and implement REST-ful API endpoints for wishlist management:

1. **Product entity**
    - /api/wishlists: GET endpoint to retrieve a user's wishlist.
    - /api/wishlists: POST endpoint to create a new wishlist item.
    - /api/wishlists/{id}: DELETE endpoint to remove a wishlist item by ID.

2. **User entity**
   - /register: POST user registration
   - /login: authenticate the user 
   

### Create project Structure

``I developed a simple project with different packages such as Controller,Service Models, <br>
Repository,DTOS,Transformers,Security,Exceptions``



### Security of Web Applications

#### 1.Authentication and Authorization
For Authentication and Authorization I have configure with  spring security filter chain <br>
Spring Security offers robustness through its extensive features and configurable options, ensuring <br>
comprehensive protection against various security threats in web applications
-----------------------------------------------------------------------------------------------------------------

                               All test cases executed successfully
--------------------------------------------------------------------------------------------------------------------


## Area Of Improvement

Spring security
1. we can implement Jwt token to allows user no need to provide login credentials for every time Logged into our System
   <br><br>
2. JWT  are well-suited for implementing single sign-on solutions, where a user can authenticate once and access <br>
multiple applications or services without the need for repeated login prompts. This improves user experience and <br>
simplifies access control across distributed systems.
   <br><br>
3. cache Memory  enables us to  improve  the performance and efficiency of  our system  by storing frequently accessed data
   <br><br>
3.Redis is often used as a caching layer to store frequently accessed data in memory, reducing the need to fetch the same data
from slower storage systems such as databases.