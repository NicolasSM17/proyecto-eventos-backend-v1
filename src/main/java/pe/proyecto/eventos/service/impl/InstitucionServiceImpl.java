package pe.proyecto.eventos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.proyecto.eventos.entity.Institucion;
import pe.proyecto.eventos.repository.InstitucionRepository;
import pe.proyecto.eventos.service.InstitucionService;

import java.util.List;

@Service
public class InstitucionServiceImpl implements InstitucionService {
    @Autowired
    private InstitucionRepository institucionRepository;

    @Override
    public List<Institucion> listar() {
        return institucionRepository.findAll();
    }

    @Override
    public Institucion buscarPorId(Integer id) {
        return institucionRepository.findById(id).get();
    }

    @Override
    public Institucion agregar(Institucion institucion) {
        return institucionRepository.save(institucion);
    }

    @Override
    public Institucion actualizar(Integer id, Institucion institucion) {
        Institucion institucionBD = institucionRepository.findById(id).get();
        /* TODO */
        return institucionRepository.save(institucionBD);
    }

    @Override
    public void eliminar(Integer id) {
        Institucion institucionBD = institucionRepository.findById(id).get();
        institucionRepository.delete(institucionBD);
    }
}
