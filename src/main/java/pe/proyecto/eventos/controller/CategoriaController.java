package pe.proyecto.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.proyecto.eventos.entity.Categoria;
import pe.proyecto.eventos.service.ICategoriaService;

import java.util.List;

@RestController
@RequestMapping("categoria")
public class CategoriaController {
    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Categoria>> listar(){
        return new ResponseEntity<>(categoriaService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Integer id){
        return new ResponseEntity<>(categoriaService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Categoria> agregar(@RequestBody Categoria categoria){
        return new ResponseEntity<>(categoriaService.agregar(categoria), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Categoria> actualizar(@PathVariable Integer id, @RequestBody Categoria categoria){
        return new ResponseEntity<>(categoriaService.actualizar(id, categoria), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable Integer id){
        categoriaService.eliminar(id);
    }
}
