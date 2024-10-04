package pe.proyecto.eventos.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketRequest {
    private Long eventoId;
    private String nombresCompletos;
    private String dni;
    private String numeroTransaccion;
    private Double precioTotal;
}
