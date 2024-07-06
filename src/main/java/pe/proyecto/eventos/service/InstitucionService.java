package pe.proyecto.eventos.service;

import pe.proyecto.eventos.entity.Institucion;

import java.util.List;

public interface InstitucionService {
    List<Institucion> listar();
    Institucion buscarPorId(Integer id);
    Institucion agregar(Institucion institucion);
    Institucion actualizar(Integer id, Institucion institucion);
    void eliminar(Integer id);
}
