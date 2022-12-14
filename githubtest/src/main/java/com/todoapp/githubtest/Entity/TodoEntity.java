package com.todoapp.githubtest.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {

    @Id
    @GeneratedValue
    private Long Id;

    @Column(nullable = false)
    private String title;

    @Column(name = "seq", nullable = false)
    private Long order;

    @Column(nullable = false)
    private Boolean completed;
}
