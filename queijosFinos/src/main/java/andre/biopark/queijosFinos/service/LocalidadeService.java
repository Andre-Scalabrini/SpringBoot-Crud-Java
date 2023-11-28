package andre.biopark.queijosFinos.service;

import andre.biopark.queijosFinos.entity.Localidade;

import java.util.List;

public interface LocalidadeService {
    Localidade createLocalidade(Localidade localidade);

    Localidade getLocalidadeById(Long localidadeId);

    List<Localidade> getAllLocalidades();

    Localidade updateLocalidade(Localidade localidade);

    void deleteLocalidade(Long localidadeId);
}

