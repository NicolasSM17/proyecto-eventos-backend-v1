package pe.proyecto.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pe.proyecto.eventos.entity.Ticket;
import pe.proyecto.eventos.entity.TicketRequest;
import pe.proyecto.eventos.entity.Usuario;
import pe.proyecto.eventos.service.impl.TicketServiceImpl;

@RestController
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    private TicketServiceImpl ticketService;

    @GetMapping("/getTicketByCodigo/{codigo}")
    public ResponseEntity<Ticket> buscarPorCodigo(@PathVariable String codigo){
        return new ResponseEntity<>(ticketService.buscarPorCodigo(codigo), HttpStatus.OK);
    }

    @PostMapping("/comprar")
    public ResponseEntity<Ticket> comprarTicket(@RequestBody TicketRequest request, @AuthenticationPrincipal Usuario usuario) {
        Ticket nuevoTicket = ticketService.crearTicket(
                request.getEventoId(),
                request.getNombresCompletos(),
                request.getDni(),
                usuario,
                request.getNumeroTransaccion(),
                request.getPrecioTotal()
        );
        //return ResponseEntity.ok(nuevoTicket);
        return new ResponseEntity<>(nuevoTicket, HttpStatus.CREATED);
    }
}
