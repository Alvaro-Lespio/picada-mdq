package picada;

import Ingredientes.Agregado;
import Ingredientes.producto.ProdcutoFiambre;
import Ingredientes.producto.ProductoQueso;
import Ingredientes.producto.ProductoSnack;

import java.util.List;

public abstract class Picada {
     private int id;
     private List<ProductoQueso> productoQuesoList;
     private List<ProdcutoFiambre> prodcutoFiambreList;
     private List<ProductoSnack> productoSnacksList;
     private double precioTotal;
     private boolean envio;
     private int valoracion;
     private Agregado agregado;

    public Picada() {
        this.precioTotal = 0;
        this.envio = false;
        this.valoracion = 0;
        this.agregado = new Agregado();
    }

    public Picada(int id, List<ProductoQueso> productoQuesoList, List<ProdcutoFiambre> prodcutoFiambreList, List<ProductoSnack> productoSnacksList, double precioTotal, boolean envio, int valoracion, Agregado agregado) {
        this.id = id;
        this.productoQuesoList = productoQuesoList;
        this.prodcutoFiambreList = prodcutoFiambreList;
        this.productoSnacksList = productoSnacksList;
        this.precioTotal = precioTotal;
        this.envio = envio;
        this.valoracion = valoracion;
        this.agregado = agregado;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public boolean isEnvio() {
        return envio;
    }

    public void setEnvio(boolean envio) {
        this.envio = envio;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public Agregado getAgregado() {
        return agregado;
    }

    public void setAgregado(Agregado agregado) {
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

    public List<ProdcutoFiambre> getProdcutoFiambreList() {
        return prodcutoFiambreList;
    }

    public void setProdcutoFiambreList(List<ProdcutoFiambre> prodcutoFiambreList) {
        this.prodcutoFiambreList = prodcutoFiambreList;
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
