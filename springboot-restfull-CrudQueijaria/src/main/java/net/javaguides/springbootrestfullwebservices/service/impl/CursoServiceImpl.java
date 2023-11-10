package net.javaguides.springbootrestfullwebservices.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestfullwebservices.entities.Curso;
import net.javaguides.springbootrestfullwebservices.repository.CursoRepository;
import net.javaguides.springbootrestfullwebservices.service.CursoService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CursoServiceImpl implements CursoService{
    private CursoRepository cursoRepository;

    @Override
    public Curso createCurso(Curso curso){
        return cursoRepository.save(curso);
    }

    @Override
    public Curso getCursoById(Long cursoId){
        Optional<Curso> optionalCurso = cursoRepository.findById((long) cursoId);
        return optionalCurso.get();
    }

    @Override
    public List<Curso> getAllCurso(){
        return cursoRepository.findAll();
    }

    @Override
    public Curso updateCurso(Curso curso){
        Curso existingCurso = cursoRepository.findById(curso.getId()).get();
        existingCurso.setNome(curso.getNome());
        existingCurso.setTipo(curso.getTipo());
        existingCurso.setInstrutor(curso.getInstrutor());
        existingCurso.setStatusCurso(curso.getStatusCurso());
        Curso updatedCurso = cursoRepository.save(existingCurso);
        return updatedCurso;
    }

    @Override
    public void deleteCurso(Long cursoId){
        cursoRepository.deleteById((cursoId));
    }
}
