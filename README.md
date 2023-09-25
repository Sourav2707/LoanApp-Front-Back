Bridgelabz Finserve - Fullstack Application using Angular and SpringBoot

**Step 1: Project creation**

-Created a springboot project with spring wbe, spring devtools, spring data jpa, spring security, Mysql driver

**Step 2: Password encoding, Authenticate and Authorization**

-Created **Config** package in the **src/main/java/com.bridgelabz.finserve**
-Crated password encoder method using **BcryptPasswordEncoder** from the **Spring Security**

-Created **Utility** package for generating JWT token using oauth 2.0 and added required dependency in the pom.xml

**Step 3: Creating Controller, Service, DAO, Repository, DTO and Entity for User**

-Created UserController for User
-Created UserService/IUserService
-Created User entity
-Created Login and Register DTO
-Created UserDAO
-Created UserRepository which extends JpaRepository interface



