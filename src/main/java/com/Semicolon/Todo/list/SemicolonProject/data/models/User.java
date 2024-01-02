package com.Semicolon.Todo.list.SemicolonProject.data.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String phoneNumber;
    private  String emailAddress;
    private LocalDateTime createdAt;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private NotePad notePad;

}
