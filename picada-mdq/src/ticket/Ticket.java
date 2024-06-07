package ticket;

import pedido.Pedido;
import picada.Picada;

import java.io.Serializable;

/**
 * La clase Ticket representa un ticket de pedido que contiene información sobre un pedido de picada.
 * Implementa la interfaz Serializable para permitir la serialización de objetos.
 */

public class Ticket implements Serializable {
    private int id;
    private Pedido<Picada> pedido;

    /**
     * Constructor de la clase Ticket.
     * @param pedido El pedido asociado al ticket.
     * @param id El identificador único del ticket.
     */
    public Ticket(Pedido<Picada> pedido, int id) {
        this.pedido = pedido;
        this.id = id;
    }

    /**
     * Obtiene el identificador único del ticket.
     * @return El identificador único del ticket.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el pedido asociado al ticket.
     * @return El pedido asociado al ticket.
     */
    public Pedido<Picada> getPedido() {
        return pedido;
    }

    /**
     * Devuelve una representación en forma de cadena de la información del ticket.
     * @return Una cadena que contiene la información del ticket.
     */
    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", pedido=" + pedido +
                '}';
    }
}
