package net.javaguides.springbootrestfullwebservices.service;

import net.javaguides.springbootrestfullwebservices.entities.Tecnologia;

import java.util.List;

public interface TecnologiaService {
    Tecnologia createTecnologia(Tecnologia tecnologia);

    Tecnologia getTecnologiaById(Long tecnologiaId);

    List<Tecnologia> getAllTecnologia();

    Tecnologia updateTecnologia(Tecnologia tecnologia);

    void deleteTecnologia(Long tecnologiaID);
}
