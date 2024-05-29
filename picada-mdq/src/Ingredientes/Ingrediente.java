package Ingredientes;

public class Ingrediente
{
    private TipoQueso queso;
    private double cantidad;

    public Ingrediente(TipoQueso queso, double cantidad) {
        this.queso = queso;
        this.cantidad = cantidad;
    }
 // new Ingrediente(cheddar,20)
    public Ingrediente() {
    }

    public double getCantidad() {
        return cantidad;
    }

    public TipoQueso getQueso() {
        return queso;
    }


    public void calcularStock()
    {

    }

}
