package net.javaguides.springbootrestfullwebservices.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestfullwebservices.entities.Tecnologia;
import net.javaguides.springbootrestfullwebservices.repository.TecnologiaRepository;
import net.javaguides.springbootrestfullwebservices.service.TecnologiaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TecnologiaServiceImpl implements TecnologiaService {

    private TecnologiaRepository tecnologiaRepository;

    @Override
    public Tecnologia createTecnologia(Tecnologia tecnologia){
        return tecnologiaRepository.save(tecnologia);
    }

    @Override
    public Tecnologia getTecnologiaById(Long tecnologiaId){
        Optional<Tecnologia> optionalTecnologia = tecnologiaRepository.findById((long) tecnologiaId);
        return optionalTecnologia.get();
    }

    @Override
    public List<Tecnologia> getAllTecnologia(){
        return tecnologiaRepository.findAll();
    }

    @Override
    public Tecnologia updateTecnologia(Tecnologia tecnologia){
        Tecnologia existingTecnologia = tecnologiaRepository.findById(tecnologia.getId()).get();
        existingTecnologia.setTipoQueijo(tecnologia.getTipoQueijo());
        existingTecnologia.setModoPreparo(tecnologia.getModoPreparo());
        existingTecnologia.setProcessoUtilizado(tecnologia.getProcessoUtilizado());
        Tecnologia updatedTecnologia = tecnologiaRepository.save(existingTecnologia);
        return updatedTecnologia;
    }

    @Override
    public void deleteTecnologia(Long tecnologiaId){
        tecnologiaRepository.deleteById((tecnologiaId));
    }
}
