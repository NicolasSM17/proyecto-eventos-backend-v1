package pe.proyecto.eventos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.proyecto.eventos.entity.Asistente;
import pe.proyecto.eventos.entity.Evento;
import pe.proyecto.eventos.entity.Ticket;
import pe.proyecto.eventos.entity.Usuario;
import pe.proyecto.eventos.repository.IAsistenteRepository;
import pe.proyecto.eventos.repository.IEventoRepository;
import pe.proyecto.eventos.repository.ITicketRepository;
import pe.proyecto.eventos.repository.IUsuarioRepository;
import pe.proyecto.eventos.service.ITicketService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Service
public class TicketServiceImpl implements ITicketService {
    @Autowired
    private ITicketRepository ticketRepository;

    @Autowired
    private IAsistenteRepository asistenteRepository;

    @Autowired
    private IEventoRepository eventoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Transactional
    @Override
    public Ticket crearTicket(Long eventoId, String nombresCompletos, String dni, Usuario usuario, String numeroTransaccion, Double precioTotal) {
        // 1. Obtener evento
        Evento evento = eventoRepository.findById(eventoId).get();

        // 2. Buscar o crear el Asistente
        Asistente asistente = asistenteRepository.findByDni(dni)
                .orElseGet(() -> {
                    Asistente newAsistente = new Asistente();
                    newAsistente.setNombresCompletos(nombresCompletos);
                    newAsistente.setDni(dni);
                    newAsistente.setEvento(evento);
                    return asistenteRepository.save(newAsistente);
                });
        // 3. Crear el Ticket
        Ticket nuevoTicket = new Ticket();
        nuevoTicket.setCodigo(generarCodigoUnico());
        nuevoTicket.setFechaCompra(LocalDate.now());
        nuevoTicket.setHoraCompra(LocalTime.now());
        nuevoTicket.setNumeroTransaccion(numeroTransaccion);
        nuevoTicket.setPrecioTotal(precioTotal);
        nuevoTicket.setUsuario(usuario);
        nuevoTicket.setEvento(evento);
        nuevoTicket.setAsistente(asistente);

        // 4. Guardar el Ticket
        return ticketRepository.save(nuevoTicket);
    }

    @Override
    public List<Ticket> listar() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket buscarPorCodigo(String codigo) {
        return ticketRepository.findByCodigo(codigo);
    }

    private String generarCodigoUnico() {
        return UUID.randomUUID().toString(); // Genera un código único para cada ticket
    }
}
