package andre.biopark.queijosFinos.service;

import andre.biopark.queijosFinos.entity.Tecnologia;

import java.util.List;

public interface TecnologiaService {
    Tecnologia createTecnologia(Tecnologia tecnologia);

    Tecnologia getTecnologiaById(Long tecnologiaId);

    List<Tecnologia> getAllTecnologias();

    Tecnologia updateTecnologia(Tecnologia tecnologia);

    void deleteTecnologia(Long tecnologiaId);
}
