# 🗃️ Resource Management System

An enterprise-grade **Resource Allocation and People Management backend** designed for dynamic organizations, IT firms, or startups. It supports assigning employees to projects, managing availability, and tracking allocations across departments.

---

## 🚀 Features

- 👥 **Employee & Resource Modules**: Add/edit/delete employees, roles, and skills
- 📁 **Project Assignment Flow**: Allocate available employees to specific projects
- 📆 **Availability Checker**: Prevents overbooking/conflicts
- 🔐 **Role-Based Access Control (RBAC)**: Admin, Manager, Viewer
- 📊 **Reporting API**: Get current allocation metrics per project/department
- 🌐 **RESTful, Swagger-documented APIs**
- ⚠️ **Centralized Exception Handling with Custom Error Responses**
- 🧪 **Validation Layer + Structured Logging (Logback)**

---

## 🧠 Architecture & Principles

- ✅ **Clean Architecture** (Controller → Service → Repository)
- ✅ **SoC** – each module handles a single concern
- ✅ **SOLID**, **DRY**, and **KISS** principles
- ✅ **Decoupled Services** using DTOs + Mappers

| Module | Responsibility |
|--------|----------------|
| Employee | Resource info, availability, skills |
| Project | Project lifecycle, budget, resource needs |
| Assignment | Matchmaking & allocations |
| Auth | JWT + Role Auth |

---

## 🛠️ Tech Stack

| Technology | Usage |
|------------|-------|
| Java 17 | Core programming |
| Spring Boot 3 | REST APIs |
| Spring Security | Auth system |
| PostgreSQL | Data storage |
| Lombok | Clean code |
| MapStruct | DTO to Entity |
| Swagger | API docs |
| Flyway | DB migrations |
| Logback | Logging |
| Docker | Containerization (optional) |

---

## 📁 Folder Structure

```shell
resource-manager/
├── controller/
├── dto/
├── entity/
├── exception/
├── mapper/
├── repository/
├── service/
├── config/
├── util/
└── application.yml

📌 Real-World Relevance
	•	Simulates actual IT resource management used in consulting firms
	•	Can be extended for:
	•	Project budgeting
	•	Skill matrix mapping
	•	Time tracking integrations
	•	Can plug into enterprise dashboards or BI tools