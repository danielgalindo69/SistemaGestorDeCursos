package com.cursosOnline.CursosON.service;

import com.cursosOnline.CursosON.models.Categoria;
import com.cursosOnline.CursosON.models.Curso;
import com.cursosOnline.CursosON.repository.ICategoriaRepository;
import com.cursosOnline.CursosON.repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    public ICursoRepository cursoRepository;

    @Autowired
    public ICategoriaRepository categoriaRepository;

    public Curso crearCurso(Curso curso){

        Long idCategoria = curso.getCategoria().getIdCategoria();
        Categoria categoria = categoriaRepository.findById(idCategoria).orElse(null);

        if(categoria != null){
            curso.setCategoria(categoria);
            return cursoRepository.save(curso);
        }
        else {
            return null;
        }

    }

    public List<Curso> obtenerCursos() {
        return cursoRepository.findAll();
    }

    public Curso obtenerCursoId(Long id){
        return cursoRepository.findById(id).orElse(null);
    }

    public void eliminarCurso(Curso curso, Long id){

        Curso cursoExistente = cursoRepository.findById(id).orElse(null);
        if(cursoExistente != null) {
            cursoRepository.deleteById(id);
        }
    }

    public Curso actualizarCurso(Curso curso, Long id){
        Curso cursoExistente = cursoRepository.findById(id).orElse(null);
        if(cursoExistente != null){
            cursoExistente.setTitulo(curso.getTitulo());
            cursoExistente.setDescripcion(curso.getDescripcion());
            cursoExistente.setCategoria(curso.getCategoria());
            return cursoRepository.save(cursoExistente);
        }
        else {
            return null;
        }
    }


}
