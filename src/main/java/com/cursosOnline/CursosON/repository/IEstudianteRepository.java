package com.cursosOnline.CursosON.repository;

import com.cursosOnline.CursosON.models.Categoria;
import com.cursosOnline.CursosON.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IEstudianteRepository extends JpaRepository<Estudiante, Long> {
    Optional<Estudiante> findByEmail(String email);
    boolean existsByEmail(String email);
}
