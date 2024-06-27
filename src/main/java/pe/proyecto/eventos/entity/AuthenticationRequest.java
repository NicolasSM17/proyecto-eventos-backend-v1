package pe.proyecto.eventos.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationRequest {
    @Email(message = "Email no tiene el formato correcto")
    @NotEmpty(message = "Email es obligatorio")
    @NotBlank(message = "Email es obligatorio")
    private String email;

    @NotEmpty(message = "contraseña es obligatorio")
    @NotBlank(message = "contraseña es obligatorio")
    @Size(min = 8, message = "La contraseña debe tener 8 caracteres como minimo")
    private String password;
}
