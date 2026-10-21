# Student REST API
A RESTful Student Management API built with **Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL**.
This project was developed as a practical backend project to learn and demonstrate common Spring Boot backend development concepts, including REST APIs, layered architecture, JPA/Hibernate, DTOs, validation, exception handling, pagination, sorting, and database queries.

## Technologies Used
- Java 21
- Spring Boot 4.1.1
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Bean Validation
- Postman
- Git & GitHub

## 📌 Features

### Student CRUD
The API supports the basic CRUD operations:
- Create a student
- Get all students
- Get a student by ID
- Update a student
- Delete a student

### DTOs
The project uses DTOs to separate API request/response data from the database entity.
Examples:
- `StudentDTO`
- `StudentResponseDTO`

### Validation
Request validation is implemented using Jakarta Bean Validation.
For example, student data can be validated before it reaches the service layer.

### Global Exception Handling
The project contains a centralized exception handler:
`GlobalExceptionHandler`
It handles application errors and returns appropriate HTTP responses instead of exposing unnecessary internal errors.

### Custom Exception
A custom exception is used when a requested student does not exist:
`StudentNotFoundException`

### Pagination
Student records can be retrieved page by page using Spring Data's `Pageable`.
This avoids returning a potentially large number of records in a single response.

### Sorting
Student records can be sorted using Spring Data JPA's sorting functionality.

### Searching
The API supports searching students by name.

The project also demonstrates Spring Data JPA derived query methods such as:
findByName(String name)
findByAge(Integer age)
findByNameAndAge(String name, Integer age)
findByAgeGreaterThan(Integer age)
findByAgeLessThan(Integer age)
findByNameContaining(String name)
findByNameStartingWith(String name)
These methods allow database queries to be created from method names without manually writing SQL for every query.

## 🏗️ Project Architecture
The application follows a layered architecture:
Controller
    ↓
Service
    ↓
Repository
    ↓
Database

### Controller
Handles HTTP requests and responses.
Example:
StudentController

### Service
Contains the application's business logic.
Example:
StudentService

### Repository
Handles communication with the database through Spring Data JPA.
Example:
StudentRepository

### Entity
Represents the database table.
Example:
Student

## 📁 Project Structure
src
└── main
    ├── java
    │   └── com.example.bjpapractice
    │       ├── GlobalExceptionHandler.java
    │       ├── HelloController.java
    │       ├── JPApracticeApplication.java
    │       ├── Student.java
    │       ├── StudentDTO.java
    │       ├── StudentNotFoundException.java
    │       ├── StudentRepository.java
    │       ├── StudentResponseDTO.java
    │       ├── StudentService.java
    │       └── ValidationErrorResponse.java
    │
    └── resources
        └── application.properties

## 🗄️ Database
The application uses **MySQL** with Spring Data JPA/Hibernate.
Example database configuration:
spring.datasource.url=jdbc:mysql://localhost:3306/jpapractice
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
The database password is loaded through an environment variable rather than being stored directly in the repository.

## 🔗 Main API Endpoints

| Method | Endpoint              | Purpose                 |
| GET    | /students             | Get students            |
| GET    | /students/{id}        | Get student by ID       |
| POST   | /students             | Create student          |
| PUT    | /students/{id}        | Update student          |
| DELETE | /students/{id}        | Delete student          |
| GET    | /students/name/{name} | Search students by name |

Pagination, sorting, and search parameters are also supported by the student listing functionality.

## 📮 Example Request
### Create Student
**POST**
/students
Request body:
```json
{
    "name": "Abdullah",
    "age": 21
}
```

Example response:

```json
{
    "id": 1,
    "name": "Abdullah",
    "age": 21
}
```

## 🔍 Example Search
GET /students/name/Abdullah
This uses a Spring Data JPA derived query to retrieve students matching the specified name.

## ▶️ How to Run

### 1. Clone the repository
```bash
git clone https://github.com/Abdullah0192/StudentRestAPI.git
```

### 2. Open the project
Open the project in an IDE such as:
- IntelliJ IDEA
- Eclipse
- NetBeans
- VS Code

### 3. Create the MySQL database
Create a database named:
```sql
CREATE DATABASE jpapractice;
```

### 4. Configure the database password
The application expects the MySQL password through the environment variable:
DB_PASSWORD
Do not put your real database password inside `application.properties`.

### 5. Build the project
```bash
mvn clean test
```

### 6. Run the application
```bash
mvn spring-boot:run
```

The application runs on: http://localhost:8080


## 🧪 Testing
The API was tested using **Postman**.

Testing included:
- GET requests
- POST requests
- PUT requests
- DELETE requests
- Invalid student IDs
- Request validation
- Search
- Pagination
- Sorting
- Error responses

## 📚 What I Learned
This project helped me practice the complete flow of a Spring Boot backend application:
HTTP Request
     ↓
Controller
     ↓
Service
     ↓
Repository
     ↓
JPA / Hibernate
     ↓
MySQL

I also practiced:
- REST API development
- Dependency Injection
- Layered architecture
- Spring Data JPA
- Hibernate ORM
- Entity mapping
- DTOs
- Bean Validation
- Custom exceptions
- Global exception handling
- Pagination
- Sorting
- Derived query methods
- MySQL integration
- API testing with Postman
- Maven
- Git and GitHub

## 🔮 Future Improvements
Possible future improvements include:
- Spring Security authentication
- JWT-based authentication
- Role-based authorization
- More automated integration tests
- Docker deployment
- API documentation with OpenAPI/Swagger

> Authentication and JWT are being developed separately in my Spring Security practice project.

## 👨‍💻 Author

**Abdullah Nadeem**

B.S. Software Engineering Student

Interested in **Java, Spring Boot, Backend Development, and REST APIs**. 
