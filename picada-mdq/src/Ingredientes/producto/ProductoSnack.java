package Ingredientes.producto;

import Ingredientes.TipoSnack;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductoSnack extends Producto{
    private TipoSnack tipoSnack;

    public ProductoSnack(int stock, TipoSnack tipoSnack) {
        super(stock);
        this.tipoSnack = tipoSnack;
    }

    @Override
    public void actualizarStock() {

    }

    public static ProductoSnack JSONToProductoSnack(JSONObject JSONProductoSnack) throws JSONException{
        int stock = JSONProductoSnack.getInt("stock");
        String tipoSnackStr = JSONProductoSnack.getString("tipoSnack");
        TipoSnack tipoSnack = TipoSnack.verificarSnack(tipoSnackStr);
        ProductoSnack productoSnack = new ProductoSnack(stock, tipoSnack);

        return productoSnack;
    }

    public JSONObject productoSnackToJSON() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stock", getStock());
        jsonObject.put("tipoSnack", tipoSnack.getNombre());
        return jsonObject;
    }
}
