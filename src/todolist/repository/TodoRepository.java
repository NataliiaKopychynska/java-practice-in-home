package todolist.repository;

import todolist.model.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class TodoRepository {
    private final List<Todo> todos = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public TodoRepository() {
        initializeMockData();
    }

    private void initializeMockData() {
        todos.add(new Todo(idGenerator.getAndIncrement(),
                "Learn Java",
                "Complete Java fundamentals and OOP concepts"));
        todos.add(new Todo(idGenerator.getAndIncrement(),
                "Build REST API",
                "Create a todo-list REST API with mock data"));
        todos.add(new Todo(idGenerator.getAndIncrement(),
                "Practice Git",
                "Learn git commands and version control"));

        // Mark first todo as completed
        todos.get(0).setCompleted(true);
    }

    public List<Todo> findAll() {
        return new ArrayList<>(todos);
    }

    public Optional<Todo> findById(Long id) {
        return todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst();
    }

    public Todo save(Todo todo) {
        if (todo.getId() == null) {
            todo.setId(idGenerator.getAndIncrement());
            todos.add(todo);
        } else {
            Optional<Todo> existingTodo = findById(todo.getId());
            if (existingTodo.isPresent()) {
                int index = todos.indexOf(existingTodo.get());
                todos.set(index, todo);
            } else {
                todos.add(todo);
            }
        }
        return todo;
    }

    public boolean deleteById(Long id) {
        return todos.removeIf(todo -> todo.getId().equals(id));
    }

    public List<Todo> findByCompleted(boolean completed) {
        return todos.stream()
                .filter(todo -> todo.isCompleted() == completed)
                .toList();
    }

    public long count() {
        return todos.size();
    }

    public void deleteAll() {
        todos.clear();
    }
}
