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
    private List<T> picadas;
    private int id;
    private boolean envio;
    private String tipoPicada;
    private double precioFinalPedido;


    public Pedido() {
        this.picadas = null;
        this.id = 0;
        this.envio = false;
        this.tipoPicada = "";
        this.precioFinalPedido = 0;
    }

    public Pedido(List<T> picadas, int id, boolean envio, String tipoPicada, double precioFinalPedido) {
        this.picadas = picadas;
        this.id = id;
        this.envio = envio;
        this.tipoPicada = tipoPicada;
        this.precioFinalPedido = precioFinalPedido;
    }

    public Pedido(T pedidos) {
        this.pedidos = pedidos;
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


    public static ArrayList<Pedido> JSONToPedido(JSONArray arrayPedidos) throws Exception{
        ArrayList<Pedido> arrayPedidosTotal = new ArrayList<>();
        for(int i=0; i<arrayPedidos.length();i++){
            JSONObject objectPedidos = new JSONObject();
            objectPedidos = arrayPedidos.getJSONObject(i);
            int id = objectPedidos.getInt("id");
            boolean envio = objectPedidos.getBoolean("envio");
            double precioFinal = objectPedidos.getDouble("precioFinal");

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

            Pedido pedido = new Pedido<>(picada, id, envio, tipoPicada, precioFinal);
            arrayPedidosTotal.add(pedido);
        }
        return arrayPedidosTotal;
    }

    public JSONObject pedidoToJSON() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("envio", envio);
        jsonObject.put("precioFinalPedido", precioFinalPedido);
        return jsonObject;
    }

    //hacer pedido

    //listar pedidos

    //eliminar pedidos

    //actualizar pedidos
}
