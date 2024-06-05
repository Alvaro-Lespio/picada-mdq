package Producto;

import Producto.tipo.TipoFiambre;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductoFiambre extends Producto{
    private TipoFiambre tipoFiambre;

    public ProductoFiambre(int stock, TipoFiambre tipoFiambre) {
        super(stock);
        this.tipoFiambre = tipoFiambre;
    }


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

    public JSONObject productoFiambreToJSON() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stock", getStock());
        jsonObject.put("tipoFiambre", tipoFiambre.getNombre());
        return jsonObject;
    }

    @Override
    public String toString() {
        return "Fiambre = " + tipoFiambre;
    }
}
