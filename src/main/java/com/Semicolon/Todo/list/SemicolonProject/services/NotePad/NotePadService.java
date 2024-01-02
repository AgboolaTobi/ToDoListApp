package com.Semicolon.Todo.list.SemicolonProject.services.NotePad;

import com.Semicolon.Todo.list.SemicolonProject.data.models.NotePad;

public interface NotePadService {

    NotePad save(NotePad notePad);

    NotePad findByNotePadName(String notePadName);
}
