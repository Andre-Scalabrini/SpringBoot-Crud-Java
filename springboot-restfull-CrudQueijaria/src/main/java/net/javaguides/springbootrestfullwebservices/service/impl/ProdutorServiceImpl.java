package net.javaguides.springbootrestfullwebservices.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestfullwebservices.entities.Produtor;
import net.javaguides.springbootrestfullwebservices.repository.ProdutorRepository;
import net.javaguides.springbootrestfullwebservices.service.ProdutorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutorServiceImpl implements ProdutorService{
    private ProdutorRepository produtorRepository;

    @Override
    public Produtor createProdutor(Produtor produtor){
        return produtorRepository.save(produtor);
    }

    @Override
    public Produtor getProdutorById(Long produtorId){
        Optional<Produtor> optionalProdutor = produtorRepository.findById((long) produtorId);
        return optionalProdutor.get();
    }

    @Override
    public List<Produtor> getAllProdutor(){
        return produtorRepository.findAll();
    }


    @Override
    public Produtor updateProdutor(Produtor produtor){
        Produtor existingProdutor = produtorRepository.findById(produtor.getId()).get();
        existingProdutor.setNome(produtor.getNome());
        existingProdutor.setCnpj(produtor.getCnpj());
        existingProdutor.setSituacao(produtor.getSituacao());
        Produtor updatedProdutor = produtorRepository.save(existingProdutor);
        return updatedProdutor;
    }

    @Override
    public void deleteProdutor(Long produtorId){
        produtorRepository.deleteById((produtorId));
    }
}
