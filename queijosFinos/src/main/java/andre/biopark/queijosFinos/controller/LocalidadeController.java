package andre.biopark.queijosFinos.controller;
import lombok.AllArgsConstructor;
import andre.biopark.queijosFinos.entity.Localidade;
import andre.biopark.queijosFinos.service.LocalidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor
@RequestMapping("api/localidades")

public class LocalidadeController {
    private LocalidadeService localidadeService;

    // build create Localidade REST API
    @PostMapping
    public ResponseEntity<Localidade> createLocalidade(@RequestBody Localidade localidade){
        Localidade savedLocalidade = localidadeService.createLocalidade(localidade);
        return new ResponseEntity<>(savedLocalidade, HttpStatus.CREATED);
    }

    // build get localidade by id REST API
    // http://localhost:8080/api/localidades/1
    @GetMapping("{id}")
    public ResponseEntity<Localidade> getLocalidadeById(@PathVariable("id") Long localidadeId){
        Localidade localidade = localidadeService.getLocalidadeById(localidadeId);
        return new ResponseEntity<>(localidade, HttpStatus.OK);
    }

    // Build Get All Localidades REST API
    // http://localhost:8080/api/localidades
    @GetMapping
    public ResponseEntity<List<Localidade>> getAllLocalidades(){
        List<Localidade> localidades = localidadeService.getAllLocalidades();
        return new ResponseEntity<>(localidades, HttpStatus.OK);
    }

    // Build Update Localidade REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/localidades/1
    public ResponseEntity<Localidade> updateLocalidade(@PathVariable("id") Long localidadeId,
                                                         @RequestBody Localidade localidade){
        localidade.setId(localidadeId);
        Localidade updatedLocalidade = localidadeService.updateLocalidade(localidade);
        return new ResponseEntity<>(updatedLocalidade, HttpStatus.OK);
    }

    // Build Delete Localidade REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLocalidade(@PathVariable("id") Long localidadeId){
        localidadeService.deleteLocalidade(localidadeId);
        return new ResponseEntity<>("Localidade successfully deleted!", HttpStatus.OK);
    }


}
