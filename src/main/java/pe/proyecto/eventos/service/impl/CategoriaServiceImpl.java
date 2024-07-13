package pe.proyecto.eventos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.proyecto.eventos.entity.Categoria;
import pe.proyecto.eventos.repository.ICategoriaRepository;
import pe.proyecto.eventos.service.ICategoriaService;

import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService {
    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarPorId(Integer id) {
        return categoriaRepository.findById(id).get();
    }

    @Override
    public Categoria agregar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizar(Integer id, Categoria categoria) {
        Categoria categoriaBD = categoriaRepository.findById(id).get();

        categoriaBD.setNombre(categoria.getNombre());

        return categoriaRepository.save(categoriaBD);
    }

    @Override
    public void eliminar(Integer id) {
        Categoria categoriaBD = categoriaRepository.findById(id).get();

        categoriaRepository.delete(categoriaBD);
    }
}
