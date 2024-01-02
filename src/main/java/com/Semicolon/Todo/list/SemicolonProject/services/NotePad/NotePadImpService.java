package com.Semicolon.Todo.list.SemicolonProject.services.NotePad;

import com.Semicolon.Todo.list.SemicolonProject.data.models.NotePad;
import com.Semicolon.Todo.list.SemicolonProject.data.repositories.NotePadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotePadImpService implements NotePadService{

    private final NotePadRepository notePadRepository;


    @Override
    public NotePad save(NotePad notePad) {
        return notePadRepository.save(notePad);
    }

    @Override
    public NotePad findByNotePadName(String notePadName) {
        return notePadRepository.findByNotePadName(notePadName);
    }


}
