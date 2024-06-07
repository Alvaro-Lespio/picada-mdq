package pedido;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import picada.Picada;
import picada.PicadaPersonalizada;
import picada.PicadaPreDefinida;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * La clase Pedido representa un pedido que contiene una o más Picadas.
 * Implementa la interfaz IPedido y es Serializable.
 *
 * @param <T> El tipo de Picada.
 */
public class Pedido<T extends Picada> implements IPedido, Serializable {
    private ArrayList<T> picadas;
    private int id;
    private boolean envio;
    private double precioFinalPedido;

    /**
     * Constructor por defecto.
     * Inicializa el objeto Pedido con valores predeterminados.
     */
    public Pedido() {
        this.picadas = null;
        this.id = generarId();
        this.envio = false;
        this.precioFinalPedido = 0;
    }

    /**
     * Construye un objeto Pedido con los valores especificados.
     *
     * @param picadas           La lista de Picadas en el pedido.
     * @param envio             Si el pedido incluye envío.
     * @param precioFinalPedido El precio final del pedido.
     */
    public Pedido(ArrayList<T> picadas, boolean envio, double precioFinalPedido) {
        this.picadas = picadas;
        this.id = generarId();
        this.envio = envio;
        this.precioFinalPedido = precioFinalPedido;
    }

    /**
     * Construye un objeto Pedido con la lista de Picadas especificada.
     *
     * @param picadas La lista de Picadas en el pedido.
     */
    public Pedido(ArrayList<T> picadas) {
        this.picadas = picadas;
    }

    //GETTERS

    public ArrayList<T> getPicadas() {
        return picadas;
    }

    public int getId() {
        return id;
    }

    public double getPrecioFinalPedido() {
        return precioFinalPedido;
    }

    /**
     * Devuelve si el pedido incluye envío.
     *
     * @return Verdadero si el pedido incluye envío, falso en caso contrario.
     */
    public boolean isEnvio() {
        return envio;
    }

    /**
     * Establece si el pedido incluye envío.
     *
     * @param envio Verdadero si el pedido incluye envío, falso en caso contrario.
     */
    public void setEnvio(boolean envio) {
        this.envio = envio;
    }

    public void setPicadas(ArrayList<T> picadas) {
        this.picadas = picadas;
    }

    public void setPrecioFinalPedido(double precioFinalPedido) {
        this.precioFinalPedido = precioFinalPedido;
    }

    private int generarId(){

        Random rand= new Random();
        return rand.nextInt(90000000) + 10000000;

    }

    /**
     * Convierte un JSONArray a una lista de objetos Pedido.
     *
     * @param arrayPedidos El JSONArray a convertir.
     * @return Una lista de objetos Pedido.
     * @throws Exception Si ocurre un error durante la conversión.
     */
    public static ArrayList<Pedido> JSONToPedido(JSONArray arrayPedidos) throws Exception{
        ArrayList<Pedido> arrayPedidosTotal = new ArrayList<>();
        for(int i=0; i<arrayPedidos.length();i++){
            JSONObject objectPedidos = new JSONObject();
            objectPedidos = arrayPedidos.getJSONObject(i);
            int id = objectPedidos.getInt("id");
            boolean envio = objectPedidos.getBoolean("envio");
            double precioFinal = objectPedidos.getDouble("precioFinalPedido");


            JSONArray arrayPicadas = objectPedidos.getJSONArray("picada");
            ArrayList<Picada> picadas= new ArrayList<>();
            for(int j=0; j<arrayPicadas.length();j++) {
                JSONObject objectPicada = arrayPicadas.getJSONObject(j);
                Picada picada = null;
                String tipoPicada = objectPicada.getString("tipoPicada");
                if(tipoPicada.equals("picadaPersonalizada")){
                    picada = new PicadaPersonalizada();
                    picada = Picada.JSONToPicada(objectPicada);
                    picadas.add(picada);
                }else if(tipoPicada.equals("picadaPreDefinida")){
                    picada = new PicadaPreDefinida();
                    picada = Picada.JSONToPicada(objectPicada);
                    picadas.add(picada);
                }else{
                    //excepcion tipo picada no encontrada
                }



            }

            Pedido pedido = new Pedido<>(picadas, envio, precioFinal);
            arrayPedidosTotal.add(pedido);
        }
        return arrayPedidosTotal;
    }

    /**
     * Convierte el objeto Pedido a un JSONObject.
     *
     * @return Un JSONObject que representa el objeto Pedido.
     * @throws JSONException Si ocurre un error durante la conversión.
     */

    public JSONObject pedidoToJSON() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("envio", envio);
        jsonObject.put("precioFinalPedido", precioFinalPedido);

        JSONArray arrayPicadas = new JSONArray();
        for(int i=0; i<picadas.size(); i++){
            arrayPicadas.put(picadas.get(i).picadaToJSON());
        }
        jsonObject.put("picadas",arrayPicadas);
        return jsonObject;
    }

    /**
     * Calcula el precio total final del pedido.
     *
     * @param precioProducto El precio del producto.
     * @return El precio total final del pedido.
     */
    @Override
    public double calcularTotalFinal(double precioProducto) {
        precioFinalPedido = precioProducto;
        if(envio){
            precioFinalPedido = precioProducto + 300;
        }

        return precioFinalPedido;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Pedido.
     *
     * @return Una representación en forma de cadena del objeto Pedido.
     */
    @Override
    public String toString() {
        return "Pedido{" +
                "picadas=" + picadas +
                ", id=" + id +
                ", envio=" + envio +
                 '\'' +
                ", precioFinalPedido=" + precioFinalPedido +
                '}';
    }
}
