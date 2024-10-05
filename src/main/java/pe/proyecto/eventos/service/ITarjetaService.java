package pe.proyecto.eventos.service;

import pe.proyecto.eventos.entity.Tarjeta;

import java.util.List;

public interface ITarjetaService {
    List<Tarjeta> listarPorUsuarioId(Integer usuarioId);
    Tarjeta agregar(Tarjeta tarjeta);
    void eliminar(Long id);
}
