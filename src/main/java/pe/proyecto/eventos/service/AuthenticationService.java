package pe.proyecto.eventos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.proyecto.eventos.entity.AuthenticationRequest;
import pe.proyecto.eventos.entity.AuthenticationResponse;
import pe.proyecto.eventos.entity.RegistrationRequest;
import pe.proyecto.eventos.entity.Usuario;
import pe.proyecto.eventos.repository.IRolRepository;
import pe.proyecto.eventos.repository.IUsuarioRepository;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final IRolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    private final IUsuarioRepository usuarioRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

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
    
    public AuthenticationResponse authenticate(AuthenticationRequest request){
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var claims = new HashMap<String, Object>();
        var user = ((Usuario)auth.getPrincipal());
        claims.put("nombre", user.getNombre());
        var jwtToken = jwtService.generateToken(claims, user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
