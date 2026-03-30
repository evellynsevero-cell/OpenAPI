package com.zup.openAPI.controllers;

import com.zup.openAPI.exception.TaskNotFoundException;
import com.zup.openAPI.models.Task;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/tasks")
@Tag(name = "Tasks", description = "Gerenciamento de tarefas")

import com.zup.openAPI.exceptions.TaskNotFoundException;
import com.zup.openAPI.models.Task;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/tasks")
@Tag(name = "Tasks", description = "Gerenciamento de tarefas")

public class TaskController {
    private final List<Task> tasks = new ArrayList<>();
    private long nextId = 1;

    @GetMapping
    public ResponseEntity<List<Task>> listar(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Boolean done,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        List<Task> resultado = tasks.stream()
                .filter(t -> title == null || t.getTitle().toLowerCase().contains(title.toLowerCase()))
                .filter(t -> done == null || t.isDone() == done)
                .skip((long) page * size)
                .limit(size)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultado);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> buscar(@PathVariable Long id) {
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }
    @PostMapping
    public ResponseEntity<Task> criar(@RequestBody Task task) {
        task.setId(nextId++);
        tasks.add(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> atualizar(@PathVariable Long id, @RequestBody Task dados) {
        Task task = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException(id));

        task.setTitle(dados.getTitle());
        task.setDescription(dados.getDescription());
        task.setDone(dados.isDone());
        return ResponseEntity.ok(task);
    }
    // DELETE /v1/tasks/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        boolean removido = tasks.removeIf(t -> t.getId().equals(id));
        if (!removido) throw new TaskNotFoundException(id);
        return ResponseEntity.noContent().build();
    }
}

