package pe.proyecto.eventos.service;

import pe.proyecto.eventos.entity.Torneo;

import java.util.List;

public interface ITorneoService {
    List<Torneo> listar();
    Torneo agregar(Torneo torneo);
    void eliminar(Long id);
}
