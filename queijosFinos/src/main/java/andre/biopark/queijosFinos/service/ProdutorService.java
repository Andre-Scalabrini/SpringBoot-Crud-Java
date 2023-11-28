package andre.biopark.queijosFinos.service;

import andre.biopark.queijosFinos.entity.Produtor;

import java.util.List;

public interface ProdutorService {
    Produtor createProdutor(Produtor produtor);

    Produtor getProdutorById(Long produtorId);

    List<Produtor> getAllProdutors();

    Produtor updateProdutor(Produtor produtor);

    void deleteProdutor(Long produtorId);
}
