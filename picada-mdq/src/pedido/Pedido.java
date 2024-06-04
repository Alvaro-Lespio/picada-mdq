package pedido;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import picada.Picada;
import picada.PicadaPersonalizada;
import picada.PicadaPreDefinida;

import java.util.ArrayList;
import java.util.List;

public class Pedido<T> implements IPedido{
    private T pedidos;
    private int id;
    private boolean envio;
    private String tipoPicada;
    private double precioFinalPedido;
    private int valoracion;


    public Pedido() {
        this.pedidos = null;
        this.id = 0;
        this.envio = false;
        this.tipoPicada = "";
        this.precioFinalPedido = 0;
        this.valoracion = 0;
    }

    public Pedido(T pedidos, int id, boolean envio, String tipoPicada, double precioFinalPedido, int valoracion) {
        this.pedidos = pedidos;
        this.id = id;
        this.envio = envio;
        this.tipoPicada = tipoPicada;
        this.precioFinalPedido = precioFinalPedido;
        this.valoracion = valoracion;
    }

    //GETTERS


    public T getPedidos() {
        return pedidos;
    }

    public int getId() {
        return id;
    }

    public boolean isEnvio() {
        return envio;
    }

    public String getTipoPicada() {
        return tipoPicada;
    }

    public double getPrecioFinalPedido() {
        return precioFinalPedido;
    }

    public int getValoracion() {
        return valoracion;
    }

    public static ArrayList<Pedido> JSONToPedido(JSONArray arrayPedidos) throws Exception{
        ArrayList<Pedido> arrayPedidosTotal = new ArrayList<>();
        for(int i=0; i<arrayPedidos.length();i++){
            JSONObject objectPedidos = new JSONObject();
            objectPedidos = arrayPedidos.getJSONObject(i);
            int id = objectPedidos.getInt("id");
            boolean envio = objectPedidos.getBoolean("envio");
            double precioFinal = objectPedidos.getDouble("precioFinal");
            int valoracion = objectPedidos.getInt("valoracion");

            Picada picada = null;
            JSONObject picadaJSON = objectPedidos.getJSONObject("pedido");
            String tipoPicada = objectPedidos.getString("tipoPicada");

            if(tipoPicada.equals("picadaPersonalizada")){
                picada = new PicadaPersonalizada();
                Picada.JSONToPicada(picadaJSON, picada);
            }else if(tipoPicada.equals("picadaPreDefinida")){
                picada = new PicadaPreDefinida();
                Picada.JSONToPicada(picadaJSON, picada);
            }else{
                //excepcion tipo picada no encontrada
            }

            Pedido pedido = new Pedido<>(picada, id, envio, tipoPicada, precioFinal, valoracion);
            arrayPedidosTotal.add(pedido);
        }
        return arrayPedidosTotal;
    }

    public JSONObject pedidoToJSON() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("envio", envio);
        jsonObject.put("precioFinalPedido", precioFinalPedido);
        jsonObject.put("valoracion", valoracion);
        return jsonObject;
    }

    //hacer pedido

    //listar pedidos

    //eliminar pedidos

    //actualizar pedidos
}
