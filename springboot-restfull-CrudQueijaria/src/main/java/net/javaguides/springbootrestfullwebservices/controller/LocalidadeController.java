package net.javaguides.springbootrestfullwebservices.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestfullwebservices.entities.Localidade;
import net.javaguides.springbootrestfullwebservices.service.LocalidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/localidade")

public class LocalidadeController {
    private LocalidadeService localidadeService;

    //build create Localidade REST API
    @PostMapping
    public ResponseEntity<Localidade> createLocalidade(@RequestBody Localidade localidade){
        Localidade savedLocalidade = localidadeService.createLocalidade(localidade);
        return new ResponseEntity<>(savedLocalidade, HttpStatus.CREATED);
    }

    // build get Localidade by id REST API
    // http://localhost:8080/api/localidade/1
    @GetMapping("{id}")
    public ResponseEntity<Localidade> getLocalidadeById(@PathVariable("id") Long localidadeId){
        Localidade localidade = localidadeService.getLocalidadeById(localidadeId);
        return new ResponseEntity<>(localidade, HttpStatus.OK);
    }

    // Build Get All Localidade REST API
    // http://localhost:8080/api/localidade
    @GetMapping
    public ResponseEntity<List<Localidade>> getAllLocalidade(){
        List<Localidade> localidade = localidadeService.getAllLocalidade();
        return new ResponseEntity<>(localidade, HttpStatus.OK);
    }

    // Build Update Localidade REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/localidade/1
    public ResponseEntity<Localidade> updatelocalidade(@PathVariable("id") Long localidadeId,
                                                   @RequestBody Localidade localidade){
        localidade.setId(localidadeId);
        Localidade updateLocalidade = localidadeService.updateLocalidade(localidade);
        return new ResponseEntity<>(updateLocalidade, HttpStatus.OK);
    }

    // Build Delete localidade REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLocalidade(@PathVariable("id") Long localidadeId){
        localidadeService.deleteLocalidade(localidadeId);
        return new ResponseEntity<>("Localidade deletado com Sucesso!", HttpStatus.OK);
    }
}
