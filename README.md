# Food-Ordering-Application

# Project SetUp:
  
  1. git clone https://github.com/Anil-kumar9/Food-Ordering-Application
  2. FrontEnd SetUp:
     1. install nodeJs -> brew install node 
     2. install Angular cli -> npm install -g @angular/cli
     3. run command -> npm install to install node_modules
     4. to run frontend use command ng serve
  3. Backend SetUp:
     -> install Java -> brew install java
     -> install maven -> brew install maven
     1. Import all services in IDE like Eclipse.
     2. Do maven update for all services to download maven dependencies
     3. create application.properties file and update the file with below details

        message="Hi from config server latest"

        spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
        spring.datasource.url=jdbc:mysql://localhost:3306/FinalMicroservice?createDatabaseIfNotExist=true
        spring.datasource.username=root
        spring.datasource.password=password
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true
        spring.jpa.properties.hibernate.format_sql=true

        eureka.client.service-url.default-zone=http://localhost:8761/eureka

        update mysql username and password.
        
     3. In config service -> open application.properties and upadte the application.  properties file location in local machine.
     4. And upadte the mySql password in all services application.properties if not using config server.
     5. Run all services 

# How To Use
  1. run frontend and backend all services
  2. Register user and login
  3. user can register his own resturant and add menu items and resturant main photos.
  4. After registering restaurant open "http://localhost:4200/admin"
     Admin logins:
     username: admin@gmail.com
     password: Admin@123
  5. Approve the Restaurant so that all users can see the restaurant for ordering food in home page.
  6. create multiple restuarts and multiple users to explore more features of application.

# Roles
  1. User
     1. user can register and login, user can add food items to cart and order food and see order status. 
     2. user can change password and update his profiule and add multiple address and can access all uaer details in user dash-board.
  2. Restuarnt
     1. After registering to application, user can register their own restuarnt.
     2. Anytime can addmore cuisines and menu items and change prices.
     3. If user places order resturant has a privillage to accept or reject the orders.
     4. After accepting teh order resturant mangement ahs to update the statsu of order.
  3. Admin
     1. Admin manages the new restuarnt approvals and rejects based on business discussions.
     2. Admin can change the restuarnt approval status.

# Technologies Used
  1. BackEnd - 8 Services
     1. Java 11
     2. Spring with Maven
     3. Hibernate 
     4. FeignClient for microservice communication
     5. Resilience4J
     6. Microservices Architecture
     7. Config and Eureka Servers
     8. Jacoco tool for code coverage
     9. JUnit testing and Mockito testing
     10. Razorpay api integartion with credentials.

  2. FrontEnd
     1. Angular
     2. Angular material
     3. TypeScript
     4. HTML and CSS
     5. OpenStreetMap for map views
     6. Angular Custom Pipes, Validators using   Directives.
  
  3. DataBase
     1. MySql.
  

