package pe.proyecto.eventos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "torneo")
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "deporte_id")
    private Deporte deporte;

    @Column(name = "numero_participantes")
    private int numeroParticipantes;

    @Column(name = "formato_torneo")
    private String formatoTorneo; // Simple o Doble Eliminación

    @OneToMany(mappedBy = "torneo", cascade = CascadeType.ALL)
    private List<Ronda> rondas;

    private String direccion;

    @Column(name = "direccion_url")
    private String direccionUrl;

    private LocalDate fecha;
    private LocalTime hora;

    @Column(name = "precio_entrada")
    private Double precioEntrada;

    @ManyToOne
    @JoinColumn(name = "institucion_id")
    private Institucion institucion;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "torneo_imagenes", joinColumns = {@JoinColumn(name = "torneo_id")},
            inverseJoinColumns = {@JoinColumn(name = "imagen_id")})
    private Set<Imagen> torneoImagenes;
}
