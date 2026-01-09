package todolist.service;

import todolist.model.Todo;
import todolist.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService()
    {
        this.todoRepository = new TodoRepository();
    }

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid todo ID");
        }
        return todoRepository.findById(id);
    }

    public Todo createTodo(String title, String description) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setDescription(description);

        return todoRepository.save(todo);
    }

    public Todo createTodo(Todo todo) {
        if (todo == null) {
            throw new IllegalArgumentException("Todo cannot be null");
        }
        if (todo.getTitle() == null || todo.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        return todoRepository.save(todo);
    }

    public Optional<Todo> updateTodo(Long id, String title, String description, Boolean completed) {
        Optional<Todo> todoOptional = todoRepository.findById(id);

        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();

            if (title != null && !title.trim().isEmpty()) {
                todo.setTitle(title);
            }
            if (description != null) {
                todo.setDescription(description);
            }
            if (completed != null) {
                todo.setCompleted(completed);
            }

            todoRepository.save(todo);
            return Optional.of(todo);
        }

        return Optional.empty();
    }

    public boolean deleteTodo(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid todo ID");
        }
        return todoRepository.deleteById(id);
    }

    public Optional<Todo> toggleTodoCompletion(Long id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);

        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            todo.setCompleted(!todo.isCompleted());
            todoRepository.save(todo);
            return Optional.of(todo);
        }

        return Optional.empty();
    }

    public List<Todo> getCompletedTodos() {
        return todoRepository.findByCompleted(true);
    }

    public List<Todo> getPendingTodos() {
        return todoRepository.findByCompleted(false);
    }

    public long getTodoCount() {
        return todoRepository.count();
    }

    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }
}
