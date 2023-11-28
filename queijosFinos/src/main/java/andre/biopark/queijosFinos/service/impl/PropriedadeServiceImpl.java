package andre.biopark.queijosFinos.service.impl;

import andre.biopark.queijosFinos.repository.PropriedadeRepository;
import andre.biopark.queijosFinos.service.PropriedadeService;
import andre.biopark.queijosFinos.entity.Propriedade;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@AllArgsConstructor
public class PropriedadeServiceImpl implements PropriedadeService {
    private PropriedadeRepository propriedadeRepository;

    @Override
    public Propriedade createPropriedade(Propriedade propriedade) {
        return propriedadeRepository.save(propriedade);
    }

    @Override
    public Propriedade getPropriedadeById(Long propriedadeId) {
        Optional<Propriedade> optionalPropriedade = propriedadeRepository.findById(propriedadeId);
        return optionalPropriedade.get();
    }

    @Override
    public List<Propriedade> getAllPropriedades() {
        return propriedadeRepository.findAll();
    }

    @Override
    public Propriedade updatePropriedade(Propriedade propriedade) {
        Propriedade existingPropriedade = propriedadeRepository.findById(propriedade.getId()).get();
        existingPropriedade.setNome(propriedade.getNome());
        existingPropriedade.setQtdleite(propriedade.getQtdleite());
        existingPropriedade.setStatusAprovacao(propriedade.getStatusAprovacao());
        existingPropriedade.setTecnologiasUsadas(propriedade.getTecnologiasUsadas());
        Propriedade updatedPropriedade = propriedadeRepository.save(existingPropriedade);
        return updatedPropriedade;
    }

    @Override
    public void deletePropriedade(Long propriedadeId) {
        propriedadeRepository.deleteById(propriedadeId);
    }
}
