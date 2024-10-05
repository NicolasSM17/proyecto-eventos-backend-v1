package pe.proyecto.eventos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pe.proyecto.eventos.entity.Tarjeta;
import pe.proyecto.eventos.entity.Usuario;
import pe.proyecto.eventos.repository.ITarjetaRepository;
import pe.proyecto.eventos.repository.IUsuarioRepository;
import pe.proyecto.eventos.service.ITarjetaService;

import java.util.List;

@Service
public class TarjetaServiceImpl implements ITarjetaService {
    @Autowired
    private ITarjetaRepository tarjetaRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Tarjeta> listarPorUsuarioId(Integer usuarioId) {
        return tarjetaRepository.findAllByUsuarioId(usuarioId);
    }

    @Override
    public Tarjeta agregar(Tarjeta tarjeta) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Usuario usuario = usuarioRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        tarjeta.setUsuario(usuario);

        return tarjetaRepository.save(tarjeta);
    }

    @Override
    public void eliminar(Long id) {
        Tarjeta tarjetaBD = tarjetaRepository.findById(id).get();

        tarjetaRepository.delete(tarjetaBD);
    }
}
