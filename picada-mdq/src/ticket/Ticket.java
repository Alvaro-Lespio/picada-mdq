package ticket;

import pedido.Pedido;
import picada.Picada;

public class Ticket {
    private int id;
    private Pedido<Picada> pedido;

    public Ticket(Pedido<Picada> pedido, int id) {
        this.pedido = pedido;
        this.id = id;
    }

    
}
