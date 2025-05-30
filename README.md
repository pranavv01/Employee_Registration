# Employee Registration API

A Spring Boot RESTful API to perform **CRUD operations** on Employee records.

---

## Overview

This project demonstrates a simple Employee Management system where you can:

- **Create** new employees  
- **Read** (fetch) all employees  
- **Update** existing employee details  
- **Delete** employees by ID  

The backend uses Spring Boot and Spring Data JPA for persistence.

---

## Endpoints

| HTTP Method | Endpoint                  | Description                | Request Body             | Response                   |
|-------------|---------------------------|----------------------------|--------------------------|----------------------------|
| GET         | `/get-all-employees`      | Retrieve all employees      | None                     | List of Employee JSON       |
| POST        | `/add-employee`           | Create a new employee       | Employee JSON object      | Created Employee JSON       |
| PUT         | `/{id}`                   | Update employee by ID       | Updated Employee JSON     | Updated Employee JSON or 404|
| DELETE      | `/delete-employee/{id}`   | Delete employee by ID       | None                     | Success/failure message     |

---

## Employee JSON Example

```json
{
  "name": "Pranav",
  "gender": "Male",
  "city": "Delhi",
  "state": "Delhi"
}
