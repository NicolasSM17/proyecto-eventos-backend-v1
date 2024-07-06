package pe.proyecto.eventos.service;

import pe.proyecto.eventos.entity.Evento;

import java.util.List;

public interface IEventosService {
    List<Evento> listar();
    Evento buscarPorId(Integer id);
    Evento agregar(Evento evento);
    Evento actualizar(Long id, Evento evento);
    void eliminar(Long id);
}