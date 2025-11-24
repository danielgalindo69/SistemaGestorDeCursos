package com.cursosOnline.CursosON.service;

import com.cursosOnline.CursosON.repository.ICategoriaRepository;
import com.cursosOnline.CursosON.repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    public ICursoRepository cursoRepository;

    @Autowired
    public ICategoriaRepository categoriaRepository;
}
