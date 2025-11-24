package com.cursosOnline.CursosON.repository;

import com.cursosOnline.CursosON.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {
}
