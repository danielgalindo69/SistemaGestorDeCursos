package com.cursosOnline.CursosON.service;

import com.cursosOnline.CursosON.models.Categoria;
import com.cursosOnline.CursosON.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    public ICategoriaRepository categoriaRepository;


    //crear categoria
    public Categoria crearCategoria( Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    //obtener todos los datos de la lista metodo get
    public List<Categoria> obtenerCategorias(){
            return categoriaRepository.findAll();

    }

    //obtener categoria por id
    public Categoria obtenerCategoriaPorId(Long id){
        return categoriaRepository.findById(id).orElse(null);
    }

    //eliminar categoria
    public void eliminarCategoria(Categoria categoria,Long id){
        Categoria categoriaExistente = categoriaRepository.findById(id).orElse(null);
        if(categoriaExistente != null) {
            categoriaRepository.deleteById(id);



        }
    }

    //actualizar categoria
    public Categoria actualizar(Categoria categoria, Long id){
        Categoria categoriaExistente = categoriaRepository.findById(id).orElse(null);
        if(categoriaExistente != null){
            categoriaExistente.setNombre(categoria.getNombre());
            return categoriaRepository.save(categoriaExistente);
        }
        else {
            return null;
        }
    }
}
