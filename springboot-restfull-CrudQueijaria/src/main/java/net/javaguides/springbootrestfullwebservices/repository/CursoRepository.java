package net.javaguides.springbootrestfullwebservices.repository;

import net.javaguides.springbootrestfullwebservices.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
