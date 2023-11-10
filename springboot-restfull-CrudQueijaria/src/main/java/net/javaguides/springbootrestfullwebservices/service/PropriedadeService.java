package net.javaguides.springbootrestfullwebservices.service;

import net.javaguides.springbootrestfullwebservices.entities.Propriedade;

import java.util.List;

public interface PropriedadeService {
    Propriedade createPropriedade(Propriedade propriedade);

    Propriedade getPropriedadeById(Long propriedadeId);

    List<Propriedade> getAllPropriedade();

    Propriedade updatePropriedade(Propriedade propriedade);

    void deletePropriedade(Long propriedadeID);
}
