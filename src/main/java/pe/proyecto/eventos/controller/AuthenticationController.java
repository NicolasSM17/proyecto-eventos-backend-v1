package pe.proyecto.eventos.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.proyecto.eventos.entity.RegistrationRequest;
import pe.proyecto.eventos.service.AuthenticationService;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> registro(@RequestBody @Valid RegistrationRequest request){
        authenticationService.registro(request);

        return ResponseEntity.accepted().build();
    }
}
