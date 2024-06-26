package pe.proyecto.eventos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String nombre;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<Usuario> usuarios;

    // @CreatedDate
    // @Column(nullable = false, updatable = false)
    // private LocalDateTime fechaCreacion;

    // @LastModifiedDate
    // @Column(insertable = false)
    // private LocalDate Time fechaUltimaModificacion;
}
