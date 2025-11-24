package com.cursosOnline.CursosON.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private long idCategoria;

    @NotBlank(message = "el nombre no puede estar vacio")
    @Column(unique = true, nullable = false)
    private String nombre;


}
