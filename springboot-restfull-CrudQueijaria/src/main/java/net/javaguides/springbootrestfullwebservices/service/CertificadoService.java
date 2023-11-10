package net.javaguides.springbootrestfullwebservices.service;

import net.javaguides.springbootrestfullwebservices.entities.Certificado;

import java.util.List;

public interface CertificadoService {
    Certificado createCertificado(Certificado certificado);

    Certificado getCertificadoById(Long certificadoId);

    List<Certificado> getAllCertificado();

    Certificado updateCertificado(Certificado certificado);

    void deleteCertificado(Long certificadoID);
}
