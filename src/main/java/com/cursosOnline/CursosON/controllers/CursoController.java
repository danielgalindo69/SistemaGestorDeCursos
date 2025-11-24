package com.cursosOnline.CursosON.controllers;


import com.cursosOnline.CursosON.models.Curso;
import com.cursosOnline.CursosON.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    public CursoService service;

    @GetMapping
    public List<Curso> obtenerCursos() {
        return service.obtenerCursos();
    }

    @PostMapping
    public Curso crearCurso(Curso curso) {
        return service.crearCurso(curso);
    }

    @PutMapping
    public Curso actualizarCurso(@RequestBody Curso curso, @PathVariable Long id) {
        return service.actualizarCurso(curso, id);
    }

    @DeleteMapping
    public void eliminarCurso(@RequestBody Curso curso, @PathVariable Long id) {
        service.eliminarCurso(curso, id);
    }
}
