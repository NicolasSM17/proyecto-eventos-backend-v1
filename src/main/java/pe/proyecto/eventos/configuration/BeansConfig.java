package pe.proyecto.eventos.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;

@Configuration
@RequiredArgsConstructor
public class BeansConfig {


    public AuthenticationProvider authenticationProvider(){

    }
}
