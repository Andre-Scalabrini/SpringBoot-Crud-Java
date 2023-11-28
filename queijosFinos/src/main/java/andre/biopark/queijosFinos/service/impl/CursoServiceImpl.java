package andre.biopark.queijosFinos.service.impl;

import andre.biopark.queijosFinos.repository.CursoRepository;
import andre.biopark.queijosFinos.service.CursoService;
import andre.biopark.queijosFinos.entity.Curso;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@AllArgsConstructor
public class CursoServiceImpl implements CursoService {
    private CursoRepository cursoRepository;

    @Override
    public Curso createCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso getCursoById(Long cursoId) {
        Optional<Curso> optionalCurso = cursoRepository.findById(cursoId);
        return optionalCurso.get();
    }

    @Override
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso updateCurso(Curso curso) {
        Curso existingCurso = cursoRepository.findById(curso.getId()).get();
        existingCurso.setNome(curso.getNome());
        existingCurso.setStatusCurso(curso.getStatusCurso());
        existingCurso.setInstrutor(curso.getInstrutor());
        existingCurso.setTipo(curso.getTipo());
        Curso updatedCurso = cursoRepository.save(existingCurso);
        return updatedCurso;
    }

    @Override
    public void deleteCurso(Long cursoId) {
        cursoRepository.deleteById(cursoId);
    }
}
