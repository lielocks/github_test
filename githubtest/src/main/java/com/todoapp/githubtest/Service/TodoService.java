package com.todoapp.githubtest.Service;

import com.todoapp.githubtest.Dto.TodoDto;
import com.todoapp.githubtest.Entity.TodoEntity;
import com.todoapp.githubtest.Repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoEntity add(TodoDto todoDto) {
        TodoEntity todoEntity = TodoEntity.builder()
                .title(todoDto.getTitle())
                .order(todoDto.getOrder())
                .completed(todoDto.getCompleted())
                .build();
        return this.todoRepository.save(todoEntity);
    }

    public TodoEntity searchById(Long id) {
        return this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TodoEntity> searchAll() {
        return this.todoRepository.findAll();
    }

    public TodoEntity updateById(Long id, TodoDto todoDto) {
        TodoEntity todoEntity = this.searchById(id);

        if (todoDto.getTitle() != null) {
            todoEntity.setTitle(todoDto.getTitle());
        }

        if (todoDto.getOrder() != null) {
            todoEntity.setOrder(todoDto.getOrder());
        }

        if (todoDto.getCompleted() != null) {
            todoEntity.setCompleted(todoDto.getCompleted());
        }

        return this.todoRepository.save(todoEntity);
    }

    public void deleteById(Long id) {
        this.todoRepository.deleteById(id);
    }

    public void deleteAll() {
        this.todoRepository.deleteAll();
    }

}
