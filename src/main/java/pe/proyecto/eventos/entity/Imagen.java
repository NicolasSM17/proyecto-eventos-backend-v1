package pe.proyecto.eventos.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "image_model")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String nombre;

    @NonNull
    private String tipo;

    @NonNull
    @Column(length = 50000000)
    private byte[] picByte;
}
