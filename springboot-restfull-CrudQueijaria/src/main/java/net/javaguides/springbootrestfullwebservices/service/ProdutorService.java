package net.javaguides.springbootrestfullwebservices.service;

import net.javaguides.springbootrestfullwebservices.entities.Produtor;

import java.util.List;

public interface ProdutorService {
    Produtor createProdutor(Produtor produtor);

    Produtor getProdutorById(Long produtorId);

    List<Produtor> getAllProdutor();

    Produtor updateProdutor(Produtor produtor);

    void deleteProdutor(Long produtorID);
}
