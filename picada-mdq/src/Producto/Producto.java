package Producto;
//vamos a tener los tipos de queso,fiambre y snack, + el stock
//Vamos a trabajar con enteros simulando que son bolsas de queso, bolsas de jamon y bolsas de snack

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
/**
 * Clase abstracta Producto que representa un producto genérico con un atributo de stock.
 */
public abstract class Producto implements Serializable {
    //Atributo
    private int stock;

    /**
     * Constructor que inicializa el stock del producto.
     *
     * @param stock la cantidad de stock del producto.
     */
    public Producto(int stock) {
        this.stock = stock;
    }

    /**
     * Constructor por defecto.
     */
    public Producto() {
    }

    /**
     * Obtiene la cantidad de stock del producto.
     *
     * @return la cantidad de stock.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece la cantidad de stock del producto.
     *
     * @param stock la nueva cantidad de stock.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

}
