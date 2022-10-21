package com.todoapp.githubtest.Dto;

import com.todoapp.githubtest.Entity.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    private Long id;
    private String title;
    private Long order;
    private Boolean completed;
    private String url;

    public TodoDto(TodoEntity todoEntity, String serviceUrl) {
        this.id = todoEntity.getId();
        this.title = todoEntity.getTitle();
        this.order = todoEntity.getOrder();
        this.completed = todoEntity.getCompleted();
        this.url = serviceUrl + this.id;
    }

}
