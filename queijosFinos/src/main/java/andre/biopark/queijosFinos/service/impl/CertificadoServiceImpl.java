package andre.biopark.queijosFinos.service.impl;

import andre.biopark.queijosFinos.repository.CertificadoRepository;
import andre.biopark.queijosFinos.service.CertificadoService;
import andre.biopark.queijosFinos.entity.Certificado;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@AllArgsConstructor
public class CertificadoServiceImpl implements CertificadoService {
    private CertificadoRepository certificadoRepository;

    @Override
    public Certificado createCertificado(Certificado certificado) {
        return certificadoRepository.save(certificado);
    }

    @Override
    public Certificado getCertificadoById(Long certificadoId) {
        Optional<Certificado> optionalCertificado = certificadoRepository.findById(certificadoId);
        return optionalCertificado.get();
    }

    @Override
    public List<Certificado> getAllCertificados() {
        return certificadoRepository.findAll();
    }

    @Override
    public Certificado updateCertificado(Certificado certificado) {
        Certificado existingCertificado = certificadoRepository.findById(certificado.getId()).get();
        existingCertificado.setNome(certificado.getNome());
        existingCertificado.setStatusCertificado(certificado.getStatusCertificado());
        existingCertificado.setAssinatura(certificado.getAssinatura());
        existingCertificado.setDataEmissao(certificado.getDataEmissao());
        Certificado updatedCertificado = certificadoRepository.save(existingCertificado);
        return updatedCertificado;
    }

    @Override
    public void deleteCertificado(Long certificadoId) {
        certificadoRepository.deleteById(certificadoId);
    }
}
