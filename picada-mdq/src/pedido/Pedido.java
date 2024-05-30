package pedido;

import java.util.ArrayList;
import java.util.List;

public class Pedido<T> implements IPedido{
    private List<T> pedidos;
    private int id;
    private boolean envio;
    private double precioFinalPedido;
    private int valoracion;

    public Pedido() {
        this.pedidos = new ArrayList<>();
        this.id = 0;
        this.envio = false;
        this.precioFinalPedido = 0;
        this.valoracion = 0;
    }

    //hacer pedido

    //listar pedidos

    //eliminar pedidos

    //actualizar pedidos
}
