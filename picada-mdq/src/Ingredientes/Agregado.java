package Ingredientes;

import org.json.JSONException;
import org.json.JSONObject;

public class Agregado
{
    private Bebida bebida;
    //private Pan pan;

    public Agregado(Bebida bebida) {
        this.bebida = bebida;
    }

    public Agregado() {
    }

    //METODOS
    public static Agregado agregadoToJSON(JSONObject JSONAgregado) throws JSONException{
        JSONObject bebidaJSON = JSONAgregado.getJSONObject("bebida");
        Bebida bebida = Bebida.JSONToBebida(bebidaJSON);
        Agregado agregado = new Agregado(bebida);
        return agregado;
    }

    public JSONObject JSONToAgregado() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("bebida", bebida);
        return jsonObject;
    }
    @Override
    public String toString() {
        return super.toString()+" Agregado{" +
                "bebida=" + bebida +
                '}';
    }
}
