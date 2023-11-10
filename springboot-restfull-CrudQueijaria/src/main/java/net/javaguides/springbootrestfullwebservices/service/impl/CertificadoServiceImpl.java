package net.javaguides.springbootrestfullwebservices.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestfullwebservices.entities.Certificado;
import net.javaguides.springbootrestfullwebservices.repository.CertificadoRepository;
import net.javaguides.springbootrestfullwebservices.service.CertificadoService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CertificadoServiceImpl implements CertificadoService{

    private CertificadoRepository certificadoRepository;

    @Override
    public Certificado createCertificado(Certificado certificado){
        return certificadoRepository.save(certificado);
    }

    @Override
    public Certificado getCertificadoById(Long certificadoId){
        Optional<Certificado> optionalCertificado = certificadoRepository.findById((long) certificadoId);
        return optionalCertificado.get();
    }

    @Override
    public List<Certificado> getAllCertificado(){
        return certificadoRepository.findAll();
    }

    @Override
    public Certificado updateCertificado(Certificado certificado){
        Certificado existingCertificado = certificadoRepository.findById(certificado.getId()).get();
        existingCertificado.setNome(certificado.getNome());
        existingCertificado.setAssinatura(certificado.getAssinatura());
        existingCertificado.setDataEmissao(certificado.getDataEmissao());
        existingCertificado.setStatusCertificado(certificado.getStatusCertificado());
        Certificado updatedCertificado = certificadoRepository.save(existingCertificado);
        return updatedCertificado;
    }

    @Override
    public void deleteCertificado(Long certificadoId){
        certificadoRepository.deleteById((certificadoId));
    }
}
