package andre.biopark.queijosFinos.controller;
import lombok.AllArgsConstructor;
import andre.biopark.queijosFinos.entity.Produtor;
import andre.biopark.queijosFinos.service.ProdutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor
@RequestMapping("api/produtores")

public class ProdutorController {
    private ProdutorService produtorService;

    // build create Produtor REST API
    @PostMapping
    public ResponseEntity<Produtor> createProdutor(@RequestBody Produtor produtor){
        Produtor savedProdutor = produtorService.createProdutor(produtor);
        return new ResponseEntity<>(savedProdutor, HttpStatus.CREATED);
    }

    // build get produtor by id REST API
    // http://localhost:8080/api/produtors/1
    @GetMapping("{id}")
    public ResponseEntity<Produtor> getProdutorById(@PathVariable("id") Long produtorId){
        Produtor produtor = produtorService.getProdutorById(produtorId);
        return new ResponseEntity<>(produtor, HttpStatus.OK);
    }

    // Build Get All Produtors REST API
    // http://localhost:8080/api/produtors
    @GetMapping
    public ResponseEntity<List<Produtor>> getAllProdutors(){
        List<Produtor> produtors = produtorService.getAllProdutors();
        return new ResponseEntity<>(produtors, HttpStatus.OK);
    }

    // Build Update Produtor REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/produtors/1
    public ResponseEntity<Produtor> updateProdutor(@PathVariable("id") Long produtorId,
                                           @RequestBody Produtor produtor){
        produtor.setId(produtorId);
        Produtor updatedProdutor = produtorService.updateProdutor(produtor);
        return new ResponseEntity<>(updatedProdutor, HttpStatus.OK);
    }

    // Build Delete Produtor REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProdutor(@PathVariable("id") Long produtorId){
        produtorService.deleteProdutor(produtorId);
        return new ResponseEntity<>("Produtor successfully deleted!", HttpStatus.OK);
    }


}
