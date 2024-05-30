package Ingredientes.producto;
//vamos a tener los tipos de queso,fiambre y snack, + el stock
public abstract class Producto {
    private double stock;

    public Producto(double stock) {
        this.stock = stock;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    //funcion que modifica el stock en base a lo que pidio el usuario
    public void actualizarStock(){}
}
