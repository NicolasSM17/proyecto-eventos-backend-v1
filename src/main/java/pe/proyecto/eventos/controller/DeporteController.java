package pe.proyecto.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.proyecto.eventos.entity.Deporte;
import pe.proyecto.eventos.service.IDeporteService;

import java.util.List;

@RestController
@RequestMapping("deporte")
public class DeporteController {
    @Autowired
    private IDeporteService deporteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Deporte>> listar(){
        return new ResponseEntity<>(deporteService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deporte> buscarPorId(@PathVariable Integer id){
        return new ResponseEntity<>(deporteService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Deporte> agregar(@RequestBody Deporte deporte){
        return new ResponseEntity<>(deporteService.agregar(deporte), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Deporte> actualizar(@PathVariable Integer id, @RequestBody Deporte deporte){
        return new ResponseEntity<>(deporteService.actualizar(id, deporte), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable Integer id){
        deporteService.eliminar(id);
    }
}
