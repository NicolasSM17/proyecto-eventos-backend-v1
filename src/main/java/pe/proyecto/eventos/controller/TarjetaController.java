package pe.proyecto.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.proyecto.eventos.entity.Tarjeta;
import pe.proyecto.eventos.service.ITarjetaService;

import java.util.List;

@RestController
@RequestMapping("tarjeta")
public class TarjetaController {
    @Autowired
    private ITarjetaService tarjetaService;

    @GetMapping("/tarjetasPorUsuarioId/{usuarioId}")
    public ResponseEntity<List<Tarjeta>> getTarjetasByUsuarioId(@PathVariable Integer usuarioId){
        return new ResponseEntity<>(tarjetaService.listarPorUsuarioId(usuarioId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tarjeta> insertar(@RequestBody Tarjeta tarjeta){
        return new ResponseEntity<>(tarjetaService.agregar(tarjeta), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        tarjetaService.eliminar(id);
    }
}
