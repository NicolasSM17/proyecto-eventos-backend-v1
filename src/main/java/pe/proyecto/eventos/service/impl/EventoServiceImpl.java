package pe.proyecto.eventos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pe.proyecto.eventos.entity.Evento;
import pe.proyecto.eventos.entity.Usuario;
import pe.proyecto.eventos.repository.IEventoRepository;
import pe.proyecto.eventos.repository.IUsuarioRepository;
import pe.proyecto.eventos.service.IEventosService;

import java.util.List;

@Service
public class EventoServiceImpl implements IEventosService {
    @Autowired
    private IEventoRepository eventoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Evento> findAllByOrganizadorId(Integer organizadorId) {
        return eventoRepository.findAllByOrganizadorId(organizadorId);
    }

    @Override
    public List<Evento> listarPorInstitucionId(Integer institucionId) {
        return eventoRepository.findAllByInstitucionId(institucionId);
    }

    @Override
    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento buscarPorId(Long id) {
        return eventoRepository.findById(id).get();
    }

    @Override
    public Evento agregar(Evento evento) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Usuario usuario = usuarioRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        evento.setOrganizador(usuario);

        return eventoRepository.save(evento);
    }

    @Override
    public Evento actualizar(Long id, Evento evento) {
        Evento eventoBD = eventoRepository.findById(id).get();
        /* TODO */
        return eventoRepository.save(eventoBD);
    }

    @Override
    public void eliminar(Long id) {
        Evento eventoBD = eventoRepository.findById(id).get();

        eventoRepository.delete(eventoBD);
    }
}
