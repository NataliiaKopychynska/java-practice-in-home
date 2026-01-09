package todolist;

import todolist.controller.TodoController;
import todolist.controller.TodoController.Response;
import todolist.model.Todo;

import java.util.List;
import java.util.Scanner;

/**
 * Todo List REST API Application
 * Demonstrates CRUD operations with mock data
 */
public class TodoListApplication {
    private static final TodoController controller = new TodoController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("   Todo List REST API Demo");
        System.out.println("=================================\n");

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> getAllTodos();
                case 2 -> getTodoById();
                case 3 -> createTodo();
                case 4 -> updateTodo();
                case 5 -> deleteTodo();
                case 6 -> toggleTodoCompletion();
                case 7 -> getCompletedTodos();
                case 8 -> getPendingTodos();
                case 9 -> getTodoCount();
                case 0 -> {
                    System.out.println("\nThank you for using Todo List API!");
                    running = false;
                }
                default -> System.out.println("\n❌ Invalid choice! Please try again.\n");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("===== REST API OPERATIONS =====");
        System.out.println("1. GET /api/todos - Get all todos");
        System.out.println("2. GET /api/todos/{id} - Get todo by ID");
        System.out.println("3. POST /api/todos - Create new todo");
        System.out.println("4. PUT /api/todos/{id} - Update todo");
        System.out.println("5. DELETE /api/todos/{id} - Delete todo");
        System.out.println("6. PATCH /api/todos/{id}/toggle - Toggle completion");
        System.out.println("7. GET /api/todos/completed - Get completed todos");
        System.out.println("8. GET /api/todos/pending - Get pending todos");
        System.out.println("9. GET /api/todos/count - Get todo count");
        System.out.println("0. Exit");
        System.out.print("\nEnter your choice: ");
    }

    private static int getUserChoice() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // Clear buffer
            return -1;
        } finally {
            scanner.nextLine(); // Consume newline
        }
    }

    private static void getAllTodos() {
        System.out.println("\n📋 GET /api/todos");
        System.out.println("─────────────────────────────────");

        Response<List<Todo>> response = controller.getAllTodos();
        printResponse(response);

        if (response.isSuccess() && response.getData() != null) {
            List<Todo> todos = response.getData();
            if (todos.isEmpty()) {
                System.out.println("No todos found.");
            } else {
                todos.forEach(todo -> {
                    String status = todo.isCompleted() ? "✅" : "⏳";
                    System.out.println(status + " [" + todo.getId() + "] " + todo.getTitle());
                    if (todo.getDescription() != null && !todo.getDescription().isEmpty()) {
                        System.out.println("   " + todo.getDescription());
                    }
                });
            }
        }
        System.out.println();
    }

    private static void getTodoById() {
        System.out.println("\n🔍 GET /api/todos/{id}");
        System.out.println("─────────────────────────────────");
        System.out.print("Enter todo ID: ");

        try {
            Long id = scanner.nextLong();
            scanner.nextLine(); // Consume newline

            Response<Todo> response = controller.getTodoById(id);
            printResponse(response);

            if (response.isSuccess() && response.getData() != null) {
                printTodoDetails(response.getData());
            }
        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
            scanner.nextLine(); // Clear buffer
        }
        System.out.println();
    }

    private static void createTodo() {
        System.out.println("\n➕ POST /api/todos");
        System.out.println("─────────────────────────────────");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        Response<Todo> response = controller.createTodo(title, description);
        printResponse(response);

        if (response.isSuccess() && response.getData() != null) {
            printTodoDetails(response.getData());
        }
        System.out.println();
    }

    private static void updateTodo() {
        System.out.println("\n✏️ PUT /api/todos/{id}");
        System.out.println("─────────────────────────────────");
        System.out.print("Enter todo ID: ");

        try {
            Long id = scanner.nextLong();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter new title (or press Enter to skip): ");
            String title = scanner.nextLine();

            System.out.print("Enter new description (or press Enter to skip): ");
            String description = scanner.nextLine();

            System.out.print("Mark as completed? (yes/no/skip): ");
            String completedInput = scanner.nextLine();
            Boolean completed = null;
            if (completedInput.equalsIgnoreCase("yes")) {
                completed = true;
            } else if (completedInput.equalsIgnoreCase("no")) {
                completed = false;
            }

            Response<Todo> response = controller.updateTodo(
                    id,
                    title.isEmpty() ? null : title,
                    description.isEmpty() ? null : description,
                    completed
            );
            printResponse(response);

            if (response.isSuccess() && response.getData() != null) {
                printTodoDetails(response.getData());
            }
        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
            scanner.nextLine(); // Clear buffer
        }
        System.out.println();
    }

    private static void deleteTodo() {
        System.out.println("\n🗑️ DELETE /api/todos/{id}");
        System.out.println("─────────────────────────────────");
        System.out.print("Enter todo ID: ");

        try {
            Long id = scanner.nextLong();
            scanner.nextLine(); // Consume newline

            Response<Void> response = controller.deleteTodo(id);
            printResponse(response);
        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
            scanner.nextLine(); // Clear buffer
        }
        System.out.println();
    }

    private static void toggleTodoCompletion() {
        System.out.println("\n🔄 PATCH /api/todos/{id}/toggle");
        System.out.println("─────────────────────────────────");
        System.out.print("Enter todo ID: ");

        try {
            Long id = scanner.nextLong();
            scanner.nextLine(); // Consume newline

            Response<Todo> response = controller.toggleTodoCompletion(id);
            printResponse(response);

            if (response.isSuccess() && response.getData() != null) {
                printTodoDetails(response.getData());
            }
        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
            scanner.nextLine(); // Clear buffer
        }
        System.out.println();
    }

    private static void getCompletedTodos() {
        System.out.println("\n✅ GET /api/todos/completed");
        System.out.println("─────────────────────────────────");

        Response<List<Todo>> response = controller.getCompletedTodos();
        printResponse(response);

        if (response.isSuccess() && response.getData() != null) {
            List<Todo> todos = response.getData();
            if (todos.isEmpty()) {
                System.out.println("No completed todos found.");
            } else {
                todos.forEach(todo ->
                        System.out.println("✅ [" + todo.getId() + "] " + todo.getTitle())
                );
            }
        }
        System.out.println();
    }

    private static void getPendingTodos() {
        System.out.println("\n⏳ GET /api/todos/pending");
        System.out.println("─────────────────────────────────");

        Response<List<Todo>> response = controller.getPendingTodos();
        printResponse(response);

        if (response.isSuccess() && response.getData() != null) {
            List<Todo> todos = response.getData();
            if (todos.isEmpty()) {
                System.out.println("No pending todos found.");
            } else {
                todos.forEach(todo ->
                        System.out.println("⏳ [" + todo.getId() + "] " + todo.getTitle())
                );
            }
        }
        System.out.println();
    }

    private static void getTodoCount() {
        System.out.println("\n📊 GET /api/todos/count");
        System.out.println("─────────────────────────────────");

        Response<Long> response = controller.getTodoCount();
        printResponse(response);

        if (response.isSuccess() && response.getData() != null) {
            System.out.println("Total todos: " + response.getData());
        }
        System.out.println();
    }

    private static void printResponse(Response<?> response) {
        String statusEmoji = response.isSuccess() ? "✅" : "❌";
        System.out.println(statusEmoji + " Status: " + response.getStatusCode());
        System.out.println("Message: " + response.getMessage());
    }

    private static void printTodoDetails(Todo todo) {
        System.out.println("\n── Todo Details ──");
        System.out.println("ID: " + todo.getId());
        System.out.println("Title: " + todo.getTitle());
        System.out.println("Description: " + (todo.getDescription() != null ? todo.getDescription() : "N/A"));
        System.out.println("Status: " + (todo.isCompleted() ? "✅ Completed" : "⏳ Pending"));
        System.out.println("Created: " + todo.getCreatedAt());
        System.out.println("Updated: " + todo.getUpdatedAt());
    }
}
