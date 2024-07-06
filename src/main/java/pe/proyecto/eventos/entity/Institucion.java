package pe.proyecto.eventos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "institucion")
public class Institucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String imagenUrl;

    @OneToMany(mappedBy = "institucion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evento> eventos;
}
