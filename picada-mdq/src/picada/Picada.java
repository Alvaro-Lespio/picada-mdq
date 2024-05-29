package picada;

import Ingredientes.Agregado;
import Ingredientes.Ingrediente;

import java.util.Objects;

public abstract class Picada {
     private int id;
     private Ingrediente ingrediente;
     private double precioTotal;
     private boolean envio;
     private int valoracion;
     private Agregado agregado;

    public Picada() {
        this.ingrediente = new Ingrediente();
        this.precioTotal = 0;
        this.envio = false;
        this.valoracion = 0;
        this.agregado = new Agregado();
    }

    public Picada(Ingrediente ingrediente, double precioTotal, boolean envio, int valoracion, Agregado agregado) {
        this.ingrediente = ingrediente;
        this.precioTotal = precioTotal;
        this.envio = envio;
        this.valoracion = valoracion;
        this.agregado = agregado;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
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


    @Override
    public String toString() {
        return "Picada{" +
                "ingrediente=" + ingrediente +
                ", precioTotal=" + precioTotal +
                ", envio=" + envio +
                ", valoracion=" + valoracion +
                ", agregado=" + agregado +
                '}';
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
