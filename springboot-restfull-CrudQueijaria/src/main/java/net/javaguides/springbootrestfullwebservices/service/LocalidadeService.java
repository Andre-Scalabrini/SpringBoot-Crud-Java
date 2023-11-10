package net.javaguides.springbootrestfullwebservices.service;

import net.javaguides.springbootrestfullwebservices.entities.Localidade;

import java.util.List;

public interface LocalidadeService {
    Localidade createLocalidade(Localidade localidade);

    Localidade getLocalidadeById(Long localidadeId);

    List<Localidade> getAllLocalidade();

    Localidade updateLocalidade(Localidade localidade);

    void deleteLocalidade(Long localidadeID);
}
