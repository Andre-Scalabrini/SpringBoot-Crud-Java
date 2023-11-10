package net.javaguides.springbootrestfullwebservices.repository;

import net.javaguides.springbootrestfullwebservices.entities.Produtor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutorRepository extends JpaRepository<Produtor, Long> {
}
