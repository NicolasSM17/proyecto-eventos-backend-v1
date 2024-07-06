package pe.proyecto.eventos.service;

import pe.proyecto.eventos.entity.Categoria;

import java.util.List;

public interface ICategoriaService {
    List<Categoria> listar();
    Categoria buscarPorId(Integer id);
    Categoria agregar(Categoria categoria);
    Categoria actualizar(Integer id, Categoria categoria);
    void eliminar(Integer id);
}
