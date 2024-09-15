package pe.proyecto.eventos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pe.proyecto.eventos.entity.Categoria;
import pe.proyecto.eventos.entity.Evento;
import pe.proyecto.eventos.entity.Usuario;
import pe.proyecto.eventos.repository.IEventoRepository;
import pe.proyecto.eventos.repository.IUsuarioRepository;
import pe.proyecto.eventos.service.IEventosService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public List<Evento> findEventosConCategoriasSimilares(Long eventoId, Integer institucionId) {
        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        // Obtener las categorías del evento
        List<Categoria> categorias = evento.getCategorias();

        // Obtener todos los eventos de la misma institución
        List<Evento> eventos = eventoRepository.findAllByInstitucionId(institucionId);

        return eventos.stream().filter(e -> !e.getId().equals(eventoId) &&
                                             e.getCategorias()
                                              .stream()
                                              .anyMatch(categorias::contains))
                                              .collect(Collectors.toList());
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

        eventoBD.setTitulo(evento.getTitulo());
        eventoBD.setDescripcion(evento.getDescripcion());
        eventoBD.setFecha(evento.getFecha());
        eventoBD.setHora(evento.getHora());
        eventoBD.setDireccion(evento.getDireccion());
        eventoBD.setDireccionUrl(evento.getDireccionUrl());
        eventoBD.setPrecioEntrada(evento.getPrecioEntrada());

        return eventoRepository.save(eventoBD);
    }

    @Override
    public void eliminar(Long id) {
        Evento eventoBD = eventoRepository.findById(id).get();

        eventoRepository.delete(eventoBD);
    }
}
