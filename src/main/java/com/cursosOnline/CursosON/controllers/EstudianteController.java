package com.cursosOnline.CursosON.controllers;

import com.cursosOnline.CursosON.models.Estudiante;
import com.cursosOnline.CursosON.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    public EstudianteService service;

    @GetMapping
    public Estudiante registrarEstudiante(Estudiante estudiante){
        return service.registrarEstudiante(estudiante);
    }

    @PostMapping
    public Estudiante registrarEstudiantePost(Estudiante estudiante){
        return service.registrarEstudiante(estudiante);
    }

    @DeleteMapping("/{id}")

    public void elimirnarEstudiante(@PathVariable Long id){
        service.eliminarEstududiante(id);
    }

    @PutMapping("/{id}")
    public Estudiante actualizarEstudiante(@RequestBody Estudiante estudiante, @PathVariable Long id) {
        return service.actualizarEstudiante(estudiante, id);
    }



}
