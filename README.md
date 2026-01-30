# User Registration Application

A full-stack User Registration application built using **Vue.js (Frontend)**, **Spring Boot (Backend)**, and **MongoDB (Database)**. The application supports complete **CRUD operations** with form validation and a clean UI.

---

## 🚀 Features

* User Registration Form
* View all registered users in a table
* Edit existing user details
* Delete user
* Form validation (Frontend + Backend)
* RESTful APIs
* MongoDB integration

---

## 🛠 Tech Stack

### Frontend

* Vue.js (Options API)
* Axios (HTTP requests)
* HTML5, CSS3

### Backend

* Java 17+
* Spring Boot
* Spring Web
* Spring Data MongoDB

### Database

* MongoDB

---

## 📁 Project Structure

### Frontend (Vue.js)

```
src/
 ├── components/
 │   ├── UserForm.vue
 │   └── UserTable.vue
 ├── services/
 │   └── UserService.js
 ├── App.vue
 └── main.js
```

### Backend (Spring Boot)

```
src/main/java/
 ├── controller/
 │   └── AssignmentprojectController.java
 ├── dto/
     └──AssignmentprojectDto.java
 ├── entity/
 │   └──AssignmentprojectEntity.java
 ├── exception/
 │   └──AssignmentprojectGlobalExceptionHandler.java
     └──AssignmentprojectResourceNotFoundException.java
 ├── repository/
 │   └── AssignmentprojectRepository.java
 ├── serviceImpl/
 │   ├── AssignmentprojectService.java
```

---

## ⚙️ Setup Instructions

### 🔹 Backend Setup (Spring Boot)

1. Install **Java 17+**
2. Install **MongoDB** and start the service
3. Clone the backend repository
4. Update `application.properties`

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/userdb
server.port=8080
```

5. Run the application

```bash
mvn spring-boot:run
```

Backend will run at:

```
http://localhost:8080
```

---

### 🔹 Frontend Setup (Vue.js)

1. Install **Node.js (v16+)**
2. Clone the frontend repository
3. Install dependencies

```bash
npm install
```

4. Run the Vue app

```bash
npm run serve
```

Frontend will run at:

```
http://localhost:8081 (or 8080 based on config)
```

---

## 🔗 API Endpoints

### 📌 Create User

**POST** `/api/users`

```json
{
  "fullName": "Suvarna Vanka",
  "email": "suvarna@gmail.com",
  "mobileNumber": "9876543210",
  "password": "password123",
  "dateOfBirth": "1998-01-30"
}
```

---

### 📌 Get All Users

**GET** `/api/users`

---

### 📌 Get User By ID

**GET** `/api/users/{id}`

---

### 📌 Update User

**PUT** `/api/users/{id}`

```json
{
  "fullName": "Updated Name",
  "email": "updated@gmail.com",
  "mobileNumber": "9123456789",
  "dateOfBirth": "1999-02-15"
}
```

---

### 📌 Delete User

**DELETE** `/api/users/{id}`

---

## ✅ Validations

### Frontend

* Required fields
* Email format validation
* Mobile number length validation

### Backend

* Unique email constraint
* Required field validation

---

## 🧪 Testing

* APIs tested using **Postman**
* Frontend tested manually using browser

---

## 📌 Future Enhancements

* Login & Authentication
* Pagination & Search
* Role-based access
* Deployment to cloud

---

## 👩‍💻 Author

**Suvarna Vanka**

---

## 📄 License

This project is for learning and demonstration purposes.
