package Ingredientes.producto;

import Ingredientes.TipoQueso;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductoQueso extends Producto{
    private TipoQueso tipoQueso;

    public ProductoQueso(int stock, TipoQueso tipoQueso) {
        super(stock);
        this.tipoQueso = tipoQueso;
    }

    @Override
    public void actualizarStock() {

    }

    public static ProductoQueso JSONToProductoQueso(JSONObject JSONProductoQueso) throws JSONException{
        int stock = JSONProductoQueso.getInt("stock");
        String tipoQuesoStr = JSONProductoQueso.getString("tipoQueso");
        TipoQueso tipoQueso = TipoQueso.verificarQueso(tipoQuesoStr);
        ProductoQueso productoQueso = new ProductoQueso(stock, tipoQueso);

        return productoQueso;
    }

    public JSONObject productoQuesoToJSON() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stock", getStock());
        jsonObject.put("TipoQueso", tipoQueso.getNombre());
        return jsonObject;
    }
}
