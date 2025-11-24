package com.cursosOnline.CursosON.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Estudiante {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idEstudiante;

    @Column(nullable = false)
    private String nombre;

    @Email(message = "el correro debe tener el formato valido")
    @Column(nullable = false, unique = true)
    private String email;



    @ManyToMany
    @JoinTable(
        name = "estudiante_curso",
        joinColumns = @JoinColumn(name = "id_estudiante"),
        inverseJoinColumns = @JoinColumn(name = "id_curso")
    )
    private Set<Curso> cursos = new HashSet<>();

}
