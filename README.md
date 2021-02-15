# Application Name:  
RestfulEMBL

# To build and run:
1. Build: mvn clean install
2. Run: mvn spring-boot:run

#To use Docker:
Once the application downloaded from the Git Repository, use the command prompt and go the project location, then execute the follwoing commands one by one.

1.docker build -t emblrepo/restfulEMBL .

2.docker run -p 8080:8080 emblrepo/restfulEMBL

#Security - Basic authentication

username : user (or) admin

password: embl

# Api Documentation

http://localhost:8080/swagger-ui.html
