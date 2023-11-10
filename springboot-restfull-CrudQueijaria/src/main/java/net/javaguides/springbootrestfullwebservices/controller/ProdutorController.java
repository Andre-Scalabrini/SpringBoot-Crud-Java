package net.javaguides.springbootrestfullwebservices.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestfullwebservices.entities.Produtor;
import net.javaguides.springbootrestfullwebservices.service.ProdutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/produtor")

public class ProdutorController {
    private ProdutorService produtorService;

    //build create Produtor REST API
    @PostMapping
    public ResponseEntity<Produtor> createProdutor(@RequestBody Produtor produtor){
        Produtor savedProdutor = produtorService.createProdutor(produtor);
        return new ResponseEntity<>(savedProdutor, HttpStatus.CREATED);
    }

    // build get Produtor by id REST API
    // http://localhost:8080/api/produtor/1
    @GetMapping("{id}")
    public ResponseEntity<Produtor> getProdutorById(@PathVariable("id") Long produtorId){
        Produtor produtor = produtorService.getProdutorById(produtorId);
        return new ResponseEntity<>(produtor, HttpStatus.OK);
    }

    // Build Get All Produtor REST API
    // http://localhost:8080/api/produtor
    @GetMapping
    public ResponseEntity<List<Produtor>> getAllProdutor(){
        List<Produtor> produtor = produtorService.getAllProdutor();
        return new ResponseEntity<>(produtor, HttpStatus.OK);
    }

    // Build Update Produtor REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/produtor/1
    public ResponseEntity<Produtor> updateprodutor(@PathVariable("id") Long produtorId,
                                                       @RequestBody Produtor produtor){
        produtor.setId(produtorId);
        Produtor updateProdutor = produtorService.updateProdutor(produtor);
        return new ResponseEntity<>(updateProdutor, HttpStatus.OK);
    }

    // Build Delete produtor REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProdutor(@PathVariable("id") Long produtorId){
        produtorService.deleteProdutor(produtorId);
        return new ResponseEntity<>("Produtor deletado com Sucesso!", HttpStatus.OK);
    }

}
