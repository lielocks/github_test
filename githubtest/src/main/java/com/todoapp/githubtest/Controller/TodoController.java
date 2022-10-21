package com.todoapp.githubtest.Controller;

import com.todoapp.githubtest.Service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
@Slf4j
public class TodoController {
    private final TodoService todoService;
    @GetMapping("/")
    public String helloWorld() {
        return "To-do Application !";
    }
}
