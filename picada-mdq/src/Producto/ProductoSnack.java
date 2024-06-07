package Producto;

import Producto.tipo.TipoSnack;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * La clase ProductoSnack representa un producto del tipo snack.
 * Extiende la clase Producto y es Serializable.
 */
public class ProductoSnack extends Producto implements Serializable {
    private TipoSnack tipoSnack;

    /**
     * Constructor para crear un ProductoSnack con un stock y un tipo de snack.
     *
     * @param stock     La cantidad de unidades disponibles en stock.
     * @param tipoSnack El tipo de snack.
     */
    public ProductoSnack(int stock, TipoSnack tipoSnack) {
        super(stock);
        this.tipoSnack = tipoSnack;
    }

    /**
     * Obtiene el tipo de snack del producto.
     *
     * @return El tipo de snack.
     */
    public TipoSnack getTipoSnack() {
        return tipoSnack;
    }

    /**
     * Convierte un objeto JSONObject a un ProductoSnack.
     *
     * @param JSONProductoSnack El objeto JSONObject que representa el ProductoSnack.
     * @return El ProductoSnack obtenido del JSONObject.
     * @throws JSONException Si ocurre un error al leer el JSONObject.
     */
    public static ProductoSnack JSONToProductoSnack(JSONObject JSONProductoSnack) throws JSONException{
        int stock = JSONProductoSnack.getInt("stock");
        String tipoSnackStr = JSONProductoSnack.getString("tipoSnack");
        TipoSnack tipoSnack = TipoSnack.verificarSnack(tipoSnackStr);
        ProductoSnack productoSnack = new ProductoSnack(stock, tipoSnack);

        return productoSnack;
    }

    /**
     * Convierte el ProductoSnack a un JSONObject.
     *
     * @return El JSONObject que representa el ProductoSnack.
     * @throws JSONException Si ocurre un error al convertir el ProductoSnack a JSONObject.
     */
    public JSONObject productoSnackToJSON() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stock", getStock());
        jsonObject.put("tipoSnack", tipoSnack.getNombre());
        return jsonObject;
    }

    /**
     * Devuelve una representación en forma de cadena del ProductoSnack.
     *
     * @return Una cadena que representa el ProductoSnack.
     */
    @Override
    public String toString() {
        return "Snack = " + tipoSnack;
    }
}
