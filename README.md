# Student Management Spring Boot App 🎓

A Spring Boot application for managing students, using Supabase PostgreSQL as the database.

## 🚀 Features

- 📚 **RESTful API** for student management
- 🔗 **Spring Data JPA** integration
- 🐘 **PostgreSQL** database support
- 📖 **OpenAPI (Swagger)** documentation
- 🐳 **Dockerized** deployment
- 🔄 **CI/CD** with GitHub Actions

## 📋 Requirements

- **Java 21**
- **Maven**
- **Docker**

## ⚙️ Getting Started

### 🔧 Build Locally

```bash
mvn clean package
```

### 🐳 Run with Docker

```bash
docker build -t student-management-app .
docker run -p 8080:8080 student-management-app
```

### 🌐 Access the Application

- **API Base URL**: `http://localhost:8080/api/students`
- **Swagger Documentation**: `http://localhost:8080/swagger-ui.html`

## 📌 API Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/students` | GET | Get all students |
| `/api/students/{id}` | GET | Get student by ID |
| `/api/students` | POST | Create new student |
| `/api/students/{id}` | PUT | Update student |
| `/api/students/{id}` | DELETE | Delete student |

## 🛠️ Configuration

### Database Configuration

Update your `application.properties` or `application.yml`:

```properties
spring.datasource.url=jdbc:postgresql://your-supabase-host:5432/your-database
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 🧪 Testing

Run tests with:

```bash
mvn test
```

## 📦 Deployment

### Docker Deployment

1. **Build Docker image**:
   ```bash
   docker build -t student-management-app .
   ```

2. **Run container**:
   ```bash
   docker run -p 8080:8080 -e DATABASE_URL=your-db-url student-management-app
   ```

### GitHub Actions CI/CD

The project includes automated CI/CD pipeline that:
- Builds the application
- Runs tests
- Creates Docker image
- Deploys to production

## 📂 Project Structure

```bash
student-management-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/studentmanagement/
│   │   │       ├── controller/     # REST Controllers
│   │   │       ├── entity/         # JPA Entities
│   │   │       ├── repository/     # Data Repositories
│   │   │       ├── service/        # Business Logic
│   │   │       └── StudentManagementApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application.yml
│   └── test/                       # Unit Tests
├── Dockerfile
├── docker-compose.yml
├── .github/workflows/              # GitHub Actions
├── pom.xml
└── README.md
```

## 🛡️ Environment Variables

| Variable | Description | Default |
|----------|-------------|---------|
| `DATABASE_URL` | PostgreSQL connection URL | `jdbc:postgresql://localhost:5432/studentdb` |
| `DATABASE_USERNAME` | Database username | `postgres` |
| `DATABASE_PASSWORD` | Database password | `password` |
| `SERVER_PORT` | Application port | `8080` |

