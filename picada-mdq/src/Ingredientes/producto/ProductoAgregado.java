package Ingredientes.producto;

import Ingredientes.Agregado;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
public class ProductoAgregado extends Producto{
    List<Agregado> agregados;

    public ProductoAgregado(int stock, List<Agregado> agregados) {
        super(stock);
        this.agregados = agregados;
    }

    @Override
    public void actualizarStock() {

    }

    public static ProductoAgregado JSONToProductoAgregado(JSONObject jsonObject) throws JSONException{
        int stock = jsonObject.getInt("stock");
        JSONArray agregadosArray = jsonObject.getJSONArray("agregados");
        List<Agregado> agregados = new ArrayList<>();
        for(int i=0; i<agregadosArray.length(); i++){
            JSONObject jsonAgregado = agregadosArray.getJSONObject(i);
            Agregado agregado = Agregado.agregadoToJSON(jsonAgregado);
            agregados.add(agregado);
        }
        ProductoAgregado productoAgregado = new ProductoAgregado(stock, agregados);
        return productoAgregado;
    }

    public JSONObject productoAgregadoToJSON() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stock", getStock());
        JSONArray agregadosArray= new JSONArray();
        for(Agregado agregado: agregados){
            agregadosArray.put(agregado.JSONToAgregado());
        }
        jsonObject.put("agregos", agregadosArray);
        return jsonObject;
    }
}
