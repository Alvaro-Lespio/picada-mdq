package Producto;

import Producto.tipo.TipoFiambre;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * La clase ProductoFiambre representa un producto del tipo fiambre.
 * Extiende la clase Producto y es Serializable.
 */
public class ProductoFiambre extends Producto implements Serializable {
    private TipoFiambre tipoFiambre;

    /**
     * Constructor para crear un ProductoFiambre con un stock y un tipo de fiambre.
     *
     * @param stock       La cantidad de unidades disponibles en stock.
     * @param tipoFiambre El tipo de fiambre.
     */
    public ProductoFiambre(int stock, TipoFiambre tipoFiambre) {
        super(stock);
        this.tipoFiambre = tipoFiambre;
    }


    /**
     * Obtiene el tipo de fiambre del producto.
     *
     * @return El tipo de fiambre.
     */
    public TipoFiambre getTipoFiambre() {
        return tipoFiambre;
    }

    public static ProductoFiambre JSONToProductoFiambre(JSONObject JSONproductoFiambre) throws JSONException{
        int stock = JSONproductoFiambre.getInt("stock");
        String tipoFiambreStr = JSONproductoFiambre.getString("tipoFiambre");
        TipoFiambre tipoFiambre = TipoFiambre.verificarFiambre(tipoFiambreStr);
        ProductoFiambre productoFiambre = new ProductoFiambre(stock, tipoFiambre);
        return productoFiambre;
    }

    /**
     * Convierte un objeto JSONObject a un ProductoFiambre.
     *
     * @param //JSONproductoFiambre El objeto JSONObject que representa el ProductoFiambre.
     * @return El ProductoFiambre obtenido del JSONObject.
     * @throws //JSONException Si ocurre un error al leer el JSONObject.
     */
    public JSONObject productoFiambreToJSON() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stock", getStock());
        jsonObject.put("tipoFiambre", tipoFiambre.getNombre());
        return jsonObject;
    }

    /**
     * Devuelve una representación en forma de cadena del ProductoFiambre.
     *
     * @return Una cadena que representa el ProductoFiambre.
     */
    @Override
    public String toString() {
        return "Fiambre = " + tipoFiambre;
    }
}
