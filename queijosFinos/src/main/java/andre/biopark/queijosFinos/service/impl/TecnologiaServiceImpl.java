package andre.biopark.queijosFinos.service.impl;

import andre.biopark.queijosFinos.repository.TecnologiaRepository;
import andre.biopark.queijosFinos.service.TecnologiaService;
import andre.biopark.queijosFinos.entity.Tecnologia;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@AllArgsConstructor
public class TecnologiaServiceImpl implements TecnologiaService {
    private TecnologiaRepository tecnologiaRepository;

    @Override
    public Tecnologia createTecnologia(Tecnologia tecnologia) {
        return tecnologiaRepository.save(tecnologia);
    }

    @Override
    public Tecnologia getTecnologiaById(Long tecnologiaId) {
        Optional<Tecnologia> optionalTecnologia = tecnologiaRepository.findById(tecnologiaId);
        return optionalTecnologia.get();
    }

    @Override
    public List<Tecnologia> getAllTecnologias() {
        return tecnologiaRepository.findAll();
    }

    @Override
    public Tecnologia updateTecnologia(Tecnologia tecnologia) {
        Tecnologia existingTecnologia = tecnologiaRepository.findById(tecnologia.getId()).get();
        existingTecnologia.setModoPreparo(tecnologia.getModoPreparo());
        existingTecnologia.setRacaBovina(tecnologia.getRacaBovina());
        existingTecnologia.setTipoQueijo(tecnologia.getTipoQueijo());
        Tecnologia updatedTecnologia = tecnologiaRepository.save(existingTecnologia);
        return updatedTecnologia;
    }

    @Override
    public void deleteTecnologia(Long tecnologiaId) {
        tecnologiaRepository.deleteById(tecnologiaId);
    }
}
