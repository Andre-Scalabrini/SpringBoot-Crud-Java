package net.javaguides.springbootrestfullwebservices.controller;


import lombok.AllArgsConstructor;
import net.javaguides.springbootrestfullwebservices.entities.Tecnologia;
import net.javaguides.springbootrestfullwebservices.service.TecnologiaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/tecnologia")
public class TecnologiaController {
    private TecnologiaService tecnologiaService;

    //build create Tecnologia REST API
    @PostMapping
    public ResponseEntity<Tecnologia> createTecnologia(@RequestBody Tecnologia tecnologia){
        Tecnologia savedTecnologia = tecnologiaService.createTecnologia(tecnologia);
        return new ResponseEntity<>(savedTecnologia, HttpStatus.CREATED);
    }

    // build get Tecnologia by id REST API
    // http://localhost:8080/api/tecnologia/1
    @GetMapping("{id}")
    public ResponseEntity<Tecnologia> getTecnologiaById(@PathVariable("id") Long tecnologiaId){
        Tecnologia tecnologia = tecnologiaService.getTecnologiaById(tecnologiaId);
        return new ResponseEntity<>(tecnologia, HttpStatus.OK);
    }

    // Build Get All Tecnologia REST API
    // http://localhost:8080/api/tecnologia
    @GetMapping
    public ResponseEntity<List<Tecnologia>> getAllTecnologia(){
        List<Tecnologia> tecnologia = tecnologiaService.getAllTecnologia();
        return new ResponseEntity<>(tecnologia, HttpStatus.OK);
    }

    // Build Update Tecnologia REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/tecnologia/1
    public ResponseEntity<Tecnologia> updateTecnologia(@PathVariable("id") Long tecnologiaId,
                                                         @RequestBody Tecnologia tecnologia){
        tecnologia.setId(tecnologiaId);
        Tecnologia updateTecnologia = tecnologiaService.updateTecnologia(tecnologia);
        return new ResponseEntity<>(updateTecnologia, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTecnologia(@PathVariable("id") Long tecnologiaId){
        tecnologiaService.deleteTecnologia(tecnologiaId);
        return new ResponseEntity<>("Tecnologia deletado com Sucesso!", HttpStatus.OK);
    }

}
