package Producto;

import Producto.tipo.TipoBebida;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * La clase ProductoBebida representa un producto del tipo bebida.
 * Extiende la clase Producto y es Serializable.
 */
public class ProductoBebida extends Producto implements Serializable {
    private TipoBebida tipoBebida;

    /**
     * Constructor para crear un ProductoBebida con un stock y un tipo de bebida.
     *
     * @param stock      La cantidad de unidades disponibles en stock.
     * @param tipoBebida El tipo de bebida.
     */
    public ProductoBebida(int stock, TipoBebida tipoBebida) {
        super(stock);
        this.tipoBebida = tipoBebida;
    }

    /**
     * Obtiene el tipo de bebida del producto.
     *
     * @return El tipo de bebida.
     */
    public TipoBebida getTipoBebida() {
        return tipoBebida;
    }

    /**
     * Convierte un objeto JSONObject a un ProductoBebida.
     *
     * @param JSONProductoBebida El objeto JSONObject que representa el ProductoBebida.
     * @return El ProductoBebida obtenido del JSONObject.
     * @throws JSONException Si ocurre un error al leer el JSONObject.
     */
    public static ProductoBebida JSONToProductoBebida(JSONObject JSONProductoBebida) throws JSONException{
        int stock = JSONProductoBebida.getInt("stock");
        String tipoBebidaStr = JSONProductoBebida.getString("tipoBebida");
        TipoBebida tipoBebida = TipoBebida.verificarBebida(tipoBebidaStr);
        ProductoBebida productoBebida = new ProductoBebida(stock,tipoBebida);

        return productoBebida;
    }

    /**
     * Convierte el ProductoBebida a un JSONObject.
     *
     * @return El JSONObject que representa el ProductoBebida.
     * @throws JSONException Si ocurre un error al convertir el ProductoBebida a JSONObject.
     */
    public JSONObject productoBebidaToJSON() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stock", getStock());
        jsonObject.put("tipoBebida", tipoBebida.getNombre());
        return jsonObject;
    }

    /**
     * Devuelve una representación en forma de cadena del ProductoBebida.
     *
     * @return Una cadena que representa el ProductoBebida.
     */
    @Override
    public String toString() {
        return "Bebida = " + tipoBebida;
    }
}
