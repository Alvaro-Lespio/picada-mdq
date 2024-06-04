package Producto;

import Producto.tipo.TipoBebida;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductoBebida extends Producto{
    private TipoBebida tipoBebida;

    public ProductoBebida(int stock, TipoBebida tipoBebida) {
        super(stock);
        this.tipoBebida = tipoBebida;
    }

    @Override
    public void actualizarStock() {

    }

    public TipoBebida getTipoBebida() {
        return tipoBebida;
    }

    public static ProductoBebida JSONToProductoBebida(JSONObject JSONProductoBebida) throws JSONException{
        int stock = JSONProductoBebida.getInt("stock");
        String tipoBebidaStr = JSONProductoBebida.getString("tipoBebida");
        TipoBebida tipoBebida = TipoBebida.verificarBebida(tipoBebidaStr);
        ProductoBebida productoBebida = new ProductoBebida(stock,tipoBebida);

        return productoBebida;
    }

    public JSONObject productoBebidaToJSON() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stock", getStock());
        jsonObject.put("tipoBebida", tipoBebida.getNombre());
        return jsonObject;
    }
}
