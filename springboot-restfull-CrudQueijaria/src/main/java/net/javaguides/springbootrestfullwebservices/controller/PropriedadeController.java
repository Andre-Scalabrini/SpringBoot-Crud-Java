package net.javaguides.springbootrestfullwebservices.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestfullwebservices.entities.Propriedade;
import net.javaguides.springbootrestfullwebservices.service.PropriedadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/propriedade")

public class PropriedadeController {
    private PropriedadeService propriedadeService;

    //build create Propriedade REST API
    @PostMapping
    public ResponseEntity<Propriedade> createPropriedade(@RequestBody Propriedade propriedade){
        Propriedade savedPropriedade = propriedadeService.createPropriedade(propriedade);
        return new ResponseEntity<>(savedPropriedade, HttpStatus.CREATED);
    }

    // build get Propriedade by id REST API
    // http://localhost:8080/api/propriedade/1
    @GetMapping("{id}")
    public ResponseEntity<Propriedade> getPropriedadeById(@PathVariable("id") Long propriedadeId){
        Propriedade propriedade = propriedadeService.getPropriedadeById(propriedadeId);
        return new ResponseEntity<>(propriedade, HttpStatus.OK);
    }

    // Build Get All Propriedade REST API
    // http://localhost:8080/api/propriedade
    @GetMapping
    public ResponseEntity<List<Propriedade>> getAllPropriedade(){
        List<Propriedade> propriedade = propriedadeService.getAllPropriedade();
        return new ResponseEntity<>(propriedade, HttpStatus.OK);
    }

    // Build Update Propriedade REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/propriedade/1
    public ResponseEntity<Propriedade> updatepropriedade(@PathVariable("id") Long propriedadeId,
                                                   @RequestBody Propriedade propriedade){
        propriedade.setId(propriedadeId);
        Propriedade updatePropriedade = propriedadeService.updatePropriedade(propriedade);
        return new ResponseEntity<>(updatePropriedade, HttpStatus.OK);
    }

    // Build Delete propriedade REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePropriedade(@PathVariable("id") Long propriedadeId){
        propriedadeService.deletePropriedade(propriedadeId);
        return new ResponseEntity<>("Propriedade deletado com Sucesso!", HttpStatus.OK);
    }
}
