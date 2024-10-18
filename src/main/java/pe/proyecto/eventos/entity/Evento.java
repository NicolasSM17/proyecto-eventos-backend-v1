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
    private String codigoAutogenerado;
    private String titulo;
    private String descripcion;
    private Date fecha;
    private String direccion;
    private String direccionUrl;
    private Double precioEntrada;
    private boolean boost = false;
    private boolean terminosAceptados;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime hora;

    @ManyToMany
    @JoinTable(name = "evento_institucion", joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "institucion_id"))
    private List<Institucion> instituciones;

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

    @OneToMany(mappedBy = "evento")
    private List<Combo> combos;
}
