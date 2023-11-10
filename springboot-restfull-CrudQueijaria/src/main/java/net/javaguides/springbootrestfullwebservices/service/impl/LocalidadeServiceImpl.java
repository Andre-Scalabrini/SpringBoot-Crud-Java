package net.javaguides.springbootrestfullwebservices.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestfullwebservices.entities.Localidade;
import net.javaguides.springbootrestfullwebservices.repository.LocalidadeRepository;
import net.javaguides.springbootrestfullwebservices.service.LocalidadeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class LocalidadeServiceImpl implements LocalidadeService{
    private LocalidadeRepository localidadeRepository;

    @Override
    public Localidade createLocalidade(Localidade localidade){
        return localidadeRepository.save(localidade);
    }

    @Override
    public Localidade getLocalidadeById(Long localidadeId){
        Optional<Localidade> optionalLocalidade = localidadeRepository.findById((long) localidadeId);
        return optionalLocalidade.get();
    }

    @Override
    public List<Localidade> getAllLocalidade(){
        return localidadeRepository.findAll();
    }

    @Override
    public Localidade updateLocalidade(Localidade localidade){
        Localidade existingLocalidade = localidadeRepository.findById(localidade.getId()).get();
        existingLocalidade.setCidade(localidade.getCidade());
        existingLocalidade.setEstado(localidade.getEstado());
        existingLocalidade.setNomeEstrada(localidade.getNomeEstrada());
        existingLocalidade.setLatitude(localidade.getLatitude());
        existingLocalidade.setLongitude(localidade.getLongitude());
        existingLocalidade.setNumero(localidade.getNumero());
        Localidade updatedLocalidade = localidadeRepository.save(existingLocalidade);
        return updatedLocalidade;
    }

    @Override
    public void deleteLocalidade(Long localidadeId){
        localidadeRepository.deleteById((localidadeId));
    }
}
