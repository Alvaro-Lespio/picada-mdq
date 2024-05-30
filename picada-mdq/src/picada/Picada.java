package picada;

import Ingredientes.Agregado;
import Ingredientes.producto.ProductoFiambre;
import Ingredientes.producto.ProductoQueso;
import Ingredientes.producto.ProductoSnack;

import java.util.ArrayList;
import java.util.List;

public abstract class Picada {
     private int id;
     private List<ProductoQueso> productoQuesoList;
     private List<ProductoFiambre> productoFiambreList;
     private List<ProductoSnack> productoSnacksList;
     private List<Agregado> agregado;
     private double precioTotal;

     //private List<Ticket> tickets;  -> recorrer con un iterador e ir guardando en un archivo.
    public Picada() {
        this.precioTotal = 0;
        this.agregado = new ArrayList<>();
    }

    public Picada(int id, List<ProductoQueso> productoQuesoList, List<ProductoFiambre> productoFiambreList, List<ProductoSnack> productoSnacksList, double precioTotal, boolean envio, int valoracion, List<Agregado> agregado) {
        this.id = id;
        this.productoQuesoList = productoQuesoList;
        this.productoFiambreList = productoFiambreList;
        this.productoSnacksList = productoSnacksList;
        this.precioTotal = precioTotal;
        this.agregado = agregado;
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

    public List<Agregado> getAgregado() {
        return agregado;
    }

    public void setAgregado(List<Agregado> agregado) {
        this.agregado = agregado;
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
}
