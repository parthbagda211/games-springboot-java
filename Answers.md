Question 2:

Suppose you have a UserService class and a UserController class in a Spring Boot application. 
UserService class has a getInfo() that prints some value. The UserController needs to interact with the UserService for user-related operations. 
Demonstrate the use of Dependency Injection in Spring Boot to wire the UserController with the UserService. Provide the necessary annotations for Dependency Injection in this scenario.


Answers : 

userService : it contaionsa method getInfo() and prints some users information.
userController : it dempends on userService via constructore injection. it has a method getUserInfo() that delegates to userService.getInfo().



Question 3:

W.r.t Srping Boot, What does @ComponentScan do?

Answers :

the @ComponentScan annotation in Spring Boot is used to specify the packages to scan for annotated components (such as @Component, @Service, @Repository, @Controller)
it help spring automatically discover and register beans in the application context.

Question 4:

W.r.t Srping Boot, What does @Transactional do?

Answers :

@Transactional annotation in Spring Boot is used for transaction behavior of a method or a class. it is part of the Spring Framework transaction management system and is used 
to ensure the atomicity, consistency, isolation, and durability (ACID) properties of database operations.

