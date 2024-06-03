package Ingredientes;

import org.json.JSONException;
import org.json.JSONObject;

public class Bebida
{
    private String tipo;
    private int cantidad;
    private String marca;
    private float cantLitros;


    public Bebida()
    {
        tipo="";
        cantidad=0;
        marca="";
        cantLitros=0;
    }
    public Bebida(String tipo, int cantidad, String marca, float cantLitros) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.marca = marca;
        this.cantLitros = cantLitros;
    }



    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getCantLitros() {
        return cantLitros;
    }

    @Override
    public String toString() {
     return "Bebida{" +
            "tipo='" + tipo + '\'' +
            ", cantidad=" + cantidad +
            ", marca='" + marca + '\'' +
            ", cantLitros=" + cantLitros +
            '}';
    }

    public static Bebida JSONToBebida(JSONObject JSONBebida) throws JSONException {
        String tipo = JSONBebida.getString("tipo");
        int cantidad = JSONBebida.getInt("cantidad");
        String marca = JSONBebida.getString("marca");
        float cantLitros = (float)JSONBebida.getDouble("cantLitros");
        Bebida bebida = new Bebida(tipo, cantidad, marca, cantLitros);

        return bebida;
    }

    public JSONObject bebidaToJSON()throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tipo", tipo);
        jsonObject.put("cantidad", cantidad);
        jsonObject.put("marca", marca);
        jsonObject.put("cantLitros", cantLitros);
        return jsonObject;
    }
}
