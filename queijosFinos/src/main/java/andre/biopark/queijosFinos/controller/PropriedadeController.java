package andre.biopark.queijosFinos.controller;
import lombok.AllArgsConstructor;
import andre.biopark.queijosFinos.entity.Propriedade;
import andre.biopark.queijosFinos.service.PropriedadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor
@RequestMapping("api/propriedades")

public class PropriedadeController {
    private PropriedadeService propriedadeService;

    // build create Propriedade REST API
    @PostMapping
    public ResponseEntity<Propriedade> createPropriedade(@RequestBody Propriedade propriedade){
        Propriedade savedPropriedade = propriedadeService.createPropriedade(propriedade);
        return new ResponseEntity<>(savedPropriedade, HttpStatus.CREATED);
    }

    // build get propriedade by id REST API
    // http://localhost:8080/api/propriedades/1
    @GetMapping("{id}")
    public ResponseEntity<Propriedade> getPropriedadeById(@PathVariable("id") Long propriedadeId){
        Propriedade propriedade = propriedadeService.getPropriedadeById(propriedadeId);
        return new ResponseEntity<>(propriedade, HttpStatus.OK);
    }

    // Build Get All Propriedades REST API
    // http://localhost:8080/api/propriedades
    @GetMapping
    public ResponseEntity<List<Propriedade>> getAllPropriedades(){
        List<Propriedade> propriedades = propriedadeService.getAllPropriedades();
        return new ResponseEntity<>(propriedades, HttpStatus.OK);
    }

    // Build Update Propriedade REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/propriedades/1
    public ResponseEntity<Propriedade> updatePropriedade(@PathVariable("id") Long propriedadeId,
                                                         @RequestBody Propriedade propriedade){
        propriedade.setId(propriedadeId);
        Propriedade updatedPropriedade = propriedadeService.updatePropriedade(propriedade);
        return new ResponseEntity<>(updatedPropriedade, HttpStatus.OK);
    }

    // Build Delete Propriedade REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePropriedade(@PathVariable("id") Long propriedadeId){
        propriedadeService.deletePropriedade(propriedadeId);
        return new ResponseEntity<>("Propriedade successfully deleted!", HttpStatus.OK);
    }


}
