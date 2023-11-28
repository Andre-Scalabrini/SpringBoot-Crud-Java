package andre.biopark.queijosFinos.service;

import andre.biopark.queijosFinos.entity.Curso;

import java.util.List;

public interface CursoService {
    Curso createCurso(Curso curso);

    Curso getCursoById(Long cursoId);

    List<Curso> getAllCursos();

    Curso updateCurso(Curso curso);

    void deleteCurso(Long cursoId);
}
