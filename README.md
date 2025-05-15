**# 🧩 Microservices Project with Spring Boot 3.2.x and Java 17**

This repository is a complete implementation of a **microservices-based architecture** using **Spring Boot 3.2.x**, **Java 17**, **Apache Kafka**, **Docker**, and **Kubernetes**. It demonstrates modern practices such as service discovery, centralized configuration, event-driven communication, API gateway routing, and CI/CD readiness.

---

**## 🏗️ Project Structure**

```text
.
├── api-gateway          # Spring Cloud Gateway for routing and filtering
├── ci-cd                # CI/CD pipeline scripts and configurations
├── common-lib           # Shared DTOs and utility classes across services
├── config-server        # Centralized configuration with Spring Cloud Config
├── discovery-service    # Eureka server for service discovery
├── kafka-service        # Kafka-based messaging service for event publishing
├── order-service        # Handles order placement and integrates with other services
├── product-service      # Manages product catalog and inventory
├── user-service         # Handles user registration, login, and authentication


**🔧 Tech Stack**
Java 17

Spring Boot 3.2.x

Spring Cloud (Gateway, Config, Eureka)

Apache Kafka for asynchronous messaging

Docker for containerization

Kubernetes for orchestration

Maven as build tool

**⚙️ Microservices Overview**

✅ discovery-service
Eureka server for registering and locating services dynamically.

✅ config-server
Provides centralized configuration for all microservices using Git-backed config repo.

✅ api-gateway
Routes client requests to appropriate backend services.

Handles cross-cutting concerns like logging, CORS, and load balancing.

✅ user-service
Manages user registration and authentication.

Communicates with order-service for fetching user orders.

✅ product-service
Provides APIs for creating and managing products.

Supplies inventory and product information to order-service.

✅ order-service
Handles order creation and cancellation.

Communicates with product-service and user-service.

Publishes order events to Kafka.

✅ kafka-service (formerly notification-service)
Listens to Kafka topics and logs or processes notifications asynchronously.

✅ common-lib
Contains shared models (DTOs), constants, and reusable components across services.

✅ ci-cd
Contains sample CI/CD scripts and configurations (e.g., GitHub Actions, Jenkins).

**🚀 How to Run**
Prerequisites
Java 17

Maven 3.8+

Docker (for containerized deployment)

Kubernetes (e.g., Minikube or Docker Desktop)

Steps
Start Config Repo

bash
Copy
Edit
cd config-repo
git init
Build All Projects

bash
Copy
Edit
mvn clean install
Run with Docker or Kubernetes

Build images using Dockerfiles in each service.

Deploy YAML manifests or Helm charts (optional).

**Access Services**

Eureka Dashboard → http://localhost:8761

API Gateway → http://localhost:8080

Config Server → http://localhost:8888

**📬 Kafka Setup (Local)**
Use Docker Compose or Bitnami Kafka Helm chart to start Kafka and Zookeeper.

Sample Kafka topic used:

order-events

📁 Config Git Repo Structure
A separate Git repo (e.g., config-repo/) should contain property files like:

pgsql
Copy
Edit
config-repo/
├── user-service.yml
├── product-service.yml
├── order-service.yml
├── kafka-service.yml
├── discovery-service.yml
├── api-gateway.yml
└── config-server.yml

**📘 Author**
Aneesh Kumar — Software Architect with 15+ years of experience in Java and Spring-based solutions.

**📚 License**
This project is licensed under the MIT License - see the LICENSE file for details.

yaml
Copy
Edit

---

Let me know if you want badges, screenshots, or setup instructions for Kafka, Docker Compose, or Minik
