package com.cursosOnline.CursosON.repository;

import com.cursosOnline.CursosON.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepository extends JpaRepository<Curso, Long> {
}
