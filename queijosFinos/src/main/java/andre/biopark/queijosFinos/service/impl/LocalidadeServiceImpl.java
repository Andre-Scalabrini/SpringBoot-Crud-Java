package andre.biopark.queijosFinos.service.impl;

import andre.biopark.queijosFinos.repository.LocalidadeRepository;
import andre.biopark.queijosFinos.service.LocalidadeService;
import andre.biopark.queijosFinos.entity.Localidade;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@AllArgsConstructor
public class LocalidadeServiceImpl implements LocalidadeService {
    private LocalidadeRepository localidadeRepository;

    @Override
    public Localidade createLocalidade(Localidade localidade) {
        return localidadeRepository.save(localidade);
    }

    @Override
    public Localidade getLocalidadeById(Long localidadeId) {
        Optional<Localidade> optionalLocalidade = localidadeRepository.findById(localidadeId);
        return optionalLocalidade.get();
    }

    @Override
    public List<Localidade> getAllLocalidades() {
        return localidadeRepository.findAll();
    }

    @Override
    public Localidade updateLocalidade(Localidade localidade) {
        Localidade existingLocalidade = localidadeRepository.findById(localidade.getId()).get();
        existingLocalidade.setCidade(localidade.getCidade());
        existingLocalidade.setEstado(localidade.getEstado());
        existingLocalidade.setNomeEstrada(localidade.getNomeEstrada());
        existingLocalidade.setNumero(localidade.getNumero());
        Localidade updatedLocalidade = localidadeRepository.save(existingLocalidade);
        return updatedLocalidade;
    }

    @Override
    public void deleteLocalidade(Long localidadeId) {
        localidadeRepository.deleteById(localidadeId);
    }
}
