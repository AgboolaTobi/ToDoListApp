package com.Semicolon.Todo.list.SemicolonProject.data.repositories;

import com.Semicolon.Todo.list.SemicolonProject.data.models.NotePad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotePadRepository extends JpaRepository<NotePad, Long> {
}
