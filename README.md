# Open Cart Project

This Open Cart Project is constructed by Spring Framework with Spring Boot, Thymeleaf, Spring MVC, Spring Security, JPA and so on


## Installation

Clone project by [this link](https://github.com/amaggat/OpenCart.git) to get this project.

```bash
git clone https://github.com/amaggat/OpenCart.git
```

## Database Installation
* Open file "opencart.sql" with source link: src\main\resources\database\opencart.sql
And execute it with SQL Workbench or and type of MySQL shell to create database

* Open file "populate.sql" with source link: src\main\resources\database\populate.sql
to populate data in database

* Open file application.properties and change 2 fields: Account and Password
If you run SQL server on port:3307 or and port, please change the link follow up "spring.datasource.url"
with your SQL Server's port
Example: You run SQL server on port 999, change the link to: 
jdbc:mysql://localhost:**999**/opencart?allowPublicKeyRetrial=true/?useSSL=false

## Usage

Use set of keys: Ctrl + Alt + (Fn) + F10 to run
Or just click the green arrow button on Intellij next to Debug button on right-top corner

Run by cmd: 
```bash
mvn clean
mvn install
mvn spring-boot:run
```
After that open your browser and input the link: https://localhost:8080

```
## Contributor:
https://github.com/thanhhdatt
https://github.com/ducduongn
https://github.com/NguyenVanQuangk63uetCACLC1
https://github.com/amaggat
