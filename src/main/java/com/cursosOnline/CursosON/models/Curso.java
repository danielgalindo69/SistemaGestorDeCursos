package com.cursosOnline.CursosON.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Curso {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
   private Long idCurso;

    @Column() @NotBlank(message = "el titulo no puede estar vacio")
   private String titulo;
    @NotBlank(message = "la descripcion no puede estar vacia")
    @Column()
   private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;


}
