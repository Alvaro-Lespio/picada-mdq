package Producto;

import Producto.tipo.TipoQueso;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * La clase ProductoQueso representa un producto del tipo queso.
 * Extiende la clase Producto y es Serializable.
 */
public class ProductoQueso extends Producto implements Serializable {
    private TipoQueso tipoQueso;

    /**
     * Constructor para crear un ProductoQueso con un stock y un tipo de queso.
     *
     * @param stock     La cantidad de unidades disponibles en stock.
     * @param tipoQueso El tipo de queso.
     */
    public ProductoQueso(int stock, TipoQueso tipoQueso) {
        super(stock);
        this.tipoQueso = tipoQueso;
    }

    /**
     * Constructor por defecto de ProductoQueso.
     */
    public ProductoQueso() {
    }

    /**
     * Obtiene el tipo de queso del producto.
     *
     * @return El tipo de queso.
     */
    public TipoQueso getTipoQueso() {
        return tipoQueso;
    }

    /**
     * Convierte un objeto JSONObject a un ProductoQueso.
     *
     * @param JSONProductoQueso El objeto JSONObject que representa el ProductoQueso.
     * @return El ProductoQueso obtenido del JSONObject.
     * @throws JSONException Si ocurre un error al leer el JSONObject.
     */
    public static ProductoQueso JSONToProductoQueso(JSONObject JSONProductoQueso) throws JSONException{
        int stock = JSONProductoQueso.getInt("stock");
        String tipoQuesoStr = JSONProductoQueso.getString("tipoQueso");
        TipoQueso tipoQueso = TipoQueso.verificarQueso(tipoQuesoStr);
        ProductoQueso productoQueso = new ProductoQueso(stock, tipoQueso);

        return productoQueso;
    }

    /**
     * Convierte el ProductoQueso a un JSONObject.
     *
     * @return El JSONObject que representa el ProductoQueso.
     * @throws JSONException Si ocurre un error al convertir el ProductoQueso a JSONObject.
     */
    public JSONObject productoQuesoToJSON() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stock", getStock());
        jsonObject.put("TipoQueso", tipoQueso.getNombre());
        return jsonObject;
    }

    /**
     * Devuelve una representación en forma de cadena del ProductoQueso.
     *
     * @return Una cadena que representa el ProductoQueso.
     */
    @Override
    public String toString() {
        return "Queso = " + tipoQueso;
    }
}
