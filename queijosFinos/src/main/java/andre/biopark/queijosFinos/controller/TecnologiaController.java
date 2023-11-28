package andre.biopark.queijosFinos.controller;
import lombok.AllArgsConstructor;
import andre.biopark.queijosFinos.entity.Tecnologia;
import andre.biopark.queijosFinos.service.TecnologiaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor
@RequestMapping("api/tecnologias")

public class TecnologiaController {
    private TecnologiaService tecnologiaService;

    // build create Tecnologia REST API
    @PostMapping
    public ResponseEntity<Tecnologia> createTecnologia(@RequestBody Tecnologia tecnologia){
        Tecnologia savedTecnologia = tecnologiaService.createTecnologia(tecnologia);
        return new ResponseEntity<>(savedTecnologia, HttpStatus.CREATED);
    }

    // build get tecnologia by id REST API
    // http://localhost:8080/api/tecnologias/1
    @GetMapping("{id}")
    public ResponseEntity<Tecnologia> getTecnologiaById(@PathVariable("id") Long tecnologiaId){
        Tecnologia tecnologia = tecnologiaService.getTecnologiaById(tecnologiaId);
        return new ResponseEntity<>(tecnologia, HttpStatus.OK);
    }

    // Build Get All Tecnologias REST API
    // http://localhost:8080/api/tecnologias
    @GetMapping
    public ResponseEntity<List<Tecnologia>> getAllTecnologias(){
        List<Tecnologia> tecnologias = tecnologiaService.getAllTecnologias();
        return new ResponseEntity<>(tecnologias, HttpStatus.OK);
    }

    // Build Update Tecnologia REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/tecnologias/1
    public ResponseEntity<Tecnologia> updateTecnologia(@PathVariable("id") Long tecnologiaId,
                                                         @RequestBody Tecnologia tecnologia){
        tecnologia.setId(tecnologiaId);
        Tecnologia updatedTecnologia = tecnologiaService.updateTecnologia(tecnologia);
        return new ResponseEntity<>(updatedTecnologia, HttpStatus.OK);
    }

    // Build Delete Tecnologia REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTecnologia(@PathVariable("id") Long tecnologiaId){
        tecnologiaService.deleteTecnologia(tecnologiaId);
        return new ResponseEntity<>("Tecnologia successfully deleted!", HttpStatus.OK);
    }


}
