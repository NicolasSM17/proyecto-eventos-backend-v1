package pe.proyecto.eventos.service;

import pe.proyecto.eventos.entity.Deporte;

import java.util.List;

public interface IDeporteService {
    List<Deporte> listar();
    Deporte buscarPorId(Integer id);
    Deporte agregar(Deporte deporte);
    Deporte actualizar(Integer id, Deporte deporte);
    void eliminar(Integer id);
}
