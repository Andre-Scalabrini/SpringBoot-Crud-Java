package andre.biopark.queijosFinos.controller;
import lombok.AllArgsConstructor;
import andre.biopark.queijosFinos.entity.Curso;
import andre.biopark.queijosFinos.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor
@RequestMapping("api/cursos")

public class CursoController {
    private CursoService cursoService;

    // build create Curso REST API
    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso){
        Curso savedCurso = cursoService.createCurso(curso);
        return new ResponseEntity<>(savedCurso, HttpStatus.CREATED);
    }

    // build get curso by id REST API
    // http://localhost:8080/api/cursos/1
    @GetMapping("{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable("id") Long cursoId){
        Curso curso = cursoService.getCursoById(cursoId);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    // Build Get All Cursos REST API
    // http://localhost:8080/api/cursos
    @GetMapping
    public ResponseEntity<List<Curso>> getAllCursos(){
        List<Curso> cursos = cursoService.getAllCursos();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    // Build Update Curso REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/cursos/1
    public ResponseEntity<Curso> updateCurso(@PathVariable("id") Long cursoId,
                                             @RequestBody Curso curso){
        curso.setId(cursoId);
        Curso updatedCurso = cursoService.updateCurso(curso);
        return new ResponseEntity<>(updatedCurso, HttpStatus.OK);
    }

    // Build Delete Curso REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCurso(@PathVariable("id") Long cursoId){
        cursoService.deleteCurso(cursoId);
        return new ResponseEntity<>("Curso successfully deleted!", HttpStatus.OK);
    }


}
