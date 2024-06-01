package pedido;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Pedido<T> implements IPedido{
    private T pedidos;
    private int id;
    private boolean envio;
    private double precioFinalPedido;
    private int valoracion;

    public Pedido() {
        this.pedidos = null;
        this.id = 0;
        this.envio = false;
        this.precioFinalPedido = 0;
        this.valoracion = 0;
    }

    public Pedido(T pedidos, int id, boolean envio, double precioFinalPedido, int valoracion) {
        this.pedidos = pedidos;
        this.id = id;
        this.envio = envio;
        this.precioFinalPedido = precioFinalPedido;
        this.valoracion = valoracion;
    }

    /*public static ArrayList<Pedido> JSONToPedido(JSONArray arrayPedidos) throws Exception{
        ArrayList<Pedido> arrayPedidosTotal = new ArrayList<>();
        for(int i=0; i<arrayPedidos.length();i++){
            JSONObject objectPedidos = new JSONObject();
            objectPedidos = arrayPedidos.getJSONObject(i);
            boolean envio = objectPedidos.getBoolean("envio");
            double precioFinal = objectPedidos.getDouble("precioFinal");
            int valoracion = objectPedidos.getInt("valoracion");
            JSONObject pedido = objectPedidos.getJSONObject("pedido");
            if(pedido.has("")){

            }
        }
    }*/

    //hacer pedido

    //listar pedidos

    //eliminar pedidos

    //actualizar pedidos
}
