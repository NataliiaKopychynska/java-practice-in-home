# Todo List REST API

A Java REST API project demonstrating CRUD operations with in-memory mock data storage.

## Project Structure

```
todolist/
├── model/
│   └── Todo.java                    # Entity/Model class
├── repository/
│   └── TodoRepository.java          # Data access layer with mock data
├── service/
│   └── TodoService.java             # Business logic layer
├── controller/
│   └── TodoController.java          # REST API endpoints
└── TodoListApplication.java         # Main application with CLI demo
```

## Features

### Model
- **Todo** entity with:
  - id (Long)
  - title (String)
  - description (String)
  - completed (boolean)
  - createdAt (LocalDateTime)
  - updatedAt (LocalDateTime)
  - Auto-update timestamps
  - Proper equals() and hashCode()
  - toString() implementation

### Repository Layer
- In-memory data storage using ArrayList
- Mock data initialization with 3 sample todos
- Thread-safe ID generation using AtomicLong
- CRUD operations:
  - `findAll()` - Get all todos
  - `findById(Long id)` - Find by ID
  - `save(Todo todo)` - Create or update
  - `deleteById(Long id)` - Delete by ID
  - `findByCompleted(boolean)` - Filter by status
  - `count()` - Get total count
  - `deleteAll()` - Clear all data

### Service Layer
- Business logic and validation
- Input validation for all operations
- Exception handling with meaningful messages
- Methods:
  - `getAllTodos()` - Retrieve all todos
  - `getTodoById(Long id)` - Get single todo
  - `createTodo(...)` - Create new todo with validation
  - `updateTodo(...)` - Update existing todo
  - `deleteTodo(Long id)` - Delete todo
  - `toggleTodoCompletion(Long id)` - Toggle status
  - `getCompletedTodos()` - Filter completed
  - `getPendingTodos()` - Filter pending
  - `getTodoCount()` - Get count
  - `deleteAllTodos()` - Clear all

### Controller Layer (REST API)
Simulates REST API with proper HTTP semantics:

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/todos` | Get all todos |
| GET | `/api/todos/{id}` | Get todo by ID |
| POST | `/api/todos` | Create new todo |
| PUT | `/api/todos/{id}` | Update todo |
| DELETE | `/api/todos/{id}` | Delete todo |
| PATCH | `/api/todos/{id}/toggle` | Toggle completion status |
| GET | `/api/todos/completed` | Get completed todos |
| GET | `/api/todos/pending` | Get pending todos |
| GET | `/api/todos/count` | Get todo count |

**Response Structure:**
```java
{
  "success": boolean,
  "data": T,
  "message": String,
  "statusCode": int  // HTTP status codes (200, 201, 400, 404, 500)
}
```

## How to Run

### Compile
```bash
cd src
javac todolist/model/Todo.java
javac todolist/repository/TodoRepository.java
javac todolist/service/TodoService.java
javac todolist/controller/TodoController.java
javac todolist/TodoListApplication.java
```

### Run
```bash
java todolist.TodoListApplication
```

### Interactive Menu
The application provides an interactive CLI menu with:
1. View all todos
2. Find todo by ID
3. Create new todo
4. Update existing todo
5. Delete todo
6. Toggle completion status
7. View completed todos
8. View pending todos
9. Get todo count
0. Exit

## Mock Data

The repository initializes with 3 sample todos:
1. ✅ **Learn Java** - Complete Java fundamentals and OOP concepts (Completed)
2. ⏳ **Build REST API** - Create a todo-list REST API with mock data (Pending)
3. ⏳ **Practice Git** - Learn git commands and version control (Pending)

## Key Concepts Demonstrated

### Architecture
- **Layered Architecture**: Model → Repository → Service → Controller
- **Separation of Concerns**: Each layer has single responsibility
- **Dependency Injection**: Controllers and services accept dependencies

### Design Patterns
- **Repository Pattern**: Data access abstraction
- **Service Layer Pattern**: Business logic separation
- **DTO Pattern**: Response wrapper for API responses

### Java Features
- **Optional<T>**: Safe null handling
- **Stream API**: Filtering and searching
- **Time API**: LocalDateTime for timestamps
- **AtomicLong**: Thread-safe ID generation
- **Generics**: Type-safe Response<T> wrapper

### Best Practices
- Input validation
- Exception handling
- Immutable where possible
- Meaningful variable names
- Clear method documentation
- Proper encapsulation
- Auto-updating timestamps

## Future Enhancements

### Spring Boot Integration
To convert to Spring Boot:
1. Add `@RestController` to TodoController
2. Add `@Service` to TodoService
3. Add `@Repository` to TodoRepository
4. Add `@Entity` and `@Id` to Todo
5. Use JPA/Hibernate for persistence
6. Add proper REST mappings (@GetMapping, @PostMapping, etc.)

### Possible Features
- ✅ Pagination and sorting
- ✅ Search functionality
- ✅ Categories/tags
- ✅ Due dates and priorities
- ✅ User authentication
- ✅ Database persistence (JPA, H2, PostgreSQL)
- ✅ JSON serialization (Jackson, Gson)
- ✅ Actual HTTP server (Spring Boot, Javalin)
- ✅ Unit tests (JUnit, Mockito)
- ✅ API documentation (Swagger/OpenAPI)

## Learning Objectives

This project demonstrates:
- REST API design principles
- HTTP methods and status codes
- CRUD operations
- Layered architecture
- In-memory data storage
- Service-oriented design
- Input validation
- Error handling
- Java best practices
- MVC pattern adaptation

Perfect for learning Java backend development concepts before moving to frameworks like Spring Boot!
