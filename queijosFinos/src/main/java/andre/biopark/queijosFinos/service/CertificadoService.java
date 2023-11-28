package andre.biopark.queijosFinos.service;

import andre.biopark.queijosFinos.entity.Certificado;

import java.util.List;

public interface CertificadoService {
    Certificado createCertificado(Certificado certificado);

    Certificado getCertificadoById(Long certificadoId);

    List<Certificado> getAllCertificados();

    Certificado updateCertificado(Certificado certificado);

    void deleteCertificado(Long certificadoId);
}
