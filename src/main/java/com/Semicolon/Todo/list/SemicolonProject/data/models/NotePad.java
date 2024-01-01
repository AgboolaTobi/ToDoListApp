package com.Semicolon.Todo.list.SemicolonProject.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class NotePad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String notePadName;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<ToDoTask> tasks;

}
