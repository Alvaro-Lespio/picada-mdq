package Producto;
//vamos a tener los tipos de queso,fiambre y snack, + el stock
//Vamos a trabajar con enteros simulando que son bolsas de queso, bolsas de jamon y bolsas de snack

import org.json.JSONException;
import org.json.JSONObject;

public abstract class Producto {
    private int stock;

    public Producto(int stock) {
        this.stock = stock;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
