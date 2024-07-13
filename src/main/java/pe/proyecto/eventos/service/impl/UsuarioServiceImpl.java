package pe.proyecto.eventos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.proyecto.eventos.entity.Rol;
import pe.proyecto.eventos.entity.Usuario;
import pe.proyecto.eventos.repository.IRolRepository;
import pe.proyecto.eventos.repository.IUsuarioRepository;
import pe.proyecto.eventos.service.IUsuarioService;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IRolRepository rolRepository;

    @Override
    @Transactional
    public void cambiarRol(String email, String nuevoRol) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);

        if(usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            Optional<Rol> rolOptional = rolRepository.findByNombre(nuevoRol);

            if(rolOptional.isPresent()){
                Rol nuevoRolObjeto = rolOptional.get();
                usuario.getRoles().clear();
                usuario.getRoles().add(nuevoRolObjeto);
                usuarioRepository.save(usuario);
            }else {
                throw new RuntimeException("Rol no encontrado: " + nuevoRol);
            }
        }else {
            throw new RuntimeException("Usuario no encontrado: " + email);
        }
    }
}
