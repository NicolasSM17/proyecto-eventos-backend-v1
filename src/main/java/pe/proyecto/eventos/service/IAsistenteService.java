package pe.proyecto.eventos.service;

import pe.proyecto.eventos.entity.Asistente;

import java.util.List;

public interface IAsistenteService {
    List<Asistente> listar();
    List<Asistente> listarPorEventoId(Long eventoId);
}
