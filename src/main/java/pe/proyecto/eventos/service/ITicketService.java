package pe.proyecto.eventos.service;

import pe.proyecto.eventos.entity.Ticket;
import pe.proyecto.eventos.entity.Usuario;

import java.util.List;

public interface ITicketService {
    Ticket crearTicket(Long eventoId, String nombresCompletos, String dni, Usuario usuario, String numeroTransaccion, Double precioTotal);
    List<Ticket> listar();
    Ticket buscarPorCodigo(String codigo);
}
