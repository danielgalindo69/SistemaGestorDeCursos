package com.cursosOnline.CursosON.service;

import com.cursosOnline.CursosON.models.Curso;
import com.cursosOnline.CursosON.models.Estudiante;
import com.cursosOnline.CursosON.repository.ICursoRepository;
import com.cursosOnline.CursosON.repository.IEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EstudianteService {

    @Autowired
    public IEstudianteRepository estudianteRepository;

    @Autowired
    public ICursoRepository cursoRepository;


    public Estudiante registrarEstudiante(Estudiante estudiante){

        if(estudianteRepository.existsByEmail(estudiante.getEmail())){
            return null;
        }

        if(estudiante.getCursos() == null || estudiante.getCursos().isEmpty()){
            return null;
        }

        Set<Curso> cursosValidados = new HashSet<>();

        for (Curso c : estudiante.getCursos()) {
            Curso cursoBD = cursoRepository.findById(c.getIdCurso()).orElse(null);
            if(cursoBD == null){
                return null;
            }
            cursosValidados.add(cursoBD);
        }

        estudiante.setCursos(cursosValidados);


        return estudianteRepository.save(estudiante);
    }


    public Estudiante obtenerEstudiantePorEmail(String email){
        return estudianteRepository.findByEmail(email).orElse(null);
    }

    public Void eliminarEstududiante(Long id){
        Estudiante estudianteExistente = estudianteRepository.findById((id)).orElse(null);

        if(estudianteExistente != null) {
            estudianteRepository.deleteById(id);
        }
        return null;
    }


    public Estudiante actualizarEstudiante(Estudiante estudiante, Long id){
        Estudiante estudianteExistente = estudianteRepository.findById(id).orElse(null);
        if(estudianteExistente != null){
            estudianteExistente.setNombre(estudiante.getNombre());
            estudianteExistente.setEmail(estudiante.getEmail());
            return estudianteRepository.save(estudianteExistente);
        }
        else {
            return null;
        }
    }

}
