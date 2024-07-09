package pe.proyecto.eventos.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationResponse {
    private Usuario usuario;
    private String token;
}
