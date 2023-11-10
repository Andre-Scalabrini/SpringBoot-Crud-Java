package net.javaguides.springbootrestfullwebservices.service;

import net.javaguides.springbootrestfullwebservices.entities.Curso;

import java.util.List;

public interface CursoService {
    Curso createCurso(Curso curso);

    Curso getCursoById(Long cursoId);

    List<Curso> getAllCurso();

    Curso updateCurso(Curso curso);

    void deleteCurso(Long cursoID);

    interface LocalidadeService {
    }
}
