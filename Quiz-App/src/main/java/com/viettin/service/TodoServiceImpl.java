package com.viettin.service;

import com.viettin.model.Todo;
import com.viettin.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoRepository repository;

    @Override
    public Todo createTodo(Todo todo) {
        return repository.save(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    @Override
    public Todo getTodoById(Long id) {
        return repository.getById(id);
    }

    @Override
    public Todo updateTodo(Long id, Todo todo) {
        Todo actualTodo = repository.findById(id).orElseThrow(
                ()-> new RuntimeException("Not found by id " + id)
        );
        actualTodo.setTitle(todo.getTitle());
        actualTodo.setCompleted(todo.isCompleted());
        return repository.save(actualTodo);
    }

    @Override
    public void deleteTodoById(Long id) {
        repository.deleteById(id);
    }
}
