package net.javaguides.springbootrestfullwebservices.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestfullwebservices.entities.Propriedade;
import net.javaguides.springbootrestfullwebservices.repository.PropriedadeRepository;
import net.javaguides.springbootrestfullwebservices.service.PropriedadeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class PropriedadeServiceImpl implements PropriedadeService{
    private PropriedadeRepository propriedadeRepository;

    @Override
    public Propriedade createPropriedade(Propriedade propriedade){
        return propriedadeRepository.save(propriedade);
    }

    @Override
    public Propriedade getPropriedadeById(Long propriedadeId){
        Optional<Propriedade> optionalPropriedade = propriedadeRepository.findById((long) propriedadeId);
        return optionalPropriedade.get();
    }

    @Override
    public List<Propriedade> getAllPropriedade(){
        return propriedadeRepository.findAll();
    }


    @Override
    public Propriedade updatePropriedade(Propriedade propriedade){
        Propriedade existingPropriedade = propriedadeRepository.findById(propriedade.getId()).get();
        existingPropriedade.setNome(propriedade.getNome());
        existingPropriedade.setDataRecebimentoCertificado(propriedade.getDataRecebimentoCertificado());
        existingPropriedade.setQtdleite(propriedade.getQtdleite());
        existingPropriedade.setProxVisita(propriedade.getProxVisita());
        existingPropriedade.setDataVencimentoContrato(propriedade.getDataVencimentoContrato());
        existingPropriedade.setStatusAprovacao(propriedade.getStatusAprovacao());
        existingPropriedade.setTecnologiasUsadas(propriedade.getTecnologiasUsadas());
        existingPropriedade.setUltimaVisita(propriedade.getUltimaVisita());
        Propriedade updatedPropriedade = propriedadeRepository.save(existingPropriedade);
        return updatedPropriedade;
    }

    @Override
    public void deletePropriedade(Long propriedadeId){
        propriedadeRepository.deleteById((propriedadeId));
    }
}
