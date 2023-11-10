package net.javaguides.springbootrestfullwebservices.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestfullwebservices.entities.Curso;
import net.javaguides.springbootrestfullwebservices.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/curso")

public class CursoController {
    private CursoService cursoService;

    //build create Curso REST API
    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso){
        Curso savedCurso = cursoService.createCurso(curso);
        return new ResponseEntity<>(savedCurso, HttpStatus.CREATED);
    }

    // build get curso by id REST API
    // http://localhost:8080/api/curso/1
    @GetMapping("{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable("id") Long cursoId){
        Curso curso = cursoService.getCursoById(cursoId);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    // Build Get All curso REST API
    // http://localhost:8080/api/certificado
    @GetMapping
    public ResponseEntity<List<Curso>> getAllCurso(){
        List<Curso> curso = cursoService.getAllCurso();
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    // Build Update Curso REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/curso/1
    public ResponseEntity<Curso> updateCurso(@PathVariable("id") Long cursoId,
                                                         @RequestBody Curso curso){
        curso.setId(cursoId);
        Curso updateCurso = cursoService.updateCurso(curso);
        return new ResponseEntity<>(updateCurso, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCurso(@PathVariable("id") Long cursoId){
        cursoService.deleteCurso(cursoId);
        return new ResponseEntity<>("Curso deletado com Sucesso!", HttpStatus.OK);
    }
}
