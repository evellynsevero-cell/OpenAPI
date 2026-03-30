package com.zup.openAPI.Controllers;

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
}
