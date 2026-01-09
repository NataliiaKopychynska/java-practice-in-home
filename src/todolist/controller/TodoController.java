package todolist.controller;

import todolist.model.Todo;
import todolist.service.TodoService;

import java.util.List;
import java.util.Optional;

/**
 * REST API Controller for Todo operations
 *
 * Endpoints:
 * GET    /api/todos           - Get all todos
 * GET    /api/todos/{id}      - Get todo by id
 * POST   /api/todos           - Create new todo
 * PUT    /api/todos/{id}      - Update todo
 * DELETE /api/todos/{id}      - Delete todo
 * PATCH  /api/todos/{id}/toggle - Toggle todo completion status
 * GET    /api/todos/completed - Get completed todos
 * GET    /api/todos/pending   - Get pending todos
 */
public class TodoController {
    private final TodoService todoService;

    public TodoController() {
        this.todoService = new TodoService();
    }

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * GET /api/todos - Get all todos
     */
    public Response<List<Todo>> getAllTodos() {
        try {
            List<Todo> todos = todoService.getAllTodos();
            return Response.success(todos, "Todos retrieved successfully");
        } catch (Exception e) {
            return Response.error("Failed to retrieve todos: " + e.getMessage());
        }
    }

    /**
     * GET /api/todos/{id} - Get todo by id
     */
    public Response<Todo> getTodoById(Long id) {
        try {
            Optional<Todo> todo = todoService.getTodoById(id);
            if (todo.isPresent()) {
                return Response.success(todo.get(), "Todo found");
            } else {
                return Response.notFound("Todo with id " + id + " not found");
            }
        } catch (IllegalArgumentException e) {
            return Response.badRequest(e.getMessage());
        } catch (Exception e) {
            return Response.error("Failed to retrieve todo: " + e.getMessage());
        }
    }

    /**
     * POST /api/todos - Create new todo
     */
    public Response<Todo> createTodo(String title, String description) {
        try {
            Todo todo = todoService.createTodo(title, description);
            return Response.created(todo, "Todo created successfully");
        } catch (IllegalArgumentException e) {
            return Response.badRequest(e.getMessage());
        } catch (Exception e) {
            return Response.error("Failed to create todo: " + e.getMessage());
        }
    }

    /**
     * PUT /api/todos/{id} - Update todo
     */
    public Response<Todo> updateTodo(Long id, String title, String description, Boolean completed) {
        try {
            Optional<Todo> todo = todoService.updateTodo(id, title, description, completed);
            if (todo.isPresent()) {
                return Response.success(todo.get(), "Todo updated successfully");
            } else {
                return Response.notFound("Todo with id " + id + " not found");
            }
        } catch (IllegalArgumentException e) {
            return Response.badRequest(e.getMessage());
        } catch (Exception e) {
            return Response.error("Failed to update todo: " + e.getMessage());
        }
    }

    /**
     * DELETE /api/todos/{id} - Delete todo
     */
    public Response<Void> deleteTodo(Long id) {
        try {
            boolean deleted = todoService.deleteTodo(id);
            if (deleted) {
                return Response.success(null, "Todo deleted successfully");
            } else {
                return Response.notFound("Todo with id " + id + " not found");
            }
        } catch (IllegalArgumentException e) {
            return Response.badRequest(e.getMessage());
        } catch (Exception e) {
            return Response.error("Failed to delete todo: " + e.getMessage());
        }
    }

    /**
     * PATCH /api/todos/{id}/toggle - Toggle todo completion status
     */
    public Response<Todo> toggleTodoCompletion(Long id) {
        try {
            Optional<Todo> todo = todoService.toggleTodoCompletion(id);
            if (todo.isPresent()) {
                return Response.success(todo.get(), "Todo status toggled successfully");
            } else {
                return Response.notFound("Todo with id " + id + " not found");
            }
        } catch (Exception e) {
            return Response.error("Failed to toggle todo: " + e.getMessage());
        }
    }

    /**
     * GET /api/todos/completed - Get completed todos
     */
    public Response<List<Todo>> getCompletedTodos() {
        try {
            List<Todo> todos = todoService.getCompletedTodos();
            return Response.success(todos, "Completed todos retrieved successfully");
        } catch (Exception e) {
            return Response.error("Failed to retrieve completed todos: " + e.getMessage());
        }
    }

    /**
     * GET /api/todos/pending - Get pending todos
     */
    public Response<List<Todo>> getPendingTodos() {
        try {
            List<Todo> todos = todoService.getPendingTodos();
            return Response.success(todos, "Pending todos retrieved successfully");
        } catch (Exception e) {
            return Response.error("Failed to retrieve pending todos: " + e.getMessage());
        }
    }

    /**
     * GET /api/todos/count - Get todo count
     */
    public Response<Long> getTodoCount() {
        try {
            long count = todoService.getTodoCount();
            return Response.success(count, "Todo count retrieved successfully");
        } catch (Exception e) {
            return Response.error("Failed to retrieve todo count: " + e.getMessage());
        }
    }

    /**
     * Generic Response wrapper for API responses
     */
    public static class Response<T> {
        private final boolean success;
        private final T data;
        private final String message;
        private final int statusCode;

        private Response(boolean success, T data, String message, int statusCode) {
            this.success = success;
            this.data = data;
            this.message = message;
            this.statusCode = statusCode;
        }

        public static <T> Response<T> success(T data, String message) {
            return new Response<>(true, data, message, 200);
        }

        public static <T> Response<T> created(T data, String message) {
            return new Response<>(true, data, message, 201);
        }

        public static <T> Response<T> badRequest(String message) {
            return new Response<>(false, null, message, 400);
        }

        public static <T> Response<T> notFound(String message) {
            return new Response<>(false, null, message, 404);
        }

        public static <T> Response<T> error(String message) {
            return new Response<>(false, null, message, 500);
        }

        public boolean isSuccess() {
            return success;
        }

        public T getData() {
            return data;
        }

        public String getMessage() {
            return message;
        }

        public int getStatusCode() {
            return statusCode;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "success=" + success +
                    ", data=" + data +
                    ", message='" + message + '\'' +
                    ", statusCode=" + statusCode +
                    '}';
        }
    }
}
