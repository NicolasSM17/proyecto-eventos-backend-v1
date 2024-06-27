package pe.proyecto.eventos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.proyecto.eventos.entity.RegistrationRequest;
import pe.proyecto.eventos.entity.Usuario;
import pe.proyecto.eventos.repository.IRolRepository;
import pe.proyecto.eventos.repository.IUsuarioRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final IRolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    private final IUsuarioRepository usuarioRepository;

    public void registro(RegistrationRequest request){
        var usuarioRol = rolRepository.findByNombre("USER")
                // todo - (por hacer) mejor manejo de excepciones
                .orElseThrow(() -> new IllegalStateException("ROL USUARIO no fue inicializado"));

        var usuario = Usuario.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(List.of(usuarioRol))
                .build();

        usuarioRepository.save(usuario);
    }
}
