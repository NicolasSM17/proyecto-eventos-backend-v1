package pe.proyecto.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.proyecto.eventos.entity.AuthenticationResponse;
import pe.proyecto.eventos.entity.Usuario;
import pe.proyecto.eventos.repository.IUsuarioRepository;
import pe.proyecto.eventos.service.IUsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    /*
    @PostMapping("/cambiarRol")
    public ResponseEntity<?> cambiarRol(String email, @RequestParam String nuevoRol){

        return new ResponseEntity<>(usuarioService.cambiarRol(email, nuevoRol), HttpStatus.OK);
    }
     */
}
