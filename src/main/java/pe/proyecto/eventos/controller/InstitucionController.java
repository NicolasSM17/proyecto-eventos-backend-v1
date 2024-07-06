package pe.proyecto.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.proyecto.eventos.entity.Institucion;
import pe.proyecto.eventos.service.InstitucionService;

import java.util.List;

@RestController
@RequestMapping("institucion")
public class InstitucionController {
    @Autowired
    private InstitucionService institucionService;

    @GetMapping
    public ResponseEntity<List<Institucion>> listar(){
        return new ResponseEntity<>(institucionService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institucion> buscarPorId(@PathVariable Integer id){
        return new ResponseEntity<>(institucionService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Institucion> insertar(@RequestBody Institucion institucion){
        return new ResponseEntity<>(institucionService.agregar(institucion), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Institucion> actualizar(@PathVariable Integer id, @RequestBody Institucion institucion){
        return new ResponseEntity<>(institucionService.actualizar(id, institucion), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        institucionService.eliminar(id);
    }
}