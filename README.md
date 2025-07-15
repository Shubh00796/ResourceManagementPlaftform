# 🧩 OrgFlow: Resource Allocation & People Management Backend

An enterprise-grade backend platform tailored for dynamic organizations, IT firms, and startups. OrgFlow streamlines employee allocation, project assignments, and availability tracking across departments — all while enforcing clean architecture and modular design.

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
- ✅ **Separation of Concerns (SoC)** – each module handles a single responsibility
- ✅ **SOLID**, **DRY**, and **KISS** principles
- ✅ **Decoupled Services** using DTOs + Mappers

```mermaid
graph TD
  A[Controller Layer] --> B[Service Layer]
  B --> C[Repository Layer]
  B --> D[DTOs & Mappers]
  C --> E[PostgreSQL]
  B --> F[Validation & Logging]
  B --> G[RBAC & Auth]
  ```

📦 Modules Overview
Module	Responsibility
Employee	Resource info, availability, skills
Project	Project lifecycle, budget, resource needs
Assignment	Matchmaking & allocations
Auth	JWT + Role Auth

```mermaid
flowchart LR
  Emp[Employee Module] -->|Assigns| Asg[Assignment Module]
  Proj[Project Module] -->|Needs| Asg
  Asg -->|Checks| Avail[Availability Checker]
  Auth -->|Secures| All[All Modules]
  ```
🛠️ Tech Stack
Technology	Usage
Java 17	Core programming
Spring Boot 3	REST APIs
Spring Security	Auth system
PostgreSQL	Data storage
Lombok	Clean code
MapStruct	DTO to Entity
Swagger	API docs
Flyway	DB migrations
Logback	Logging
Docker	Containerization (optional)
📚 API Documentation
Swagger UI available at /swagger-ui/index.html

Follows RESTful conventions with proper status codes and error handling

Includes OpenAPI annotations for all endpoints

🔐 RBAC Roles
Role	Permissions
Admin	Full access to all modules
Manager	Assign resources, view reports
Viewer	Read-only access to allocations & data
🧪 Testing & Validation
JSR-380 Bean Validation for request payloads

Global exception handler with custom error responses

Logback integration for structured logs

🐳 Docker Support
Optional Docker setup for containerized deployment:

bash
docker build -t orgflow-backend .
docker run -p 8080:8080 orgflow-backend
📈 Reporting API
/api/report/project/{id} – Allocation metrics per project

/api/report/department/{id} – Department-level resource usage

📂 Project Structure
plaintext
src/
├── controller/
├── service/
├── repository/
├── dto/
├── mapper/
├── config/
├── exception/
└── model/
🧠 Design Patterns Used
🧠 Strategy – for dynamic allocation logic

🏭 Factory – for role-based instantiation

👁️ Observer – for availability notifications

🧾 Specification – for filtering resources

🧩 Command – for assignment operations

📌 Setup Instructions
Clone the repo git clone https://github.com/Shubh00796/ResourceManagementPlaftform.git

Configure PostgreSQL credentials in application.yml

Run migrations mvn flyway:migrate

Start the app mvn spring-boot:run

🧭 Contribution Guidelines
Follow naming conventions and modular structure

Ensure Swagger annotations for all endpoints

Write unit tests for service and controller layers

📜 License
This project is licensed under the MIT License.

🙌 Acknowledgements
Crafted with precision by Shubham — backend architect passionate about scalable SaaS platforms and clean architecture.
