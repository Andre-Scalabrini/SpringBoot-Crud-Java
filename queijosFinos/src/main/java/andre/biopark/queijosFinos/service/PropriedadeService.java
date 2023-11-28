package andre.biopark.queijosFinos.service;

import andre.biopark.queijosFinos.entity.Propriedade;

import java.util.List;

public interface PropriedadeService {
    Propriedade createPropriedade(Propriedade Propriedade);

    Propriedade getPropriedadeById(Long PropriedadeId);

    List<Propriedade> getAllPropriedades();

    Propriedade updatePropriedade(Propriedade Propriedade);

    void deletePropriedade(Long PropriedadeId);
}
