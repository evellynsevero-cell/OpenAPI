package com.zup.openAPI.exceptions;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("Tarefa com id=" + id + " não encontrada");

    }
}
