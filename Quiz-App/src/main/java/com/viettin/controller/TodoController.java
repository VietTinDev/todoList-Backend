package com.viettin.controller;

import com.viettin.model.Todo;
import com.viettin.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Todo>> getAllTodos(){
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Todo> getById(@PathVariable Long id){
        return ResponseEntity.ok(todoService.getTodoById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.updateTodo(id,todo));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }

}