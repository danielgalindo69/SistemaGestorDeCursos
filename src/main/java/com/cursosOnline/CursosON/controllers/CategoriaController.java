package com.cursosOnline.CursosON.controllers;

import com.cursosOnline.CursosON.models.Categoria;
import com.cursosOnline.CursosON.service.CategoriaService;
import com.cursosOnline.CursosON.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    public CategoriaService service;

    @GetMapping
    public List<Categoria> obtenerCategorias(){
        return service.obtenerCategorias();
    }

    @PostMapping
    public Categoria crearCategoria(Categoria categoria){
        return service.crearCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable Long id) {
        service.eliminarCategoria(null, id);
    }

    @PutMapping
    public Categoria actualizarCategoria(@RequestBody Categoria categoria, @PathVariable Long id) {
        return service.actualizar(categoria, id);
    }


}
