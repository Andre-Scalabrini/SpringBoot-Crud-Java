package andre.biopark.queijosFinos.service.impl;

import andre.biopark.queijosFinos.repository.ProdutorRepository;
import andre.biopark.queijosFinos.service.ProdutorService;
import andre.biopark.queijosFinos.entity.Produtor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@AllArgsConstructor
public class ProdutorServiceImpl implements ProdutorService {
    private ProdutorRepository produtorRepository;

    @Override
    public Produtor createProdutor(Produtor produtor) {
        return produtorRepository.save(produtor);
    }

    @Override
    public Produtor getProdutorById(Long produtorId) {
        Optional<Produtor> optionalProdutor = produtorRepository.findById(produtorId);
        return optionalProdutor.get();
    }

    @Override
    public List<Produtor> getAllProdutors() {
        return produtorRepository.findAll();
    }

    @Override
    public Produtor updateProdutor(Produtor produtor) {
        Produtor existingProdutor = produtorRepository.findById(produtor.getId()).get();
        existingProdutor.setNome(produtor.getNome());
        existingProdutor.setCnpj(produtor.getCnpj());
        existingProdutor.setSituacao(produtor.getSituacao());
        Produtor updatedProdutor = produtorRepository.save(existingProdutor);
        return updatedProdutor;
    }

    @Override
    public void deleteProdutor(Long produtorId) {
        produtorRepository.deleteById(produtorId);
    }
}
