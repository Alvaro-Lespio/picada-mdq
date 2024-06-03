package picada;


import Ingredientes.producto.ProductoBebida;
import Ingredientes.producto.ProductoFiambre;
import Ingredientes.producto.ProductoQueso;
import Ingredientes.producto.ProductoSnack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public abstract class Picada {
     private int id;
     private List<ProductoQueso> productoQuesoList;
     private List<ProductoFiambre> productoFiambreList;
     private List<ProductoSnack> productoSnacksList;
     private List<ProductoBebida> productoBebidaList;
     private double precioTotal;

     //private List<Ticket> tickets;  -> recorrer con un iterador e ir guardando en un archivo.


    public Picada() {
        this.productoQuesoList = new ArrayList<>();
        this.productoFiambreList = new ArrayList<>();
        this.productoSnacksList = new ArrayList<>();
        this.productoBebidaList = new ArrayList<>();
        this.precioTotal = 0.0;
        this.id = 0;
    }

    public Picada( List<ProductoQueso> productoQuesoList, List<ProductoFiambre> productoFiambreList, List<ProductoSnack> productoSnacksList, List<ProductoBebida> productoBebidaList, double precioTotal) {
        this.productoQuesoList = productoQuesoList;
        this.productoFiambreList = productoFiambreList;
        this.productoSnacksList = productoSnacksList;
        this.productoBebidaList = productoBebidaList;
        this.precioTotal = precioTotal;
    }

    public List<ProductoFiambre> getProductoFiambreList() {
        return productoFiambreList;
    }

    public void setProductoFiambreList(List<ProductoFiambre> productoFiambreList) {
        this.productoFiambreList = productoFiambreList;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public List<ProductoBebida> getProductoBebidaList() {
        return productoBebidaList;
    }

    public int getId() {
        return id;
    }


    public List<ProductoQueso> getProductoQuesoList() {
        return productoQuesoList;
    }

    public void setProductoQuesoList(List<ProductoQueso> productoQuesoList) {
        this.productoQuesoList = productoQuesoList;
    }

    public List<ProductoFiambre> getProdcutoFiambreList() {
        return productoFiambreList;
    }

    public void setProdcutoFiambreList(List<ProductoFiambre> productoFiambreList) {
        this.productoFiambreList = productoFiambreList;
    }

    public List<ProductoSnack> getProductoSnacksList() {
        return productoSnacksList;
    }

    public void setProductoSnacksList(List<ProductoSnack> productoSnacksList) {
        this.productoSnacksList = productoSnacksList;
    }

    public void setProductoBebidaList(List<ProductoBebida> productoBebidaList) {
        this.productoBebidaList = productoBebidaList;
    }

    private int generarId(){

        return 0;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Picada picada = (Picada) object;
        return id == picada.id;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public static void JSONToPicada(JSONObject picadaJson, Picada picada) throws JSONException {
        picada.id = picadaJson.getInt("id");
        picada.precioTotal = picadaJson.getDouble("precioTotal");

        JSONArray quesoArray = picadaJson.getJSONArray("productoQuesoList");
        List<ProductoQueso> productoQuesoList = new ArrayList<>();
        for (int i = 0; i < quesoArray.length(); i++) {
            JSONObject quesoJson = quesoArray.getJSONObject(i);
            productoQuesoList.add(ProductoQueso.JSONToProductoQueso(quesoJson));
        }
        picada.setProductoQuesoList(productoQuesoList);

        JSONArray fiambreArray = picadaJson.getJSONArray("productoFiambreList");
        List<ProductoFiambre> productoFiambreList = new ArrayList<>();
        for (int i = 0; i < fiambreArray.length(); i++) {
            JSONObject fiambreJson = fiambreArray.getJSONObject(i);
            productoFiambreList.add(ProductoFiambre.JSONToProductoFiambre(fiambreJson));
        }
        picada.setProductoFiambreList(productoFiambreList);

        JSONArray snackArray = picadaJson.getJSONArray("productoSnacksList");
        List<ProductoSnack> productoSnacksList = new ArrayList<>();
        for (int i = 0; i < snackArray.length(); i++) {
            JSONObject snackJson = snackArray.getJSONObject(i);
            productoSnacksList.add(ProductoSnack.JSONToProductoSnack(snackJson));
        }
        picada.setProductoSnacksList(productoSnacksList);

        JSONArray bebidaArray = picadaJson.getJSONArray("productoBebidaList");
        List<ProductoBebida> productoBebidaList = new ArrayList<>();
        for (int i = 0; i < bebidaArray.length(); i++) {
            JSONObject bebidaJson = bebidaArray.getJSONObject(i);
            productoBebidaList.add(ProductoBebida.JSONToProductoBebida(bebidaJson));
        }
        picada.setProductoBebidaList(productoBebidaList);
    }



}
