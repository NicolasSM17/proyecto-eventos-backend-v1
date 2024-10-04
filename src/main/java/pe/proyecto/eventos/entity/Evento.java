package pe.proyecto.eventos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private Date fecha;
    private String direccion;
    private String direccionUrl;
    private Double precioEntrada;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime hora; 

    @ManyToOne
    @JoinColumn(name = "institucion_id", nullable = false)
    private Institucion institucion;

    @ManyToMany
    @JoinTable(name = "evento_categoria", joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario organizador;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "evento_imagenes", joinColumns = {@JoinColumn(name = "evento_id")},
            inverseJoinColumns = {@JoinColumn(name = "imagen_id")})
    private Set<Imagen> eventoImagenes;

    @OneToMany(mappedBy = "evento")
    private List<Asistente> asistentes;
}
