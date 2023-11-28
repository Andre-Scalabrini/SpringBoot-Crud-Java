package andre.biopark.queijosFinos.controller;
import lombok.AllArgsConstructor;
import andre.biopark.queijosFinos.entity.Certificado;
import andre.biopark.queijosFinos.service.CertificadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor
@RequestMapping("api/certificados")

public class CertificadoController {
    private CertificadoService certificadoService;

    // build create Certificado REST API
    @PostMapping
    public ResponseEntity<Certificado> createCertificado(@RequestBody Certificado certificado){
        Certificado savedCertificado = certificadoService.createCertificado(certificado);
        return new ResponseEntity<>(savedCertificado, HttpStatus.CREATED);
    }

    // build get certificado by id REST API
    // http://localhost:8080/api/certificados/1
    @GetMapping("{id}")
    public ResponseEntity<Certificado> getCertificadoById(@PathVariable("id") Long certificadoId){
        Certificado certificado = certificadoService.getCertificadoById(certificadoId);
        return new ResponseEntity<>(certificado, HttpStatus.OK);
    }

    // Build Get All Certificados REST API
    // http://localhost:8080/api/certificados
    @GetMapping
    public ResponseEntity<List<Certificado>> getAllCertificados(){
        List<Certificado> certificados = certificadoService.getAllCertificados();
        return new ResponseEntity<>(certificados, HttpStatus.OK);
    }

    // Build Update Certificado REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/certificados/1
    public ResponseEntity<Certificado> updateCertificado(@PathVariable("id") Long certificadoId,
                                                   @RequestBody Certificado certificado){
        certificado.setId(certificadoId);
        Certificado updatedCertificado = certificadoService.updateCertificado(certificado);
        return new ResponseEntity<>(updatedCertificado, HttpStatus.OK);
    }

    // Build Delete Certificado REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCertificado(@PathVariable("id") Long certificadoId){
        certificadoService.deleteCertificado(certificadoId);
        return new ResponseEntity<>("Certificado successfully deleted!", HttpStatus.OK);
    }


}
