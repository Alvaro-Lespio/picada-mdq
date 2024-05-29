package Ingredientes;

public class Ingrediente
{
    private String tipo;
    private double cantidad;

    public Ingrediente()
    {
        tipo="";
        cantidad=0;
    }

    public Ingrediente(String tipo, double cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "tipo='" + tipo + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void calcularStock()
    {

    }

}
