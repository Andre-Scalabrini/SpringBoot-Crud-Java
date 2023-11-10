package net.javaguides.springbootrestfullwebservices.controller;


import lombok.AllArgsConstructor;
import net.javaguides.springbootrestfullwebservices.entities.Certificado;
import net.javaguides.springbootrestfullwebservices.service.CertificadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/certificado")
public class CertificadoController {
    private CertificadoService certificadoService;

    //build create Certificado REST API
    @PostMapping
    public ResponseEntity<Certificado> createCertificado(@RequestBody Certificado certificado){
        Certificado savedCertificado = certificadoService.createCertificado(certificado);
        return new ResponseEntity<>(savedCertificado, HttpStatus.CREATED);
    }

    // build get certificado by id REST API
    // http://localhost:8080/api/certificado/1
    @GetMapping("{id}")
    public ResponseEntity<Certificado> getCertificadoById(@PathVariable("id") Long certificadoId){
        Certificado certificado = certificadoService.getCertificadoById(certificadoId);
        return new ResponseEntity<>(certificado, HttpStatus.OK);
    }

    // Build Get All Certificados REST API
    // http://localhost:8080/api/certificado
    @GetMapping
    public ResponseEntity<List<Certificado>> getAllCertificado(){
        List<Certificado> certificado = certificadoService.getAllCertificado();
        return new ResponseEntity<>(certificado, HttpStatus.OK);
    }

    // Build Update Certificados REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/certificado/1
    public ResponseEntity<Certificado> updateCertificado(@PathVariable("id") Long certificadoId,
                                           @RequestBody Certificado certificado){
        certificado.setId(certificadoId);
        Certificado updateCertificado = certificadoService.updateCertificado(certificado);
        return new ResponseEntity<>(updateCertificado, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCertificado(@PathVariable("id") Long certificadoId){
        certificadoService.deleteCertificado(certificadoId);
        return new ResponseEntity<>("Certificado deletado com Sucesso!", HttpStatus.OK);
    }

}
